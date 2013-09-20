package lige.grupo18.pr5.editor.vista;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Clase que contiene todos un panel con todos los elementos de la descripción
 * @author grupo 18
 *
 */
public class PanelDescripcionHabitacion extends JPanel{

	/**
	 * Variables locales
	 */
	private static final long serialVersionUID = 1L;
	private JTextField _txtId;
	private JTextArea _txtDescripcion;
	private JCheckBox _chkSalida;
	/**
	 * Constructor
	 */
	public PanelDescripcionHabitacion()
	{
		super();
		inicializar();
	}
	/**
	 * Metodo que inicializa el panel
	 */
	public void inicializar()
	{
		this.setLayout(new GridLayout(3,2,5,5));
		TitledBorder titulo = BorderFactory.createTitledBorder("Configuración Habitación");
		titulo.setTitleColor(Color.blue);
		this.setBorder(titulo);
		
		JLabel lblId=new JLabel("Identificador :");
		_txtId=new JTextField();
		
		JLabel lblDescripcion=new JLabel("Descripción :");
		_txtDescripcion=new JTextArea(2,20);
		JScrollPane scrollPane = new JScrollPane(_txtDescripcion); 
		
		JLabel lblSalida=new JLabel("Es salida? :");
		_chkSalida=new JCheckBox();
		
		
		add(lblId);
		add(_txtId);
		add(lblDescripcion);
		add(scrollPane);
		add(lblSalida);
		add(_chkSalida);
	}
	/**
	 * Reinicia el formulario
	 */
	public void reiniciarFormulario()
	{
		_txtId.setText("");
		_txtDescripcion.setText("");
		_chkSalida.setSelected(false);
	}
	/**
	 * Accedente del idHabitacion
	 * @return Habitacion 
	 */
	public String getIdHabitacion()
	{
		return _txtId.getText();
	}
	/**
	 * Accedente de la descripción
	 * @return descripción
	 */
	public String getDescripcionHabitacion()
	{
		return _txtDescripcion.getText();
	}
	/**
	 * Accedente de si es salida
	 * @return salida
	 */
	public boolean getEsSalida()
	{
		return _chkSalida.isSelected();
	}
	/**
	 * Mutador idhabitacion
	 * @param id idhabitacion
	 */
	public void setIdHabitacion(String id)
	{
		_txtId.setText(id);
	}
	/**
	 * Mutador descripción
	 * @param descripcion descripcion
	 */
	public void setDescripcion(String descripcion)
	{
		_txtDescripcion.setText(descripcion);
	}
	/**
	 * Mutador de salida
	 * @param salida salida
	 */
	public void setSalida(boolean salida)
	{
		_chkSalida.setSelected(salida);
	}

}
