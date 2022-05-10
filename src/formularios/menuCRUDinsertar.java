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

public class menuCRUDinsertar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCRUDinsertar frame = new menuCRUDinsertar();
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
	public menuCRUDinsertar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsertaranimales = new JButton("Insertar Animal");
		btnInsertaranimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			formularioInsertaranimales insertaranimales = new formularioInsertaranimales();
			insertaranimales.setVisible(true);
			}
		});
		btnInsertaranimales.setBounds(31, 114, 164, 23);
		contentPane.add(btnInsertaranimales);
		
		JButton btnInsertaradoptantes= new JButton("Insertar Adoptante");
		btnInsertaradoptantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formularioInsertaradoptante insertaradoptante = new formularioInsertaradoptante();
				insertaradoptante.setVisible(true);
			}
		});
		btnInsertaradoptantes.setBounds(31, 195, 164, 23);
		contentPane.add(btnInsertaradoptantes);
		
		JButton btnInsertarrenunciantes = new JButton("Insertar Donante");
		btnInsertarrenunciantes.setBounds(299, 195, 164, 23);
		btnInsertarrenunciantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					formularioInsertarrenunciante insertarrenunciante = new formularioInsertarrenunciante();
				insertarrenunciante.setVisible(true);
			}
		});
		contentPane.add(btnInsertarrenunciantes);
		
		JButton btnSALIR = new JButton("Salir");
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSALIR.setBounds(185, 290, 164, 23);
		contentPane.add(btnSALIR);
		
		JButton btnInsertaradopciones = new JButton("Insertar adopci\u00F3n");
		btnInsertaradopciones.setBounds(299, 114, 164, 23);
		
		btnInsertaradopciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					insertaradopciones insertaradopciones = new insertaradopciones();
				insertaradopciones.setVisible(true);
			}
		});contentPane.add(btnInsertaradopciones);
	}
		
	}
