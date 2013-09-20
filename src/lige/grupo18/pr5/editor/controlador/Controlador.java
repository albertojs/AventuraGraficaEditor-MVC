package lige.grupo18.pr5.editor.controlador;

import java.io.File;
import java.util.ArrayList;

import lige.grupo18.pr5.editor.modelo.Door;
import lige.grupo18.pr5.editor.modelo.Modelo;
import lige.grupo18.pr5.editor.modelo.Room;
import lige.grupo18.pr5.editor.modelo.items.Item;

/**
 * Clase que contiene el controlador
 * @author grupo18
 *
 */
public class Controlador {

	//Variables locales
	private Modelo _modelo;
	
	/**
	 * Contructor
	 * @param modelo modelo
	 */
	public Controlador(Modelo modelo)
	{
		_modelo=modelo;
	}
	/**
	 * metodo que solicita crear nuevo mapa
	 * @param filas filas
	 * @param columnas columnas
	 */
	public void solicitarCrearNuevoMapa(int filas,int columnas)
	{
		_modelo.editarNuevoMapa(filas,columnas);
	}
	/**
	 * Metodo que solicita guarda una habitación
	 * @param id id
	 * @param descripcion descripción de la habitación
	 * @param esSalida si es salida o no
	 * @param x posicion x
	 * @param y posicion y
	 * @param puertas array de puertas
	 * @param objetos array de objetos
	 */
	public void solicitarGuardarHabitacion(String id,String descripcion,boolean esSalida,int x,int y,ArrayList<Door> puertas,ArrayList<Item> objetos)
	{
		Room habitacion= new Room(id,descripcion,esSalida,x,y,objetos,puertas);
		_modelo.guardarNuevaHabitacion(habitacion);
	}
	/**
	 * Metodo que solicita eliminar una habitacion
	 * @param x posicion x
	 * @param y posicion y
	 */
	public void solicitarEliminarHabitacion(int x,int y)
	{
		_modelo.eliminarHabitacion(x, y);
	}
	/**
	 * Metodo que solicita abrir un mapa
	 * @param archivo archivo
	 */
	public void solicitarAbrirMapa(File archivo)
	{
		_modelo.abrirMapa(archivo);
	}
	/**
	 * Metodo que solicita guardar un mapa
	 * @param ruta ruta
	 */
	public void solicitarGuardarMapa(String ruta)
	{
		_modelo.guardarMapa(ruta);
	}
}
