package lige.grupo18.pr5.editor.vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import lige.grupo18.pr5.editor.controlador.Controlador;
/** Clase Menu que extiende la clase JMenuBar y gestiona la configuracion de la barra de menu
@author Grupo18
@version 1.0
@see BufferedReader
@see FileReader
*/
public class Menu extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador _controlador;
	
	private JMenuItem _nuevo;
	//Creamos un submenu para abrir mapa
	private JMenuItem _abrir;
	//Creamos un submenu para guardar
	private JMenuItem _guardar;
	//Creamos un submenu para guardar como
	private JMenuItem _guardarComo;
	//Creamos un submenu para las instrucciones
	private JMenuItem _instrucciones;
	//Creamos un submenu para salir
	private JMenuItem _salir;
	
	private String _ruta;
	private String _fichero;
	
	/**
	 * Contructor
	 * @param controlador controlador
	 */
	public Menu(Controlador controlador)
	{
		super();
		_controlador=controlador;
		_ruta="";
		_fichero="";
		inicializar();
	}
	/**
	 * Metodo que inicializa
	 */
	public void inicializar()
	{
		//Creamos el menu principal
		JMenu menuOpciones = new JMenu("File");
		menuOpciones.setToolTipText("Que cosas puedes hacer");
		this.add(menuOpciones);
		
		//Creamos un submenu para nuevo mapa
		_nuevo = new JMenuItem("Nuevo");
		_nuevo.setToolTipText("Pulsa si quieres empezar a editar un nuevo mapa");
		_nuevo.addActionListener(new OyenteMenu());
		menuOpciones.add(_nuevo);
				
		//Creamos un submenu para abrir mapa
		_abrir = new JMenuItem("Abrir");
		_abrir.setToolTipText("Pulsa si quieres abrir y editar un mapa");
		_abrir.addActionListener(new OyenteMenu());
		menuOpciones.add(_abrir);
		
		//Creamos un submenu para guardar
		_guardar = new JMenuItem("Guardar");
		_guardar.setToolTipText("Pulsa si quieres guardar el mapa");
		_guardar.addActionListener(new OyenteMenu());
		_guardar.setEnabled(false);
		menuOpciones.add(_guardar);
		
		//Creamos un submenu para guardar como
		_guardarComo = new JMenuItem("Guardar como");
		_guardarComo.setToolTipText("Pulsa si quieres guardar el mapa");
		_guardarComo.addActionListener(new OyenteMenu());
		_guardarComo.setEnabled(false);
		menuOpciones.add(_guardarComo);
		
		//Creamos un submenu para las instrucciones
		_instrucciones = new JMenuItem("Instrucciones");
		_instrucciones.setToolTipText("Pulsa si quieres ver las instrucciones");
		_instrucciones.addActionListener(new OyenteMenu());
		menuOpciones.add(_instrucciones);
		
		//Creamos un submenu para salir
		_salir = new JMenuItem("Salir");
		_salir.setToolTipText("Para salir de la aplicación");
		_salir.addActionListener(new OyenteMenu());
		menuOpciones.add(_salir);
	}
	
	/** 
	 * Clase OyenteMenu que implementa ActionListener 
	 * para gestionar lo que hacer cuando se pulsa en un submenu
	*/
	class OyenteMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String accion=e.getActionCommand();
			
			if("Nuevo".equals(accion))
			{
				
				procesarNuevoMapa();
			}
			else if("Abrir".equals(accion))
			{
				procesarAbrirArhivo();
			}
			else if("Guardar".equals(accion))
			{
				procesarGuardarArchivo();
			}
			else if("Guardar como".equals(accion))
			{
				procesarGuardarComo();
			}
			else if("Instrucciones".equals(accion))
				generarMensajeInstrucciones();
			else if("Salir".equals(accion))
			{
				//Si hemos pulsado en salir preguntamos si queremos salir
				int salir = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
				if (salir == JOptionPane.YES_OPTION)
				     System.exit(0);
			}
		}
	}
	
	/**
	 * Mutador ruta
	 * @param ruta ruta
	 */
	public void setRuta(String ruta)
	{
		_ruta=ruta;
	}
	
	/**
	 * Metodo que procesa guardar un archivo
	 */
	public void procesarGuardarArchivo()
	{
		if(_fichero.equals("") || _ruta.equals(""))
			procesarGuardarComo();
		else
		{
			String ruta=_ruta+"\\"+_fichero;
			
			if(ruta.contains(".xml"))
		    	_controlador.solicitarGuardarMapa(ruta);
		    else
		    	_controlador.solicitarGuardarMapa(ruta+".xml");
			
		}
	}
	/**
	 * metodo que procesa guardar como...
	 */
	public void procesarGuardarComo()
	{
		JFileChooser jfc=new JFileChooser();
		jfc.setMultiSelectionEnabled(false);

		if(_ruta.equals(""))
			jfc.setCurrentDirectory(new File("."));
		else
			jfc.setCurrentDirectory(new File(_ruta));
	
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		jfc.setFileFilter(filtro);
		int valor=jfc.showSaveDialog(this.getParent());
		
		if (valor == JFileChooser.APPROVE_OPTION)
		{
		    File fichero = jfc.getSelectedFile();
		    String ruta=fichero.getAbsolutePath();
		    
		    if(ruta.contains(".xml"))
		    	_controlador.solicitarGuardarMapa(ruta);
		    else
		    	_controlador.solicitarGuardarMapa(ruta+".xml");
		    
		    _ruta=fichero.getAbsolutePath().substring(0,fichero.getAbsolutePath().lastIndexOf("\\")+1);
			_fichero=fichero.getName();
		}
	}
	/**
	 * metodo que procesa abrir un archivo
	 */
	public void procesarAbrirArhivo()
	{		
		JFileChooser jfc=new JFileChooser();
		jfc.setMultiSelectionEnabled(false);
		
		if(_ruta.equals(""))
			jfc.setCurrentDirectory(new File("."));
		else
			jfc.setCurrentDirectory(new File(_ruta));

		FileNameExtensionFilter filtro = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		jfc.setFileFilter(filtro);
		int valor=jfc.showOpenDialog(this.getParent());
		
		if (valor == JFileChooser.APPROVE_OPTION)
		{
			File fichero=jfc.getSelectedFile();
			_ruta=fichero.getAbsolutePath().substring(0,fichero.getAbsolutePath().lastIndexOf("\\")+1);
			_fichero=fichero.getName();
			
			_controlador.solicitarAbrirMapa(fichero);
			
		}
		
	}
	
	/**
	 * Método para generar las instrucciones del juego
	 */
	private void generarMensajeInstrucciones(){
		JDialog ventana=new JDialog();
		ventana.setAlwaysOnTop(true);
		ventana.setVisible(true);
		ventana.setSize(900,650);
		ventana.setLayout(new FlowLayout());
		ventana.add(new VentanaInstrucciones());
		ventana.setTitle("Instrucciones");
		ventana.setLocation(350,150);	
	}
	
	/**
	 * Metodo que procesa un nuevo mapa
	 */
	public void procesarNuevoMapa()
	{
		boolean correcto=false;
		String filas="";
		String columnas="";
		
		_fichero="";
		
		while(!correcto)
		{
			try{
				filas = JOptionPane.showInputDialog(null,"Introduce el numero de filas del mapa","");
				columnas = JOptionPane.showInputDialog(null,"Introduce el numero de columnas del mapa","");
			}
			catch(NullPointerException ex)
			{}
			
			if(filas==null || columnas==null || filas.equals("") || columnas.equals(""))
				JOptionPane.showMessageDialog(null,"Debes introducir un valor para el tamaño de las filas y las columnas","Error",JOptionPane.WARNING_MESSAGE);
			else 
				correcto=true;
		}
		
		_controlador.solicitarCrearNuevoMapa(Integer.parseInt(filas),Integer.parseInt(columnas));
	}
	/**
	 * metodo que habilita la opcion de guardar
	 */
	public void habilitarGuardar()
	{
		_guardar.setEnabled(true);
		_guardarComo.setEnabled(true);
	}
}
