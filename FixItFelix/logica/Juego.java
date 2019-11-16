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
	
	
	/** Realiza un ciclo de la partida. Adem�s, si la partida termin� agrega al jugador a la lista. Para esto
	 * verifica que el jugador no est� ya en la lista, para evitar duplicados si siguen mandando turnos a 
	 * una partida terminada; si el arrego es vac�o, para no comparar en un arreglo vac�o; y luego si 
	 * el puntaje es mayor al m�nimo del arreglo, en ese caso se reemplaza uno por otro y se ordena
	 * el arreglo.
	 * @param dir La direcci�n en la que debe moverse F�lix durante este turno
	 * @param martillazos La cantidad de martillazos que debe dar F�lix durante este turno**/
	public void guardarEnTopScores(String nombre) {
		Fichero arch = new Fichero();
		Partida.getInstance().getJugador().setNombre(nombre);
		String [] auxNombres = new String[5];
			int [] auxScores = new int[5];
			int [] auxStats = new int[3];
			if (!(this.topScores.contains(Partida.getInstance().getJugador()))) {
				if (!this.topScores.isEmpty()) {
					if (Partida.getInstance().getJugador().getPuntaje() > Collections.min(this.topScores).getPuntaje()) {
						arch.aumentarCont(2, arch);
						this.topScores.add(Partida.getInstance().getJugador());
						this.topScores.remove(Collections.min(this.topScores));
						Collections.sort(this.topScores);
						for(int i=0; i<5; i++) {
							auxNombres[i]=this.topScores.get(i).getNombre();
							auxScores[i]=this.topScores.get(i).getPuntaje();
						}
						arch.escribir(auxNombres, auxScores);
					}
				} else {
					this.topScores.add(Partida.getInstance().getJugador());
					auxNombres[0]=this.topScores.get(0).getNombre();
					auxScores[0]=this.topScores.get(0).getPuntaje();
					for(int i=1; i<5; i++) {
						auxNombres[i]=this.topScores.get(i).getNombre();
						auxScores[i]=this.topScores.get(i).getPuntaje();
					}
					arch.escribir(auxNombres, auxScores);
			}
		}
			for(Jugador juge : this.topScores) {
				System.out.println(juge.getNombre() + ":" + juge.getPuntaje());
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