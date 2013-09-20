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
	 * @param descripcion Descripción del Item
	 * @param vida Cantidad de vida que suma o resta
	 * @param cantidad Número de veces que puede ser usado el Item
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
	 * Método que obtiene el número de veces que puede ser usado el Item 
	 * @return Devuelve la cantidad
	 */
	public int getCantidad()
	{
		return _cantidad;
	}
	
	/**
	 * Método que devuelve la información del Item.
	 * @return Devuelve un String con la información.
	 */
	public String toString() {
		
		return _descripcion+" // Vida: "+_vida+", Cantidad: "+_cantidad;
		
	}
	/**
	 * Metodo que obtiene la descripción de la comida
	 * @return descripción
	 */
	public String getDescripcion()
	{
		return _descripcion;
	}
}
