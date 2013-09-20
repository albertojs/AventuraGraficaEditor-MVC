package lige.grupo18.pr5.editor.modelo.items;

/**
 * Clase abstracta de los Items
 * @author grupo18
 * @version 2.0
 */
public abstract class Item {

	protected String _id;
	protected String _descripcion;
	
	/**
	 * Constructor por defecto
	 */
	public Item(){
		_id = "";
		_descripcion="";
	}
	
	/**
	 * Contructor paramétrizado
	 * @param id identificador del Item
	 * @param descripcion pequeña descripción del objeto
	 */
	public Item(String id,String descripcion)
	{
		_id = id;		
		_descripcion=descripcion;
	}
	
	/**
	 * Accedente para conseguir el identificador del Item
	 * @return cadena con el id
	 */
	public String getId()
	{
		return _id;
	}
	
	/**
	 * Accedente para conseguir la descripción del Item
	 * @return Devuelve un String con la descripción
	 */
	public String getDescripcion()
	{
		return _descripcion;
	}
	
	/**
	 * Función que sirve para ver los atributos que contiene el objeto.
	 * @return devuelve una cadena con el identificador y una descripción del objeto 
	 */
	public String toString() {
		
		return _descripcion;		
		
	}
	
	
}
