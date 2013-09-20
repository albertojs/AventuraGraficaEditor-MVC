package lige.grupo18.pr5.editor.modelo.items;

/**
 * Clase que define un Item de tipo consumible
 * @author grupo18
 * @version 1.0
 * @see ItemConsumible
 * @see Item
 */
public class Comida extends ItemConsumible {

	private int _vida;
	
	/**
	 * Constructor con parametros de Comida
	 * @param id Identificador
	 * @param descripcion Descripci�n del Item
	 * @param vida Cantidad de vida que suma o resta
	 * @param cantidad N�mero de veces que puede ser usado el Item
	 */
	public Comida(String id, String descripcion, int vida, int cantidad)
	{
		super(id,descripcion);
		_vida=vida;
		_cantidad=cantidad;
	}
	public int getVida()
	{
		return _vida;
	}
	
	/**
	 * M�todo que obtiene el n�mero de veces que puede ser usado el Item 
	 * @return Devuelve la cantidad
	 */
	public int getCantidad()
	{
		return _cantidad;
	}
	
	/**
	 * M�todo que devuelve la informaci�n del Item.
	 * @return Devuelve un String con la informaci�n.
	 */
	public String toString() {
		
		return _descripcion+" // Vida: "+_vida+", Cantidad: "+_cantidad;
		
	}
	/**
	 * Metodo que obtiene la descripci�n de la comida
	 * @return descripci�n
	 */
	public String getDescripcion()
	{
		return _descripcion;
	}
}
