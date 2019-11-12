package logica;
import java.util.*;
import grafica.*;
public class Partida{

	private static Partida INSTANCE;
	private int tiempo;
	private int dificultad;
	private Felix pj;
	private Ralph boss;
	private Jugador player;
	private Edificio tablero;
	private ArrayList<Objeto> objetosPartida;
	private PartidaGUI partidaGUI;
	
	
	private Partida(String nombre) {
		this.tablero = new Edificio(this.dificultad);
		this.tiempo = 120;
		this.dificultad = 1;
		this.pj = new Felix();
		this.boss = new Ralph();
		this.player = new Jugador(nombre);
		this.objetosPartida = new ArrayList<Objeto>();
		this.partidaGUI = new PartidaGUI(this.tablero.getVentanas());
	}
	
	public static Partida getInstance (String nombre) {
		if (INSTANCE == null) {
			INSTANCE = new Partida(nombre);
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}
	
	public static Partida getInstance() {
		return INSTANCE;
	}

	public void visible() {
		this.partidaGUI.visible();
	}
	
	public void invisible(){
		this.partidaGUI.invisible();
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
		int x = this.pj.repararVentana(this.tablero.getVentanas(), this.tablero.nivelTerminado());
		this.player.setPuntaje(x);
		if (x != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/** Pregunta si F�lix se encuentra con alg�n elemento de la lista, y de acuerdo al objeto realiza las acciones correspondientes.
	 * P�jaro: reinicia la secci�n sin perder vidas.
	 * Ladrillo: reinicia el nivel perdiendo una vida.
	 * Torta: Vuelve invulnerable a F�lix durante una determinada cantidad de ciclos. **/
	private void gestionarColisiones() {
		if (this.tablero.getVentanas().get(this.pj.getPosFelix().getX()).get(this.pj.getPosFelix().getY()).pajaro()) {
			this.objetosPartida.removeAll(objetosPartida);
			this.tablero.reiniciarEtapa(dificultad);
			this.pj.reset();
			System.out.println("Choc� con un p�jaro y se reinici� la etapa.");
		} else {
			if (this.tablero.getVentanas().get(this.pj.getPosFelix().getX()).get(this.pj.getPosFelix().getY()).ladrillo()) {
				this.pj.perderVida();
				this.tablero = new Edificio(dificultad);
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
	
	
}
