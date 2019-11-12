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
public class GUI extends JFrame{
	
	private JLayeredPane organizadorDeCapas = new JLayeredPane();
	private JLabel felix = new JLabel(new ImageIcon("img\\felix\\slice65_65.png"));
	private JLabel edificio_seccion_1 = new JLabel(new ImageIcon("img\\edificio\\edificio_150_seccion1.png"));
	private JLabel edificio_seccion_2 = new JLabel(new ImageIcon("img\\edificio\\edificio_150_seccion2.png"));
	private JLabel edificio_seccion_3 = new JLabel(new ImageIcon("img\\edificio\\edificio_150_seccion2.png")); 
	private JLabel ralph = new JLabel(new ImageIcon("img\\ralph\\slice163_@.png"));
	private ArrayList<ArrayList<JLabel>> ventanas_seccion_1 = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<ArrayList<JLabel>> ventanas_seccion_2 = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<ArrayList<JLabel>> ventanas_seccion_3 = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<JLabel> obstaculos = new ArrayList<JLabel>();
	private Posicion posicionCoordenada = new Posicion(2,0);
	
	
	
	
	public GUI(ArrayList<ArrayList<Ventana>> ventanasLogica) {	
		felix.setBounds(477, 630, 40, 60);
		edificio_seccion_1.setBounds(352, 352, 320, 340);
		edificio_seccion_2.setBounds(352, 12, 320, 340);
		edificio_seccion_3.setBounds(352, -328, 325, 340);
		ralph.setBounds(462, 377, 100, 66);
		organizadorDeCapas.add(felix, new Integer(3));
		organizadorDeCapas.add(ralph, new Integer(3));
		crearVentanas_Suelo(392, 615, this.ventanas_seccion_1, ventanasLogica);
		crearObstaculos(ventanasLogica);
		crearVentanas(392, 380, this.ventanas_seccion_2, ventanasLogica);
		organizadorDeCapas.add(edificio_seccion_1, new Integer(0));
		crearVentanas(392, 145, this.ventanas_seccion_3, ventanasLogica);
		organizadorDeCapas.add(edificio_seccion_2, new Integer(0));
		organizadorDeCapas.add(edificio_seccion_3, new Integer(0));
		organizadorDeCapas.setBounds(0, 0, 1024, 720);
		add(organizadorDeCapas);
		setSize(1024,720);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		addKeyListener(new MiAdapter());
	}
	
	
	public class MiAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			System.out.println(key);
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
					if (Partida.getInstance().repararVentana()) {
						arreglarVentana();
					}
				break;
			}
		}
	}
	
	public void arreglarVentana() {
		if (posicionCoordenada.getX() != 2) {
			ventanas_seccion_1.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagen(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas()));
			ventanas_seccion_1.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();		
		} else {
			if (posicionCoordenada.getY() != 2) {
				boolean aux = true;
				if (posicionCoordenada.getY() == 1) aux = false;
				ventanas_seccion_1.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagenSemicircular(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas(), aux));
				ventanas_seccion_1.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();
			} else {
				ventanas_seccion_1.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).setIcon(elegirImagen(posicionCoordenada.getX(), posicionCoordenada.getY(), Partida.getInstance().getVentanas()));
				ventanas_seccion_1.get(posicionCoordenada.getX()).get(posicionCoordenada.getY()).repaint();		
			}
		}
	}
	
	public void movArriba() {
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
	}
	
	public void movAbajo() {
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
	}
	
	public void movIzquierda() {
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
		if (felix.getX()-50 > 372  ) {
			felix.setLocation(felix.getX()-50, felix.getY());
			felix.repaint();
			posicionCoordenada.moverIzq();
		}
	}
	
	
	public void movDerecha() {
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
					JLabel AuxLabel = new JLabel(elegirImagen(x, y, ventanasLogica));
					AuxLabel.setBounds(XAux, YAux, 40, 60);
					aux1.add(AuxLabel);
					organizadorDeCapas.add(AuxLabel, new Integer(2));
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
	
	
	private void crearObstaculos(ArrayList<ArrayList<Ventana>> ventanasLogica) {
		for (ArrayList<Ventana> arr : ventanasLogica) {
			for (Ventana vent : arr) {
				int x = ventanas_seccion_1.get(vent.getPos().getX()).get(vent.getPos().getY()).getX()+5;
				int y = ventanas_seccion_1.get(vent.getPos().getX()).get(vent.getPos().getY()).getY()+44;
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
	
		
	
	
	
		
	} 