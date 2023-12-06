package Visual;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import logico.Clinica;
import logico.Enfermedad;

public class RegEnfermedades extends JPanel {
	private JTextField txtId;
	private JTable table;
	private JTextField txtNombre;
	private JTextPane txtDescripcion;
	private int modo;

	/**
	 * Create the panel.
	 */
	public RegEnfermedades() {
		modo = 0;
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enfermedad");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 26, 208, 23);
		add(lblNewLabel);
		Dimension dimension = new Dimension(1904, 900);
		this.setPreferredSize(new Dimension(1904, 896));
		
		JLabel lblNewLabel_1 = new JLabel("_____________________________________________");
		lblNewLabel_1.setBounds(28, 47, 494, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripci\u00F3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(28, 212, 80, 16);
		add(lblNewLabel_2);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(165, 96, 330, 32);
		add(txtId);
		txtId.setColumns(10);
		txtId.setEditable(false);
		txtId.setText(""+Clinica.getIdEnfermedades());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1032, 13, 860, 870);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar");
		
		btnNewButton.setBounds(900, 851, 120, 32);
		add(btnNewButton);
		if (modo == 0) {
			btnNewButton.setEnabled(true);
		} else if (modo == 1) {
			btnNewButton.setEnabled(false);
		}
		
		JButton btnModificar = new JButton("Guardar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(768, 851, 120, 32);
		add(btnModificar);
		if (modo == 0) {
			btnModificar.setEnabled(false);
		} else if (modo == 1) {
			btnModificar.setEnabled(true);
		}
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(636, 851, 120, 32);
		add(btnEliminar);
		if (modo == 0) {
			btnEliminar.setEnabled(false);
		} else if (modo == 1) {
			btnModificar.setEnabled(true);
		}
		
		JLabel lblFecha = new JLabel("Nombre");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(28, 157, 56, 16);
		add(lblFecha);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(28, 103, 135, 16);
		add(lblId);
		
		JButton btnEnfermedadNueva = new JButton("Enfermedad Nueva");
		btnEnfermedadNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = 0;
				clean();
			}
		});
		btnEnfermedadNueva.setBounds(464, 851, 160, 32);
		add(btnEnfermedadNueva);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(165, 150, 330, 32);
		add(txtNombre);
		
		txtDescripcion = new JTextPane();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescripcion.setBounds(165, 205, 330, 157);
		add(txtDescripcion);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Enfermedad enfermedad = new Enfermedad(txtId.getText(), txtNombre.getText(), txtDescripcion.getText());
				Clinica.getInstance().agregarEnfermedad(enfermedad);
				JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Registro", JOptionPane.INFORMATION_MESSAGE);
				clean();
			}

			

			
		});
		
		
	}
	
	
	
	private void clean() {
		txtId.setText(""+Clinica.getIdEnfermedades());
		txtNombre.setText("");
		txtDescripcion.setText("");
		
	}
	
	
}
