package grafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import logica.*;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class StatusGUI extends JPanel {
	private JTextField txtPuntajeMaximo = new JTextField();
	private JTextField txtPuntajeActual = new JTextField();
	private JTextField txtTiempo = new JTextField();
	private JTextField txtVidas = new JTextField();
	private JTextField textPuntajeMax = new JTextField();
	private JTextField textPuntajeAct = new JTextField();
	private JTextField textTiemp = new JTextField();
	private JLabel lbVidas = new JLabel("New label"); 
	private String mensaje;

	
	public StatusGUI() {
		setBorder(new LineBorder(new Color(255, 215, 0), 5, true));
		txtPuntajeMaximo.setBorder(null);
		txtPuntajeMaximo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtPuntajeMaximo.setFocusable(false);
		txtPuntajeActual.setFocusable(false);
		txtTiempo.setBorder(null);
		txtTiempo.setFocusable(false);
		txtVidas.setBorder(null);
		txtVidas.setFocusable(false);
		textPuntajeAct.setFont(new Font("Arial Black", Font.BOLD, 15));
		textPuntajeAct.setBorder(null);
		textPuntajeAct.setBackground(Color.BLACK);
		textPuntajeAct.setForeground(Color.WHITE);
		textPuntajeAct.setFocusable(false);
		textTiemp.setFont(new Font("Arial Black", Font.BOLD, 15));
		textTiemp.setBorder(null);
		textTiemp.setForeground(Color.WHITE);
		textTiemp.setBackground(new Color(0, 0, 0));
		textTiemp.setFocusable(false);
		lbVidas.setFocusable(false);
		setBackground(Color.BLACK);
		setLayout(null);
		textPuntajeMax.setFont(new Font("Arial Black", Font.BOLD, 15));
		textPuntajeMax.setBorder(null);
		textPuntajeMax.setForeground(Color.WHITE);
		textPuntajeMax.setBackground(Color.BLACK);
		textPuntajeMax.setFocusable(false);
		textPuntajeMax.setEditable(false);
		mensaje = String.valueOf(Juego.getInstance().getHighScore());
		textPuntajeMax.setText(mensaje);
		textPuntajeMax.setBounds(97, 44, 155, 20);
		add(textPuntajeMax);
		textPuntajeMax.setColumns(10);
		txtPuntajeMaximo.setEditable(false);
		txtPuntajeMaximo.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPuntajeMaximo.setForeground(new Color(204, 0, 0));
		txtPuntajeMaximo.setBackground(Color.BLACK);
		txtPuntajeMaximo.setText("PUNTAJE MAXIMO");
		txtPuntajeMaximo.setBounds(97, 5, 171, 28);
		add(txtPuntajeMaximo);
		txtPuntajeMaximo.setColumns(10);
		txtPuntajeActual.setEditable(false);
		txtPuntajeActual.setBorder(null);
		txtPuntajeActual.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPuntajeActual.setForeground(new Color(204, 0, 0));
		txtPuntajeActual.setBackground(Color.BLACK);
		txtPuntajeActual.setText("PUNTAJE ACTUAL");
		txtPuntajeActual.setBounds(354, 8, 161, 22);
		add(txtPuntajeActual);
		txtPuntajeActual.setColumns(10);
		
		txtTiempo.setEditable(false);
		txtTiempo.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTiempo.setForeground(new Color(204, 0, 0));
		txtTiempo.setBackground(Color.BLACK);
		txtTiempo.setText("TIEMPO");
		txtTiempo.setBounds(635, 5, 118, 28);
		add(txtTiempo);
		txtTiempo.setColumns(10);
		
		txtVidas.setEditable(false);
		txtVidas.setForeground(new Color(204, 0, 0));
		txtVidas.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtVidas.setBackground(Color.BLACK);
		txtVidas.setText("VIDAS");
		txtVidas.setBounds(832, 5, 66, 28);
		add(txtVidas);
		txtVidas.setColumns(10);
		
		textPuntajeAct.setEditable(false);
		textPuntajeAct.setBounds(354, 44, 161, 20);
		add(textPuntajeAct);
		textPuntajeAct.setColumns(10);
		
		textTiemp.setEditable(false);
		textTiemp.setBounds(635, 44, 80, 20);
		add(textTiemp);
		textTiemp.setColumns(10);
		
		actualizarBarraDeEstado();
		setFocusable(false);
		
		lbVidas.setIcon(new ImageIcon(StatusGUI.class.getResource("/img/felix/VidasFelix.jpeg")));
		lbVidas.setBounds(818, 40, 80, 28);
		add(lbVidas);
		
	}
	public void actualizarBarraDeEstado() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		 	public void run(){
		 		
				mensaje = String.valueOf(Partida.getInstance().getJugador().getPuntaje());
				textPuntajeAct.setText(mensaje);
				
				switch(Partida.getInstance().getVidas()) {  //Cambia el tamanio de mi imagen segun las vidas que tenga, la longitud define cuantas caras se ven
				case 3: lbVidas.setBounds(879, 37, 80, 28);
				break;
				case 2: lbVidas.setBounds(879, 37, 55, 28);
				break;
				case 1:lbVidas.setBounds(879, 37, 30, 28);
				break;
				}
				
				mensaje = String.valueOf(Partida.getInstance().getTiempo());
				textTiemp.setText(mensaje);
		 	}
		};
		timer.schedule(task, 10, 1);
}
}
