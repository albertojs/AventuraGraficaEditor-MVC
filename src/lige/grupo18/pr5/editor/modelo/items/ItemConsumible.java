package lige.grupo18.pr5.editor.modelo.items;

/**
 * Clase abstracta de los items consumibles
 * @author grupo18
 * @version 2.0
 */
public abstract class ItemConsumible extends Item{

	protected int _cantidad;
	
	/**
	 * Constructor parametrizado
	 * @param id identificador del objeto
	 * @param descripcion descripcion del objeto
	 */
	public ItemConsumible(String id, String descripcion) {
		super(id,descripcion);
	}

}
