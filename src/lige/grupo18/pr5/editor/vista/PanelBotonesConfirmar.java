package lige.grupo18.pr5.editor.vista;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import lige.grupo18.pr5.editor.controlador.Controlador;

/**
 * Clase que contiene el panel de los botones de confirmación
 * @author Grupo 18
 *
 */
@SuppressWarnings("serial")
public class PanelBotonesConfirmar extends JPanel{

	//Variables locales
	private Controlador _controlador;
	
	private JButton _btGuardar;
	private JButton _btEliminar;
	private JButton _btCancelar;
	
	private PanelMapaHabitaciones _panelMapaHabitaciones;
	private PanelDescripcionHabitacion _panelDescripcionHabitacion;
	private PanelPuertasHabitacion _panelPuertasHabitacion;
	private PanelItemsHabitacion _panelItemsHabitacion;
	private JSplitPane _panelSplitAccionesJugador;
	
	private int _x;
	private int _y;
	
	/**
	 * Constructor por defecto
	 * @param controlador controlador
	 * @param panelDescripcion panel de descripcion
	 * @param panelPuertas panale de puertas
	 * @param panelItems panel de items
	 * @param x posicion x
	 * @param y posicion y
	 * @param panelSplitAccionesJugador panel de acciones
	 * @param panelMapaHabitaciones panel de mapa
	 */
	public PanelBotonesConfirmar(Controlador controlador,PanelDescripcionHabitacion panelDescripcion,PanelPuertasHabitacion panelPuertas,PanelItemsHabitacion panelItems,int x,int y,JSplitPane panelSplitAccionesJugador,PanelMapaHabitaciones panelMapaHabitaciones)
	{
		super();
		_controlador=controlador;
		_panelDescripcionHabitacion=panelDescripcion;
		_panelPuertasHabitacion=panelPuertas;
		_panelItemsHabitacion=panelItems;
		_x=x;
		_y=y;
		_panelSplitAccionesJugador=panelSplitAccionesJugador;
		_panelMapaHabitaciones=panelMapaHabitaciones;
		inicializar();
		
		
	}
	
	/**
	 * Metodo inicializador
	 */
	public void inicializar()
	{
		this.setLayout(new FlowLayout());
		
		OyenteBotones oyente=new OyenteBotones();
		
		_btGuardar=new JButton("Guardar Habitación");
		_btEliminar=new JButton("Eliminar Habitación");
		_btCancelar=new JButton("Cancelar");
		
		_btGuardar.addActionListener(oyente);
		_btEliminar.addActionListener(oyente);
		_btCancelar.addActionListener(oyente);
		
		this.add(_btGuardar);
		this.add(_btEliminar);
		this.add(_btCancelar);
		
	}
	/**
	 * Mutador de posicion de x
	 * @param x posicion x
	 */
	public void setX(int x)
	{
		_x=x;
	}
	/**
	 * Mutador posicion y
	 * @param y
	 */
	public void setY(int y)
	{
		_y=y;
	}
	
	/**
	 * Clase oyente para las acciones
	 * @author grupo 18
	 *
	 */
	class OyenteBotones implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String accion=e.getActionCommand();
			if("Guardar Habitación".equals(accion))
			{
				JButton boton = (JButton)e.getSource();
				procesarGuardar(boton);
			}
			else if("Eliminar Habitación".equals(accion))
			{
				JButton boton = (JButton)e.getSource();
				procesarEliminar(boton);
			}
			else if("Cancelar".equals(accion))
			{
				JButton boton = (JButton)e.getSource();
				procesarCancelar(boton);
			}
		}
	}
	
	/**
	 * Metodo que procesa la información
	 * @param boton boton
	 */
	public void procesarGuardar(JButton boton)
	{
		if(_panelDescripcionHabitacion.getIdHabitacion().equals(""))
			JOptionPane.showMessageDialog(getParent(), "Debes introducir el identificador de la habitación", "Aviso",JOptionPane.WARNING_MESSAGE);
		else if(_panelDescripcionHabitacion.getDescripcionHabitacion().equals(""))
			JOptionPane.showMessageDialog(getParent(), "Debes introducir la descripción de la habitación", "Aviso",JOptionPane.WARNING_MESSAGE);
		else
		{
			_controlador.solicitarGuardarHabitacion(_panelDescripcionHabitacion.getIdHabitacion(),_panelDescripcionHabitacion.getDescripcionHabitacion(),_panelDescripcionHabitacion.getEsSalida(),_x,_y, _panelPuertasHabitacion.getPuertas(), _panelItemsHabitacion.getItems());
			
			JOptionPane.showMessageDialog(getParent(), "La habitación se guardó correctamente", "Aviso",JOptionPane.INFORMATION_MESSAGE);

			reinciarVista();
			boton.getParent().setVisible(false);

		}
	}
	/**
	 * Metodo del boton cancelar
	 * @param boton boton
	 */
	public void procesarCancelar(JButton boton)
	{
		reinciarVista();
		boton.getParent().setVisible(false);

	}
	/**
	 * metodo del boton eliminar
	 * @param boton boton
	 */
	public void procesarEliminar(JButton boton)
	{
		if(_panelMapaHabitaciones.getHabitacion(_x, _y)!=null)
		{
			int opcion=JOptionPane.showConfirmDialog(getParent(), "Estas seguro de eliminar esta habitación?", "Eliminar",JOptionPane.INFORMATION_MESSAGE);
			if(opcion==JOptionPane.OK_OPTION)
			{
				_controlador.solicitarEliminarHabitacion(_x,_y);
				JOptionPane.showMessageDialog(getParent(), "La habitación se eliminó correctamente", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
				
				reinciarVista();
				boton.getParent().setVisible(false);
			}
		}
		else
			JOptionPane.showMessageDialog(getParent(), "No hay ninguna habitación seleccionada", "Aviso",JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Metodo que reinicia toda la vista de la app
	 */
	public void reinciarVista()
	{
		_panelDescripcionHabitacion.setVisible(false);
		_panelPuertasHabitacion.setVisible(false);
		_panelItemsHabitacion.setVisible(false);
		_panelSplitAccionesJugador.setVisible(false);
		
		
		_panelDescripcionHabitacion.reiniciarFormulario();
		_panelPuertasHabitacion.reiniciarFormulario();
		_panelPuertasHabitacion.vaciarTabla();
		_panelPuertasHabitacion.reiniciarCombo();
		_panelItemsHabitacion.reiniciarFormulario();
		_panelItemsHabitacion.vaciarTabla();
	}
	
}
