package lige.grupo18.pr5.editor.modelo.eventos;

import lige.grupo18.pr5.editor.EnumeradorEventos;
import lige.grupo18.pr5.editor.modelo.Room;

/**
 * Clase evento que guarda las habitaciones
 * @author grupo18
 *
 */
public class EventoGuardarHabitacion implements Evento{

	//Variables locales
	private Room _habitacion;
	
	/**
	 * Constructor
	 * @param habitacion habitacion
	 */
	public EventoGuardarHabitacion(Room habitacion)
	{
		_habitacion=habitacion;
	}
	
	/**
	 * Accedente del tipo de evento 
	 * @return evento
	 */
	public EnumeradorEventos getTipo() {
		
		return EnumeradorEventos.EventoGuardarHabitacion;
	}

	/**
	 * Accedente habitacion
	 * @return habitacion
	 */
	public Room getHabitacion()
	{
		return _habitacion;
	}
	/**
	 * Accedente posicion x
	 * @return posicion x
	 */
	public int getX()
	{
		return _habitacion.getX();
	}
	/**
	 * Accedente posicion y
	 * @return posicion y
	 */
	public int getY()
	{
		return _habitacion.getY();
	}
}
