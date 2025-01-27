package grafica;
import javax.swing.*;
import logica.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
public class PartidaGUI extends JFrame{
	
	private JLayeredPane organizadorDeCapas = new JLayeredPane();
	private JLabel felix = new JLabel(new ImageIcon("img\\felix\\slice65_65.png"));
	private JLabel edificio_seccion_1 = new JLabel(new ImageIcon("img\\edificio\\edificio_150_seccion1.png"));
	private JLabel edificio_seccion_2 = new JLabel(new ImageIcon("img\\edificio\\edificio_150_seccion2.png"));
	private JLabel edificio_seccion_3 = new JLabel(new ImageIcon("img\\edificio\\edificio_150_seccion3.png")); 
	private JLabel ralph = new JLabel(new ImageIcon("img\\ralph\\slice163_@.png"));
	private ArrayList<ArrayList<JLabel>> ventanas_seccion_1 = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<ArrayList<JLabel>> ventanas_seccion_2 = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<ArrayList<JLabel>> ventanas_seccion_3 = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<JLabel> obstaculos = new ArrayList<JLabel>();
	private Posicion posicionCoordenada = new Posicion(2,0);
	private StatusGUI barraDeEstado = new StatusGUI();
	boolean congelar = false;
	boolean muerta = false;
	
	
	
	
	public PartidaGUI(ArrayList<ArrayList<Ventana>> ventanasLogica1, ArrayList<ArrayList<Ventana>> ventanasLogica2, ArrayList<ArrayList<Ventana>> ventanasLogica3) {	
		felix.setBounds(477, 630, 40, 60);
		edificio_seccion_1.setBounds(352, 445, 320, 249);
		edificio_seccion_2.setBounds(352, 207, 320, 249);
		edificio_seccion_3.setBounds(350, -100, 325, 306);
		ralph.setBounds(462, 360, 100, 85);
		organizadorDeCapas.add(felix, new Integer(3));
		organizadorDeCapas.add(ralph, new Integer(3));
		crearVentanas_Suelo(392, 615, this.ventanas_seccion_1, ventanasLogica1);
		crearObstaculos(ventanasLogica1, ventanas_seccion_1);
		crearVentanas(392, 380, this.ventanas_seccion_2, ventanasLogica2);
		organizadorDeCapas.add(edificio_seccion_1, new Integer(0));
		crearVentanas(392, 145, this.ventanas_seccion_3, ventanasLogica3);
		organizadorDeCapas.add(edificio_seccion_2, new Integer(0));
		organizadorDeCapas.add(edificio_seccion_3, new Integer(0));
		barraDeEstado.setBounds(0, 0, 1024, 100);
		organizadorDeCapas.add(barraDeEstado, new Integer(5));
		organizadorDeCapas.setBounds(0, 0, 1024, 720);
		add(organizadorDeCapas);
		setSize(1024,720);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		addKeyListener(new MiAdapter());
		this.setIconImage(new ImageIcon(PantallaPrincipalGUI.class.getResource("/img/Icono.png")).getImage());
		AnimacionesRalph animRalph = new AnimacionesRalph();
		animRalph.animarRalph();
		setVisible(true);
	}
	
	

	
	
	
	
	public class MiAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
				case KeyEvent.VK_UP:
					if (Partida.getInstance().puedoSubir())
						movArriba();
				break;
				case KeyEvent.VK_DOWN:
					if (Partida.getInstance().puedoBajar())
						movAbajo();
				break;
				case KeyEvent.VK_RIGHT:
					if (Partida.getInstance().puedoAvanzar())
						movDerecha();
				break;
				case KeyEvent.VK_LEFT:
					if (Partida.getInstance().puedoRetroceder())
						movIzquierda();
				break;
				case KeyEvent.VK_SPACE:
					animarMartillazoFelix();
					procesarArreglar();
				break;
			}
		}
	}
	
	
	
	
	public void procesarArreglar() {
		int x = Partida.getInstance().getSeccionActual();
		if (Partida.getInstance().repararVentana()) {
			if (x == 0) {
				arreglarVentana(ventanas_seccion_1, true);
			} else {
				if (x == 1) {
					arreglarVentana(ventanas_seccion_2, false);
				} else {
					arreglarVentana(ventanas_seccion_3, false);
				}
			}
		}	   	   
		if (Partida.getInstance().ganeNivel()) {
			Partida.getInstance().siguienteNivel();
		} else {
			if (Partida.getInstance().seccionTerminada()) {
				siguienteSeccion();
			}
		}
	}
	

	
	public void visible() {
		setVisible(true);
	}
	
	public void invisible() {
		setVisible(false);
	}
	
	public void arreglarVentana(ArrayList<ArrayList<JLabel>> ventanasGrafica, boolean tieneSemicirc) {
		if (tieneSemicirc) {
			if (posicionCoordenada.getX() != 2) {
				ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagen(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas()));
				ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();		
			} else {
				if (posicionCoordenada.getY() != 2) {
					boolean aux = true;
					if (posicionCoordenada.getY() == 1) aux = false;
					ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagenSemicircular(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas(), aux));
					ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();
				} else {
					ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagen(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas()));
					ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();		
				}
			}
		} else {
			ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagen(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas()));
			ventanasGrafica.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();
		}
	}
	
	public void movArriba() {
		if (Partida.getInstance().getSeccionActual() == 0) {
			if ((felix.getX() == 477) && (felix.getY() == 630)) {
				felix.setLocation(felix.getX(), felix.getY()-95);
				felix.repaint();
				posicionCoordenada.moverAr();
			} else {
				if ((felix.getX() == 477) && (felix.getY()-85 == 450)) {
					felix.setLocation(felix.getX(), felix.getY()-85);
					felix.repaint();
					posicionCoordenada.moverAr();
				} else {
					if (felix.getY()-80 >= 400) {
						felix.setLocation(felix.getX(), felix.getY()-80);
						felix.repaint();
						posicionCoordenada.moverAr();
					}
				}
			}
		} else {
			if (felix.getY()-80 >= 400) {
				felix.setLocation(felix.getX(), felix.getY()-80);
				felix.repaint();
				posicionCoordenada.moverAr();
			}
			
		}
	}
	
	public void movAbajo() {
		if (Partida.getInstance().getSeccionActual() == 0) {
			if ((felix.getX() == 477) && (felix.getY() == 535)) {
				felix.setLocation(felix.getX(), felix.getY()+95);
				felix.repaint();
				posicionCoordenada.moverAb();
			} else {
				if ((felix.getX() == 477) && (felix.getY()+85 == 535)) {
					felix.setLocation(felix.getX(), felix.getY()+85);
					felix.repaint();
					posicionCoordenada.moverAb();
				} else {
					if (felix.getY()+80 <= 640) {
						felix.setLocation(felix.getX(), felix.getY()+80);
						felix.repaint();
						posicionCoordenada.moverAb();
					}
				}
			}
		} else {
			if (felix.getY()+80 <= 640) {
				felix.setLocation(felix.getX(), felix.getY()+80);
				felix.repaint();
				posicionCoordenada.moverAb();
			}
		}
	}
	
	public void movIzquierda() {
		if (Partida.getInstance().getSeccionActual() == 0) {
			if ((felix.getX() == 477) && (felix.getY() == 630)) {
				felix.setLocation(felix.getX(),felix.getY()-20);
			} else {
				if ((felix.getX()-50 == 477) && (felix.getY()+20 == 630)) {
					felix.setLocation(felix.getX(), felix.getY()+20);
				}
			}
			if ((felix.getX() == 477) && (felix.getY() == 535)) {
				felix.setLocation(felix.getX(),felix.getY()-5);
			} else {
				if ((felix.getX()-50 == 477) && (felix.getY()+5 == 535)) {
					felix.setLocation(felix.getX(), felix.getY()+5);
				}
			}
		}
		if (felix.getX()-50 > 372  ) {
			felix.setLocation(felix.getX()-50, felix.getY());
			felix.repaint();
			posicionCoordenada.moverIzq();
		}
	}
	
	
	public void movDerecha() {
		if(Partida.getInstance().getSeccionActual() == 0) {
			if ((felix.getX() == 477) && (felix.getY() == 630)) {
				felix.setLocation(felix.getX(), felix.getY()-20);
			} else {
				if ((felix.getX()+50 == 477) && (felix.getY()+20 == 630)) {
					felix.setLocation(felix.getX(), felix.getY()+20);
				}
			}
			if ((felix.getX() == 477) && (felix.getY() == 535)) {
				felix.setLocation(felix.getX(), felix.getY()-5);
			} else {
				if ((felix.getX()+50 == 477) && (felix.getY()+5 == 535)) {
					felix.setLocation(felix.getX(), felix.getY()+5);
				}
			}
		}
		if (felix.getX()+50 < 602) {
			felix.setLocation(felix.getX()+50, felix.getY());
			felix.repaint();
			posicionCoordenada.moverDer();
		}
	}
	
	private void crearVentanas_Suelo(int paramX, int paramY, ArrayList<ArrayList<JLabel>> ventanas, ArrayList<ArrayList<Ventana>> ventanasLogica){
		ArrayList<JLabel> aux1;
		int XAux = paramX; //392;
		for (int x = 0; x < 5; x++) {
			aux1 = new ArrayList<JLabel>();	
				int YAux = paramY; //615;
				for (int y = 0; y < 3; y++) {
					if (x != 2) {
						if (ventanasLogica.get(x).get(y).esVentanaAbierta()) {
							if (ventanasLogica.get(x).get(y).estaAbierta()) {
								JLabel AuxLabel = new JLabel(new ImageIcon("img\\ventanas_y_panel\\slice106_@.png"));
								AuxLabel.setBounds(XAux, YAux, 40, 60);
								aux1.add(AuxLabel);
								organizadorDeCapas.add(AuxLabel, new Integer(1));
							} else {
								JLabel AuxLabel = new JLabel(new ImageIcon("img\\ventanas_y_panel\\slice105_@.png"));
								AuxLabel.setBounds(XAux, YAux, 40, 60);
								aux1.add(AuxLabel);
								organizadorDeCapas.add(AuxLabel, new Integer(1));
							}
						} else {
							JLabel AuxLabel = new JLabel(elegirImagen(x, y, ventanasLogica));
							AuxLabel.setBounds(XAux, YAux, 40, 60);
							aux1.add(AuxLabel);
							organizadorDeCapas.add(AuxLabel, new Integer(1));
						}
					} else {
						if (y == 0) {
							JLabel AuxLabel = new JLabel(elegirImagenSemicircular(x, y, ventanasLogica, true));
							aux1.add(AuxLabel);
							AuxLabel.setBounds(XAux-10, 590, 61, 97);
							organizadorDeCapas.add(AuxLabel, new Integer(1));
						} else {
							if (y == 1) {
								JLabel AuxLabel = new JLabel(elegirImagenSemicircular(x, y, ventanasLogica, false));
								aux1.add(AuxLabel);
								AuxLabel.setBounds(XAux-10, YAux, 62, 60);
								organizadorDeCapas.add(AuxLabel, new Integer(1));
							} else {
								if (ventanasLogica.get(x).get(y).esVentanaAbierta()) {
									if (ventanasLogica.get(x).get(y).estaAbierta()) {
										JLabel AuxLabel = new JLabel(new ImageIcon("img\\ventanas_y_panel\\slice106_@.png"));
										AuxLabel.setBounds(XAux, YAux, 40, 60);
										aux1.add(AuxLabel);
										organizadorDeCapas.add(AuxLabel, new Integer(1));
									} else {
										JLabel AuxLabel = new JLabel(new ImageIcon("img\\ventanas_y_panel\\slice105_@.png"));
										AuxLabel.setBounds(XAux, YAux, 40, 60);
										aux1.add(AuxLabel);
										organizadorDeCapas.add(AuxLabel, new Integer(1));
									}
								} else {
									JLabel AuxLabel = new JLabel(elegirImagen(x, y, ventanasLogica));
									AuxLabel.setBounds(XAux, YAux, 40, 60);
									aux1.add(AuxLabel);
									organizadorDeCapas.add(AuxLabel, new Integer(1));
								}
							}
						}
					}
					YAux-= 80;
				}
			ventanas.add(aux1);
			XAux += 50;
		}	
	}
	
	private void crearVentanas(int paramX, int paramY, ArrayList<ArrayList<JLabel>> ventanas, ArrayList<ArrayList<Ventana>> ventanasLogica) {
		ArrayList<JLabel> aux1;
		int XAux = paramX; //392;
		for (int x = 0; x < 5; x++) {
			aux1 = new ArrayList<JLabel>();	
				int YAux = paramY; //615;
				for (int y = 0; y < 3; y++) {
					if (ventanasLogica.get(x).get(y).esVentanaAbierta()) {
						if (ventanasLogica.get(x).get(y).estaAbierta()) {
							JLabel AuxLabel = new JLabel(new ImageIcon("img\\ventanas_y_panel\\slice106_@.png"));
							AuxLabel.setBounds(XAux, YAux, 40, 60);
							aux1.add(AuxLabel);
							organizadorDeCapas.add(AuxLabel, new Integer(1));
						} else {
							JLabel AuxLabel = new JLabel(new ImageIcon("img\\ventanas_y_panel\\slice105_@.png"));
							AuxLabel.setBounds(XAux, YAux, 40, 60);
							aux1.add(AuxLabel);
							organizadorDeCapas.add(AuxLabel, new Integer(1));
						}
					} else {
						JLabel AuxLabel = new JLabel(elegirImagen(x, y, ventanasLogica));
						AuxLabel.setBounds(XAux, YAux, 40, 60);
						aux1.add(AuxLabel);
						organizadorDeCapas.add(AuxLabel, new Integer(1));				
					}
					YAux-= 80;
				}
			ventanas.add(aux1);
			XAux += 50;
		}
	}
	
	private ImageIcon elegirImagenSemicircular(int x, int y, ArrayList<ArrayList<Ventana>> ventanasLogica, boolean esPuerta) {
		if (esPuerta) {
				switch (ventanasLogica.get(x).get(y).cantidadRotos()) {
					case 1:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_1.png");
					case 2:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_2.png");
					case 3:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_3.png");
					case 4:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_4.png");
					case 5:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_5.png");
					case 6:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_6.png");
					case 7:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_7.png");
					case 8:
						return new ImageIcon("img\\semicirculares\\pb_panelesrotos_8.png");
					default:
						return new ImageIcon("img\\semicirculares\\pb_paneles_sanos.png");
				}
		} else {
			switch (ventanasLogica.get(x).get(y).cantidadRotos()) {
			case 1:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_1.png");
			case 2:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_2.png");
			case 3:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_3.png");
			case 4:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_4.png");
			case 5:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_5.png");
			case 6:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_6.png");
			case 7:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_7.png");
			case 8:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_8.png");
			case 9:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_9.png");
			case 10:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_10.png");
			case 11:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_11.png");
			case 12:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_12.png");
			case 13:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_13.png");
			case 14:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_14.png");
			case 15:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_15.png");
			case 16:
				return new ImageIcon("img\\semicirculares\\1ro_panelesrotos_16.png");
			default:
				return new ImageIcon("img\\semicirculares\\1ro_paneles_sanos.png");
		}
		}
	}

	
	private ImageIcon elegirImagen(int x, int y, ArrayList<ArrayList<Ventana>> ventanasLogica) {
		if (ventanasLogica.get(x).get(y).arreglada()) {
			return new ImageIcon("img\\ventanas_y_panel\\slice100_@.png");
		} else {
			switch (ventanasLogica.get(x).get(y).cantidadRotos()) {
				case 1:
					return new ImageIcon("img\\ventanas_y_panel\\slice24_24.png");
				case 2:
					return new ImageIcon("img\\ventanas_y_panel\\slice113_@.png");
				case 3:
					return new ImageIcon("img\\ventanas_y_panel\\slice110_@.png");
				case 4:
					return new ImageIcon("img\\ventanas_y_panel\\slice103_@.png");
				default:
					return new ImageIcon("img\\ventanas_y_panel\\slice100_@.png");
			}
		}
		
	}
	
	
	private void crearObstaculos(ArrayList<ArrayList<Ventana>> ventanasLogica, ArrayList<ArrayList<JLabel>> ventanasGrafica) {
		for (ArrayList<Ventana> arr : ventanasLogica) {
			for (Ventana vent : arr) {
				int x = ventanasGrafica.get(vent.getPos().getX()).get(vent.getPos().getY()).getX()+5;
				int y = ventanasGrafica.get(vent.getPos().getX()).get(vent.getPos().getY()).getY()+44;
				if(vent.tieneMacetero()) {
					JLabel aux = new JLabel(new ImageIcon("img\\obstaculos\\macetero.png"));
					aux.setBounds(x, y, 29, 16);			
					organizadorDeCapas.add(aux, new Integer(3));
					obstaculos.add(aux);
				}
				if (vent.tieneMoldura()) {
					JLabel aux2 = new JLabel(new ImageIcon("img\\obstaculos\\slice22_22.png"));
					aux2.setBounds(x-5, y-45, 40, 10);
					organizadorDeCapas.add(aux2, new Integer(3));
					obstaculos.add(aux2);
				}
			}
		}
	}
	

	
	

	
	public void animarMartillazoFelix() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int cont = 0;
		 	@Override
		 	public void run(){
		 		if(!Partida.getInstance().isInvulnerable()) {
			 		if (!((cont % 2) == 0)) {
			 			felix.setIcon(new ImageIcon("img/felix/slice76_76.png"));
			 			felix.repaint();
			 		} else {
			 			felix.setIcon(new ImageIcon("img/felix/slice65_65.png"));
			 			felix.repaint();
			 		}
			 		if (cont == 4) {
			 			timer.cancel();
			 		}
			 		cont++;
		 		} else {
		 			if (!((cont % 2) == 0)) {
			 			felix.setIcon(new ImageIcon("img/felix/slice76_76INV.png"));
			 			felix.repaint();
			 		} else {
			 			felix.setIcon(new ImageIcon("img/felix/slice65_65INV.png"));
			 			felix.repaint();
			 		}
			 		if (cont == 4) {
			 			timer.cancel();
			 		}
			 		cont++;
		 		}
		 	};
		};
		timer.schedule(task, 10, 100);
	}
	
	public void siguienteSeccion() {
		congelar = true;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int cont = 0;
		 	public void run(){
			 	ralph.setLocation(ralph.getX(), ralph.getY()+1);
				edificio_seccion_1.setLocation(edificio_seccion_1.getX(), edificio_seccion_1.getY()+1);
		 		edificio_seccion_1.repaint();
		 		edificio_seccion_2.setLocation(edificio_seccion_2.getX(), edificio_seccion_2.getY()+1);
		 		edificio_seccion_2.repaint();
		 		edificio_seccion_3.setLocation(edificio_seccion_3.getX(), edificio_seccion_3.getY()+1);
			 	edificio_seccion_3.repaint();
				if ((cont % 100) == 0) {
		 			ralph.setIcon(new ImageIcon("img/ralph/slice174_@.png"));
		 			ralph.repaint();
				} else {
		 			ralph.setIcon(new ImageIcon("img/ralph/slice175_@.png"));
		 			ralph.repaint();
			 	}
				for(ArrayList<JLabel> arr : ventanas_seccion_1) {
	 			for (JLabel vent : arr) {
						vent.setLocation(vent.getX(), vent.getY()+1);
		 				vent.repaint();
		 			}
		 		}
				for(ArrayList<JLabel> arr : ventanas_seccion_2) {
		 			for (JLabel vent : arr) {
		 				vent.setLocation(vent.getX(), vent.getY()+1);
			 			vent.repaint();
			 		}
				}
		 		for(ArrayList<JLabel> arr : ventanas_seccion_3) {
		 			for (JLabel vent : arr) {
		 				vent.setLocation(vent.getX(), vent.getY()+1);
			 			vent.repaint();
					}
				}
		 		felix.setLocation(477, 610);
		 		posicionCoordenada = new Posicion (2,0);
		 		for (JLabel obs : obstaculos) {
		 			obs.setLocation(obs.getX(), obs.getY()+1); 
		 		}
		 		felix.repaint();
		 		ralph.setLocation(462, 360);
		 		ralph.repaint();
		 		if(Partida.getInstance().getSeccionActual() == 1) {
			 		if(edificio_seccion_2.getY() == 442) {
				 		crearObstaculos(Partida.getInstance().getVentanas(), ventanas_seccion_2);
			 			eliminarTerminado();
			 			Partida.getInstance().resetTiempo();
			 			timer.cancel();
			 		}
		 		} else {
		 			if(edificio_seccion_3.getY() == 370) {
				 		crearObstaculos(Partida.getInstance().getVentanas(), ventanas_seccion_3);
			 			eliminarTerminado();
			 			Partida.getInstance().resetTiempo();
			 			timer.cancel();
			 		}
		 		}
		 		congelar = false;
		 		cont++;
		 	}
		};
		timer.schedule(task, 10, 1);
	}
	
	public void eliminarTerminado() {
		if (Partida.getInstance().getSeccionActual() == 1) {
			remove(edificio_seccion_1);
			for(ArrayList<JLabel> arr : ventanas_seccion_1) {
	 			for (JLabel vent : arr) {
	 				remove(vent);
	 			}
	 		}
		} else {
			remove(edificio_seccion_2);
			for(ArrayList<JLabel> arr : ventanas_seccion_2) {
	 			for (JLabel vent : arr) {
	 				remove(vent);
	 			}
	 		}
		}
		revalidate();
		repaint();
	}
	
	public class AnimacionesRalph extends Thread{
		
		public void animarRalph() {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				int tiempoParaLadrillos = Juego.getInstance().getDificultad()*100;
				boolean izq = true;
				int cont = 0;
				@Override
			 	public void run(){
					if (!muerta) {
						if (!congelar) {
					 		if (tiempoParaLadrillos < 1100) { /// A medida que aumente la dificultad el contador va a comenzar con un n�mero m�s grande, por lo que ralph va a tirar ladrillos m�s seguido.
					 			if (izq) {
						 			if (cont < 10) {
						 				ralph.setIcon(new ImageIcon("img/ralph/slice221_@_izq.png"));
						 			} else {
						 				ralph.setIcon(new ImageIcon("img/ralph/slice228_@_izq.png"));
						 			}
						 			if (cont == 20) cont= -1;
						 			ralph.setLocation(ralph.getX()-1, ralph.getY());
						 			ralph.repaint();
						 		} else {
						 			if (cont < 10) {
						 				ralph.setIcon(new ImageIcon("img/ralph/slice221_@.png"));
						 			} else {
						 				ralph.setIcon(new ImageIcon("img/ralph/slice228_@.png"));
						 			}
						 			if (cont == 20) cont= -1;
						 			ralph.setLocation(ralph.getX()+1, ralph.getY());
						 			ralph.repaint();
						 		}
						 		if (ralph.getX() == 352) {
						 			izq = false;
						 		} else {
						 			if (ralph.getX() == 570) {
						 				izq = true;
						 			}
						 		}
						 		cont++;
						 		tiempoParaLadrillos++;
					 		} else {
					 			tiempoParaLadrillos = Juego.getInstance().getDificultad();
					 			animarTirarLadrillos(izq);
					 		}
						}
					} else {
						timer.cancel();
					}
				 	};
				};
				timer.schedule(task, 10, 10);
		}
		
		
		public void animarTirarLadrillos(boolean izq) {
			int alternarLadrillos = 1;
			int cont = 0;
			for (int i = 0; i < 1000000; i++) {
				if (!congelar) {
					if (cont == 0) {
						animarLadrillos(alternarLadrillos);
			 			if (alternarLadrillos == 1) {
			 				alternarLadrillos = 2;
			 			} else {
			 				alternarLadrillos = 1;
			 			}
					}
				 	if (cont < 125000) {
				 			ralph.setIcon(new ImageIcon("img/ralph/slice167_@.png"));
				 			ralph.repaint();
				 	} else {
				 			ralph.setIcon(new ImageIcon("img/ralph/slice168_@.png"));
				 			ralph.repaint();
				 	}
				 	if (cont == 250000) {
				 		cont = -1;
				 	}
				 	cont++;
				}
			}
		}
		
		
		
		public void animarLadrillos(int alternarLadrillos) {
			JLabel ladrillo;
			if ((alternarLadrillos % 2) == 0) {
				ladrillo = new JLabel(new ImageIcon("img/rocas/slice10_10.png"));
				ladrillo.setBounds(ralph.getX(), ralph.getY()+89, 20, 13);
				organizadorDeCapas.add(ladrillo, new Integer(3));		
		 		organizadorDeCapas.repaint();
			} else {
				ladrillo = new JLabel(new ImageIcon("img/rocas/slice11_11.png"));
				ladrillo.setBounds(ralph.getX()+100, ralph.getY()+89, 20, 13);
				organizadorDeCapas.add(ladrillo, new Integer(3));
				organizadorDeCapas.repaint();
			}
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				boolean ladEliminado = false;
			 	@Override
			 	public void run(){
			 		if (!muerta) {
				 		if (ladrillo.getY() < 720) {
				 			ladrillo.setLocation(ladrillo.getX(), ladrillo.getY()+1);
				 			ladrillo.repaint();
				 		} else {
				 			ladEliminado = true;
				 		}
				 		if (!congelar) {
				 			if (!Partida.getInstance().isInvulnerable()){
						 		if (tocaAFelix(ladrillo.getX(), ladrillo.getY(), ladrillo.getWidth(), ladrillo.getHeight())) {
						 			if (!Partida.getInstance().isInvulnerable()) {
							 			Partida.getInstance().perdiUnaVida();  
						 			}
						 			organizadorDeCapas.remove(ladrillo);
						 			organizadorDeCapas.repaint();
						 			timer.cancel(); 
						 		}
				 			}
				 		} else {
				 			organizadorDeCapas.remove(ladrillo);
				 			revalidate();
				 			repaint();
				 			timer.cancel();
				 		}
				 		if (ladEliminado) {
				 			organizadorDeCapas.remove(ladrillo);
				 			revalidate();
				 			repaint();
				 			timer.cancel();
				 		}
				 	} else {
				 		organizadorDeCapas.remove(ladrillo);
			 			revalidate();
			 			repaint();
			 			timer.cancel();
			 	} 
			 	}
			};
			int velocidadCaida = 11-Juego.getInstance().getDificultad();
			timer.schedule(task, 10, velocidadCaida);
		}	
	}
	
	
	public boolean tocaAFelix(int x, int y, int width, int height) {
		boolean aux = false;
		
		if (((y+height) <= (felix.getY() + felix.getHeight())) && ((y + height) >= felix.getY())){
			if((x >= felix.getX()) && (x <= (felix.getX() + felix.getWidth()))) {
				aux = true;
			}
			if(((x+width) >= felix.getX()) && ((x+width) <= (felix.getX() + felix.getWidth()))) {
				aux = true;
			}
		}
		if (((y) <= (felix.getY() + felix.getHeight())) && ((y) >= felix.getY())){
			if((x >= felix.getX()) && (x <= (felix.getX() + felix.getWidth()))) {
				aux = true;
			}
			if(((x+width) >= felix.getX()) && ((x+width) <= (felix.getX() + felix.getWidth()))) {
				aux = true;
			}
		}
		
		
		return aux;
	}




	public void animarPajaro() {
		boolean der;
		JLabel pajaro;
		double a = Math.random();
		int y = (int) (Math.random() * (670 - 400)) + 400;
		if (a < 0.50) {
			pajaro = new JLabel(new ImageIcon("img/pajaro/slice08_08.png"));
			pajaro.setBounds(0, y, 35, 21);
			der = true;
		} else {
			pajaro = new JLabel(new ImageIcon("img/pajaro/slice41_41.png"));
			pajaro.setBounds(1024, y, 35, 21);
			der = false;
		}
		organizadorDeCapas.add(pajaro, new Integer(4));
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			boolean alasArriba = true;
			int tiempoAlas = 0;
		 	@Override
		 	public void run(){
		 		if (!muerta) {
			 		if (der) {
			 			if (pajaro.getX() < 1024) {
			 				pajaro.setLocation(pajaro.getX()+1, pajaro.getY());
			 				if ((tiempoAlas % 2) == 0) {
				 				if (alasArriba) {
				 					pajaro.setIcon(new ImageIcon("img/pajaro/slice08_08.png"));
				 					alasArriba = false;
				 				} else {
				 					pajaro.setIcon(new ImageIcon("img/pajaro/slice09_09.png"));
				 					alasArriba = true;
				 				}
			 				}
			 				if (tiempoAlas > 4) tiempoAlas = 0;
			 				pajaro.repaint();
			 			} else {
			 				organizadorDeCapas.remove(pajaro);
							revalidate();
							repaint();
							timer.cancel();
			 			}
			 		} else {  
			 			if (pajaro.getX() > -35) {
			 				pajaro.setLocation(pajaro.getX()-1, pajaro.getY());
			 				if ((tiempoAlas % 10) == 0) {
				 				if (alasArriba) {
				 					pajaro.setIcon(new ImageIcon("img/pajaro/slice41_41.png"));
				 					alasArriba = false;
				 				} else {
				 					pajaro.setIcon(new ImageIcon("img/pajaro/slice61_61.png"));
				 					alasArriba = true;    
				 				}
			 				}
			 				if (tiempoAlas > 40) tiempoAlas = 0;
			 				pajaro.repaint();    
			 			} else {
			 				organizadorDeCapas.remove(pajaro);
					 		revalidate();
					 		repaint();
					 		timer.cancel();
			 			}
			 		}
			 		if (!congelar) {	
			 			if (!Partida.getInstance().isInvulnerable()){
				 			if (tocaAFelix(pajaro.getX(), pajaro.getY(), pajaro.getWidth(), pajaro.getHeight())) {
						 		Partida.getInstance().perdiUnaVida();  
					 			organizadorDeCapas.remove(pajaro);
					 			organizadorDeCapas.repaint();
					 			timer.cancel(); 
					 		}
			 			}
			 		} else {
			 			organizadorDeCapas.remove(pajaro);
			 			revalidate();
			 			repaint();
			 			timer.cancel();
			 		}
			 		
			 	}else {
			 		organizadorDeCapas.remove(pajaro);
		 			revalidate();
		 			repaint();
		 			timer.cancel();
			 	}
		 	} 
		};
		int velocidadVuelo = 11-Juego.getInstance().getDificultad();
		timer.schedule(task, 10, velocidadVuelo);	
	}
	
	
	
	
	public void animarNicelanderYTorta(int x, int y) {
		JLabel nicelanderTorta = new JLabel(new ImageIcon("img/nicelander/slice244_@.png"));
  		int aux = Partida.getInstance().getSeccionActual(); 
		switch(aux) {
			case 0:
				nicelanderTorta.setBounds((ventanas_seccion_1.get(x).get(y).getX() + 10), (ventanas_seccion_1.get(x).get(y).getY() + 33), 20, 15);
				ventanas_seccion_1.get(x).get(y).setIcon(new ImageIcon("img/ventanas_y_panel/slice113_@.png"));
				ventanas_seccion_1.get(x).get(y).repaint();
			break;
			case 1:
				nicelanderTorta.setBounds((ventanas_seccion_2.get(x).get(y).getX() + 10), (ventanas_seccion_1.get(x).get(y).getY() + 33), 20, 15);
				ventanas_seccion_2.get(x).get(y).setIcon(new ImageIcon("img/ventanas_y_panel/slice113_@.png"));
				ventanas_seccion_1.get(x).get(y).repaint();
			break;
			case 2:
				nicelanderTorta.setBounds((ventanas_seccion_3.get(x).get(y).getX() + 10), (ventanas_seccion_1.get(x).get(y).getY() + 33), 20, 15);
				ventanas_seccion_3.get(x).get(y).setIcon(new ImageIcon("img/ventanas_y_panel/slice113_@.png"));
				ventanas_seccion_1.get(x).get(y).repaint();
			break;
			default:
			break;
		}
		organizadorDeCapas.add(nicelanderTorta, new Integer(4));
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int cont = 0;
		 	@Override
		 	public void run(){
		 		if (!muerta) {
			 		if (!(cont < 100)) {
			 			if ((cont % 2) == 0) {
			 				nicelanderTorta.setIcon(new ImageIcon("img/pastel/slice12_12.png"));
			 				nicelanderTorta.repaint();
			 			} else {
			 				nicelanderTorta.setIcon(new ImageIcon("img/pastel/slice13_13.png"));
			 				nicelanderTorta.repaint();
			 			}
			 			if (congelar || ((posicionCoordenada.getX() == x) && (posicionCoordenada.getY() == y))) {
			 				switch(Partida.getInstance().getSeccionActual()) {
				 				case 0:
				 					ventanas_seccion_1.get(x).get(y).setIcon(new ImageIcon("img/ventanas_y_panel/slice100_@.png"));
				 					ventanas_seccion_1.get(x).get(y).repaint();
				 				break;
				 				case 1:
				 					ventanas_seccion_2.get(x).get(y).setIcon(new ImageIcon("img/ventanas_y_panel/slice100_@.png"));
				 					ventanas_seccion_1.get(x).get(y).repaint();
				 				break;
				 				case 2:
				 					ventanas_seccion_3.get(x).get(y).setIcon(new ImageIcon("img/ventanas_y_panel/slice100_@.png"));
				 					ventanas_seccion_1.get(x).get(y).repaint();
				 				break;
				 				default:
				 				break;
			 				}
			 				organizadorDeCapas.remove(nicelanderTorta);
				 			revalidate();
				 			repaint();
				 			Partida.getInstance().setInvulnerable();
				 			cambiarColor();
				 			timer.cancel();
				 		}
			 		} 
			 	}else {
		 			organizadorDeCapas.remove(nicelanderTorta);
		 			revalidate();
			 		repaint();
			 		timer.cancel();
			 	}
			 	cont++;
			 }   
		};
		timer.schedule(task, 10, 10);	
	}

	
		
	
	public void cambiarColor() {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int cont = 0;
		 	@Override
		 	public void run(){
		 		if (Partida.getInstance().isInvulnerable()) {
		 			felix.setIcon(new ImageIcon("img/felix/slice65_65INV.png"));
		 		} else {
		 			felix.setIcon(new ImageIcon("img/felix/slice65_65.png"));
		 			timer.cancel();
		 		}
		 	}
		};
		timer.schedule(task, 10, 500);	
	}
	
	public void matarInstancia() {
		this.muerta = true;
		this.dispose();
	}
	
} 




	