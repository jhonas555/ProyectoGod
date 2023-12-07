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
import java.io.IOException;
import java.awt.event.ActionEvent;

import logico.Doctor;

public class RegDoctores extends JPanel {
    private JTextField idCita;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;

    /**
     * Create the panel.
     */
    public RegDoctores() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Doctor");
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
                agregarDoctor();
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

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
        lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblFechaNacimiento.setBounds(28, 267, 126, 16);
        add(lblFechaNacimiento);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(165, 260, 330, 32);
        add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(165, 315, 330, 32);
        add(textField_4);

        JLabel lblTelfono = new JLabel("Tel\u00E9fono");
        lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTelfono.setBounds(28, 323, 126, 16);
        add(lblTelfono);

        JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico");
        lblCorreoElectrnico.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCorreoElectrnico.setBounds(28, 377, 147, 16);
        add(lblCorreoElectrnico);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(165, 370, 330, 32);
        add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(165, 425, 330, 32);
        add(textField_6);

        JLabel lblEspecialidad = new JLabel("Especialidad");
        lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEspecialidad.setBounds(28, 432, 147, 16);
        add(lblEspecialidad);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(165, 480, 330, 32);
        add(textField_7);

        JLabel lblLicenciaMdica = new JLabel("Licencia M\u00E9dica");
        lblLicenciaMdica.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblLicenciaMdica.setBounds(28, 487, 147, 16);
        add(lblLicenciaMdica);

        JLabel label = new JLabel("Contrase\u00F1a");
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(520, 157, 88, 16);
        add(label);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(657, 150, 330, 32);
        add(textField_8);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(657, 96, 330, 32);
        add(textField_9);

        JLabel label_1 = new JLabel("Usuario");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label_1.setBounds(520, 103, 135, 16);
        add(label_1);
    }

    // Método para obtener los datos del doctor desde la interfaz y agregarlo a la lista
    private void agregarDoctor() {
        String id = idCita.getText();
        String nombre = textField_1.getText();
        String apellido = textField.getText();
        String fechaNacimiento = textField_3.getText();
        String telefono = textField_4.getText();
        String correoElectronico = textField_5.getText();
        String especialidad = textField_6.getText();
        String licenciaMedica = textField_7.getText();
        String usuario = textField_9.getText();
        String contrasena = textField_8.getText();

        // Crear un objeto Doctor con los datos ingresados
        Doctor doctor = new Doctor(id, contrasena, "", nombre, apellido, null, telefono, correoElectronico);
        doctor.setEspecialidad(especialidad);
        doctor.setNumeroLicenciaMedica(licenciaMedica);

        try {
            // Guardar los datos del doctor en el archivo
            doctor.guardarDatos();
        } catch (IOException e) {
            e.printStackTrace();
            // Puedes manejar la excepción de alguna manera (por ejemplo, mostrar un mensaje de error)
        }

        // Limpiar los campos después de agregar el doctor
        limpiarCampos();
    }

    // Método para limpiar los campos después de agregar un doctor
    private void limpiarCampos() {
        idCita.setText("");
        textField_1.setText("");
        textField.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
        textField_7.setText("");
        textField_9.setText("");
        textField_8.setText("");
    }
}