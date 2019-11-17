package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConfiguracionGUI extends JFrame {

	private JPanel contentPane;
	private JFrame aux;
	private JTextField txtSeleccioneLaDificultad;
	JSlider slider = new JSlider();


	public ConfiguracionGUI(JFrame principal) {
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
		
		slider.setValue(1);
		slider.setBackground(Color.BLACK);
		slider.setForeground(Color.RED);
		slider.setFont(new Font("Arial Black", Font.BOLD, 12));
		slider.setMajorTickSpacing(1);
		slider.setMaximum(10);
		slider.setMinimum(1);
		slider.setPaintLabels(true);
		slider.setBounds(170, 463, 700, 114);
		contentPane.add(slider);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConfiguracionGUI.class.getResource("/img/pantallaprincipal/Fix-It-Felix-Jr-PNG-Pic.png")));
		label.setBounds(144, 10, 800, 300);
		contentPane.add(label);
		
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
		
		txtSeleccioneLaDificultad = new JTextField();
		txtSeleccioneLaDificultad.setBorder(null);
		txtSeleccioneLaDificultad.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccioneLaDificultad.setFont(new Font("Arial Black", Font.BOLD, 24));
		txtSeleccioneLaDificultad.setForeground(Color.RED);
		txtSeleccioneLaDificultad.setBackground(Color.BLACK);
		txtSeleccioneLaDificultad.setText("SELECCIONE LA DIFICULTAD DESEADA");
		txtSeleccioneLaDificultad.setBounds(170, 320, 700, 100);
		contentPane.add(txtSeleccioneLaDificultad);
		txtSeleccioneLaDificultad.setColumns(10);
		
	}
	
	public int getDificultad() {
		return slider.getValue();
	}
	
	public void aumentarDificultad() {
		slider.setValue(slider.getValue()+1);
	}
}
