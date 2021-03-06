package formularios;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import conexionsafe_pets.*;
import adopciones.Controlleradopciones;
import adopciones.adopciones;


public class formularioEliminaradopcion extends JFrame{

	public static String col;
	
  
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               
        	   formularioEliminaradopcion form=new formularioEliminaradopcion();
               form.setVisible(true);;
           }
       });

  }


  
  
  public formularioEliminaradopcion()
  {
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexionsafe_pets conex=new conexionsafe_pets();
			Statement st = conex.conectar().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM adopciones");
   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(600,300,451,366);
    setTitle("Eliminar datos");
    getContentPane().setLayout(null);

    
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(48,43,336,197);
    getContentPane().add(scroll);

    
    final JTable table=new JTable();
    scroll.setViewportView(table);

    
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

    
    table.setModel(model);

    model.addColumn("Codadopci?n");
    model.addColumn("Adoptante");
    model.addColumn("Donante");
    model.addColumn("Fecha adopci?n");
    model.addColumn("IDanimal");

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
    
    
    
    JButton btnEliminar=new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
    	
      @Override
      public void actionPerformed(ActionEvent arg0) {
        

        
        for(int i=0;i<table.getRowCount();i++)
        {
          Boolean checked=Boolean.valueOf(table.getValueAt(i, 4).toString());
          col=table.getValueAt(i, 0).toString();
          
         
          if(checked)
          {
        	  int confirmado = JOptionPane.showConfirmDialog(
        			  null, "Va a eliminar la adopci?n con codadopci?n: "+col+". ?Est? seguro?", 
        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	  			
        			if (JOptionPane.OK_OPTION == confirmado) {
        				adopciones adopciones = new adopciones();
        				Controlleradopciones controller = new Controlleradopciones();
        				int setcodadopcion;
        				controller.eliminar(adopciones);
        				controller.veradopciones();     
        				model.removeRow(i); 
        				i=i-1;

        	           
        	           }
        			else 
        				JOptionPane.showMessageDialog(null, "Eliminaci?n cancelada"); 
            
          }
        }
    
      }
    });

    JButton btnSalir = new JButton("Salir");
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			dispose();
		}
	});
	
    
    btnEliminar.setBounds(48,267,117,23);
    getContentPane().add(btnEliminar);
    
    btnSalir.setBounds(267,267,117,23);
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