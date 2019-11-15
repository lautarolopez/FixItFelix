package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EstadisticasGUI extends JFrame {

	private JPanel contentPane;
	private JFrame aux;
	
	public EstadisticasGUI(JFrame principal) {
		aux=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				if(e.getSource().equals(btnNewButton)) {
					principal.setVisible(true);
					aux.setVisible(false);
				}
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon(Top5GUI.class.getResource("/img/pantallaprincipal/back-navigational-arrow-button-pointing-to-left.png")));
		btnNewButton.setBounds(10, 427, 44, 33);
		contentPane.add(btnNewButton);
	}

}
