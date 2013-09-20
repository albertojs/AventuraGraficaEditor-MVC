package lige.grupo18.pr5.editor.modelo.items;


/**
 * Clase que contiene la informacion de uso de la llave
 * @author grupo18
 * @version 2.0
 * @see ItemPersistente
 * @see Item
 */
public class Llave extends ItemPersistente{
		
	private String _puerta;
	
	/**
	 * Contructir parametrizado
	 * @param id identificador del item
	 * @param descripcion descripcion del objeto
	 * @param puerta puerta que abirirá
	 */
	public Llave(String id,String descripcion,String puerta)
	{
		super(id,descripcion);
		_puerta=puerta;
	}
	/**
	 * Obtiene el Id de la puerta
	 * @return Devuelve la puerta
	 */
	public String getPuerta()
	{
		return _puerta;
	}
	/**
	 * Sobreescritura de toString()
	 */
	public String toString() {
		
		return _descripcion+" // Puerta: "+_puerta;
		
	}

}
