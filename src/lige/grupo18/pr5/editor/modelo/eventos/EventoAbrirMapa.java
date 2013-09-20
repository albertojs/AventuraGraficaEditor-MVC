package lige.grupo18.pr5.editor.modelo.eventos;

import lige.grupo18.pr5.editor.EnumeradorEventos;
import lige.grupo18.pr5.editor.modelo.Escenario;
import lige.grupo18.pr5.editor.modelo.Room;

/**
 * Clase evento que abre el mapa
 * @author grupo18
 *
 */
public class EventoAbrirMapa implements Evento{
	
	//Variables locales
	private boolean _resultado;
	private Escenario _escenario;
	
	/**
	 * Contructor
	 * @param cargado cargado
	 * @param stage escenario
	 */
	public EventoAbrirMapa(boolean cargado, Escenario stage){
		_resultado = cargado;
		_escenario = stage;
	}
	
	/**
	 * Accedente del tipo
	 * @return evento
	 */
	public EnumeradorEventos getTipo() {
		return EnumeradorEventos.EventoAbrirMapa;
	}

	/**
	 * Accedente de resultado
	 * @return resultado
	 */
	public boolean getResultado(){
		return _resultado;
	}
	
	/**
	 * Accedente de escenario
	 * @return escenario
	 */
	public Escenario getEscenario(){
		return _escenario;
	}
	
	/**
	 * Accedente del ancho
	 * @return ancho
	 */
	public int getAncho(){
		return _escenario.getAncho();
	}
	
	/**
	 * Accedente del alto
	 * @return alto
	 */
	public int getAlto(){
		return _escenario.getAlto();
	}
	/**
	 * Accedente del numero de habitaciones
	 * @return habitaciones
	 */
	public int getNumeroHabitaciones()
	{
		return _escenario.getNumeroHabitaciones();
	}
	/**
	 * Accedente de la habitacion
	 * @param i posicion
	 * @return habitacion
	 */
	public Room getHabitacion(int i)
	{
		return _escenario.getHabitacion(i);
	}

	
}
