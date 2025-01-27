package logica;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import grafica.*;
public class Partida{

	private static Partida INSTANCE;
	private int tiempo;
	private Felix pj;
	private Ralph boss;
	private Jugador player;
	private Edificio tablero;
	private PartidaGUI partidaGUI;
	
	
	private Partida() {
		this.tablero = new Edificio(Juego.getInstance().getDificultad());
		this.tiempo = 5000;
		this.pj = new Felix();
		this.boss = new Ralph();
		this.player = new Jugador("");
	}
	
	public static Partida getInstance () {
		if (INSTANCE == null) {
			INSTANCE = new Partida();
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}
	
	public static Partida nuevaPartida() {
		INSTANCE = new Partida();
		return INSTANCE;
	}
	
	public void iniciarGrafica() {
		this.partidaGUI = new PartidaGUI(this.tablero.getVentanas(0), this.tablero.getVentanas(1), this.tablero.getVentanas(2));
		ciclo();
	}
	


	public void visible() {
		this.partidaGUI.visible();
	}
	
	public void invisible(){
		this.partidaGUI.invisible();
	}
	
	public int getVidas() {
		return this.pj.getVidas();
	}
	
	public boolean puedoSubir() {
		return this.pj.movArriba(this.tablero.getVentanas());
	}
	
	public boolean puedoBajar() {
		return this.pj.movAbajo(this.tablero.getVentanas());
	}
	
	public boolean puedoAvanzar() {
		return this.pj.movDerecha(this.tablero.getVentanas());
	}
	
	public boolean puedoRetroceder() {
		return this.pj.movIzquierda(this.tablero.getVentanas());
	}
	
	public boolean repararVentana() {
		int x = this.pj.repararVentana(this.tablero.getVentanas());
		this.player.setPuntaje(x);
		if (x != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void siguienteNivel() {
		this.tablero = new Edificio(Juego.getInstance().proximoNivel());
		this.partidaGUI.matarInstancia();
		this.partidaGUI = new PartidaGUI(tablero.getVentanas(0), tablero.getVentanas(1), tablero.getVentanas(2));
		this.partidaGUI.visible();
		this.pj.reset();
		this.tiempo = 5000;
	}
	
	public void perdiUnaVida() {
		if (this.pj.getVidas() > 1) {
			this.tablero = new Edificio(Juego.getInstance().getDificultad());
	   		this.partidaGUI.matarInstancia();
			this.partidaGUI = new PartidaGUI(tablero.getVentanas(0), tablero.getVentanas(1), tablero.getVentanas(2));
			this.partidaGUI.visible();
			this.pj.perderVida();
			this.pj.reset();
			this.getJugador().penalizacion();
			this.tiempo = 5000;
		} else {
			this.partidaGUI.matarInstancia();
			if (Juego.getInstance().puntajeMaximo(this.player.getPuntaje())) {
				NuevoPuntajeGUI nuevoMaxScore = new NuevoPuntajeGUI();
				nuevoMaxScore.setVisible(true);
			} else { 
				Juego.getInstance().irAlMenu();
			}
		}
		
	}
	
	
	
	private void ciclo() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int cantPajaros = 0;
			int cont = 0;
			int cont2 = 0;
			int cont3 = 0;
			boolean hayNicelander = false;
		 	@Override
		 	public void run(){
		 		if ((tiempo != 0) && (Juego.getInstance().getDificultad() < 11)) {
					
		 			if ((cont >  (3000 / Juego.getInstance().getDificultad())) && (cantPajaros >= 2)) {
						cantPajaros = 0 ;
						cont = 0;
					}
		 			
					if (tablero.generarPajaro()) {
						if (cantPajaros < 2) {
							partidaGUI.animarPajaro();
							cantPajaros++;
						}	
					}
					
					/** Consulta a todas las ventanas si debe generar un Nicelander. Cada ventana lo implementa a su manera. Si le retornan
					 * verdadero crea una nueva instancia de Objeto Nicelander y lo agrega a la lista de elementos de la partida.  **/
					if (!hayNicelander) {	
						for (ArrayList<Ventana> arrVent : tablero.getVentanas()) {
							for (Ventana vent : arrVent) {
								if (vent.generarNicelander()) {
									partidaGUI.animarNicelanderYTorta(vent.getPos().getX(), vent.getPos().getY());
									hayNicelander = true;
								}
							}
						}
					}
					
					
					
					
					if (cont2 >  3000) {
						hayNicelander = false;
						cont2 = 0;
					}
					
					
					if(cont3 > 1000 && pj.isInvulnerable()) {
						cont3 = 0;
						pj.setInvulnerable();
					}
				
					
					 
					
					cont++;
					cont2++;
					cont3++;
					tiempo--;
		 		} else {
		 			if (tiempo == 0) {
		 				perdiUnaVida();
		 			} else {
			 			partidaGUI.matarInstancia();
						if (Juego.getInstance().puntajeMaximo(player.getPuntaje())) {
							NuevoPuntajeGUI nuevoMaxScore = new NuevoPuntajeGUI();
							nuevoMaxScore.setVisible(true);
						} else { 
							System.out.println("GANASTE!"); ///reemplazar por pantalla de victoria, pero sin introducir texto porque no logr� un puntaje para el top5
							Juego.getInstance().irAlMenu();
						}
		 			}
		 			timer.cancel();
		 		}
		 	};
		};
		timer.schedule(task, 10, 10);
	}	
	
	
	public Jugador getJugador() {
		return this.player;
	}
	
	public ArrayList<ArrayList<Ventana>>  getVentanas() {
		return this.tablero.getVentanas();
	}
	
	public ArrayList<ArrayList<Ventana>>  getVentanas(int secc) {
		return this.tablero.getVentanas(secc);
	}
	public void resetTiempo() {
		this.tiempo = 5000;
	}
	
	public boolean ganeNivel() {
		return this.tablero.nivelTerminado();
	}
	
	public boolean seccionTerminada() {
		if (this.tablero.seccionTerminada()){
			this.tablero.proximaEtapa();
			this.pj.reset();
			return true;
		} else return false;
	}
	
	public int getSeccionActual() {
		return this.tablero.getSeccionActual();
	}
	
	public boolean isInvulnerable() {
		return this.pj.isInvulnerable();
	}
	
	public void setInvulnerable() {
		this.pj.setInvulnerable();
	}

	
	public int getTiempo() {
		return tiempo;
	}

		
	
	
	
	
}
