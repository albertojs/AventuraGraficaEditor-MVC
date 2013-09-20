package lige.grupo18.pr5.editor.modelo.eventos;

import lige.grupo18.pr5.editor.EnumeradorEventos;

/**
 * Clase del evento guardar mapa
 * @author grupo18
 *
 */
public class EventoGuardarMapa implements Evento{

	private String _ruta;
	private boolean _resultado;
	
	/**
	 * Contructor
	 * @param ruta ruta
	 * @param resultado resultado
	 */
	public EventoGuardarMapa(String ruta,boolean resultado)
	{
		_ruta=ruta;
		_resultado=resultado;
	}

	/**
	 * Accedente del resultado
	 * @return resultado
	 */
	public boolean getResultado()
	{
		return _resultado;
	}
	/**
	 * Accedente de la ruta
	 * @return ruta
	 */
	public String getRuta()
	{
		return _ruta;
	}
	
	/**
	 * Accedente del tipo de evento
	 * @return evento
	 */
	public EnumeradorEventos getTipo() {
	
		return EnumeradorEventos.EventoGuardarMapa;
	}

}
