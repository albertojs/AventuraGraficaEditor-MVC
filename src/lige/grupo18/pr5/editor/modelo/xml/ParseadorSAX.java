package lige.grupo18.pr5.editor.modelo.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import lige.grupo18.pr5.editor.Directions;
import lige.grupo18.pr5.editor.modelo.Door;
import lige.grupo18.pr5.editor.modelo.Escenario;
import lige.grupo18.pr5.editor.modelo.Room;
import lige.grupo18.pr5.editor.modelo.items.Comida;
import lige.grupo18.pr5.editor.modelo.items.Item;
import lige.grupo18.pr5.editor.modelo.items.Llave;
import lige.grupo18.pr5.editor.modelo.items.ObjetoValor;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase que define el parseador para leer datos de un fichero XML
 * @author grupo18
 * @version 1.0
 */
public class ParseadorSAX {

	Escenario _escenario;
	ArrayList<Room> _habitaciones;
	Room _habitacion;
	int _x;
	int _y;
	Door _puerta;
	Item _item;
	File _archivo;
	
	/**
	 * Constructor
	 * @param nombreArchivo archivo a leer
	 */
	public ParseadorSAX(File nombreArchivo){
		_archivo = nombreArchivo;
	}
	
	/**
	 * Método que se encarga de leer el XML
	 * @return Devuelve booleano si se ha realizado sin errores
	 */
	public boolean parsearArchivo(){
		
		//Creamos el parser empleando la factoría
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser parser = null;
		
		try 
		{
			parser = factory.newSAXParser();
		} 
		catch (ParserConfigurationException e) 
		{
			//e.printStackTrace();
			return false;
		} 
		catch (SAXException e) {
			
			//e.printStackTrace();
			return false;
		}
		//Oyente hereda de DefaultHandler
		DefaultHandler oyente = new Oyente();
		
		//Lanzamos el proceso de parseo
		try {
			parser.parse(_archivo, oyente);
		} 
		catch (SAXException e) 
		{
			
			//e.printStackTrace();
			return false;
		} 
		catch (IOException e) 
		{
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método que da forma al escenario
	 * @param atrs Atributos
	 */
	public void crearEscenario(Attributes atrs)
	{
		for(int i=0;i<atrs.getLength();i++)
		{
			switch(atrs.getQName(i))
			{
				case "filas":
				{
					_escenario.setAlto(Integer.parseInt(atrs.getValue(i)));
					break;
				}
				case "columnas":
				{
					_escenario.setAncho(Integer.parseInt(atrs.getValue(i)));
					break;
				}
			}
		}
	}
	/**
	 * Método que crea una habitación
	 * @param atrs Atributos
	 */
	public void crearHabitacion(Attributes atrs)
	{
		String id="";
		String descripcion="";
		boolean salida=true;
		
		for(int i=0;i<atrs.getLength();i++)
		{
			switch(atrs.getQName(i))
			{
				case "id":
				{
					id=atrs.getValue(i);	
					break;
				}
				case "descripcion":
				{
					descripcion=atrs.getValue(i);
					break;
				}
				case "esSalida":
				{
					if(atrs.getValue(i).equals("true"))
						salida = true;
					else
						salida = false;
				}
				break;
			}
		}
		
		_habitacion = new Room(id,descripcion,salida);
	}
	
	/**
	 * Método que crea una puerta
	 * @param atrs Atributos
	 */
	public void crearPuerta(Attributes atrs)
	{
		String id="";
		Directions direccion=Directions.NONE;
		boolean abierta=true;
		
		for(int i=0;i<atrs.getLength();i++)
		{
			switch(atrs.getQName(i))
			{
				case "id":
				{
					id=atrs.getValue(i);
					break;
				}
				case "direccion":
				{
					switch(atrs.getValue(i).toUpperCase())
					{
					case "NORTE":
						direccion = Directions.NORTE;
						break;
					case "SUR":
						direccion = Directions.SUR;
						break;
					case "ESTE":
						direccion = Directions.ESTE;
						break;
					default:
						direccion = Directions.OESTE;
					}
					
					break;
				}
				case "abierta":
				{
					if(atrs.getValue(i).equals("true"))
						abierta = true;
					else
						abierta = false;
					
					break;
				}
			}
		}
		
		_puerta = new Door(id,direccion,abierta);
	}
	
	/**
	 * Método que crea un itemLLave 
	 * @param atrs Atributos
	 */
	public void crearItemLLave(Attributes atrs)
	{
		String id="";
		String descripcion="";
		String puerta="";
		
		for(int i=0;i<atrs.getLength();i++)
		{
			switch(atrs.getQName(i))
			{
				case "id":
				{	
					id=atrs.getValue(i);
					break;
				}
				case "descripcion":
				{
					descripcion=atrs.getValue(i);
					break;
				}
				case "puerta":
				{
					puerta=atrs.getValue(i);
					break;
				}
			
			}
		}
		
		_item = new Llave(id,descripcion, puerta);
		
	}
	
	/**
	 * Método que crea un itemComida
	 * @param atrs Atributos
	 */
	public void crearItemComida(Attributes atrs)
	{
		String id="";
		String descripcion="";
		int usos=0;
		int vida=0;
		
		for(int i=0;i<atrs.getLength();i++)
		{
			switch(atrs.getQName(i))
			{
				case "id":
				{	
					id=atrs.getValue(i);
					break;
				}
				case "descripcion":
				{
					descripcion=atrs.getValue(i);
					break;
				}
				case "usos":
				{
					usos=Integer.parseInt(atrs.getValue(i));
					break;
				}
				case "vida":
				{
					vida=Integer.parseInt(atrs.getValue(i));
					break;
				}
			}
		}
		
		_item = new Comida(id,descripcion,vida,usos);
	}
	
	
	/**
	 * Método que crea un itemObjetoValor
	 * @param atrs Atributos
	 */
	public void crearItemObjetoValor(Attributes atrs)
	{
		String id="";
		String descripcion="";
		int puntuacion=0;
		
		for(int i=0;i<atrs.getLength();i++)
		{
			switch(atrs.getQName(i))
			{
				case "id":
				{	
					id=atrs.getValue(i);
					break;
				}
				case "descripcion":
				{
					descripcion=atrs.getValue(i);
					break;
				}
				case "puntuacion":
				{
					puntuacion=Integer.parseInt(atrs.getValue(i));
					break;
				}
			}
		}
		_item = new ObjetoValor(id,descripcion,puntuacion);
		
	}
	
	
	public class Oyente extends DefaultHandler {
		
		/**
		 * Inicio del documento
		 */
		public void startDocument() throws SAXException 
		{
			_escenario = new Escenario();
			_habitaciones = new ArrayList<Room>();
		}
		/**
		 * Fin del documento
		 */
		public void endDocument() throws SAXException 
		{
		}
		/**
		 * Inicio de lectura de un elemento del fichero
		 */
		public void startElement(String namespace, String sName, String qName, Attributes atrs) throws SAXException 
		{
			
			switch(qName){
				case "mapa":
				{
					crearEscenario(atrs);
					break;
				}
				case "habitacion":
				{
					crearHabitacion(atrs);
					break;
				}
				case "posicion":
				{
					_x=Integer.parseInt(atrs.getValue(0));
					_y=Integer.parseInt(atrs.getValue(1));
					break;
				}
				case "puerta":
				{
					crearPuerta(atrs);
					break;
				}
				case "itemLlave":
				{
					crearItemLLave(atrs);
					break;
				}
				case "itemValor":
				{
					crearItemObjetoValor(atrs);
					break;
				}
				case "itemComida":
				{
					crearItemComida(atrs);
					break;
				}
			}
		}
		/**
		 * Fin de lectura de un elemento del fichero
		 */
		public void endElement(String uri, String localName, String name) throws SAXException
		{
			switch(name){
				case "mapa":{
					_escenario.setHabitaciones(_habitaciones);
					break;
				}
				case "habitacion":{
					_habitaciones.add(_habitacion);
					break;
				}
				case "posicion":{
					_habitacion.setX(_x);
					_habitacion.setY(_y);
					break;
				}
				case "puerta":{
					_habitacion.añadirPuerta(_puerta);
					break;
				}
				case "itemLlave":{
					_habitacion.addItem(_item);
					break;
				}
				case "itemValor":{
					_habitacion.addItem(_item);
					break;
				}
				case "itemComida":{
					_habitacion.addItem(_item);
					break;
				}
			}
		}
	}
	/**
	 * Obtiene el escenario ya formado
	 * @return Devuelve el escenario
	 */
	public Escenario getEscenario(){
		return _escenario;
	}
}
