package lige.grupo18.pr5.editor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import lige.grupo18.pr5.editor.modelo.items.Comida;
import lige.grupo18.pr5.editor.modelo.items.Item;
import lige.grupo18.pr5.editor.modelo.items.Llave;
import lige.grupo18.pr5.editor.modelo.items.ObjetoValor;

/**
 * Clase que contiene el panel con los componentes de los items
 * @author grupo18
 *
 */
public class PanelItemsHabitacion extends JPanel{

	
	/**
	 * Variables locales
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel _lblOpcion;
	private JLabel _lblOpcion2;
	private JTextField _txtOpcion2;
	private JTextField _txtOpcion;
	private JTable _tabla;
	private TablaItems _tablaItems;
	private ArrayList<Item> _arrayItems;
	private JTextField _txtId;
	private JTextArea _txtDescripcion;
	private JRadioButton _rbLlave;
	private JRadioButton _rbComida;
	private JRadioButton _rbObjeto;
	
	/**
	 * Contructor
	 */
	public PanelItemsHabitacion()
	{
		super();
		inicializar();
		
	}
	/**
	 * Metodo que inicializa los componentes
	 */
	public void inicializar()
	{
		this.setLayout(new BorderLayout());
		TitledBorder titulo = BorderFactory.createTitledBorder("Configuración Items");
		titulo.setTitleColor(Color.blue);
		this.setBorder(titulo);
		
		JPanel panelConfiguracionItems=new JPanel(new GridLayout(4,2,5,5));
		
		_arrayItems=new ArrayList<Item>();
		
		OyenteBotones oyente=new OyenteBotones();
		
		JLabel lblId=new JLabel("Identificador :");
		_txtId=new JTextField();
		
		JLabel lblDescripcion=new JLabel("Descripción :");
		_txtDescripcion=new JTextArea(2,20);
		JScrollPane scrollPane = new JScrollPane(_txtDescripcion); 
		
		JLabel lblTipo=new JLabel("Tipo :");
		_rbLlave = new JRadioButton("Llave");
		_rbComida = new JRadioButton("Comida");
		_rbObjeto = new JRadioButton("Objeto de valor");
		
		_rbLlave.addActionListener(oyente);
		_rbComida.addActionListener(oyente);
		_rbObjeto.addActionListener(oyente);
		
		ButtonGroup group = new ButtonGroup();
		group.add(_rbLlave);
		group.add(_rbComida);
		group.add(_rbObjeto);
		
		JPanel panelRadioButtons=new JPanel(new GridLayout(1,3,5,5));
		panelRadioButtons.add(_rbLlave);
		panelRadioButtons.add(_rbComida);
		panelRadioButtons.add(_rbObjeto);
		
		
		_lblOpcion=new JLabel("Identificador puerta :");
		_txtOpcion=new JTextField();
		_lblOpcion.setVisible(false);
		_txtOpcion.setVisible(false);
		
		_lblOpcion2=new JLabel("");
		_txtOpcion2=new JTextField();
		_lblOpcion2.setVisible(false);
		_txtOpcion2.setVisible(false);
		
		JPanel panelOpcionesItems=new JPanel(new GridLayout(1,2,5,5));
		JPanel panelOpcionesItems2=new JPanel(new GridLayout(1,2,5,5));
		
		panelOpcionesItems.add(_lblOpcion);
		panelOpcionesItems.add(_txtOpcion);
		panelOpcionesItems2.add(_lblOpcion2);
		panelOpcionesItems2.add(_txtOpcion2);
		
		panelConfiguracionItems.add(lblId);
		panelConfiguracionItems.add(_txtId);
		panelConfiguracionItems.add(lblDescripcion);
		panelConfiguracionItems.add(scrollPane);
		panelConfiguracionItems.add(lblTipo);
		panelConfiguracionItems.add(panelRadioButtons);
		panelConfiguracionItems.add(panelOpcionesItems);
		panelConfiguracionItems.add(panelOpcionesItems2);
		
		this.add(panelConfiguracionItems,BorderLayout.NORTH);
		
		
		JButton btAñadir=new JButton("Añadir");
		JButton btEliminar=new JButton("Quitar");
		btAñadir.addActionListener(oyente);
		btEliminar.addActionListener(oyente);
		
		JPanel panelBotones=new JPanel();
		panelBotones.add(btAñadir);
		panelBotones.add(btEliminar);
		this.add(panelBotones,BorderLayout.CENTER);
		
		
		//inicializarTabla
		
		_tablaItems = new TablaItems();
		_tabla = new JTable(_tablaItems);
		
		_tabla.setGridColor(Color.WHITE);
		_tabla.setSelectionForeground(Color.WHITE);
		_tabla.setPreferredScrollableViewportSize(new Dimension(50,50));
		_tabla.setColumnSelectionAllowed(false);
		
		JScrollPane panelScroll = new JScrollPane(_tabla);
		
		this.add(panelScroll,BorderLayout.SOUTH);
		
	}
	
	/**
	 * meotod que carga la tabla de items
	 */
	public void cargarTablaItems()
	{
		_tablaItems.removeAll();		
		_tablaItems.inicializa(_arrayItems);
		_tablaItems.fireTableDataChanged();
		_tabla.repaint();
		
	}
	/**
	 * Mutador del array de items
	 * @param items array de items
	 */
	public void setArrayItems(ArrayList<Item> items)
	{
		_arrayItems=items;
	}
	
	/**
	 * Clase que contiene la tabla abstracta para añadir los itemes
	 * @author grupo18
	 *
	 */
	private class TablaItems extends AbstractTableModel{
		/**
		 * Serialization version number
		 */
		private static final long serialVersionUID = 1L;

		//COLUMNAS Y ELEMENTOS DEL JUGADOR
		final String[] _columnNames = { "Identificador", "Descripcion"};
		final ArrayList<Item> _dato = new ArrayList<Item>();
		
		/**
		 * Constructor por defecto de la clase
		 */
		public TablaItems(){
			super();
		}
		
		/**
		 * Metodo que inicializa/actualiza la tabla
		 * @param inventario array de items
		 */
		public void inicializa(ArrayList<Item> arrayItems){

			int longitud = arrayItems.size();
			for(int i=0;i<longitud;i++){
				_dato.add(arrayItems.get(i));
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
					valor = _dato.get(row).toString();
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
		 * @param value valor
		 * @param index indice
		 */
		@SuppressWarnings("unused")
		public void setValueAt(Item value, int index) {

			_dato.add(index, value);
		}
		
		
	}
	
	/**
	 * Clase oyente de la propia clase
	 * @author grupo18
	 *
	 */
	class OyenteBotones implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String accion=e.getActionCommand();
			if("Llave".equals(accion))
			{
				_lblOpcion.setText("Identificador puerta :");
				_lblOpcion.setVisible(true);
				_txtOpcion.setVisible(true);
				_lblOpcion2.setVisible(false);
				_txtOpcion2.setVisible(false);
			}
			else if("Comida".equals(accion))
			{
				_lblOpcion.setText("Cantidad de vida :");
				_lblOpcion2.setText("Número de usos :");
				_lblOpcion.setVisible(true);
				_txtOpcion.setVisible(true);
				_lblOpcion2.setVisible(true);
				_txtOpcion2.setVisible(true);
			}
			else if("Objeto de valor".equals(accion))
			{
				_lblOpcion.setText("Cantidad de puntos :");
				_lblOpcion.setVisible(true);
				_txtOpcion.setVisible(true);
				_lblOpcion2.setVisible(false);
				_txtOpcion2.setVisible(false);
			}
			else if("Añadir".equals(accion))
			{
				try{
					procesarAñadir();
				}
				catch(java.lang.Exception ex){}
			}
			else if("Quitar".equals(accion))
			{
				procesarQuitar();
			}
		}
	}
	/**
	 * Metodoq que interactua con la tabla para quitar items
	 */
	public void procesarQuitar()
	{
		if(_tabla.getSelectedRow()==-1)
			JOptionPane.showMessageDialog(getParent(), "Debes seleccionar un item de la tabla", "Aviso",JOptionPane.WARNING_MESSAGE);
		else
		{
			int i=0;
			boolean encontrado=false;
			while(i<_arrayItems.size() && !encontrado)
			{
				if(_arrayItems.get(i).getId().equals(_tablaItems.getValueAt(_tabla.getSelectedRow(),0)))
				{
					_arrayItems.remove(i);
					encontrado=true;
				}
				else 
					i++;
			}
			cargarTablaItems();
		}
	}
	/**
	 * Metodo que interactua con la tabla para añadir elementos
	 */
	public void procesarAñadir()
	{
		if(_txtId.getText().equals(""))
		{
			JOptionPane.showMessageDialog(getParent(), "Debes introducir un identificador para el item", "Aviso",JOptionPane.WARNING_MESSAGE);
		}
		else if(_txtDescripcion.getText().equals(""))
		{
			JOptionPane.showMessageDialog(getParent(), "Debes introducir una descripcion para el item", "Aviso",JOptionPane.WARNING_MESSAGE);
		}
		else if(!_rbComida.isSelected() && !_rbLlave.isSelected() && !_rbObjeto.isSelected())
		{
			JOptionPane.showMessageDialog(getParent(), "Debes introducir el tipo de item", "Aviso",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			if(_rbComida.isSelected())
			{
				if(_txtOpcion.getText().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Debes introducir la cantidad de vida", "Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else if(_txtOpcion2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Debes introducir la cantidad de usos", "Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Item item=new Comida(_txtId.getText(),_txtDescripcion.getText(),Integer.parseInt(_txtOpcion.getText()),Integer.parseInt(_txtOpcion2.getText()));
					_arrayItems.add(item);
					cargarTablaItems();
					reiniciarFormulario();
				}
			}
			else if(_rbLlave.isSelected())
			{
				if(_txtOpcion.getText().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Debes introducir el identificador de la puerta para la llave", "Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Item item=new Llave(_txtId.getText(),_txtDescripcion.getText(),_txtOpcion.getText());
					_arrayItems.add(item);
					cargarTablaItems();
					reiniciarFormulario();
				}
			}
			else if(_rbObjeto.isSelected())
			{
				if(_txtOpcion.getText().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Debes introducir la cantidad de puntos", "Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Item item=new ObjetoValor(_txtId.getText(),_txtDescripcion.getText(),Integer.parseInt(_txtOpcion.getText()));
					_arrayItems.add(item);
					cargarTablaItems();
					reiniciarFormulario();
				}
			}
		}
	}
	
	/**
	 * Metodo que reinicia el panel
	 */
	public void reiniciarFormulario()
	{
		_txtId.setText("");
		_txtDescripcion.setText("");
		_txtOpcion.setText("");
		_txtOpcion2.setText("");
		
	}
	/**
	 * Metodo que obtiene la lista de items
	 * @return array de items
	 */
	public ArrayList<Item> getItems()
	{
		return _arrayItems;
	}
	/**
	 * Metodo que vacia la tabla 
	 */
	public void vaciarTabla()
	{
		_arrayItems=new ArrayList<Item>();
		cargarTablaItems();
	}
	
}
