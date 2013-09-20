package lige.grupo18.pr5.editor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

import lige.grupo18.pr5.editor.Directions;
import lige.grupo18.pr5.editor.controlador.Controlador;
import lige.grupo18.pr5.editor.modelo.Door;
import lige.grupo18.pr5.editor.modelo.Room;
import lige.grupo18.pr5.editor.modelo.items.Item;
/**
 * Clase que contiene el panel con el mapa de habitaciones
 * @author grupo18
 *
 */
public class PanelMapaHabitaciones extends JPanel{

	/**
	 * Variables locales
	 */
	private static final long serialVersionUID = 1L;
	private Controlador _controlador;
	private int _filas;
	private int _columnas;
	private BotonMapa[][] _tablaBotones;
	private PanelDescripcionHabitacion _panelDescripcionHabitacion;
	private PanelPuertasHabitacion _panelPuertasHabitacion;
	private PanelItemsHabitacion _panelItemsHabitacion;
	private PanelBotonesConfirmar _panelBotonesConfirmar;
	private JSplitPane _panelSplitAccionesJugador;
	
	/**
	 * constructor
	 * @param controlador controlador
	 * @param filas filas
	 * @param columnas columnas
	 */
	public PanelMapaHabitaciones(Controlador controlador,int filas,int columnas)
	{
		super();
		_controlador=controlador;
		_filas=filas;
		_columnas=columnas;
		_tablaBotones=new BotonMapa[_filas][_columnas];		
		inicializar();
	}
	/**
	 * metodo que inicializa
	 */
	public void inicializar()
	{
		this.setLayout(new BorderLayout());
		//Creamos un panel para los botones de las habitaciones
		JPanel panelBotonesHabitaciones = new JPanel();
		panelBotonesHabitaciones.setLayout(new GridLayout(_filas,_columnas,1,1));
		TitledBorder titulo = BorderFactory.createTitledBorder("Mapa");
		titulo.setTitleColor(Color.blue);
		panelBotonesHabitaciones.setBorder(titulo);
		//Creamos un listener que sera el encargado de gestionar cuando se pulsa un boton
		OyenteMapa oyenteListener = new OyenteMapa();

		Dimension dimension = new Dimension(40,20);
		//Creamos los botones
		for(int i = 0; i < _filas; i++)
		{
			for(int j = 0; j < _columnas; j++){
				
				_tablaBotones[i][j] = new BotonMapa(i,j,null);
				_tablaBotones[i][j].addActionListener(oyenteListener);
				_tablaBotones[i][j].setBackground(Color.WHITE);
				_tablaBotones[i][j].setPreferredSize(dimension);
				_tablaBotones[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLUE));
				
				panelBotonesHabitaciones.add(_tablaBotones[i][j]);
			}
		}
		
		panelBotonesHabitaciones.setVisible(true);
		this.add(panelBotonesHabitaciones,BorderLayout.NORTH);
		
		
	}
	
	/**
	 * Metodo que crea los panales
	 * @param x variable x
	 * @param y variable y
	 */
	public void crearPanelesConfiguracionHabitacion(int x,int y)
	{
		if(_panelDescripcionHabitacion!=null)
		{
				_panelDescripcionHabitacion.setVisible(true);
				_panelPuertasHabitacion.setVisible(true);
				_panelItemsHabitacion.setVisible(true);
				_panelSplitAccionesJugador.setVisible(true);
				_panelBotonesConfirmar.setVisible(true);
				
				_panelSplitAccionesJugador.setDividerLocation(400);

				
				_panelBotonesConfirmar.setX(x);
				_panelBotonesConfirmar.setY(y);
		}
		else
		{
		
			JPanel panelConfiguracionHabitacion=new JPanel();
			panelConfiguracionHabitacion.setLayout(new BorderLayout());
			
			_panelDescripcionHabitacion=new PanelDescripcionHabitacion();
			panelConfiguracionHabitacion.add(_panelDescripcionHabitacion,BorderLayout.NORTH);
			
			_panelPuertasHabitacion=new PanelPuertasHabitacion();
			//panelConfiguracionHabitacion.add(_panelPuertasHabitacion,BorderLayout.CENTER);
			
			_panelItemsHabitacion=new PanelItemsHabitacion();
			//panelConfiguracionHabitacion.add(_panelItemsHabitacion,BorderLayout.SOUTH);
			
			_panelSplitAccionesJugador = new JSplitPane();
			_panelSplitAccionesJugador.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
			_panelSplitAccionesJugador.setLeftComponent(_panelPuertasHabitacion);
			_panelSplitAccionesJugador.setRightComponent(_panelItemsHabitacion);
			_panelSplitAccionesJugador.setDividerLocation(400);
			_panelSplitAccionesJugador.setPreferredSize(new Dimension(900,300));
			
			panelConfiguracionHabitacion.add(_panelSplitAccionesJugador,BorderLayout.CENTER);
			
			this.add(panelConfiguracionHabitacion,BorderLayout.CENTER);
			
			_panelBotonesConfirmar=new PanelBotonesConfirmar(_controlador,_panelDescripcionHabitacion,_panelPuertasHabitacion,_panelItemsHabitacion,x,y,_panelSplitAccionesJugador,this);
			this.add(_panelBotonesConfirmar,BorderLayout.SOUTH);
			
			this.updateUI();
		
		}
	}
	/**
	 * Mutador de idhabitacion
	 * @param id identificador de habitacion
	 */
	public void setIdHabitacion(String id)
	{
		_panelDescripcionHabitacion.setIdHabitacion(id);
	}
	/**
	 * Mutador de descripcion
	 * @param descripcion descripcion
	 */
	public void setDescripcionHabitacion(String descripcion)
	{
		_panelDescripcionHabitacion.setDescripcion(descripcion);
	}
	/**
	 * Mutador de salida
	 * @param salida si es salida o no
	 */
	public void setSalida(boolean salida)
	{
		_panelDescripcionHabitacion.setSalida(salida);
	}
	/**
	 * Mutador de array de puertas
	 * @param puertas array con las puertas
	 */
	public void setArrayPuertas(ArrayList<Door> puertas)
	{
		_panelPuertasHabitacion.setArrayPuertas(puertas);
	}
	/**
	 * Mutador del array de items
	 * @param items array con los items
	 */
	public void setArrayItems(ArrayList<Item> items)
	{
		_panelItemsHabitacion.setArrayItems(items);
	}
	/**
	 * metodo que actualiza la tabla
	 */
	public void actualizarTablas()
	{
		_panelPuertasHabitacion.cargarTablaPuertas();
		_panelItemsHabitacion.cargarTablaItems();
	}
	/**
	 * Mutador de habitaciones
	 * @param x posicion x
	 * @param y posicion y
	 * @param habitacion habitacion
	 */
	public void setHabitacion(int x,int y,Room habitacion)
	{
		_tablaBotones[x][y].setHabitacion(habitacion);
	}
	/**
	 * Metodo que reestablece el boton
	 * @param x posicion x
	 * @param y posicion y
	 */
	public void reestablecerBoton(int x,int y)
	{
		_tablaBotones[x][y].setText("");
		_tablaBotones[x][y].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLUE));
	}
	/**
	 * Metodo de actualizar
	 * @param habitacion habitacion
	 */
	public void update(Room habitacion)
	{
		int x=habitacion.getX();
		int y=habitacion.getY();
		
		_tablaBotones[x][y].setText(habitacion.getNombre());
		_tablaBotones[x][y].setHabitacion(habitacion);
		
		updateBordersDoor(x,y,habitacion.getPuertas());
		
	}
	/**
	 * 
	 * @param x posicion x
	 * @param y posicion y
	 * @return habitacion
	 */
	public Room getHabitacion(int x,int y)
	{
		return _tablaBotones[x][y].getRoom();
	}
	/**
	 * metodo q actualiza las puertas
	 * @param x posicion x
	 * @param y posicion y
	 * @param array array de puertas
	 */
	public void updateBordersDoor(int x,int y,ArrayList<Door> array)
	{
		int norte=1;
		int sur=1;
		int este=1;
		int oeste=1;
		
		int i=0;
		
		while(i<array.size())
		{
			if(array.get(i).getDireccion().equals(Directions.NORTE))
			{
				if(array.get(i).isOpen())
					norte=2;
				else
					norte=5;
			}
			else if(array.get(i).getDireccion().equals(Directions.SUR))
			{
				if(array.get(i).isOpen())
					sur=2;
				else
					sur=5;
			}
			else if(array.get(i).getDireccion().equals(Directions.ESTE))
			{
				if(array.get(i).isOpen())
					este=2;
				else
					este=5;
			}
			else if(array.get(i).getDireccion().equals(Directions.OESTE))
			{
				if(array.get(i).isOpen())
					oeste=2;
				else
					oeste=5;
			}
			
			i++;
		}
		
		_tablaBotones[x][y].setBorder(BorderFactory.createMatteBorder(norte,oeste,sur,este,Color.red));
		
	}
	
	/** Clase OyenteListener que implementa ActionListener 
	 * para gestionar lo que hacer cuando se pulsa en una habitacion
	*/
	class OyenteMapa implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			BotonMapa boton = (BotonMapa)e.getSource();
				
			crearPanelesConfiguracionHabitacion(boton.getCoordenadaX(),boton.getCoordenadaY());
			
			_panelDescripcionHabitacion.reiniciarFormulario();
			_panelPuertasHabitacion.reiniciarFormulario();
			_panelPuertasHabitacion.vaciarTabla();
			_panelItemsHabitacion.reiniciarFormulario();
			_panelItemsHabitacion.vaciarTabla();
			_panelPuertasHabitacion.reiniciarCombo();
			
			if(boton.getRoom()!=null)
			{
				//_controlador.solicitarCargarHabitacion(boton.getCoordenadaX(),boton.getCoordenadaY());
				
				setIdHabitacion(boton.getIdHabitacion());
				setDescripcionHabitacion(boton.getDescripcionHabitacion());
				setSalida(boton.getSalida());
				
				setArrayPuertas(boton.getArrayPuertas());
				setArrayItems(boton.getArrayItems());
				actualizarTablas();
			}
				
				
			
		}
	}
	
}
