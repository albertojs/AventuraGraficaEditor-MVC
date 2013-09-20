package lige.grupo18.pr5.editor.modelo;

import java.util.*;

import lige.grupo18.pr5.editor.modelo.items.Item;

/**
 * Clase que describe una habitaci�n del juego incluyendo una descripci�n de este y si es una salida o no
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
	 * @param descripcion Descripci�n de la habitacion
	 * @param salida Indica si la habitaci�n es una salida o no
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
	 * M�todo get del atributo descripci�n
	 * @return Devuelve la descripci�n de la habitaci�n
	 */
	public String getDescripcion()
	{
		return this._descripcion;
	}
	
	/**
	 * M�todo get del atributo salida
	 * @return Devuelve si la habitaci�n es una salida o no
	 */
	public boolean getSalida()
	{
		return this._salida;
	}
	/**
	 * M�todo que obtiene la coordenada X
	 * @return Devuelve X
	 */
	public int getX()
	{
		return _x;
	}
	/**
	 * M�todo que obtiene la coordenada Y
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
	 * M�todo set para coordenada Y
	 * @param y Valor de Y
	 */
	public void setY(int y)
	{
		_y=y;
	}
	
	/**
	 * M�todo get para el array de objetos
	 * @return devuelve el array con los objetos que hay en la habitaci�n
	 */
	public ArrayList<Item> getObjetos()
	{
		return _objetos;
	}
	
	/**
	 * M�todo set del atributo descripci�n
	 * @param descripcion Contiene la descripci�n de la habitaci�n
	 */
	public void setDescripcion(String descripcion)
	{
		this._descripcion=descripcion;
	}
	/**
	 * M�todo set del atributo salida
	 * @param salida Contiene si la habitaci�n es una salida o no
	 */
	public void setSalida(boolean salida)
	{
		this._salida=salida;
	}
	/**
	 * M�todo que muesta los items de la habitaci�n
	 * @return Devuelve un String con la descripci�n de los Items de la habitaci�n
	 */
	public String showItems()
	{		
		if(_objetos.isEmpty())
			return "Este lugar no contiene ning�n objeto.";
		else
		{
			return "Este lugar contiene los siguientes objetos: "+ _objetos.toString();
			
		}
	}
	
	/**
	 * M�todo que a�ade un objeto al inventario de la habitaci�n
	 * @param objeto Objeto a a�adir
	 * @return Devuelve true si se ha a�adido con exito
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
	 * M�todo que obtiene el array de puertas
	 * @return Array de puertas
	 */
	public ArrayList<Door> getPuertas()
	{
		return _puertas;
	}
	/**
	 * M�todo que a�ade una puerta al array
	 * @param puerta Objeto Door
	 */
	public void a�adirPuerta(Door puerta)
	{
		_puertas.add(puerta);
	}
	/**
	 * M�todo que a�ade un item al array de objetos
	 * @param item Objeto Item
	 */
	public void a�adirItem(Item item)
	{
		_objetos.add(item);
	}
	/**
	 * M�todo que obtiene el n�mero de items del array
	 * @return Devuelve el numero
	 */
	public int getNumeroItems()
	{
		return _objetos.size();
	}
	/**
	 * M�todo que obtiene el n�mero de puertas del array
	 * @return Devuelve el n�mero
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
	 * Obtiene la descripci�n de la puerta
	 * @param i Puerta
	 * @return Devuelve la descripci�n
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
	 * Obtiene la descripci�n del item
	 * @param i indice del item
	 * @return Devuelve la descripci�n
	 */
	public String getDescripcionItem(int i)
	{
		return _objetos.get(i).getDescripcion();
	}
	
}
