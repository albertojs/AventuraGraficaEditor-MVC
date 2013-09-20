package lige.grupo18.pr5.editor.vista;

import java.util.ArrayList;

import javax.swing.JButton;

import lige.grupo18.pr5.editor.modelo.Door;
import lige.grupo18.pr5.editor.modelo.Room;
import lige.grupo18.pr5.editor.modelo.items.Item;

@SuppressWarnings("serial")
/**
 * Clase que contiene los botones del mapa
 * @author grupo18
 *
 */
public class BotonMapa extends JButton {

	//Variables privadas
	private int _x;
	private int _y;
	private Room _habitacion;
	
	/**
	 * Contructor parametrizado
	 * @param x posicion x en el mapa
	 * @param y posicion y en el mapa
	 * @param habitacion indica la habitación que contiene el boton
	 */
	public BotonMapa(int x, int y,Room habitacion){
		_x = x;
		_y = y;
		_habitacion = habitacion;
	}
	
	/**
	 * Accedente que devuelve la posición x
	 * @return posicion x en el mapa
	 */
	public int getCoordenadaX(){
		return _x;
	}
	
	/**
	 * Accedente que devuelve la posición y 
	 * @return posición y en el mapa
	 */
	public int getCoordenadaY(){
		return _y;
	}
	
	/**
	 * Accedente que me devulve la habitación
	 * @return habitación que contiene el boton
	 */
	public Room getRoom()
	{
		return _habitacion;
	}
	/**
	 * Mutador que establece la habitación del boton
	 * @param habi habitación
	 */
	public void setHabitacion(Room habi){
		_habitacion = habi;
	}
	/**
	 * Accedente idHabitación
	 * @return id
	 */
	public String getIdHabitacion()
	{
		return _habitacion.getNombre();
	}
	/**
	 * Accedente descripción
	 * @return descripción
	 */
	public String getDescripcionHabitacion()
	{
		return _habitacion.getDescripcion();
	}
	/**
	 * Accedente salida
	 * @return salida
	 */
	public boolean getSalida()
	{
		return _habitacion.getSalida();
	}
	/**
	 * Accedente lista de puertas
	 * @return array
	 */
	public ArrayList<Door> getArrayPuertas()
	{
		return _habitacion.getPuertas();
	}
	/**
	 * Accedente lista de items
	 * @return items
	 */
	public ArrayList<Item> getArrayItems()
	{
		return _habitacion.getObjetos();
	}
	
}
