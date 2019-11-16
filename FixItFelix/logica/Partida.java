package logica;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import grafica.*;
public class Partida{

	private static Partida INSTANCE;
	private int tiempo;
	private Felix pj;
	private Ralph boss;
	private Jugador player;
	private Edificio tablero;
	private ArrayList<Objeto> objetosPartida;
	private PartidaGUI partidaGUI;
	
	
	private Partida() {
		this.tablero = new Edificio(Juego.getInstance().getDificultad());
		this.tiempo = 900;
		this.pj = new Felix();
		this.boss = new Ralph();
		this.player = new Jugador("");
		this.objetosPartida = new ArrayList<Objeto>();
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
		partidaGUI.invisible();
		this.partidaGUI = new PartidaGUI(tablero.getVentanas(0), tablero.getVentanas(1), tablero.getVentanas(2));
		this.partidaGUI.visible();
		this.pj.reset();
	}
	
	public void perdiUnaVida() {
		if (this.pj.getVidas()-1 != 0) {
			this.tablero = new Edificio(Juego.getInstance().getDificultad());
	   		this.partidaGUI.invisible();
			this.partidaGUI = new PartidaGUI(tablero.getVentanas(0), tablero.getVentanas(1), tablero.getVentanas(2));
			this.partidaGUI.visible();
			this.pj.perderVida();
			this.pj.reset();
			this.getJugador().penalizacion();
		} else {
			this.partidaGUI.invisible();
			if (Juego.getInstance().puntajeMaximo(this.player.getPuntaje())) {
				NuevoPuntajeGUI nuevoMaxScore = new NuevoPuntajeGUI();
				nuevoMaxScore.setVisible(true);
			} else { 
				Juego.getInstance().irAlMenu();
				this.partidaGUI.invisible();

			}
		}
		
	}
	
	
	
	
	/** Pregunta si F�lix se encuentra con alg�n elemento de la lista, y de acuerdo al objeto realiza las acciones correspondientes.
	 * P�jaro: reinicia la secci�n sin perder vidas.
	 * Ladrillo: reinicia el nivel perdiendo una vida.
	 * Torta: Vuelve invulnerable a F�lix durante una determinada cantidad de ciclos. **/
	private void gestionarColisiones() {
		if (this.tablero.getVentanas().get(this.pj.getPosFelix().getX()).get(this.pj.getPosFelix().getY()).pajaro()) {
			this.objetosPartida.removeAll(objetosPartida);
			this.tablero.reiniciarEtapa(Juego.getInstance().getDificultad());
			this.pj.reset();
			System.out.println("Choc� con un p�jaro y se reinici� la etapa.");
		} else {
			if (this.tablero.getVentanas().get(this.pj.getPosFelix().getX()).get(this.pj.getPosFelix().getY()).ladrillo()) {
				this.pj.perderVida();
				this.tablero = new Edificio(Juego.getInstance().getDificultad());
				this.objetosPartida.removeAll(objetosPartida);
				this.pj.reset();
				System.out.println("Choc� con un ladrillo y se reinicia el nivel.");
			} else {
				if (this.tablero.getVentanas().get(this.pj.getPosFelix().getX()).get(this.pj.getPosFelix().getY()).ladrillo()){
					this.pj.setInvulnerable();
					System.out.println("F�lix ahora es invulnerable!");
				}
			}
		}
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
	

	
	public int getTiempo() {
		if (tiempo != 0)
			tiempo--;
		return tiempo;
	}

		
	
	
	
	
}
