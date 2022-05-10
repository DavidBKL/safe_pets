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
import adopciones.Controlleradopciones;
import adopciones.adopciones;
import java.sql.*;
import conexionsafe_pets.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FormularioActualizaradopciones extends JFrame{

	public static String col;
	private JTextField textcodadopcion;
	private JTextField textadoptante;
	private JTextField textrenunciante;
	private JDateChooser dateChooseradopcion= new JDateChooser();;
	private JTextField textidanimal;
	private java.util.Date fecha;
	
	
	final JTable table=new JTable();
  //MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
        	   FormularioActualizaradopciones form=new FormularioActualizaradopciones();
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
				ResultSet rs = st.executeQuery("SELECT * FROM adopciones");
			
		    //ADD SCROLLPANE
				JScrollPane scroll=new JScrollPane();
			    scroll.setBounds(240,51,643,369);
			    getContentPane().add(scroll);


		    //THE ROW
			while (rs.next()){
				Object [] filas = new Object[5];

		    for(int i=0;i<4;i++) {    	 
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
  public FormularioActualizaradopciones()
  {
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexionsafe_pets conex=new conexionsafe_pets();
			Statement st = conex.conectar().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM adopciones");
    //the form
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(600,300,960,554);
    setTitle("Actualizar adopciones");
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
        	return Boolean.class;
        

          default:
            return Object.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    
    model.addColumn("codadopcion");
    model.addColumn("renunciante");
    model.addColumn("idanimal");
    model.addColumn("fechaadopcion");
    model.addColumn("Editar");

    //THE ROW
	while (rs.next()){
		Object [] filas = new Object[5];

    for(int i=0;i<4;i++) {    	 
    	filas[i] = rs.getObject(i+1);
    	}
    
    	((DefaultTableModel) table.getModel()).addRow(filas);     
	}
	
    for(int i=0;i<table.getRowCount();i++) {    	 
    	model.setValueAt(false,i,4);
	}
    
    JButton btnActualizar=new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
    	
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

          //GET SELECTED ROW
          for(int i=0;i<table.getRowCount();i++)
          {
            Boolean checked=Boolean.valueOf(table.getValueAt(i, 4).toString());
            col=table.getValueAt(i, 0).toString();
            int id = Integer.parseInt(col);
			
        //DISPLAY
       if(checked) {
			adopciones adopciones = new adopciones(Integer.valueOf(textcodadopcion.getText()),dateChooseradopcion.getDate(),Integer.valueOf(textadoptante.getText()),Integer.valueOf(textrenunciante.getText()),Integer.valueOf(textidanimal.getText()));
			Controlleradopciones controller = new Controlleradopciones();
			adopciones.setcodadopcion(id);
			controller.actualizar(adopciones);
			controller.veradopciones();
			RefreshTable();
			textcodadopcion.setText("");
			textadoptante.setText("");
    		textrenunciante.setText("");
    		textidanimal.setText("");
    		dateChooseradopcion.getDate();
    		
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
    
    JLabel lblcodadopcion = new JLabel("codAdopcion:");
    lblcodadopcion.setBounds(30, 68, 78, 14);
    getContentPane().add(lblcodadopcion);
    
    JLabel lblrenunciante = new JLabel("renunciante:");
    lblrenunciante.setBounds(30, 229, 53, 14);
    getContentPane().add(lblrenunciante);
    
    textcodadopcion = new JTextField();
    textcodadopcion.setEditable(false);
    textcodadopcion.setBounds(106, 65, 105, 20);
    getContentPane().add(textcodadopcion);
    textcodadopcion.setColumns(10);
    
    JDateChooser dateChooseradopcion = new JDateChooser();
    dateChooseradopcion.setDateFormatString("yyyy-mm-dd");

    
    dateChooseradopcion.setBounds(106, 291, 105, 20);
    getContentPane().add(dateChooseradopcion);
	dateChooseradopcion.setDate(new Date(01,07,1990));
	 
    JButton btnEditar = new JButton("Editar");
    btnEditar.addActionListener(new ActionListener() {
    	//DISPLAY
      
    	@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
  
    		   //GET SELECTED ROW
            for(int i=0;i<table.getRowCount();i++)
            {
              Boolean checked=Boolean.valueOf(table.getValueAt(i, 4).toString());
 //             col=table.getValueAt(i, 0).toString();
//              int id = Integer.parseInt(col);
              
              if(checked) {
            	  try {
            		String fechatabla = table.getValueAt(i, 3).toString();
            		fecha = new SimpleDateFormat("yyyy-mm-dd").parse(fechatabla);
            		 dateChooseradopcion.setDate(fecha);
            		 textcodadopcion.setText(table.getValueAt(i,0).toString());
            		 textadoptante.setText(table.getValueAt(i,1).toString());
            		 textrenunciante.setText(table.getValueAt(i,2).toString());
            		 
            		 

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

            	  }
   
            }
    	}
    });
    btnEditar.setBounds(259, 459, 105, 23);
    getContentPane().add(btnEditar);
    
    JLabel lblfechaadopcion = new JLabel("fechaadopcion:");
    lblfechaadopcion.setBounds(30, 291, 46, 14);
    getContentPane().add(lblfechaadopcion);
    
    textrenunciante = new JTextField();
    textrenunciante.setEditable(false);
    textrenunciante.setBounds(106, 226, 105, 20);
    getContentPane().add(textrenunciante);
    textrenunciante.setColumns(10);
    
    JLabel lblidanimal = new JLabel("idanimal:");
    lblidanimal.setBounds(30, 363, 46, 14);
    getContentPane().add(lblidanimal);
    
    textidanimal = new JTextField();
    textidanimal.setEditable(false);
    textidanimal.setColumns(10);
    textidanimal.setBounds(106, 360, 105, 20);
    getContentPane().add(textidanimal);
    
    JLabel lbladoptante = new JLabel("adoptante:");
    lbladoptante.setBounds(30, 147, 53, 14);
    getContentPane().add(lbladoptante);
    
    textadoptante = new JTextField();
    textadoptante.setEditable(false);
    textadoptante.setColumns(10);
    textadoptante.setBounds(106, 144, 105, 20);
    getContentPane().add(textadoptante);
    

  
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
