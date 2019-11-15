package logica;
import grafica.*;
import java.util.*;
public class Juego {
	
	private static Juego INSTANCE;
	private ArrayList<Jugador> topScores;
	private PantallaPrincipalGUI pantallaPrinc;
	private Fichero arch;
	
	private Juego() {
		this.topScores = new ArrayList<Jugador>();
		this.pantallaPrinc = new PantallaPrincipalGUI();
		int [] actualizarStatsJuego = new int[3];
		Fichero arch = new Fichero();
		arch.leerEstadisticas();
		actualizarStatsJuego = arch.getStats();
		actualizarStatsJuego[0]++;
		arch.escribirEstadisticas(actualizarStatsJuego);
	}
	
	
	public static void nuevoJuego(String nombre){
		Partida.getInstance(nombre);
		Partida.getInstance().inciarGrafica();
	};
	
	public int getDificultad() {
		return pantallaPrinc.getDificultad();
	}
	
	public static Juego getInstance (String nombre) {
		if (INSTANCE == null) {
			INSTANCE = new Juego();
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}
	
	public static Juego getInstance() {
		return INSTANCE;
	}
	
	
	/** Realiza un ciclo de la partida. Además, si la partida terminó agrega al jugador a la lista. Para esto
	 * verifica que el jugador no esté ya en la lista, para evitar duplicados si siguen mandando turnos a 
	 * una partida terminada; si el arrego es vacío, para no comparar en un arreglo vacío; y luego si 
	 * el puntaje es mayor al mínimo del arreglo, en ese caso se reemplaza uno por otro y se ordena
	 * el arreglo.
	 * @param dir La dirección en la que debe moverse Félix durante este turno
	 * @param martillazos La cantidad de martillazos que debe dar Félix durante este turno**/
	public void turno(String dir, int martillazos) {
		String [] auxNombres = new String[5];
			int [] auxScores = new int[5];
			int [] auxStats = new int[3];
			if (!(this.topScores.contains(Partida.getInstance().getJugador()))) {
				if (!this.topScores.isEmpty()) {
					if (Partida.getInstance().getJugador().getPuntaje() > Collections.min(this.topScores).getPuntaje()) {
						auxStats = arch.getStats();
						auxStats[2]++;
						arch.escribirEstadisticas(auxStats);
						this.topScores.add(Partida.getInstance().getJugador());
						this.topScores.remove(Collections.min(this.topScores));
						Collections.sort(this.topScores);
						for(int i=0; i<5; i++) {
							auxNombres[i]=this.topScores.get(i).getNombre();
							auxScores[i]=this.topScores.get(i).getPuntaje();
						}
						arch.escribir(auxNombres, auxScores);
					}
				} else this.topScores.add(Partida.getInstance().getJugador());
			}
	}
	
	/**Imprime los cinco puntajes más altos. **/
	public void imprimirTopScores() {
		System.out.println("------------Mejores puntajes------------");
		for (Jugador jug : this.topScores) {
			System.out.println(jug.toString());
		}
		System.out.println("----------------------------------------");
	}
}