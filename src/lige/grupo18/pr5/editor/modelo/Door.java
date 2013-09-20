package lige.grupo18.pr5.editor.modelo;

import lige.grupo18.pr5.editor.Directions;

/**
 * Clase que define una puerta que conecta entre dos habitaciones
 * @author grupo18
 * @version 1.0
 */
public class Door {
	
	//Atributos de Door
	private String _id;
	private Directions _direccion;
	private boolean _abierta;
	
	/**
	 * Constructor por defecto de la clase Door
	 */
	Door(){
		_id="";
		_direccion=Directions.NONE;
		_abierta=false;
	}
	
	/**
	 * Constructor con parametros de Door
	 * @param id Identificador de la puerta
	 * @param pos Orientación de la puerta
	 * @param abierta Indica si esta abierta o cerrada
	 */
	public Door(String id,Directions pos,boolean abierta){
		_id=id;
		_direccion = pos;
		_abierta = abierta;
	}
	/**
	 * Obtiene el Id de la puerta
	 * @return Devuelve el ID
	 */
	public String getId()
	{
		return _id;
	}
	/**
	 * Obtiene la dirección de la puerta
	 * @return Devuelve la direccion
	 */
	public Directions getDireccion()
	{
		return _direccion;
	}
	/**
	 * Obtiene la dirección de la puerta en String
	 * @return Devuelve String
	 */
	public String getDireccionString()
	{
		return _direccion.toString();
	}
	/**
	 * Método que indica si la puerta esta abierta o cerrada
	 * @return Devuelve un booleano indicandolo
	 */
	public boolean isOpen()
	{
		return _abierta;
	}
	
	
}
