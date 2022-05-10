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

public class menuCRUDactualizar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCRUDactualizar frame = new menuCRUDactualizar();
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
	public menuCRUDactualizar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnactualizaranimales = new JButton("Actualizar Animal");
		btnactualizaranimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioActualizaranimal actualizaranimales = new FormularioActualizaranimal();
			actualizaranimales.setVisible(true);
			}
		});
		btnactualizaranimales.setBounds(20, 110, 153, 23);
		contentPane.add(btnactualizaranimales);
		
		JButton btnactualizaradoptantes= new JButton("Actualizar Adoptante");
		btnactualizaradoptantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioActualizaradoptante actualizaradoptantes = new FormularioActualizaradoptante();
				actualizaradoptantes.setVisible(true);
			}
		});
		btnactualizaradoptantes.setBounds(20, 206, 153, 23);
		contentPane.add(btnactualizaradoptantes);
		
		JButton btnactualizarrenunciantes = new JButton("Actualizar Donante");
		btnactualizarrenunciantes.setBounds(352, 206, 153, 23);
		btnactualizarrenunciantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioActualizarrenunciante actualizarrenunciantes = new FormularioActualizarrenunciante();
				actualizarrenunciantes.setVisible(true);
			}
		});
		contentPane.add(btnactualizarrenunciantes);
		
		JButton btnSALIR = new JButton("Salir");
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSALIR.setBounds(185, 290, 164, 23);
		contentPane.add(btnSALIR);
		
		JButton btnactualizaradopciones = new JButton("Actualizar Adopci\u00F3n");
	       btnactualizaradopciones.setBounds(352, 110, 153, 23);
		btnactualizaradopciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioActualizaradopciones actualizaradopciones = new FormularioActualizaradopciones();
				actualizaradopciones.setVisible(true);
			}
		});
		contentPane.add (btnactualizaradopciones);
	}
}	
	
