package lige.grupo18.pr5.editor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import lige.grupo18.pr5.editor.Directions;
import lige.grupo18.pr5.editor.modelo.Door;

/**
 * Clase que contiene el panel con las puertas de la habitación
 * @author grupo18
 *
 */
public class PanelPuertasHabitacion extends JPanel{

	/**
	 * variables locales
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable _tabla;
	private TablaPuertas _tablaPuertas;
	private JTextField _txtId;
	private JComboBox<String> _comboDirecciones;
	private JCheckBox _chkAbierta;
	private ArrayList<Door> _arrayPuertas;
	
	/**
	 * Contructor
	 */
	public PanelPuertasHabitacion()
	{
		super();
		inicializar();
	}
	/**
	 * metodo quye inicializa los componentes
	 */
	public void inicializar()
	{
		this.setLayout(new BorderLayout(1,1));
		TitledBorder titulo = BorderFactory.createTitledBorder("Configuración Puertas");
		titulo.setTitleColor(Color.blue);
		this.setBorder(titulo);
		
		JPanel panelConfiguracionPuertas=new JPanel(new GridLayout(3,2,5,30));
		
		_arrayPuertas=new ArrayList<Door>();
		
		JLabel lblId=new JLabel("Identificador :");
		_txtId=new JTextField();
		
		JLabel lblDireccion=new JLabel("Dirección :");
		_comboDirecciones=new JComboBox<String>();
		_comboDirecciones.addItem(Directions.NORTE.toString());
		_comboDirecciones.addItem(Directions.SUR.toString());
		_comboDirecciones.addItem(Directions.ESTE.toString());
		_comboDirecciones.addItem(Directions.OESTE.toString());
		
		JLabel lblSalida=new JLabel("Esta abierta? :");
		_chkAbierta=new JCheckBox();
		
		panelConfiguracionPuertas.add(lblId);
		panelConfiguracionPuertas.add(_txtId);
		panelConfiguracionPuertas.add(lblDireccion);
		panelConfiguracionPuertas.add(_comboDirecciones);
		panelConfiguracionPuertas.add(lblSalida);
		panelConfiguracionPuertas.add(_chkAbierta);
		
		this.add(panelConfiguracionPuertas,BorderLayout.NORTH);
		
		
		
		JButton btAñadir=new JButton("Añadir");
		JButton btEliminar=new JButton("Quitar");
		OyenteBotones oyente= new OyenteBotones();
		btAñadir.addActionListener(oyente);
		btEliminar.addActionListener(oyente);
		
		JPanel panelBotones=new JPanel();
		panelBotones.add(btAñadir);
		panelBotones.add(btEliminar);
		this.add(panelBotones,BorderLayout.CENTER);
		
		
		//inicializarTabla
		
		_tablaPuertas = new TablaPuertas();
		_tabla = new JTable(_tablaPuertas);
		
		_tabla.setGridColor(Color.WHITE);
		_tabla.setSelectionForeground(Color.WHITE);
		_tabla.setPreferredScrollableViewportSize(new Dimension(50,50));
		_tabla.setColumnSelectionAllowed(false);
		
		JScrollPane panelScroll = new JScrollPane(_tabla);
		
		this.add(panelScroll,BorderLayout.SOUTH);

	}
	/**
	 * Metodo que carga la tabla de puertas
	 */
	public void cargarTablaPuertas()
	{
		_tablaPuertas.removeAll();		
		_tablaPuertas.inicializa(_arrayPuertas);
		_tablaPuertas.fireTableDataChanged();
		_tabla.repaint();
		
	}
	
	/**
	 * Mutador de array de puertas
	 * @param puertas array de puertas
	 */
	public void setArrayPuertas(ArrayList<Door> puertas)
	{
		_arrayPuertas=puertas;
	}
	
	/**
	 * Clase que tiene la tabla abstracta para el array de puertas
	 * @author grupo18
	 *
	 */
	private class TablaPuertas extends AbstractTableModel{
		/**
		 * Serialization version number
		 */
		private static final long serialVersionUID = 1L;

		//COLUMNAS Y ELEMENTOS DEL JUGADOR
		final String[] _columnNames = { "Identificador", "Dirección", "Abierta" };
		final ArrayList<Door> _dato = new ArrayList<Door>();
		
		/**
		 * Constructor por defecto de la clase
		 */
		public TablaPuertas(){
			super();
		}
		
		/**
		 * Metodo que inicializa/actualiza la tabla
		 * @param inventario 
		 */
		public void inicializa(ArrayList<Door> arrayPuertas){

			int longitud = arrayPuertas.size();
			for(int i=0;i<longitud;i++){
				_dato.add(arrayPuertas.get(i));
				_comboDirecciones.removeItem(arrayPuertas.get(i).getDireccion().toString());
			}
		}
		
		/**
		 * Devuelve el numero de columnas del modelo
		 */
		public int getColumnCount() {
			return _columnNames.length;
		}
		
		/**
		 * Devuelve el numero de filas
		 */
		public int getRowCount() {
			return _dato.size();
		}

		/**
		 * Devuelve el nombre de la columna dada
		 */
		public String getColumnName(int col) {
			return _columnNames[col];
		}

		/**
		 * Devuelve el valor en la fila y columna dadas
		 * @return String devuelve el String correspondiente del id o descripcion
		 */
		public String getValueAt(int row,int col) {
			String valor = "";
		
			if (row > -1){ 
				if (col == 0) {
					valor = _dato.get(row).getId();
				} else if (col == 1) {
					valor = _dato.get(row).getDireccion().toString();
				}
				else if(col==2)
				{
					valor =String.valueOf(_dato.get(row).isOpen());
				}
			}

			return valor;
		}
		
		/**
		 * Elimina toda la tabla eliminandolos del arrayList
		 */
		public void removeAll() {
			//_dato.removeAllElements();
			_dato.removeAll(_dato);
		}

		/**
		 * Añade un elemento a la tabla
		 * @param value
		 * @param index
		 */
		@SuppressWarnings("unused")
		public void setValueAt(Door value, int index) {

			_dato.add(index, value);
		}
		
		
	}
	
	/**
	 * Clase oyente del panel d epuertas
	 * @author grupo18
	 *
	 */
	class OyenteBotones implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String accion=e.getActionCommand();
			if("Añadir".equals(accion))
			{
				procesarAñadir();
			}
			else if("Quitar".equals(accion))
			{
				procesarQuitar();
			}
		}
	}
	
	/**
	 * Metodo de añadir
	 */
	public void procesarAñadir()
	{
		
			if(_txtId.getText().equals(""))
				JOptionPane.showMessageDialog(getParent(), "Debes introducir un identificador para la puerta", "Aviso",JOptionPane.WARNING_MESSAGE);
			else if(_comboDirecciones.getItemCount()==0)
				JOptionPane.showMessageDialog(getParent(), "No puedes introducir más puertas", "Aviso",JOptionPane.WARNING_MESSAGE);
			else
			{
				String opcion=_comboDirecciones.getSelectedItem().toString();
				Directions direccion;
				switch(opcion)
				{
					case "NORTE":
						direccion=Directions.NORTE;
						break;
					case "SUR":
						direccion=Directions.SUR;
						break;
					case "ESTE":
						direccion=Directions.ESTE;
						break;
					case "OESTE":
						direccion=Directions.OESTE;
						break;
					default:
						direccion=Directions.NONE;
						break;
				}
				
				_comboDirecciones.removeItemAt(_comboDirecciones.getSelectedIndex());
				
				Door puerta = new Door(_txtId.getText(),direccion,_chkAbierta.isSelected());
				_arrayPuertas.add(puerta);
				
				cargarTablaPuertas();
				reiniciarFormulario();
			}
	}
	/**
	 * Metodo de quitar
	 */
	public void procesarQuitar()
	{
		if(_tabla.getSelectedRow()==-1)
			JOptionPane.showMessageDialog(getParent(), "Debes seleccionar una puerta de la tabla", "Aviso",JOptionPane.WARNING_MESSAGE);
		else
		{
			int i=0;
			boolean encontrado=false;
			while(i<_arrayPuertas.size() && !encontrado)
			{
				if(_arrayPuertas.get(i).getId().equals(_tablaPuertas.getValueAt(_tabla.getSelectedRow(),0)))
				{
					_comboDirecciones.addItem(_arrayPuertas.get(i).getDireccion().toString());
					_arrayPuertas.remove(i);
					encontrado=true;
				}
				else
					i++;
			}
			
			cargarTablaPuertas();

			
		}
	}
	/**
	 * Metodo de reiniciar formulario
	 */
	public void reiniciarFormulario()
	{
		_txtId.setText("");
		_chkAbierta.setSelected(false);
		
	}
	/**
	 * Metodo de reiniciar combo
	 */
	public void reiniciarCombo()
	{
		_comboDirecciones.removeAllItems();
		_comboDirecciones.addItem(Directions.NORTE.toString());
		_comboDirecciones.addItem(Directions.SUR.toString());
		_comboDirecciones.addItem(Directions.ESTE.toString());
		_comboDirecciones.addItem(Directions.OESTE.toString());
	}
	/**
	 * Accedente de puertas
	 * @return array de puertas
	 */
	public ArrayList<Door> getPuertas()
	{
		return _arrayPuertas;
	}
	
	/**
	 * Metodo que vacia la tabla
	 */
	public void vaciarTabla()
	{
		_arrayPuertas=new ArrayList<Door>();
		cargarTablaPuertas();
	}
	
	
}
