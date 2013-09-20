package lige.grupo18.pr5.editor.modelo.xml;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 * Clase que define el transformador para generar un fichero xml a partir de un arbol DOM
 * @author grupo18
 * @version 1.0
 */
public class TransformadorXML {

	public TransformadorXML()
	{
		
	}
	/**
	 * Método que se encarga de crear el fichero xml
	 * @param root Arbol DOM
	 * @param ruta Ruta donde se crea el fichero
	 * @return Devuelve booleano si se ha realizado correctamente
	 */
	public static boolean transformar(Document root,String ruta)
	{
		//Creación del transformador a partir de una factoría
		TransformerFactory factoria = TransformerFactory.newInstance();
		
		Transformer transformer = null;
		
		try 
		{
			transformer = factoria.newTransformer();
		}
		catch(TransformerConfigurationException e) 
		{
			e.printStackTrace();
			return false;
		}
		//Creación de un Source a partir del arbol DOM
		DOMSource origen = new DOMSource(root);
		
		//Creación de un Result a partir del fichero de destino
		File ficheroDestino = new File(ruta);
		StreamResult destino = new StreamResult(ficheroDestino);
		
		try 
		{
			transformer.transform(origen, destino);
		}
		catch(TransformerException e) 
		{
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
}
