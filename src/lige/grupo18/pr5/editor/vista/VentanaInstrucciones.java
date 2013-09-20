package lige.grupo18.pr5.editor.vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
/**
 * Clase que me crea un panel en el que se mostrará la ayuda
 * @author Grupo18
 *
 */
public class VentanaInstrucciones extends JPanel{
	private JTextArea _areaDescripcion;
	
	/**
	 * Contructor por defecto
	 */
	public VentanaInstrucciones()
	{
		super();
		inicializacion();

	}
	/**
	 * Metodo que inicializa los componentes
	 */
	public void inicializacion()
	{
		this.setLayout(new FlowLayout());
		
		//Creo el TextArea
		_areaDescripcion=new JTextArea();
		_areaDescripcion.setEditable(false);
		//_areaDescripcion.setPreferredSize(new Dimension(880,600));
		
		//Cargo el archivo
		cargarArchivo();
		
		//Creo el ScrollPanel y le añado el textArea
		JScrollPane panelScroll=new JScrollPane(_areaDescripcion);
		panelScroll.setPreferredSize(new Dimension(880,600));
		this.add(panelScroll);	
	
	}
	
	/**
	 * Metodo que carga el archivo ayuda.txt
	 */
	private void cargarArchivo()
	{
		 FileReader fr = null;
		 BufferedReader br = null;
		 //Cadena de texto donde se guardara el contenido del archivo
		 String contenido = "";
		 try
		 {
			 //ruta puede ser de tipo String o tipo File
			 fr = new FileReader( "IntruccionesXML.txt" );
			 
			 br = new BufferedReader( fr );
			 String linea;
			 
			 //Obtenemos el contenido del archivo linea por linea
			 while( ( linea = br.readLine() ) != null ){
				 contenido += linea + "\n";
			 }
		 }catch( Exception e ){ }
		 //finally se utiliza para que si todo ocurre correctamente o si ocurre
		 //algun error se cierre el archivo que anteriormente abrimos
		 finally
		 {
			 try{
				 br.close();
			 }
			 catch( Exception ex ){}
		 }
		 _areaDescripcion.setText(contenido);
	}

}
