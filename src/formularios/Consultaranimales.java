package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexionsafe_pets.conexionsafe_pets;

public class Consultaranimales extends JFrame {

	
	  public static int comienzo=0;
	  public static int num=5;
	  public static int total=0;
	  DefaultTableModel model;
	private JPanel contentPane;
	final JTable table=new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultaranimales frame = new Consultaranimales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	  
	   
	    
	public void RefreshTable() {
			try {	  
					//ADD SCROLLPANE
				    JScrollPane scroll=new JScrollPane();
				    scroll.setBounds(48,43,688,103);
				    getContentPane().add(scroll);
				    
				    //THE TABLE
		
				   
				((DefaultTableModel) table.getModel()).setRowCount(0);
				    //THE ROW
					conexionsafe_pets conex=new conexionsafe_pets();
					Statement st = conex.conectar().createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM animales LIMIT "+comienzo+","+num+"");
					while (rs.next()){
						Object [] filas = new Object[11];

				    for(int i=0;i<11;i++) {    	 
				    	filas[i] = rs.getObject(i+1);
				    	}
				    
				    	((DefaultTableModel) table.getModel()).addRow(filas); 
				    	((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,5);
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
	
	
	public int Conteo() {
		try {
			conexionsafe_pets conex=new conexionsafe_pets();
			Statement st = conex.conectar().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM animales");
			total=0;
			while (rs.next()){
				total++;
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
		return total;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Consultaranimales() {
		  try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				conexionsafe_pets conex=new conexionsafe_pets();
				Statement st = conex.conectar().createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM animales LIMIT "+comienzo+","+num+"");		

				
	    //the form
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(400,300,1014,302);
	    setTitle("Consulta de datos");
	    getContentPane().setLayout(null);

	    //ADD SCROLLPANE
	    JScrollPane scroll=new JScrollPane();
	    scroll.setBounds(48,43,688,103);
	    getContentPane().add(scroll);
	    
	    //THE TABLE
	    scroll.setViewportView(table);
	   
	    //THE MODEL OF OUR TABLE
	    model=new DefaultTableModel()
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
	        default:
	            return Object.class;
	        }
	      }
	    };

	    //ASSIGN THE MODEL TO TABLE
	    table.setModel(model);

	    model.addColumn("idanimal");
	    model.addColumn("codDonante");
	    model.addColumn("Especie");
	    model.addColumn("Nombre");
	    model.addColumn("Edad");
	    model.addColumn("Raza");
	    model.addColumn("Vacunas");
	    model.addColumn("Observaciones");
	    model.addColumn("caracteristicas");
	    model.addColumn("sexo");
	    model.addColumn("tamano");
	    //THE ROW
		while (rs.next()){
			Object [] filas = new Object[11];

	    for(int i=0;i<11;i++) {    	 
	    	filas[i] = rs.getObject(i+1);
	    	}
	    
	    	((DefaultTableModel) table.getModel()).addRow(filas);     
		}
		
	    
	    //OBTAIN SELECTED ROW
	    JButton btnSiguiente=new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
		//		System.out.println(comienzo+num);
		//		System.out.println(Conteo());
				if(comienzo+num<Conteo()) {

					comienzo=comienzo+5;
					RefreshTable();
		//			dispose();				
		//			VentanaConsulta form=new VentanaConsulta();
		//			form.setVisible(true);
					
					}
				else
					JOptionPane.showMessageDialog(null, "No existen más datos");
			}
		});



	    JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comienzo>0) {
					comienzo=comienzo-5;
					RefreshTable();
			//		dispose();
			//		VentanaConsulta form=new VentanaConsulta();
			//		form.setVisible(true);;
					}
				else
					JOptionPane.showMessageDialog(null, "No existen más datos");
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
	    btnSiguiente.setBounds(393,199,117,23);
	    getContentPane().add(btnSiguiente);
	    
	    btnAnterior.setBounds(183,199,117,23);
	    getContentPane().add(btnAnterior);
	    
	    btnSalir.setBounds(615, 199, 89, 23);
	    getContentPane().add(btnSalir);
	  
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

