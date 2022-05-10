package formularios;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import personas.adoptantes;
import personas.Controlleradoptantes;
import java.sql.*;
import conexionsafe_pets.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;


public class FormularioActualizaradoptante extends JFrame{

	public static String col;
	private JTextField textcodadoptante;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textProvincia;
	private JTextField textDireccion;
	private JTextField textCodigoPostal;
	private JTextField textNIF;
	final JTable table=new JTable();
  //MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
        	   FormularioActualizaradoptante form=new FormularioActualizaradoptante();
               form.setVisible(true);;
           }
       });

  }


	public void RefreshTable() {
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				((DefaultTableModel) table.getModel()).setRowCount(0);   
				conexionsafe_pets conex=new conexionsafe_pets();
				Statement st = conex.conectar().createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM adoptantes");
			
		    //ADD SCROLLPANE
				JScrollPane scroll=new JScrollPane();
			    scroll.setBounds(240,51,643,369);
			    getContentPane().add(scroll);


		    //THE ROW
			while (rs.next()){
				Object [] filas = new Object[10];

		    for(int i=0;i<9;i++) {    	 
		    	filas[i] = rs.getObject(i+1);
		    	}
		    
		    	((DefaultTableModel) table.getModel()).addRow(filas);   
		    	((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0, table.getRowCount());
			}
	
		}
			catch(SQLException s)
			{
				System.out.println("Error: SQL.");
				System.out.println("SQLException: " + s.getMessage());
			}
			catch(Exception s)
			{
				System.out.println("Error: Varios.");
				System.out.println("SQLException: " + s.getMessage());

			}
} 
  
  
  //CONSTRUCTOR
  public FormularioActualizaradoptante()
  {
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexionsafe_pets conex=new conexionsafe_pets();
			Statement st = conex.conectar().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM adoptantes");
    //the form
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(600,300,960,554);
    setTitle("Eliminar datos");
    getContentPane().setLayout(null);

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(240,51,643,369);
    getContentPane().add(scroll);

    //THE TABLE
    scroll.setViewportView(table);

    //THE MODEL OF OUR TABLE
    DefaultTableModel model=new DefaultTableModel()
    {
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
        	return Object.class;
        case 1:
        	return Object.class;
        case 2:
        	return Object.class;
        case 3:
        	return Object.class;
        case 4:
        	return Object.class;
        case 5:
        	return Object.class;
        case 6:
        	return Object.class;
        case 7:
        	return Object.class;
        case 8:
        	return Object.class;
        case 9:
        	return Boolean.class;

          default:
            return Object.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    
    model.addColumn("CodAdoptante");
    model.addColumn("NIF");
    model.addColumn("Nombre");
    model.addColumn("Apellidos");
    model.addColumn("Dirección");
    model.addColumn("CP");
    model.addColumn("Provincia");
    model.addColumn("Tipoacogida");
    model.addColumn("Motivoadopción");
    model.addColumn("Editar");

    //THE ROW
	while (rs.next()){
		Object [] filas = new Object[10];

    for(int i=0;i<9;i++) {    	 
    	filas[i] = rs.getObject(i+1);
    	}
    
    	((DefaultTableModel) table.getModel()).addRow(filas);     
	}
	
    for(int i=0;i<table.getRowCount();i++) {    	 
    	model.setValueAt(false,i,9);
	}
    //OBTAIN SELECTED ROW
    JComboBox comboMotivoadopcion = new JComboBox();
    comboMotivoadopcion.setModel(new DefaultComboBoxModel(new String[] {"Vivo s\u00F3lo y quiero compa\u00F1\u00EDa", "Quiero ayudar a reducir el abandono de animales", "Quiero ampliar la familia", "Perd\u00ED a mi mascota hace un tiempo y quiero volver a adoptar", "Otros (escribir el motivo)"}));
    comboMotivoadopcion.setBounds(118, 348, 105, 20);
    getContentPane().add(comboMotivoadopcion);
    
    JComboBox comboTipoacogida = new JComboBox();
    comboTipoacogida.setModel(new DefaultComboBoxModel(new String[] {"Acogida Temporal", "Adopci\u00F3n"}));
    comboTipoacogida.setBounds(118, 274, 105, 20);
    getContentPane().add(comboTipoacogida);
    
    JButton btnActualizar=new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
    	
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

          //GET SELECTED ROW
          for(int i=0;i<table.getRowCount();i++)
          {
            Boolean checked=Boolean.valueOf(table.getValueAt(i, 9).toString());
            col=table.getValueAt(i, 0).toString();
            int id = Integer.parseInt(col);
			
        //DISPLAY
       if(checked) {
			adoptantes adoptantes = new adoptantes(textNIF.getText(),textNombre.getText(),textApellidos.getText(),Integer.valueOf(textCodigoPostal.getText()),textDireccion.getText(),textProvincia.getText(),(String)comboTipoacogida.getSelectedItem(),(String)comboMotivoadopcion.getSelectedItem());
			Controlleradoptantes controller = new Controlleradoptantes();
			adoptantes.setcodadoptante(id);
			controller.actualizar(adoptantes);
			controller.veradoptantes();
			RefreshTable();
			textcodadoptante.setText("");
			textNIF.setText("");
    		textNombre.setText("");
    		textApellidos.setText("");
    		textDireccion.setText("");
    		textCodigoPostal.setText("");
    		textProvincia.setText("");
    		
        }
      }
      }
    });

    JButton btnSalir = new JButton("Salir");
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//	System.exit(0);
			dispose();
		}
	});
	
    //ADD BUTTON TO FORM
    btnActualizar.setBounds(415,459,117,23);
    getContentPane().add(btnActualizar);
    
    btnSalir.setBounds(588,459,117,23);
    getContentPane().add(btnSalir);
    
    JLabel lblcodadoptante = new JLabel("codAdoptante");
    lblcodadoptante.setBounds(30, 30, 78, 14);
    getContentPane().add(lblcodadoptante);
    
    JLabel lblNombre = new JLabel("Nombre");
    lblNombre.setBounds(30, 103, 53, 14);
    getContentPane().add(lblNombre);
    
    textcodadoptante = new JTextField();
    textcodadoptante.setEditable(false);
    textcodadoptante.setBounds(118, 27, 105, 20);
    getContentPane().add(textcodadoptante);
    textcodadoptante.setColumns(10);
    
    JButton btnEditar = new JButton("Editar");
    btnEditar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		   //GET SELECTED ROW
            for(int i=0;i<table.getRowCount();i++)
            {
              Boolean checked=Boolean.valueOf(table.getValueAt(i, 9).toString());
 //             col=table.getValueAt(i, 0).toString();
//              int id = Integer.parseInt(col);

              //DISPLAY
              if(checked) {
            		textcodadoptante.setText(table.getValueAt(i, 0).toString());
            		textNIF.setText(table.getValueAt(i, 1).toString());
            		textNombre.setText(table.getValueAt(i, 2).toString());
            		textApellidos.setText(table.getValueAt(i, 3).toString());
            		textDireccion.setText(table.getValueAt(i, 4).toString());
            		textCodigoPostal.setText(table.getValueAt(i, 5).toString());
            		textProvincia.setText(table.getValueAt(i, 6).toString());
            		if (table.getValueAt(i, 7).toString().equals("Acogida Temporal")) {
            			comboTipoacogida.setSelectedItem("Acogida Temporal");
            		}
            		else {
            			comboTipoacogida.setSelectedItem("Adopción");
            		}
            		if (table.getValueAt(i, 8).toString().equals("Vivo sólo y quiero compañía")) {
            			comboMotivoadopcion.setSelectedItem("Vivo sólo y quiero compañía");
            		}
            		if (table.getValueAt(i, 8).toString().equals("Quiero ayudar a reducir el abandono de animales")) {
            			comboMotivoadopcion.setSelectedItem("Quiero ayudar a reducir el abandono de animales");
            		}
            		if (table.getValueAt(i, 8).toString().equals("Quiero ampliar la familia")) {
            			comboMotivoadopcion.setSelectedItem("Quiero ampliar la familia");
            		}
            		if (table.getValueAt(i, 8).toString().equals("Perdí a mi mascota hace un tiempo y quiero volver a adoptar")) {
            			comboMotivoadopcion.setSelectedItem("Perdí a mi mascota hace un tiempo y quiero volver a adoptar");
            		}
            		if (table.getValueAt(i, 8).toString().equals("Otros (escribir el motivo)")) {
            			comboMotivoadopcion.setSelectedItem("Otros (escribir el motivo)");
            		}
              }
            }
    	}
    });
    btnEditar.setBounds(259, 459, 105, 23);
    getContentPane().add(btnEditar);
    
    JLabel lblApellidos = new JLabel("Apellidos");
    lblApellidos.setBounds(30, 134, 46, 14);
    getContentPane().add(lblApellidos);
    
    textNombre = new JTextField();
    textNombre.setBounds(118, 100, 105, 20);
    getContentPane().add(textNombre);
    textNombre.setColumns(10);
    
    textApellidos = new JTextField();
    textApellidos.setColumns(10);
    textApellidos.setBounds(118, 131, 105, 20);
    getContentPane().add(textApellidos);
    
    JLabel lblProvincia = new JLabel("Provincia");
    lblProvincia.setBounds(30, 230, 78, 14);
    getContentPane().add(lblProvincia);
    
    textProvincia = new JTextField();
    textProvincia.setColumns(10);
    textProvincia.setBounds(118, 227, 105, 20);
    getContentPane().add(textProvincia);
    
    JLabel lblDireccion = new JLabel("Direccion");
    lblDireccion.setBounds(30, 165, 46, 14);
    getContentPane().add(lblDireccion);
    
    textDireccion = new JTextField();
    textDireccion.setColumns(10);
    textDireccion.setBounds(118, 162, 105, 20);
    getContentPane().add(textDireccion);
    
    JLabel lblCP = new JLabel("C\u00F3digo Postal");
    lblCP.setBounds(30, 196, 46, 14);
    getContentPane().add(lblCP);
    
    textCodigoPostal = new JTextField();
    textCodigoPostal.setColumns(10);
    textCodigoPostal.setBounds(118, 193, 105, 20);
    getContentPane().add(textCodigoPostal);
    
    JLabel lblTipoacogida = new JLabel("Tipo de Acogida");
    lblTipoacogida.setBounds(30, 277, 90, 14);
    getContentPane().add(lblTipoacogida);
    
    JLabel lblNIF = new JLabel("NIF");
    lblNIF.setBounds(30, 68, 53, 14);
    getContentPane().add(lblNIF);
    
    textNIF = new JTextField();
    textNIF.setColumns(10);
    textNIF.setBounds(118, 65, 105, 20);
    getContentPane().add(textNIF);
    
    JLabel lblMotivoadopcion = new JLabel("Motivo de Adopci\u00F3n");
    lblMotivoadopcion.setBounds(30, 352, 90, 14);
    getContentPane().add(lblMotivoadopcion);

  
  }
	catch(SQLException s)
	{
		System.out.println("Error: SQL.");
		System.out.println("SQLException: " + s.getMessage());
	}
	catch(Exception s)
	{
		System.out.println("Error: Varios.");
		System.out.println("SQLException: " + s.getMessage());

	}
}
}