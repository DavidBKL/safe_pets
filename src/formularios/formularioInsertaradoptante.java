package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import personas.*;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;



public class formularioInsertaradoptante extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldNIF;
	public static JTextField textFieldNombre;
	public static JTextField textFieldApellidos;
	public static JTextField textFieldDireccion;
	public static JTextField textFieldCP;
	public static JTextField textFieldProvincia;
	public static JComboBox Tipoacogida;
	private JTextField NIF;
	private JTextField Apellidos;
	private JTextField Direccion;
	private JTextField CP;
	private JTextField Provincia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioInsertaradoptante frame = new formularioInsertaradoptante();
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
	public formularioInsertaradoptante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adoptantes:");
		lblNewLabel.setFont(new Font("Ravie", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 0, 393, 49);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewNombre = new JLabel("Nombre:");
		lblNewNombre.setBounds(207, 150, 46, 14);
		contentPane.add(lblNewNombre);
		
		JLabel lblNewApellidos = new JLabel("Apellidos:");
		lblNewApellidos.setBounds(207, 192, 46, 14);
		contentPane.add(lblNewApellidos);
		
		JLabel lblNewDireccion = new JLabel("Direcci\u00F3n:");
		lblNewDireccion.setBounds(207, 228, 56, 14);
		contentPane.add(lblNewDireccion);
		
		JLabel lblNewCP = new JLabel("<html><body>Codigo<BR>Postal</body></hmtl>");
		lblNewCP.setBounds(207, 253, 46, 36);
		contentPane.add(lblNewCP);
		
		JLabel lblNewObservaciones = new JLabel("Provincia:");
		lblNewObservaciones.setBounds(205, 306, 56, 14);
		contentPane.add(lblNewObservaciones);
		
		JLabel lblNewtipoadopcion = new JLabel("<html><body>Tipo<BR>Adopci\u00F3n</body></hmtl>");
		lblNewtipoadopcion.setBounds(207, 347, 46, 36);
		contentPane.add(lblNewtipoadopcion);
		
		JLabel lblNewMotivo = new JLabel("<html><body>?Por qu? quieres<BR>adoptar?</body></hmtl>\"");
		lblNewMotivo.setBounds(207, 384, 56, 62);
		contentPane.add(lblNewMotivo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(263, 147, 167, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		
		JComboBox comboBoxtipoacogida = new JComboBox();
		comboBoxtipoacogida.setModel(new DefaultComboBoxModel(new String[] {"Acogida Temporal", "Adopci?n"}));
		comboBoxtipoacogida.setBounds(263, 351, 146, 22);
		contentPane.add(comboBoxtipoacogida);
		
		JComboBox comboBoxmotivoadopcion = new JComboBox();
		comboBoxmotivoadopcion.setModel(new DefaultComboBoxModel(new String[] {"Vivo s\u00F3lo y quiero compa\u00F1\u00EDa", "<html><body>Quiero ayudar a reducir<BR>el abandono de animales</body></hmtl>", "Quiero ampliar la familia", "<html><body>Perd\u00ED a mi mascota hace un tiempo <BR>y quiero volver a adoptar</body></hmtl>", "Otros (escribir el motivo)"}));
		comboBoxmotivoadopcion.setBounds(263, 390, 205, 43);
		contentPane.add(comboBoxmotivoadopcion);
		
	
		
		JButton btnNewButtonSalir = new JButton("Salir");
		btnNewButtonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButtonSalir.setBounds(413, 470, 124, 23);
		contentPane.add(btnNewButtonSalir);
		
		JLabel lblNIF = new JLabel("NIF");
		lblNIF.setBounds(207, 111, 46, 14);
		contentPane.add(lblNIF);
		
		NIF = new JTextField();
		NIF.setBounds(263, 108, 106, 20);
		contentPane.add(NIF);
		NIF.setColumns(10);
		
		Apellidos = new JTextField();
		Apellidos.setBounds(263, 189, 167, 20);
		contentPane.add(Apellidos);
		Apellidos.setColumns(10);
		
		Direccion = new JTextField();
		Direccion.setBounds(263, 225, 167, 20);
		contentPane.add(Direccion);
		Direccion.setColumns(10);
		
		CP = new JTextField();
		CP.setBounds(263, 257, 86, 20);
		contentPane.add(CP);
		CP.setColumns(10);
		
		Provincia = new JTextField();
		Provincia.setBounds(263, 303, 167, 20);
		contentPane.add(Provincia);
		Provincia.setColumns(10);
		
		JButton insertaradoptante = new JButton("Insertar adoptante");
		insertaradoptante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NIF.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo NIF no puede estar vac?o");
					}
				else if (textFieldNombre.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Nombre no puede estar vac?o");
					}
				else if (Apellidos.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Apellidos no puede estar vac?o");
					}
				else if (Direccion.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo Direccion no puede estar vac?o");
					}
				else if (CP.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane,"El campo C?digo Postal no puede estar vac?o");
					}
					else if (Provincia.getText().length()==0) {
						JOptionPane.showMessageDialog(rootPane,"El campo Provincia no puede estar vac?o");
					}
				else {
				
				
					}	

				adoptantes adoptantes = new adoptantes(NIF.getText(),textFieldNombre.getText(), Apellidos.getText(), Integer.valueOf(CP.getText()),Direccion.getText(),Provincia.getText(), (String)comboBoxtipoacogida.getSelectedItem(),(String)comboBoxmotivoadopcion.getSelectedItem()); 
				Controlleradoptantes controller = new Controlleradoptantes();
				controller.registrar(adoptantes);
				controller.veradoptantes();
				
				NIF.setText("");
				textFieldNombre.setText("");
	    		Apellidos.setText("");
	    		CP.setText("");
	    		Direccion.setText("");
	    		Provincia.setText("");
			}
		});
		insertaradoptante.setBounds(99, 470, 124, 23);
		contentPane.add(insertaradoptante);
		
		}
		
	}

	
