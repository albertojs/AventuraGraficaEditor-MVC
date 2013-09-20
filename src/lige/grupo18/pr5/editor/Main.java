package lige.grupo18.pr5.editor;

import lige.grupo18.pr5.editor.controlador.Controlador;
import lige.grupo18.pr5.editor.modelo.Modelo;
import lige.grupo18.pr5.editor.vista.Vista;

/**
 * Clase main de la aplicacion
 * @author grupo18
 *
 */
public class Main {

	/**
	 * Entrada
	 * @param args argumentos
	 */
	public static void main(String[] args)
	{
		
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo);
		Vista vista = new Vista(controlador);
		
		modelo.addObserver(vista);
		
	}
}
