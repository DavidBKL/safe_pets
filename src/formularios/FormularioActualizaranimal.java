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
import animales.animales;
import animales.Controlleranimales;
import java.sql.*;
import conexionsafe_pets.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;


public class FormularioActualizaranimal extends JFrame{

	public static String col;
	private JTextField textIdanimal;
	private JTextField textNombre;
	public static JComboBox ComboEspecie;
	public static JComboBox comboSexo;
	public static String mensaje;
	public static String cadena="";
	private JTextField textEdad;
	private JTextField textObservaciones;
	private JTextField textcodrenunciante;
	private JTextField textRaza;
	private JTextField textVacunas;
	private JTextField textCaracteristicas;
	
  //MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
        	   FormularioActualizaranimal form=new FormularioActualizaranimal();
               form.setVisible(true);;
           }
       });

  }


	public void RefreshTable() {
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexionsafe_pets conex=new conexionsafe_pets();
				Statement st = conex.conectar().createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM animales");
			
		    //ADD SCROLLPANE
		    JScrollPane scroll=new JScrollPane();
		    scroll.setBounds(259,43,460,243);
		    getContentPane().add(scroll);

		    //THE TABLE
		    final JTable table=new JTable();
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
		        	return Object.class;
		        case 10:
		        	return Object.class;
		        case 11:
		        	return Boolean.class;

		          default:
		            return Object.class;
		        }
		      }
		    };

		    //ASSIGN THE MODEL TO TABLE
		    table.setModel(model);

		    model.addColumn("Idanimal");
		    model.addColumn("CodDonante");
		    model.addColumn("Especie");
		    model.addColumn("Nombre");
		    model.addColumn("Edad");
		    model.addColumn("Raza");
		    model.addColumn("Vacunas");
		    model.addColumn("Observaciones");
		    model.addColumn("Características");
		    model.addColumn("Sexo");
		    model.addColumn("Tamaño");
		    model.addColumn("Editar");

		    //THE ROW
			while (rs.next()){
				Object [] filas = new Object[11];

		    for(int i=0;i<11;i++) {    	 
		    	filas[i] = rs.getObject(i+1);
		    	}
		    
		    	((DefaultTableModel) table.getModel()).addRow(filas);     
			}
			
		    for(int i=0;i<table.getRowCount();i++) {    	 
		    	model.setValueAt(false,i,11);
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
  public FormularioActualizaranimal()
  {
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexionsafe_pets conex=new conexionsafe_pets();
			Statement st = conex.conectar().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM animales");
    //the form
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(600,300,806,548);
    setTitle("Eliminar datos");
    getContentPane().setLayout(null);

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(259,43,460,377);
    getContentPane().add(scroll);

    //THE TABLE
    final JTable table=new JTable();
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
        	return Object.class;
        case 10:
        	return Object.class;
        case 11:
        	return Boolean.class;

          default:
            return Object.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    
    model.addColumn("Idanimal");
    model.addColumn("CodDonante");
    model.addColumn("Especie");
    model.addColumn("Nombre");
    model.addColumn("Edad");
    model.addColumn("Raza");
    model.addColumn("Vacunas");
    model.addColumn("Observaciones");
    model.addColumn("Características");
    model.addColumn("Sexo");
    model.addColumn("Tamaño");
    model.addColumn("Editar");

    //THE ROW
	while (rs.next()){
		Object [] filas = new Object[11];

    for(int i=0;i<11;i++) {    	 
    	filas[i] = rs.getObject(i+1);
    	}
    
    	((DefaultTableModel) table.getModel()).addRow(filas);     
	}
	
    for(int i=0;i<table.getRowCount();i++) {    	 
    	model.setValueAt(false,i,11);
	}
    //OBTAIN SELECTED ROW
    JComboBox comboTamano = new JComboBox();
    comboTamano.setModel(new DefaultComboBoxModel(new String[] {"menos de 5 kilos", "de 5 a 10 kilos", "mas de 10 kilos"}));
    comboTamano.setBounds(118, 459, 105, 20);
    getContentPane().add(comboTamano);
    
    JButton btnActualizar=new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
    	
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

          //GET SELECTED ROW
          for(int i=0;i<table.getRowCount();i++)
          {
            Boolean checked=Boolean.valueOf(table.getValueAt(i, 11).toString());
            col=table.getValueAt(i, 0).toString();
            int id = Integer.parseInt(col);
			mensaje="";
			

			cadena = ComboEspecie.getSelectedItem().toString().substring(0,2);
        //DISPLAY
       if(checked) {
			animales animales = new animales(Integer.valueOf(textcodrenunciante.getText()), (String)ComboEspecie.getSelectedItem(),textNombre.getText(),textEdad.getText(),textRaza.getText(),textVacunas.getText(),textObservaciones.getText(),textCaracteristicas.getText(),(String)comboSexo.getSelectedItem(),(String)comboTamano.getSelectedItem());
			Controlleranimales controller = new Controlleranimales();
			animales.setidanimal(id);
			controller.actualizar(animales);
			controller.veranimales();
			RefreshTable();
			textIdanimal.setText("");
    		textcodrenunciante.setText("");
    		textNombre.setText("");
    		textEdad.setText("");
    		textRaza.setText("");
    		textVacunas.setText("");
    		textObservaciones.setText("");
    		textCaracteristicas.setText("");
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
    
    JLabel lblidanimal = new JLabel("Idanimal");
    lblidanimal.setBounds(30, 11, 78, 14);
    getContentPane().add(lblidanimal);
    
    JLabel lblNombre = new JLabel("Nombre");
    lblNombre.setBounds(30, 103, 53, 14);
    getContentPane().add(lblNombre);
    
    textIdanimal = new JTextField();
    textIdanimal.setEditable(false);
    textIdanimal.setBounds(118, 8, 105, 20);
    getContentPane().add(textIdanimal);
    textIdanimal.setColumns(10);
    
    JButton btnEditar = new JButton("Editar");
    btnEditar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		   //GET SELECTED ROW
            for(int i=0;i<table.getRowCount();i++)
            {
              Boolean checked=Boolean.valueOf(table.getValueAt(i, 11).toString());
 //             col=table.getValueAt(i, 0).toString();
//              int id = Integer.parseInt(col);

              //DISPLAY
              if(checked) {
            		textIdanimal.setText(table.getValueAt(i, 0).toString());
            		textcodrenunciante.setText(table.getValueAt(i, 1).toString());
            		textNombre.setText(table.getValueAt(i, 3).toString());
            		textEdad.setText(table.getValueAt(i, 4).toString());
            		textRaza.setText(table.getValueAt(i, 5).toString());
            		textVacunas.setText(table.getValueAt(i, 6).toString());
            		textObservaciones.setText(table.getValueAt(i, 7).toString());
            		textCaracteristicas.setText(table.getValueAt(i, 8).toString());
            		if (table.getValueAt(i, 2).toString()=="Perro") {
            			ComboEspecie.setSelectedItem("Perro");
            		}
            		else {
            			ComboEspecie.setSelectedItem("Gato");
            		}
            		if (table.getValueAt(i, 9).toString()=="Macho") {
            			comboSexo.setSelectedItem("Macho");
            		}
            		else {
            			comboSexo.setSelectedItem("Hembra");
            		}
            		if (table.getValueAt(i, 10).toString()=="menos de 5 kilos") {
            			ComboEspecie.setSelectedItem("menos de 5 kilos");
            		}
            		if (table.getValueAt(i, 10).toString()=="de 5 a 10 kilos") {
            			ComboEspecie.setSelectedItem("de 5 a 10 kilos");
            		}
            		if (table.getValueAt(i, 10).toString()=="mas de 10 kilos") {
            			ComboEspecie.setSelectedItem("mas de 10 kilos");
            		}
              }
            }
    	}
    });
    btnEditar.setBounds(259, 459, 105, 23);
    getContentPane().add(btnEditar);
    
    JLabel lblEspecie = new JLabel("Especie");
    lblEspecie.setBounds(30, 72, 46, 14);
    getContentPane().add(lblEspecie);
    
    ComboEspecie = new JComboBox();
    ComboEspecie.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato"}));
    ComboEspecie.setBounds(118, 69, 105, 20);
    getContentPane().add(ComboEspecie);
    
    JLabel lblSexo = new JLabel("Sexo");
    lblSexo.setBounds(30, 419, 90, 14);
    getContentPane().add(lblSexo);
    
    JLabel lblEdad = new JLabel("Edad");
    lblEdad.setBounds(30, 134, 46, 14);
    getContentPane().add(lblEdad);
    
    comboSexo = new JComboBox();
    comboSexo.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
    comboSexo.setBounds(118, 416, 105, 20);
    getContentPane().add(comboSexo);
    
    textNombre = new JTextField();
    textNombre.setBounds(118, 100, 105, 20);
    getContentPane().add(textNombre);
    textNombre.setColumns(10);
    
    textEdad = new JTextField();
    textEdad.setColumns(10);
    textEdad.setBounds(118, 131, 105, 20);
    getContentPane().add(textEdad);
    
    JLabel lblObservaciones = new JLabel("Observaciones");
    lblObservaciones.setBounds(30, 260, 78, 14);
    getContentPane().add(lblObservaciones);
    
    textObservaciones = new JTextField();
    textObservaciones.setColumns(10);
    textObservaciones.setBounds(118, 227, 105, 81);
    getContentPane().add(textObservaciones);
    
    textcodrenunciante = new JTextField();
    textcodrenunciante.setEditable(false);
    textcodrenunciante.setColumns(10);
    textcodrenunciante.setBounds(118, 41, 105, 20);
    getContentPane().add(textcodrenunciante);
    
    JLabel lblcodrenunciante = new JLabel("CodDonante");
    lblcodrenunciante.setBounds(30, 44, 53, 14);
    getContentPane().add(lblcodrenunciante);
    
    JLabel lblRaza = new JLabel("Raza");
    lblRaza.setBounds(30, 165, 46, 14);
    getContentPane().add(lblRaza);
    
    textRaza = new JTextField();
    textRaza.setColumns(10);
    textRaza.setBounds(118, 162, 105, 20);
    getContentPane().add(textRaza);
    
    JLabel lblVacunas = new JLabel("Vacunas");
    lblVacunas.setBounds(30, 196, 46, 14);
    getContentPane().add(lblVacunas);
    
    textVacunas = new JTextField();
    textVacunas.setColumns(10);
    textVacunas.setBounds(118, 193, 105, 20);
    getContentPane().add(textVacunas);
    
    textCaracteristicas = new JTextField();
    textCaracteristicas.setColumns(10);
    textCaracteristicas.setBounds(118, 317, 105, 81);
    getContentPane().add(textCaracteristicas);
    
    JLabel lblCaracteristicas = new JLabel("Caracteristicas");
    lblCaracteristicas.setBounds(30, 350, 78, 14);
    getContentPane().add(lblCaracteristicas);
    
    JLabel lblTamano = new JLabel("Tama\u00F1o");
    lblTamano.setBounds(30, 463, 90, 14);
    getContentPane().add(lblTamano);
    
  
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
