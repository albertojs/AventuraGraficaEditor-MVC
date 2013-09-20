package lige.grupo18.pr5.editor.modelo.items;

/**
 * Clase que tiene la funcionalidad de los items consumibles
 * @author grupo18
 * @version 2.0
 * @see ItemConsumible
 * @see Item
 */
public class ObjetoValor extends ItemConsumible{

	private int _puntos;
	
	/**
	 * Constructor parametrizado
	 * @param id identificador del item
	 * @param descripcion descripcion del item
	 * @param puntos puntos del item
	 */
	public ObjetoValor(String id,String descripcion,int puntos)
	{
		super(id,descripcion);
		_puntos=puntos;
	}
	/**
	 * Obtiene la puntuación
	 * @return Devuelve la cantidad de puntos
	 */
	public int getPuntos()
	{
		return _puntos;
	}
	/**
	 * Sobreescritura de toString()
	 */
	public String toString() {
		
		return _descripcion+" // Puntos: "+_puntos;
		
	}
}
