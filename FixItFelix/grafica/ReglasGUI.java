package grafica;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class ReglasGUI extends JFrame {

	private JPanel contentPane;
	private JFrame aux;
	private JTextField txtReglas;
	private JTextArea txtRalphEsEl;
	
	public ReglasGUI(JFrame principal) {
		aux=this;
		this.setIconImage(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/Icono.png")).getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		btnNewButton.setIcon(new ImageIcon(Top5GUI.class.getResource("/img/pantallaprincipal/back-navigational-arrow-button-pointing-to-left.png")));
		btnNewButton.setBounds(10, 427, 44, 33);
		contentPane.add(btnNewButton);
		
		txtReglas = new JTextField();
		txtReglas.setEditable(false);
		txtReglas.setBorder(null);
		txtReglas.setForeground(Color.RED);
		txtReglas.setFont(new Font("Arial Black", Font.BOLD, 32));
		txtReglas.setBackground(Color.BLACK);
		txtReglas.setText("Reglas");
		txtReglas.setBounds(500, 10, 130, 50);
		contentPane.add(txtReglas);
		txtReglas.setColumns(10);
		
		txtRalphEsEl = new JTextArea();
		txtRalphEsEl.setEditable(false);
		txtRalphEsEl.setBackground(Color.BLACK);
		txtRalphEsEl.setForeground(Color.RED);
		txtRalphEsEl.setFont(new Font("Arial Black", Font.BOLD, 16));
		txtRalphEsEl.setLineWrap(true);
		txtRalphEsEl.setText("Ralph es el villano del juego. \r\nFue despojado de su h\u00E1bitat para construir un edificio llamado \u201CNiceland\u201D.\r\nRalph decide vengarse rompiendo las ventanas del edificio. \r\nLos habitantes del edificio son conocidos como los \u201CNicelanders\u201D \r\ny llaman a Felix Jr. para que repare los destrozos que ocasiona Ralph. \r\nOcasionalmente los gentiles Nicelanders agradecen a F\u00E9lix por su trabajo acerc\u00E1ndole un pastel.\r\nEl objetivo en Fix It Felix Jr. es reparar todas las ventanas rotas \r\ndel edificio Niceland en un tiempo limitado.");
		txtRalphEsEl.setBounds(100, 100, 878, 230);
		contentPane.add(txtRalphEsEl);
		txtRalphEsEl.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReglasGUI.class.getResource("/img/pantallaprincipal/Screenshot_3.png")));
		label.setBounds(100, 312, 860, 300);
		contentPane.add(label);
	}
}
