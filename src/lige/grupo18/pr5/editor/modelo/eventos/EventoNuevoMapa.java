package lige.grupo18.pr5.editor.modelo.eventos;

import lige.grupo18.pr5.editor.EnumeradorEventos;

/**
 * Clase que tiene el evento de nuevo mapa
 * @author grupo18
 *
 */
public class EventoNuevoMapa implements Evento{

	//Variables locales
	private int _filas;
	private int _columnas;
	/**
	 * Constructor
	 * @param filas filas
	 * @param columnas columnas
	 */
	public EventoNuevoMapa(int filas,int columnas)
	{
		_filas=filas;
		_columnas=columnas;
	}
	
	/**
	 * Accedente de las filas
	 * @return filas
	 */
	public int getFilas()
	{
		return _filas;
	}
	/**
	 * Accedente columnas
	 * @return columnas
	 */
	public int getColumnas()
	{
		return _columnas;
	}
	
	/**
	 * Accedente del tipo de evento
	 * @return evento
	 */
	public EnumeradorEventos getTipo() {
		return EnumeradorEventos.EventoNuevoMapa;
	}
}
