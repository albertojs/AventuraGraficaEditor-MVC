package lige.grupo18.pr5.editor.modelo;

import java.util.ArrayList;

import lige.grupo18.pr5.editor.modelo.items.Item;

/**
 * Clase que implementa el escenario
 * @author grupo18
 *
 */
public class Escenario {

	//Variables locales
	private int _alto;
	private int _ancho;
	private ArrayList<Room> _habitaciones;
	/**
	 * Contructor
	 */
	public Escenario(){
		

	}
	
	/**
	 * Contructor parametrizado
	 * @param alto alto
	 * @param ancho ancho
	 */
	public Escenario(int alto,int ancho)
	{
		_alto=alto;
		_ancho=ancho;
		_habitaciones=new ArrayList<Room>();
	}
	/**
	 * Constructor parametrizado 2
	 * @param alto alto
	 * @param ancho ancho
	 * @param habitaciones array habitaciones
	 */
	public Escenario(int alto,int ancho,ArrayList<Room> habitaciones)
	{
		_alto=alto;
		_ancho=ancho;
		_habitaciones=habitaciones;
	}
	/**
	 * Accedente ancho
	 * @return ancho
	 */
	public int getAncho()
	{
		return _ancho;
	}
	/**
	 * Accedente alto
	 * @return alto
	 */
	public int getAlto()
	{
		return _alto;
	}
	/**
	 * Mutador ancho
	 * @param ancho ancho
	 */
	public void setAncho(int ancho)
	{
		_ancho=ancho;
	}
	/**
	 * Mutador alto
	 * @param alto alto
	 */
	public void setAlto(int alto)
	{
		_alto=alto;
	}
	/**
	 * Mutador habitaciones
	 * @param array array con las habitaciones
	 */
	public void setHabitaciones(ArrayList<Room> array)
	{
		_habitaciones=array;
	}
	/**
	 * metodo que añade habitaciones
	 * @param habitacion habitacion
	 */
	public void añadirHabitacion(Room habitacion)
	{
		_habitaciones.add(habitacion);
	}
	/**
	 * Metodo que busca la habtaciones
	 * @param x posicion x
	 * @param y posicion y
	 * @return habitacion
	 */
	public Room findRoom(int x,int y)
	{
		Room habitacion=null;
		int i=0;
		boolean encontrado=false;
		
		while (!encontrado && i<_habitaciones.size())
		{
			if(x==_habitaciones.get(i).getX() && y==_habitaciones.get(i).getY())
			{
				habitacion=_habitaciones.get(i);
				encontrado=true;
			}
			else 
				i++;
		}
		
		return habitacion;
	}
	/**
	 * Meotod que obtiene el indice de la habitacion
	 * @param habitacion habitacions
	 * @return indice
	 */
	public int getIndexRoom(Room habitacion)
	{
		int i=0;
		int indice=-1;
		boolean encontrado=false;
		
		if(habitacion!=null)
		{
			while (!encontrado && i<_habitaciones.size())
			{
				if(habitacion.getX()==_habitaciones.get(i).getX() && habitacion.getY()==_habitaciones.get(i).getY())
				{
					indice=i;
					encontrado=true;
				}
				else 
					i++;
			}
		
		}
		
		return indice;
	}
	/**
	 * Metodo que elimina la habitacion i 
	 * @param indice indice
	 */
	public void eliminarHabitacion(int indice)
	{
		_habitaciones.remove(indice);
	}
	/**
	 * Accedente del numero de habitaciones
	 * @return numero habitaciones
	 */
	public int getNumeroHabitaciones()
	{
		return _habitaciones.size();
	}
	/**
	 * Accedente del numero de puertas de la habtiacion i
	 * @param i posicion
	 * @return numero puertas
	 */
	public int getNumeroPuertas(int i)
	{
		return _habitaciones.get(i).getNumeroPuertas();
	}
	/**
	 * Accedente del numero de items
	 * @param i items de la habitacion i
	 * @return numero de items
	 */
	public int getNumeroItems(int i)
	{
		return _habitaciones.get(i).getNumeroItems();
	}
	/**
	 * Accedente de la habitacion en posicion i
	 * @param indiceArray posicion en el array
	 * @return habitacion
	 */
	public Room getHabitacion(int indiceArray)
	{
		return _habitaciones.get(indiceArray);
	}
	/**
	 * Accedente del id de la habitacion en la posicion i
	 * @param i posicion 
	 * @return idHabitacion
	 */
	public String getIdHabitacion(int i)
	{
		return _habitaciones.get(i).getNombre();
	}
	/**
	 * Accedente de la descripción de la habitacion en posicion i
	 * @param i posicion
	 * @return descripcion
	 */
	public String getDescripcionHabitacion(int i)
	{
		return _habitaciones.get(i).getDescripcion();
	}
	/**
	 * Accedente de si es salida la habitacion en la posicion i
	 * @param i posicion 
	 * @return si es o no salida
	 */
	public boolean getEsSalidaHabitacion(int i)
	{
		return _habitaciones.get(i).getSalida();
	}
	/**
	 * Accedente de id de puerta de la habitacion i y puerta j
	 * @param i posicion habitacion
	 * @param j posicion puerta
	 * @return idPuerta
	 */
	public String getIdPuerta(int i,int j)
	{
		return _habitaciones.get(i).getIdPuerta(j);
	}
	/**
	 * Accedente de la direccion de la puerta j de la habitacion i
	 * @param i posicion habitacion
	 * @param j posicion puerta
	 * @return direccion
	 */
	public String getDireccionPuerta(int i,int j)
	{
		return _habitaciones.get(i).getDireccionPuerta(j);
	}
	/**
	 * Accedente de si la puerta j de la habitación i esta abierta
	 * @param i habitacion
	 * @param j puerta 
	 * @return si esta o no abierta
	 */
	public boolean getEstaAbiertaPuerta(int i,int j)
	{
		return _habitaciones.get(i).getEstaAbiertaPuerta(j);
	}
	/**
	 * Accedente del item de la habitación i
	 * @param i habitacion
	 * @param j posicion del item
	 * @return item
	 */
	public Item getItem(int i,int j)
	{
		return _habitaciones.get(i).getItem(j);
	}
	/**
	 * Accedente de la posicon x
	 * @param i posicion x
	 * @return posicion
	 */
	public int getXHabitacion(int i)
	{
		return _habitaciones.get(i).getX();
	}
	/**
	 * Accedente de la posicion y
	 * @param i posicion y
	 * @return posicion
	 */
	public int getYHabitacion(int i)
	{
		return _habitaciones.get(i).getY();
	}
}
