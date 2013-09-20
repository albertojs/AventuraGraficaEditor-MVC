package lige.grupo18.pr5.editor.modelo;

import java.util.*;

import lige.grupo18.pr5.editor.modelo.items.Item;

/**
 * Clase que describe una habitación del juego incluyendo una descripción de este y si es una salida o no
 * @version 2.0
 * @author grupo18
 * 
 */
public class Room {
	
	//Atributos de Room
	private String _nombre;
	private String _descripcion;
	private boolean _salida;
	private int _x;
	private int _y;
	private ArrayList<Item> _objetos;
	private ArrayList<Door> _puertas;
	
	/**
	 * Contructor por defecto de Room
	 */
	public Room()
	{
		_nombre="";
		_descripcion="";
		_salida = false;
		_objetos = new ArrayList<Item>();
		_puertas=new ArrayList<Door>();
	}
	public Room(String nombre,String descripcion,boolean salida)
	{
		_nombre=nombre;
		_descripcion = descripcion;
		_salida = salida;
		_objetos = new ArrayList<Item>();
		_puertas=new ArrayList<Door>();
	}
	/**
	 * Constructor con parametros de Room
	 * @param descripcion Descripción de la habitacion
	 * @param salida Indica si la habitación es una salida o no
	 */
	public Room(String nombre,String descripcion,boolean salida,int x,int y, ArrayList<Item> objetos,ArrayList<Door> puertas)
	{
		_nombre=nombre;
		_descripcion = descripcion;
		_salida = salida;
		_x=x;
		_y=y;

		_objetos = objetos;
		_puertas=puertas;
		
	}
	/**
	 * Accedente que obtiene el nombre
	 * @return nombre
	 */
	public String getNombre()
	{
		return _nombre;
	}
	/**
	 * Mutador que establece los objetos
	 * @param objetos
	 */
	public void setObjetos(ArrayList<Item> objetos)
	{
		_objetos=objetos;
	}
	/**
	 * Método get del atributo descripción
	 * @return Devuelve la descripción de la habitación
	 */
	public String getDescripcion()
	{
		return this._descripcion;
	}
	
	/**
	 * Método get del atributo salida
	 * @return Devuelve si la habitación es una salida o no
	 */
	public boolean getSalida()
	{
		return this._salida;
	}
	/**
	 * Método que obtiene la coordenada X
	 * @return Devuelve X
	 */
	public int getX()
	{
		return _x;
	}
	/**
	 * Método que obtiene la coordenada Y
	 * @return Devuelve Y
	 */
	public int getY()
	{
		return _y;
	}
	/**
	 * Metodo set para coordenada X
	 * @param x Valor de X
	 */
	public void setX(int x)
	{
		_x=x;
	}
	/**
	 * Método set para coordenada Y
	 * @param y Valor de Y
	 */
	public void setY(int y)
	{
		_y=y;
	}
	
	/**
	 * Método get para el array de objetos
	 * @return devuelve el array con los objetos que hay en la habitación
	 */
	public ArrayList<Item> getObjetos()
	{
		return _objetos;
	}
	
	/**
	 * Método set del atributo descripción
	 * @param descripcion Contiene la descripción de la habitación
	 */
	public void setDescripcion(String descripcion)
	{
		this._descripcion=descripcion;
	}
	/**
	 * Método set del atributo salida
	 * @param salida Contiene si la habitación es una salida o no
	 */
	public void setSalida(boolean salida)
	{
		this._salida=salida;
	}
	/**
	 * Método que muesta los items de la habitación
	 * @return Devuelve un String con la descripción de los Items de la habitación
	 */
	public String showItems()
	{		
		if(_objetos.isEmpty())
			return "Este lugar no contiene ningún objeto.";
		else
		{
			return "Este lugar contiene los siguientes objetos: "+ _objetos.toString();
			
		}
	}
	
	/**
	 * Método que añade un objeto al inventario de la habitación
	 * @param objeto Objeto a añadir
	 * @return Devuelve true si se ha añadido con exito
	 */
	public boolean addItem(Item objeto)
	{
		return _objetos.add(objeto);
	}
	/**
	* Sobreescritura del metodo toString() 
	 */
	public String toString()
	{
		String cadena="";
		cadena=cadena+getDescripcion()+"\n"+showItems();
		return cadena;
	}

	/**
	 * Método que obtiene el array de puertas
	 * @return Array de puertas
	 */
	public ArrayList<Door> getPuertas()
	{
		return _puertas;
	}
	/**
	 * Método que añade una puerta al array
	 * @param puerta Objeto Door
	 */
	public void añadirPuerta(Door puerta)
	{
		_puertas.add(puerta);
	}
	/**
	 * Método que añade un item al array de objetos
	 * @param item Objeto Item
	 */
	public void añadirItem(Item item)
	{
		_objetos.add(item);
	}
	/**
	 * Método que obtiene el número de items del array
	 * @return Devuelve el numero
	 */
	public int getNumeroItems()
	{
		return _objetos.size();
	}
	/**
	 * Método que obtiene el número de puertas del array
	 * @return Devuelve el número
	 */
	public int getNumeroPuertas()
	{
		return _puertas.size();
	}
	/**
	 * Obtiene el idPuerta
	 * @param i Puerta
	 * @return Devuelve el Id
	 */
	public String getIdPuerta(int i)
	{
		return _puertas.get(i).getId();
	}
	/**
	 * Obtiene la descripción de la puerta
	 * @param i Puerta
	 * @return Devuelve la descripción
	 */
	public String getDireccionPuerta(int i)
	{
		return _puertas.get(i).getDireccionString();
	}
	/**
	 * Obtiene si la puerta esta abierta
	 * @param i Puerta
	 * @return Devuelve booleano
	 */
	public boolean getEstaAbiertaPuerta(int i)
	{
		return _puertas.get(i).isOpen();
	}
	/**
	 * Obtiene un objeto del array
	 * @param i Indice
	 * @return Devuelve Item
	 */
	public Item getItem(int i)
	{
		return _objetos.get(i);
	}
	/**
	 * Obtiene el IdItem
	 * @param i Indice del item
	 * @return devuelve el ID
	 */
	public String getIdItem(int i)
	{
		return _objetos.get(i).getId();
	}
	/**
	 * Obtiene la descripción del item
	 * @param i indice del item
	 * @return Devuelve la descripción
	 */
	public String getDescripcionItem(int i)
	{
		return _objetos.get(i).getDescripcion();
	}
	
}
