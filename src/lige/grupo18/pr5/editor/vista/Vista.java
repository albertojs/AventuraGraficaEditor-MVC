package lige.grupo18.pr5.editor.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lige.grupo18.pr5.editor.controlador.Controlador;
import lige.grupo18.pr5.editor.modelo.eventos.Evento;
import lige.grupo18.pr5.editor.modelo.eventos.EventoAbrirMapa;
import lige.grupo18.pr5.editor.modelo.eventos.EventoEliminarHabitacion;
import lige.grupo18.pr5.editor.modelo.eventos.EventoGuardarHabitacion;
import lige.grupo18.pr5.editor.modelo.eventos.EventoGuardarMapa;
import lige.grupo18.pr5.editor.modelo.eventos.EventoNuevoMapa;

/**
 * Clase Vista
 * @author grupo18
 *
 */
public class Vista extends JFrame implements Observer{

	/**
	 * Variables locales
	 */
	private static final long serialVersionUID = 1L;
	private Controlador _controlador;
	private PanelMapaHabitaciones _panelMapaHabitaciones;
	private Menu _menu;
	
	/**
	 * Contructor
	 * @param controlador
	 */
	public Vista(Controlador controlador)
	{
		super("Editor Aventura Gráfica");
		_controlador=controlador;
		inicializar();		
	}

	/**
	 * Metodo que inicializa los componetes
	 */
	public void inicializar()
	{
		//Asignamos un contenedor de tipo BorderLayout
		setLayout(new BorderLayout());
		
		//Añadimos una barra de menu
		_menu=new Menu(_controlador);
		setJMenuBar(_menu);
		
		//Terminamos de configurar el JFrame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setSize(900,950);
		this.setMinimumSize(new Dimension(900,400));
		this.setLocation(350,0);
		//this.setResizable(false);
	}
	
	/**
	 * Metodo para actualizar la vista
	 */
	public void update(Observable modelo, Object objeto) {
		Evento evento;
		evento = (Evento)objeto;
		switch(evento.getTipo()){
			case EventoNuevoMapa:
				procesarNuevoMapa(evento);
				break;
			case EventoGuardarHabitacion:
				procesarGuardarHabitacion(evento);
				break;
			case EventoEliminarHabitacion:
				procesarEliminarHabitacion(evento);
				break;
			case EventoAbrirMapa:
				procesarAbrirMapa(evento);
				break;
			case EventoGuardarMapa:
				procesarGuardarMapa(evento);
				break;
			default:
				break;
		
		}
		
	}
	/**
	 * Metodo que procesa guardar el mapa
	 * @param evento evento
	 */
	public void procesarGuardarMapa(Evento evento)
	{
		EventoGuardarMapa EventoGuardarMapa=(EventoGuardarMapa)evento;
		
		if(EventoGuardarMapa.getResultado())
		{
			JOptionPane.showMessageDialog(null,"El mapa se ha guardado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null,"Se ha producido un error al guardar el mapa", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	/**
	 * Metodo que procesa abrir el mapa
	 * @param evento evento
	 */
	public void procesarAbrirMapa(Evento evento)
	{
		EventoAbrirMapa eventoAbrirMapa=(EventoAbrirMapa)evento;
		if(eventoAbrirMapa.getResultado())
		{
		
			if(_panelMapaHabitaciones!=null)
			{
				_panelMapaHabitaciones.removeAll();
				this.revalidate();
			}
			
			_panelMapaHabitaciones = new PanelMapaHabitaciones(_controlador,eventoAbrirMapa.getAlto(),eventoAbrirMapa.getAncho());
			this.add(_panelMapaHabitaciones,BorderLayout.NORTH);
			
			for(int i=0;i<eventoAbrirMapa.getNumeroHabitaciones();i++)
			{
				_panelMapaHabitaciones.update(eventoAbrirMapa.getHabitacion(i));
			}
			
			_menu.habilitarGuardar();
			this.pack();
			this.setSize(900,810);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Se ha producido un error al cargar el mapa", "Mensaje", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Metodo que procesa eliminar habitacion
	 * @param evento evento
	 */
	public void procesarEliminarHabitacion(Evento evento)
	{
		EventoEliminarHabitacion eventoEliminarHabitacion=(EventoEliminarHabitacion)evento;
		
		_panelMapaHabitaciones.setHabitacion(eventoEliminarHabitacion.getX(),eventoEliminarHabitacion.getY(), null);
		_panelMapaHabitaciones.reestablecerBoton(eventoEliminarHabitacion.getX(),eventoEliminarHabitacion.getY());
	}
	/**
	 * Metodo que procesa guardar habitacion
	 * @param evento evento
	 */
	public void procesarGuardarHabitacion(Evento evento)
	{
		EventoGuardarHabitacion eventoGuardarHabitacion=(EventoGuardarHabitacion)evento;
		_panelMapaHabitaciones.update(eventoGuardarHabitacion.getHabitacion());
	}
	/**
	 * Metodo que procesa nuevo mapa
	 * @param evento evento
	 */
	public void procesarNuevoMapa(Evento evento)
	{
		if(_panelMapaHabitaciones!=null)
		{
			_panelMapaHabitaciones.removeAll();
			this.revalidate();
			
		}
		
		EventoNuevoMapa eventoMapaNuevo=(EventoNuevoMapa)evento;
		
		_menu.habilitarGuardar();
		int filas=eventoMapaNuevo.getFilas();
		int columnas=eventoMapaNuevo.getColumnas();
		
		_panelMapaHabitaciones = new PanelMapaHabitaciones(_controlador,filas,columnas);
		this.add(_panelMapaHabitaciones,BorderLayout.NORTH);
			
		this.pack();
		this.setSize(900,810);
		
		
	}
	
}
