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
import java.awt.Component;
import javax.swing.SwingConstants;

public class NuevoPuntajeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseNombre;
	private JTextField textField;
	private JTextField txtNombreInvalidoIngrese;
	private JLabel lblNewLabel_1 = new JLabel("");
	private JLabel lblNewLabel_2;
	private JTextField txtNuevoPuntajeAlto;
	private JFrame aux = this;
	
	public NuevoPuntajeGUI() {
		this.setIconImage(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/Icono.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(255, 255, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoPuntajeAlto = new JTextField();
		txtNuevoPuntajeAlto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuevoPuntajeAlto.setEditable(false);
		txtNuevoPuntajeAlto.setForeground(new Color(255, 0, 0));
		txtNuevoPuntajeAlto.setBorder(null);
		txtNuevoPuntajeAlto.setBackground(Color.BLACK);
		txtNuevoPuntajeAlto.setFont(new Font("Arial Black", Font.BOLD, 24));
		txtNuevoPuntajeAlto.setBounds(10, 306, 988, 48);
		contentPane.add(txtNuevoPuntajeAlto);
		txtNuevoPuntajeAlto.setColumns(10);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngreseNombre.setEditable(false);
		txtIngreseNombre.setBorder(null);
		txtIngreseNombre.setForeground(new Color(0, 0, 255));
		txtIngreseNombre.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtIngreseNombre.setBackground(new Color(0, 0, 0));
		txtIngreseNombre.setText("INGRESE NOMBRE ");
		txtIngreseNombre.setBounds(10, 357, 988, 32);
		contentPane.add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.BOLD, 13));
		textField.setBounds(378, 409, 248, 39);
		contentPane.add(textField);
		textField.setColumns(10);
	
		txtNombreInvalidoIngrese = new JTextField();
		txtNombreInvalidoIngrese.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreInvalidoIngrese.setEditable(false);
		txtNombreInvalidoIngrese.setVisible(false);
		txtNombreInvalidoIngrese.setBorder(null);
		txtNombreInvalidoIngrese.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtNombreInvalidoIngrese.setForeground(Color.RED);
		txtNombreInvalidoIngrese.setBackground(new Color(0, 0, 0));
		txtNombreInvalidoIngrese.setBounds(10, 519, 988, 39);
		contentPane.add(txtNombreInvalidoIngrese);
		txtNombreInvalidoIngrese.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/pantallaprincipal/Fix-It-Felix-Jr-PNG-Pic.png")));
		lblNewLabel.setBounds(144, 10, 800, 300);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>2) { 
					boolean hayBlanco=false;
					int i=0;
					while(i<textField.getText().length()&&hayBlanco==false) { //Evaluo caracter por caracter que no existan blancos
						if(textField.getText().charAt(i)==' ') {
							hayBlanco=true;
						}else {
							i++;
						}
					}
					if(hayBlanco==true) { //Si encontre algun blanco, lo informo y solicito un nuevo nombre
						txtNombreInvalidoIngrese.setVisible(true);
						txtNombreInvalidoIngrese.setText("NOMBRE INVALIDO, INGRESE OTRO QUE NO CONTENGA ESPACIOS");
					}else {
						String nombreFinal = textField.getText();
						if(nombreFinal.length()>20) {				//Llegados a este punto el nombre es valido, evaluo si posee mas de 20 caracteres y de ser asi cropeo el String dejando solo los primeros 20.
							nombreFinal = nombreFinal.substring(0, 20);
						}
						Juego.getInstance().guardarEnTopScores(nombreFinal);  //Me dirijo al menu y hago invisible esta ventana
						Juego.getInstance().irAlMenu();
						  dispose();
					}
				}else
					txtNombreInvalidoIngrese.setText("NOMBRE INVALIDO, INGRESE OTRO QUE SEA MAYOR A DOS CARACTERES"); //El nombre es menor a 3 caracteres por lo que informo y solicito uno nuevo.
					txtNombreInvalidoIngrese.setVisible(true);
			}
		});
	
		btnAceptar.setBounds(458, 459, 89, 23);
		contentPane.add(btnAceptar);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1.setBounds(695, 365, 128, 145);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(278, 418, 54, 64);
		contentPane.add(lblNewLabel_2);
		  
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/medallas/slice29_29.png")));
		lblNewLabel_3.setBounds(458, 557, 95, 113);
		contentPane.add(lblNewLabel_3);
		actualizarAnimaciones(); 
		
	}
	
	/** A medida que pase el tiempo alternara las animaciones de Ralph y Felix, dependiendo si la partida se gano o se perdio.
	 * Ademas alternara el texto que indique si efectivamente se gano o no el juego. **/
	public void actualizarAnimaciones() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int i=1;
			
		 	public void run(){
		 		switch(i) {
		 		case 1: if(Juego.getInstance().getDificultad()==10) {
		 					txtNuevoPuntajeAlto.setText("HA GANADO!! NUEVO PUNTAJE ALTO!");
			 				lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice197_@.png")));
			 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice72_72.png")));
		 					}
		 				else {
		 					txtNuevoPuntajeAlto.setText("HA PERDIDO, PERO... NUEVO PUNTAJE ALTO!");
			 				lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice146_@.png")));
			 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice293_@.png")));
		 					}	
		 				i++;
		 				break;
		 		case 2: if(Juego.getInstance().getDificultad()==10) {
		 					txtNuevoPuntajeAlto.setText("HA GANADO!! NUEVO PUNTAJE ALTO!");
			 				lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice196_@.png")));
			 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice73_73.png")));
		 					}
		 				else {
		 					txtNuevoPuntajeAlto.setText("HA PERDIDO, PERO... NUEVO PUNTAJE ALTO!");
			 				lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice150_@.png")));
			 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice294_@.png")));
		 					}	
		 				i++;
		 				break;
		 		case 3: if(Juego.getInstance().getDificultad()==10) {
		 					txtNuevoPuntajeAlto.setText("HA GANADO!! NUEVO PUNTAJE ALTO!");
			 				lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice195_@.png")));
			 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice77_77.png")));
		 					}
		 				else {
		 					txtNuevoPuntajeAlto.setText("HA PERDIDO, PERO... NUEVO PUNTAJE ALTO!");
			 				lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice151_@.png")));
			 				lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice295_@.png")));
		 					}
		 				i++;
		 				break;
		 		 case 4: if(Juego.getInstance().getDificultad()==10) {
		 			 		txtNuevoPuntajeAlto.setText("HA GANADO!! NUEVO PUNTAJE ALTO!");
		 			 		lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice196_@.png")));
		 			 		lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice73_73.png")));
 							}
		 		 		else {
		 		 			txtNuevoPuntajeAlto.setText("HA PERDIDO, PERO... NUEVO PUNTAJE ALTO!");
		 		 			lblNewLabel_1.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/ralph/slice151_@.png")));
		 		 			lblNewLabel_2.setIcon(new ImageIcon(NuevoPuntajeGUI.class.getResource("/img/felix/slice296_@.png")));
		 		 			}
		 		 		i=1;
		 		 		break;
		 			}
		 		}
		};
		timer.schedule(task, 10, 150);
	}
}
