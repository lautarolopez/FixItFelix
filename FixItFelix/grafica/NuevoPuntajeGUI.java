package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import logica.Juego;
import logica.Partida;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class NuevoPuntajeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseNombre;
	private JTextField textField;
	private JTextField txtNombreInvalidoIngrese;
	private JLabel lblNewLabel_1 = new JLabel("New label");
	private JLabel lblNewLabel_2;
	private JTextField txtNuevoPuntajeAlto;
	private JFrame aux = this;

	
	public NuevoPuntajeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(255, 255, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoPuntajeAlto = new JTextField();
		txtNuevoPuntajeAlto.setEditable(false);
		txtNuevoPuntajeAlto.setForeground(new Color(255, 0, 0));
		txtNuevoPuntajeAlto.setBorder(null);
		txtNuevoPuntajeAlto.setBackground(Color.BLACK);
		txtNuevoPuntajeAlto.setFont(new Font("Arial Black", Font.BOLD, 24));
		txtNuevoPuntajeAlto.setText("NUEVO PUNTAJE ALTO");
		txtNuevoPuntajeAlto.setBounds(354, 290, 340, 56);
		contentPane.add(txtNuevoPuntajeAlto);
		txtNuevoPuntajeAlto.setColumns(10);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setEditable(false);
		txtIngreseNombre.setBorder(null);
		txtIngreseNombre.setForeground(new Color(0, 0, 255));
		txtIngreseNombre.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtIngreseNombre.setBackground(new Color(0, 0, 0));
		txtIngreseNombre.setText("INGRESE NOMBRE ");
		txtIngreseNombre.setBounds(433, 342, 190, 32);
		contentPane.add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		
		
		textField = new JTextField();
		textField.setBounds(397, 385, 248, 39);
		contentPane.add(textField);
		textField.setColumns(10);
	
		txtNombreInvalidoIngrese = new JTextField();
		txtNombreInvalidoIngrese.setEditable(false);
		txtNombreInvalidoIngrese.setVisible(false);
		txtNombreInvalidoIngrese.setBorder(null);
		txtNombreInvalidoIngrese.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtNombreInvalidoIngrese.setForeground(Color.RED);
		txtNombreInvalidoIngrese.setBackground(new Color(0, 0, 0));
		
		txtNombreInvalidoIngrese.setBounds(281, 469, 635, 39);
		contentPane.add(txtNombreInvalidoIngrese);
		txtNombreInvalidoIngrese.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/pantallaprincipal/Fix-It-Felix-Jr-PNG-Pic.png")));
		lblNewLabel.setBounds(144, 10, 800, 300);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>3) {
					boolean hayBlanco=false;
					int i=0;
					while(i<textField.getText().length()&&hayBlanco==false) {
						if(textField.getText().charAt(i)==' ') {
							hayBlanco=true;
						}else {
							i++;
						}
					}
					if(hayBlanco==true) {
						txtNombreInvalidoIngrese.setVisible(true);
						txtNombreInvalidoIngrese.setText("NOMBRE INVALIDO, INGRESE OTRO QUE NO CONTENGA ESPACIOS");
					}else
						if(textField.getText().length()>20) {
							textField.getText().substring(0, 20); //Si el nombre supera los 20 caracteres, creopea los primeros 20
							}
						aux.setVisible(false); //El nombre es valido, ir al menu
						Juego.getInstance().guardarEnTopScores(textField.getText());
						Juego.getInstance().irAlMenu();
					
				}else
					txtNombreInvalidoIngrese.setText("NOMBRE INVALIDO, INGRESE OTRO QUE SEA MAYOR A DOS CARACTERES");
					txtNombreInvalidoIngrese.setVisible(true);
			}
		});
	
		btnAceptar.setBounds(477, 435, 89, 23);
		contentPane.add(btnAceptar);
		
		lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice197_@.png")));
		lblNewLabel_1.setBounds(711, 402, 128, 56);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice72_72.png")));
		lblNewLabel_2.setBounds(281, 393, 41, 56);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/medallas/slice29_29.png")));
		lblNewLabel_3.setBounds(482, 519, 95, 145);
		contentPane.add(lblNewLabel_3);
		actualizarBarraDeEstado();
		
		
	}
	public void actualizarBarraDeEstado() {
	
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int i=1;
			
		 	public void run(){
		 		switch(i) {
		 		case 1: lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice197_@.png")));
		 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice72_72.png")));
		 				i++;
		 				break;
		 		case 2: lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice196_@.png")));
		 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice73_73.png")));
		 				i++;
		 				break;
		 		case 3: lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice195_@.png")));
		 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice77_77.png")));
		 				i=1;
		 				break;
		 	}}
		};
		timer.schedule(task, 10, 150);
	}
}