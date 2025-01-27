package grafica;
import logica.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class PantallaPrincipalGUI extends JFrame {

	private JPanel contentPane;
	private JFrame aux;
	private ConfiguracionGUI configuracion = new ConfiguracionGUI(this);
	private EstadisticasGUI estadisticas = new EstadisticasGUI(this);
	private Top5GUI top5 = new Top5GUI(this);
	private ReglasGUI reglas = new ReglasGUI(this);




	/**
	 * Create the frame.
	 */
	public PantallaPrincipalGUI() {
		aux=this;
		Fichero arch = new Fichero();
		this.setIconImage(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/Icono.png")).getImage());
		setResizable(false);		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnQuieroJugar = new JButton("QUIERO JUGAR!");
		btnQuieroJugar.setForeground(new Color(204, 0, 0));
		btnQuieroJugar.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnQuieroJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arch.aumentarCont(1, arch);
				Partida.nuevaPartida();
				Partida.getInstance().iniciarGrafica();
				aux.setVisible(false);
			}
		});
		btnQuieroJugar.setBackground(new Color(0, 0, 0));
		btnQuieroJugar.setBounds(311, 329, 438, 95);
		panel.add(btnQuieroJugar);
		
		JButton btnReglasDelJuego = new JButton("REGLAS ");
		btnReglasDelJuego.setForeground(Color.RED);
		
		
		
		btnReglasDelJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReglasDelJuego.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnReglasDelJuego.setBackground(new Color(0, 0, 0));
		btnReglasDelJuego.setBounds(311, 465, 214, 95);
		panel.add(btnReglasDelJuego);
		btnReglasDelJuego.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				aux.setVisible(false);
				reglas.setVisible(true);
			}
		});
		
		JButton btnTop = new JButton("TOP 5");
		btnTop.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				aux.setVisible(false);
				Top5GUI top5 = new Top5GUI(aux);
				top5.setVisible(true);
			}
		});
		
		btnTop.setForeground(new Color(204, 0, 0));
		btnTop.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnTop.setBackground(new Color(0, 0, 0));
		btnTop.setBounds(535, 465, 210, 95);
		panel.add(btnTop);
		
		JButton btnEstadisticas = new JButton("ESTADISTICAS");
		btnEstadisticas.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnEstadisticas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				aux.setVisible(false);
				EstadisticasGUI est = new EstadisticasGUI(aux);
				est.setVisible(true);
			}
		});
		btnEstadisticas.setForeground(Color.RED);
		btnEstadisticas.setBackground(new Color(0, 0, 0));
		btnEstadisticas.setBounds(10, 585, 137, 61);
		panel.add(btnEstadisticas);
		
		JButton btnConfiguracion = new JButton("");
		btnConfiguracion.setBorder(null);
		btnConfiguracion.setBackground(Color.BLACK);
		btnConfiguracion.setForeground(Color.BLACK);
		btnConfiguracion.setIcon(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/pantallaprincipal/configuraciones(1).png")));
		btnConfiguracion.setBounds(962, 562, 84, 84);
		panel.add(btnConfiguracion);
		btnConfiguracion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				aux.setVisible(false);
				configuracion.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/pantallaprincipal/Fix-It-Felix-Jr-PNG-Pic.png")));
		lblNewLabel.setBounds(144, 10, 800, 300);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/pantallaprincipal/Screenshot_1.png")));
		label.setBounds(193, 596, 715, 50);
		panel.add(label);
		this.setVisible(true);
	}
	
	public int getDificultad() {
		return configuracion.getDificultad();
	}
	
	public void aumentarDificultad() {
		this.configuracion.aumentarDificultad();
	}
	
	public void visible() {
		aux.setVisible(true);
	}

}

