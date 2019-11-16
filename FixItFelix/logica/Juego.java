package logica;
import grafica.*;
import java.util.*;
public class Juego {
	
	private static Juego INSTANCE;
	private ArrayList<Jugador> topScores;
	private PantallaPrincipalGUI pantallaPrinc;
	private Fichero arch;
	
	private Juego() {
		Fichero arch = new Fichero();
		cargarTopScores();
		this.pantallaPrinc = new PantallaPrincipalGUI();
		arch.aumentarCont(0, arch);	
	}
	
	
	
	
	public int getDificultad() {
		return pantallaPrinc.getDificultad();
	}
	
	public static Juego getInstance () {
		if (INSTANCE == null) {
			INSTANCE = new Juego();
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}
	

	public int proximoNivel() {
		this.pantallaPrinc.aumentarDificultad();
		return this.pantallaPrinc.getDificultad();
	}
	
	
	public void guardarEnTopScores(String nombre) {
		Fichero arch = new Fichero();
		Partida.getInstance().getJugador().setNombre(nombre);
		String [] auxNombres = new String[5];
			int [] auxScores = new int[5];
			if (!(this.topScores.contains(Partida.getInstance().getJugador()))) {
					if (Partida.getInstance().getJugador().getPuntaje() > Collections.min
						(this.topScores).getPuntaje()) {
						arch.aumentarCont(2, arch);
						this.topScores.add(5,Partida.getInstance().getJugador());
						//Uso comparador porque SORT siempre ordena de MENOR A MAYOR, esto INVIERTE el orden de sort.
						Comparator<Jugador> comparador = Collections.reverseOrder();
						Collections.sort(this.topScores, comparador);
						this.topScores.remove(Collections.min(this.topScores));
						for(int i=0; i<5; i++) {
							auxNombres[i]=this.topScores.get(i).getNombre();
							auxScores[i]=this.topScores.get(i).getPuntaje();
						}
						arch.escribir(auxNombres, auxScores);
					}
		}
	}
	
	public boolean puntajeMaximo(int puntaje) {
		return (puntaje > Collections.min(this.topScores).getPuntaje());
	}
	
	public int getHighScore() {
		return this.topScores.get(0).getPuntaje();
	}
	
	private void cargarTopScores() {
		Fichero arch = new Fichero();
		arch.leer();
		ArrayList<Jugador> jug = new ArrayList<Jugador>();
		Jugador aux;
		for (int i=0; i<5; i++) {
			aux = new Jugador(arch.getNombres()[i]);
			aux.setPuntaje(arch.getPuntos()[i]);		
			jug.add(aux);
		}
		this.topScores=jug;
	}
	
	public void irAlMenu() {
		this.pantallaPrinc.visible();
	}
	
}