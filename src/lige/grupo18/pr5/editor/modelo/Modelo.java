package lige.grupo18.pr5.editor.modelo;

import java.io.File;
import java.util.Observable;

import lige.grupo18.pr5.editor.modelo.eventos.EventoAbrirMapa;
import lige.grupo18.pr5.editor.modelo.eventos.EventoEliminarHabitacion;
import lige.grupo18.pr5.editor.modelo.eventos.EventoGuardarHabitacion;
import lige.grupo18.pr5.editor.modelo.eventos.EventoGuardarMapa;
import lige.grupo18.pr5.editor.modelo.eventos.EventoNuevoMapa;
import lige.grupo18.pr5.editor.modelo.xml.CreadorDOM;
import lige.grupo18.pr5.editor.modelo.xml.ParseadorSAX;
import lige.grupo18.pr5.editor.modelo.xml.TransformadorXML;

/**
 * Clase que implementa el modelo
 * @author grupo18
 *
 */
public class Modelo extends Observable{

	private Escenario _escenario;
	
	/**
	 * Constructor
	 */
	public Modelo()
	{
		_escenario=new Escenario();
	}
	/**
	 * Metodo que edita el nuevo mapa
	 * @param filas filas
	 * @param columnas columnas
	 */
	public void editarNuevoMapa(int filas,int columnas)
	{
		_escenario=new Escenario(filas,columnas);
		
		EventoNuevoMapa evento= new EventoNuevoMapa(filas,columnas);
		this.setChanged();
		this.notifyObservers(evento);
	}
	/**
	 * metodo que guarda una nueva habitacion en el mapa
	 * @param habitacion habtiacion
	 */
	public void guardarNuevaHabitacion(Room habitacion)
	{
		int indice=_escenario.getIndexRoom(habitacion);
		if(indice!=-1)
			_escenario.eliminarHabitacion(indice);
		
		_escenario.añadirHabitacion(habitacion);
		
		EventoGuardarHabitacion evento=new EventoGuardarHabitacion(habitacion);
		this.setChanged();
		this.notifyObservers(evento);
		
	}
	/**
	 * Metodo que elimina una habtiacion del mapa
	 * @param x posicion x
	 * @param y posicion y
	 */
	public void eliminarHabitacion(int x,int y)
	{
		Room habitacion=_escenario.findRoom(x, y);
		
		int indice=_escenario.getIndexRoom(habitacion);
		if(indice!=-1)
			_escenario.eliminarHabitacion(indice);
		
		EventoEliminarHabitacion evento=new EventoEliminarHabitacion(x,y);
		this.setChanged();
		this.notifyObservers(evento);
	}
	/**
	 * Metodo que abre un archivo (mapa)
	 * @param archivo archivo
	 */ 
	public void abrirMapa(File archivo)
	{
		ParseadorSAX parseador = new ParseadorSAX(archivo);
		
		boolean resultado=parseador.parsearArchivo();
		_escenario=parseador.getEscenario();
		
		EventoAbrirMapa evento = new EventoAbrirMapa(resultado,_escenario);
		
		this.setChanged();
		this.notifyObservers(evento);
	}
	/**
	 * metodo que guarda el mapa
	 * @param ruta ruta
	 */
	public void guardarMapa(String ruta)
	{
		CreadorDOM creador=new CreadorDOM(_escenario);
		boolean resultado=creador.crearArbolDOM();
		
		if(resultado)
		{
			resultado=TransformadorXML.transformar(creador.getDocument(), ruta);
		}
		
		EventoGuardarMapa evento=new EventoGuardarMapa(ruta,resultado);
		this.setChanged();
		this.notifyObservers(evento);
	}
}
