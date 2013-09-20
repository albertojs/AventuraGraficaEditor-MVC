package lige.grupo18.pr5.editor.modelo.eventos;

import lige.grupo18.pr5.editor.EnumeradorEventos;

/**
 * Clase del evento que elimina habitaciones
 * @author grupo18
 *
 */
public class EventoEliminarHabitacion implements Evento{

	//Variables locales
	private int _x;
	private int _y;
	
	/**
	 * Constructor
	 * @param x posicion x
	 * @param y posicion y
	 */
	public EventoEliminarHabitacion(int x,int y)
	{
		_x=x;
		_y=y;
	}
	
	/**
	 * Accedente posicion x
	 * @return posicion x
	 */
	public int getX()
	{
		return _x;
	}
	/**
	 * Accedente posicion y
	 * @return posicion 7
	 */
	public int getY()
	{
		return _y;
	}
	
	/**
	 * Accedente tipo de evento
	 * @return evento
	 */
	public EnumeradorEventos getTipo() {
		
		return EnumeradorEventos.EventoEliminarHabitacion;
	}

}
