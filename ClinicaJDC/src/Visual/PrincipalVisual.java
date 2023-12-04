package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class PrincipalVisual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVisual frame = new PrincipalVisual();
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
	public PrincipalVisual() {
		Dimension dim = getToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("    P\u00E1gina Principal");
		menuBar.add(mnNewMenu_1);
		
		Dimension currentSize = mnNewMenu_1.getPreferredSize();
		int additionalWidth = 20; // You can adjust this value
		int newWidth = currentSize.width + additionalWidth;
		mnNewMenu_1.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnNewMenu = new JMenu("    Citas");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		menuBar.add(mnNewMenu);
		
		currentSize = mnNewMenu.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnNewMenu.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnViviendas = new JMenu("    Viviendas");
		menuBar.add(mnViviendas);
		
		currentSize = mnViviendas.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnViviendas.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnNewMenu_2 = new JMenu("    Doctores");
		menuBar.add(mnNewMenu_2);
		
		currentSize = mnNewMenu_2.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnNewMenu_2.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnNewMenu_3 = new JMenu("    Pacientes");
		menuBar.add(mnNewMenu_3);
		
		currentSize = mnNewMenu_3.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnNewMenu_3.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnNewMenu_4 = new JMenu("    Enfermedades");
		menuBar.add(mnNewMenu_4);
		
		currentSize = mnNewMenu_4.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnNewMenu_4.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnNewMenu_5 = new JMenu("    Vacunas");
		menuBar.add(mnNewMenu_5);
		
		currentSize = mnNewMenu_5.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnNewMenu_5.setPreferredSize(new Dimension(newWidth, currentSize.height));
		
		JMenu mnNewMenu_6 = new JMenu("    Administradores");
		menuBar.add(mnNewMenu_6);
		
		currentSize = mnNewMenu_6.getPreferredSize();
		additionalWidth = 20; // You can adjust this value
		newWidth = currentSize.width + additionalWidth;
		mnNewMenu_6.setPreferredSize(new Dimension(newWidth, currentSize.height));

		
		Component rigidArea = Box.createRigidArea(new Dimension(5,80));
		menuBar.add(rigidArea);
		setContentPane(contentPane);
		

	}

}
