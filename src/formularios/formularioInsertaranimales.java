package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import animales.animales;
import animales.Controlleranimales;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conexionsafe_pets.conexionsafe_pets;
import animales.*;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;



public class formularioInsertaranimales extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldNombre;
	public static JTextField textFieldEdad;
	public static JTextField textFieldRaza;
	public static JTextField textFieldVacunas;
	public static JTextField textFieldObservaciones;
	public static JTextField textFieldcaracteristicas;
	public static JComboBox comboBoxsexo;
	public static JCheckBox chckbxNewCheckBoxmenos5kilos;
	public static JCheckBox chckbxNewCheckBoxde5a10kilos;
	public static JCheckBox chckbxNewCheckBoxmasde10kilos;
	public static String mensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioInsertaranimales frame = new formularioInsertaranimales();
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
	public formularioInsertaranimales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuestras Mascotas:");
		lblNewLabel.setFont(new Font("Ravie", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 0, 393, 49);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewNombre = new JLabel("Nombre:");
		lblNewNombre.setBounds(207, 150, 46, 14);
		contentPane.add(lblNewNombre);
		
		JLabel lblNewEdad = new JLabel("Edad:");
		lblNewEdad.setBounds(207, 192, 46, 14);
		contentPane.add(lblNewEdad);
		
		JLabel lblNewRaza = new JLabel("Raza:");
		lblNewRaza.setBounds(207, 228, 56, 14);
		contentPane.add(lblNewRaza);
		
		JLabel lblNewVacunas = new JLabel("Vacunas:");
		lblNewVacunas.setBounds(207, 264, 46, 14);
		contentPane.add(lblNewVacunas);
		
		JLabel lblNewObservaciones = new JLabel("Observaciones:");
		lblNewObservaciones.setBounds(205, 292, 83, 14);
		contentPane.add(lblNewObservaciones);
		
		JLabel lblNewcaracteristicas = new JLabel("caracteristicas:");
		lblNewcaracteristicas.setBounds(205, 326, 83, 14);
		contentPane.add(lblNewcaracteristicas);
		
		JLabel lblNewsexo = new JLabel("sexo:");
		lblNewsexo.setBounds(207, 355, 46, 14);
		contentPane.add(lblNewsexo);
		
		JLabel lblNewtamano = new JLabel("tamano:");
		lblNewtamano.setBounds(207, 397, 46, 14);
		contentPane.add(lblNewtamano);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(263, 147, 167, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		

		textFieldEdad = new JTextField();
		textFieldEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char validar=evt.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					
					JOptionPane.showMessageDialog(rootPane,"Ingresar solo números");
				}
			}
		});
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(263, 189, 167, 20);
		contentPane.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		textFieldRaza = new JTextField();
		textFieldRaza.setBounds(263, 225, 167, 20);
		contentPane.add(textFieldRaza);
		textFieldRaza.setColumns(10);
		
		textFieldVacunas = new JTextField();
		textFieldVacunas.setBounds(263, 261, 167, 20);
		contentPane.add(textFieldVacunas);
		textFieldVacunas.setColumns(10);
		
		textFieldObservaciones = new JTextField();
		textFieldObservaciones.setBounds(282, 289, 175, 20);
		contentPane.add(textFieldObservaciones);
		textFieldObservaciones.setColumns(10);
		
		textFieldcaracteristicas = new JTextField();
		textFieldcaracteristicas.setBounds(312, 323, 175, 20);
		contentPane.add(textFieldcaracteristicas);
		textFieldcaracteristicas.setColumns(10);
		
		JComboBox comboBoxsexo = new JComboBox();
		comboBoxsexo.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		comboBoxsexo.setBounds(311, 351, 146, 22);
		contentPane.add(comboBoxsexo);
		
		JComboBox comboBoxEspecie = new JComboBox();
		comboBoxEspecie.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato"}));
		comboBoxEspecie.setBounds(263, 107, 167, 22);
		contentPane.add(comboBoxEspecie);
		
		JComboBox comboBoxtamano = new JComboBox();
		comboBoxtamano.setModel(new DefaultComboBoxModel(new String[] {"menos de 5 kilos", "de 5 a 10 kilos", "mas de 10 kilos"}));
		comboBoxtamano.setBounds(312, 393, 106, 22);
		contentPane.add(comboBoxtamano);
		
		JComboBox codrenunciante = new JComboBox();
		codrenunciante.setBounds(263, 60, 167, 22);
		contentPane.add(codrenunciante);
		
		JButton btnNewButtonInsertaranimal = new JButton("Insertar Animal");
		btnNewButtonInsertaranimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNombre.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Nombre no puede estar vacío");
					}
				else if (textFieldEdad.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Edad no puede estar vacío");
					}
				else if (textFieldRaza.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Raza no puede estar vacío");
					}
				else if (textFieldVacunas.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Vacunas no puede estar vacío");
					}
				else if (textFieldObservaciones.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Observaciones no puede estar vacío");
					}
				else if (textFieldcaracteristicas.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo caracteristicas no puede estar vacío");
					}
				else {
				
				
					}	
				String renunciante;
				renunciante=(String) codrenunciante.getSelectedItem();
				renunciante=renunciante.substring(0,1);
				animales animales = new animales(Integer.valueOf(renunciante),(String)comboBoxEspecie.getSelectedItem(),textFieldNombre.getText(), textFieldEdad.getText(), textFieldRaza.getText(), textFieldVacunas.getText(), textFieldObservaciones.getText(), textFieldcaracteristicas.getText(), (String)comboBoxsexo.getSelectedItem(),(String)comboBoxtamano.getSelectedItem()); 
				Controlleranimales controller = new Controlleranimales();
				controller.registrar(animales);
				controller.veranimales();
				}
			
		
			
		});
		btnNewButtonInsertaranimal.setBounds(118, 470, 135, 23);
		contentPane.add(btnNewButtonInsertaranimal);
		
		JLabel Jlabelcodrenunciante = new JLabel("Donante:");
		Jlabelcodrenunciante.setBounds(207, 63, 46, 14);
		contentPane.add(Jlabelcodrenunciante);
		
		JButton btnNewButtonSalir = new JButton("Salir");
		btnNewButtonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButtonSalir.setBounds(461, 470, 124, 23);
		contentPane.add(btnNewButtonSalir);
		
		JLabel lblEspecie = new JLabel("Especie:");
		lblEspecie.setBounds(207, 111, 46, 14);
		contentPane.add(lblEspecie);
		
		try {
	         //   System.out.println("INICIO DE EJECUCIÓN.");
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            conexionsafe_pets conex=new conexionsafe_pets();
	    		
	            Statement st = conex.conectar().createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM renunciantes");
	            if (rs != null) {
	          
	 
	                while (rs.next()) {
	                
	                codrenunciante.addItem(""+rs.getObject(1)+", "+rs.getObject(3)+" "+rs.getObject(4)+"");
	                 
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
		
		
		
	}
}	
	
