package Visual;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;

public class PagPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PagPrincipal() {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pag Principal");
		lblNewLabel.setBounds(257, 286, 164, 54);
		add(lblNewLabel);
		Dimension dimension = new Dimension(1904, 896);
		this.setPreferredSize(dimension);

	}

}
