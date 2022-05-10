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

public class menuCRUDconsultar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCRUDconsultar frame = new menuCRUDconsultar();
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
	public menuCRUDconsultar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnconsultaranimales = new JButton("Consultar Animal");
		btnconsultaranimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultaranimales consultaranimales = new Consultaranimales();
			consultaranimales.setVisible(true);
			}
		});
		btnconsultaranimales.setBounds(22, 105, 164, 23);
		contentPane.add(btnconsultaranimales);
		
		JButton btnconsultaradoptantes= new JButton("Consultar Adoptante");
		btnconsultaradoptantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultaradoptantes consultaradoptantes = new Consultaradoptantes();
				consultaradoptantes.setVisible(true);
			}
		});
		btnconsultaradoptantes.setBounds(22, 198, 164, 23);
		contentPane.add(btnconsultaradoptantes);
		
		JButton btnconsultarrenunciantes = new JButton("Consultar Donante");
		btnconsultarrenunciantes.setBounds(294, 198, 164, 23);
		btnconsultarrenunciantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultarrenunciantes consultarrenunciantes = new Consultarrenunciantes();
				consultarrenunciantes.setVisible(true);
			}
		});
		contentPane.add(btnconsultarrenunciantes);
		
		JButton btnSALIR = new JButton("Salir");
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSALIR.setBounds(185, 290, 164, 23);
		contentPane.add(btnSALIR);
		
		JButton btnConsultaradopciones = new JButton("Consultar Adopci\u00F3n");
	       btnConsultaradopciones.setBounds(294, 105, 164, 23);
		btnConsultaradopciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultaradopciones Consultaradopciones = new Consultaradopciones();
				Consultaradopciones.setVisible(true);
			}
		});
		contentPane.add (btnConsultaradopciones);
	}
}	
	
