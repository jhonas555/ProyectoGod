package Visual;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegPacientes extends JPanel {
	private JTextField idCita;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public RegPacientes() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 26, 208, 23);
		add(lblNewLabel);
		Dimension dimension = new Dimension(1904, 900);
		this.setPreferredSize(new Dimension(1904, 896));
		
		JLabel lblNewLabel_1 = new JLabel("_____________________________________________");
		lblNewLabel_1.setBounds(28, 47, 494, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(28, 212, 56, 16);
		add(lblNewLabel_2);
		
		idCita = new JTextField();
		idCita.setBounds(165, 96, 330, 32);
		add(idCita);
		idCita.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1032, 13, 860, 870);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(900, 851, 120, 32);
		add(btnNewButton);
		
		JButton btnModificar = new JButton("Guardar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(768, 851, 120, 32);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(636, 851, 120, 32);
		add(btnEliminar);
		
		JLabel lblFecha = new JLabel("Nombre");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(28, 157, 56, 16);
		add(lblFecha);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 205, 330, 32);
		add(textField);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(28, 103, 135, 16);
		add(lblId);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaciente.setBounds(28, 267, 80, 16);
		add(lblPaciente);
		
		JButton button_1 = new JButton("Cita Nueva");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(504, 851, 120, 32);
		add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 150, 330, 32);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 260, 330, 32);
		add(textField_2);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaNacimiento.setBounds(28, 322, 126, 16);
		add(lblFechaNacimiento);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 315, 330, 32);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 370, 330, 32);
		add(textField_4);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelfono.setBounds(28, 378, 126, 16);
		add(lblTelfono);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico");
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorreoElectrnico.setBounds(28, 432, 147, 16);
		add(lblCorreoElectrnico);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(165, 425, 330, 32);
		add(textField_5);
		
		JLabel lblEspecialidad = new JLabel("Historial Clinico");
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidad.setBounds(28, 487, 147, 16);
		add(lblEspecialidad);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBounds(165, 480, 120, 32);
		add(btnConsultas);
	}
}