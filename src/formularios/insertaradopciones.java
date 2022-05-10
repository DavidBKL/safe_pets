package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDayChooser;
import adopciones.Controlleradopciones;
import adopciones.adopciones;
import conexionsafe_pets.conexionsafe_pets;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class insertaradopciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertaradopciones frame = new insertaradopciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public insertaradopciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Animal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(44, 62, 84, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechaDeAdopcin = new JLabel("Fecha de adopci\u00F3n");
		lblFechaDeAdopcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeAdopcin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFechaDeAdopcin.setBounds(44, 139, 84, 58);
		contentPane.add(lblFechaDeAdopcin);
		lblFechaDeAdopcin.setText("<html><body>Fecha de<BR>Adopcion</body></hmtl>");
		Border borderline = BorderFactory.createLineBorder(Color.RED,2);
		lblFechaDeAdopcin.setBorder(borderline);
		
		JLabel lblAdoptante = new JLabel("Adoptante");
		lblAdoptante.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdoptante.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdoptante.setBounds(44, 256, 77, 26);
		contentPane.add(lblAdoptante);
		
		JComboBox animal = new JComboBox();
		animal.setBounds(166, 65, 157, 23);
		contentPane.add(animal);
		
		 try {
	         //   System.out.println("INICIO DE EJECUCIÓN.");
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            conexionsafe_pets conex=new conexionsafe_pets();
	    		
	            Statement st = conex.conectar().createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM animales");
	            if (rs != null) {
	          
	 
	                while (rs.next()) {
	                
	                animal.addItem(""+rs.getObject(1)+" - "+rs.getObject(2)+" "+rs.getObject(4)+"");
	                 
	                }
	            
	                rs.close();
	            }
	            st.close();
	 
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
		
		JComboBox adoptante = new JComboBox();
		adoptante.setBounds(166, 259, 157, 23);
		contentPane.add(adoptante);
		
		try {
	         //   System.out.println("INICIO DE EJECUCIÓN.");
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            conexionsafe_pets conex=new conexionsafe_pets();
	    		
	            Statement st = conex.conectar().createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM adoptantes");
	            if (rs != null) {
	          
	 
	                while (rs.next()) {
	                
	                adoptante.addItem(""+rs.getObject(1)+" - "+rs.getObject(3)+" - "+rs.getObject(4)+"");
	                 
	                }
	            
	                rs.close();
	            }
	            st.close();
	 
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
		
		
		
		JDateChooser fechaadopcion = new JDateChooser();
		fechaadopcion.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fechaadopcion.setBounds(166, 162, 157, 26);
		contentPane.add(fechaadopcion);
		JButton btnNewButton = new JButton("INSERTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje = "";
				if (fechaadopcion.getDate()==null ) {
					mensaje="Seleccione una fecha";
					JOptionPane.showMessageDialog(rootPane, mensaje);
					}
				else {
				String renunciante;
				String idanimal;
				int id_animal;
				
				
				idanimal=(String) animal.getSelectedItem();
				idanimal=idanimal.substring(0,2).trim();
				id_animal=Integer.parseInt(idanimal);
				
				renunciante=(String) animal.getSelectedItem();
				renunciante=renunciante.substring(3+idanimal.length(),5+idanimal.length()).trim();
				
				String adoptantes;
				adoptantes=(String) adoptante.getSelectedItem();
				adoptantes=adoptantes.substring(0,2).trim();
				
				adopciones adopcion = new adopciones(1,fechaadopcion.getDate(),Integer.parseInt(adoptantes),Integer.parseInt(renunciante),id_animal);
				Controlleradopciones controller = new Controlleradopciones();
				controller.registrar(adopcion);
				controller.veradopciones();}
			}
			})
		;
		btnNewButton.setBounds(183, 334, 89, 35);
		contentPane.add(btnNewButton);
		
		}
}
