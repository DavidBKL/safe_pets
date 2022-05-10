package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuCRUDeliminar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCRUDeliminar frame = new menuCRUDeliminar();
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
	public menuCRUDeliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminaranimal= new JButton("Eliminar Animal");
		btnEliminaranimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			formularioEliminaranimal eliminaranimal = new formularioEliminaranimal();
			eliminaranimal.setVisible(true);
			}
		});
		btnEliminaranimal.setBounds(20, 108, 164, 23);
		contentPane.add(btnEliminaranimal);
		
		JButton btnEliminaradoptantes= new JButton("Eliminar Adoptante");
		btnEliminaradoptantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formularioEliminaradoptante eliminaradoptante = new formularioEliminaradoptante();
				eliminaradoptante.setVisible(true);
			}
		});
		btnEliminaradoptantes.setBounds(20, 187, 164, 25);
		contentPane.add(btnEliminaradoptantes);
		
		JButton btnEliminarrenunciante = new JButton("Eliminar Donante");
		btnEliminarrenunciante.setBounds(283, 188, 179, 23);
		btnEliminarrenunciante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					formularioEliminarrenunciante eliminarrenunciante = new formularioEliminarrenunciante();
			eliminarrenunciante.setVisible(true);
			}
		});
		contentPane.add(btnEliminarrenunciante);
		
		JButton btnSALIR = new JButton("Salir");
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSALIR.setBounds(185, 290, 164, 23);
		contentPane.add(btnSALIR);
		
		JButton btnEliminaradopciones= new JButton("Eliminar adopci\u00F3n");
		btnEliminaradopciones.setBounds(283, 108, 179, 23);
		btnEliminaradopciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formularioEliminaradopcion eliminaradopcion = new formularioEliminaradopcion();
				eliminaradopcion.setVisible(true);
			}
		});
		contentPane.add(btnEliminaradopciones);
		
		
	}
	}
