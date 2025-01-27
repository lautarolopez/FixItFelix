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
import javax.swing.SwingConstants;

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
	private JTextField txtNivel;
	private JTextField textNiv;

	
	public StatusGUI() {
		setBorder(new LineBorder(new Color(255, 215, 0), 5, true));
		txtPuntajeMaximo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntajeMaximo.setBorder(null);
		txtPuntajeMaximo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtPuntajeMaximo.setFocusable(false);
		txtPuntajeActual.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntajeActual.setFocusable(false);
		txtTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTiempo.setBorder(null);
		txtTiempo.setFocusable(false);
		txtVidas.setHorizontalAlignment(SwingConstants.CENTER);
		txtVidas.setBorder(null);
		txtVidas.setFocusable(false);
		textPuntajeAct.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntajeAct.setFont(new Font("Arial Black", Font.BOLD, 15));
		textPuntajeAct.setBorder(null);
		textPuntajeAct.setBackground(Color.BLACK);
		textPuntajeAct.setForeground(Color.WHITE);
		textPuntajeAct.setFocusable(false);
		textTiemp.setHorizontalAlignment(SwingConstants.CENTER);
		textTiemp.setFont(new Font("Arial Black", Font.BOLD, 15));
		textTiemp.setBorder(null);
		textTiemp.setForeground(Color.WHITE);
		textTiemp.setBackground(new Color(0, 0, 0));
		textTiemp.setFocusable(false);
		lbVidas.setFocusable(false);
		setBackground(Color.BLACK);
		setLayout(null);
		textPuntajeMax.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntajeMax.setFont(new Font("Arial Black", Font.BOLD, 15));
		textPuntajeMax.setBorder(null);
		textPuntajeMax.setForeground(Color.WHITE);
		textPuntajeMax.setBackground(Color.BLACK);
		textPuntajeMax.setFocusable(false);
		textPuntajeMax.setEditable(false);
		mensaje = String.valueOf(Juego.getInstance().getHighScore());
		textPuntajeMax.setText(mensaje);
		textPuntajeMax.setBounds(10, 44, 190, 28);
		add(textPuntajeMax);
		textPuntajeMax.setColumns(10);
		txtPuntajeMaximo.setEditable(false);
		txtPuntajeMaximo.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPuntajeMaximo.setForeground(new Color(204, 0, 0));
		txtPuntajeMaximo.setBackground(Color.BLACK);
		txtPuntajeMaximo.setText("PUNTAJE MAXIMO");
		txtPuntajeMaximo.setBounds(10, 8, 190, 28);
		add(txtPuntajeMaximo);
		txtPuntajeMaximo.setColumns(10);
		txtPuntajeActual.setEditable(false);
		txtPuntajeActual.setBorder(null);
		txtPuntajeActual.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPuntajeActual.setForeground(new Color(204, 0, 0));
		txtPuntajeActual.setBackground(Color.BLACK);
		txtPuntajeActual.setText("PUNTAJE ACTUAL");
		txtPuntajeActual.setBounds(210, 8, 190, 28);
		add(txtPuntajeActual);
		txtPuntajeActual.setColumns(10);
		
		txtTiempo.setEditable(false);
		txtTiempo.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTiempo.setForeground(new Color(204, 0, 0));
		txtTiempo.setBackground(Color.BLACK);
		txtTiempo.setText("TIEMPO");
		txtTiempo.setBounds(410, 8, 190, 28);
		add(txtTiempo);
		txtTiempo.setColumns(10);
		
		txtVidas.setEditable(false);
		txtVidas.setForeground(new Color(204, 0, 0));
		txtVidas.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtVidas.setBackground(Color.BLACK);
		txtVidas.setText("VIDAS");
		txtVidas.setBounds(810, 8, 190, 28);
		add(txtVidas);
		txtVidas.setColumns(10);
		
		textPuntajeAct.setEditable(false);
		textPuntajeAct.setBounds(210, 44, 190, 20);
		add(textPuntajeAct);
		textPuntajeAct.setColumns(10);
		
		textTiemp.setEditable(false);
		textTiemp.setBounds(410, 44, 190, 28);
		add(textTiemp);
		textTiemp.setColumns(10);
		
		actualizarBarraDeEstado();
		setFocusable(false);
		
		lbVidas.setIcon(new ImageIcon(StatusGUI.class.getResource("/img/felix/VidasFelix.png")));
		lbVidas.setBounds(867, 46, 80, 28);
		add(lbVidas);
		
		txtNivel = new JTextField();
		txtNivel.setBorder(null);
		txtNivel.setFocusable(false);
		txtNivel.setEditable(false);
		txtNivel.setHorizontalAlignment(SwingConstants.CENTER);
		txtNivel.setForeground(new Color(204, 0, 0));
		txtNivel.setBackground(Color.BLACK);
		txtNivel.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtNivel.setText("NIVEL");
		txtNivel.setBounds(610, 8, 190, 28);
		add(txtNivel);
		txtNivel.setColumns(10);
		
		textNiv = new JTextField();
		textNiv.setHorizontalAlignment(SwingConstants.CENTER);
		textNiv.setFocusable(false);
		textNiv.setForeground(new Color(255, 255, 255));
		textNiv.setFont(new Font("Arial Black", Font.BOLD, 15));
		textNiv.setEditable(false);
		textNiv.setBorder(null);
		textNiv.setBackground(new Color(0, 0, 0));
		textNiv.setBounds(610, 44, 190, 28);
		add(textNiv);
		mensaje = String.valueOf(Juego.getInstance().getDificultad());
		textNiv.setText(mensaje);
 		textNiv.setColumns(10);
		
	}
	public void actualizarBarraDeEstado() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		 	public void run(){
		 		
				mensaje = String.valueOf(Partida.getInstance().getJugador().getPuntaje());
				textPuntajeAct.setText(mensaje);
				
				mensaje = String.valueOf(Partida.getInstance().getTiempo()/10 );
				textTiemp.setText(mensaje);
				if(Partida.getInstance().getTiempo()<100)
					textTiemp.setForeground(new Color(204, 0, 0));
			
				switch(Partida.getInstance().getVidas()) {  
				case 3: lbVidas.setBounds(867, 46, 80, 28);
				break;
				case 2: lbVidas.setBounds(867, 46, 55, 28);
				break;
				case 1:lbVidas.setBounds(867, 46, 30, 28);
				break;
				}
				
				
		 	}
		};
		timer.schedule(task, 10, 1);
}
}
