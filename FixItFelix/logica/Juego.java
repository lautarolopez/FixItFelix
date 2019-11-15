package logica;
import grafica.*;
import java.util.*;
public class Juego {
	
	private static Juego INSTANCE;
	private ArrayList<Jugador> topScores;
	private PantallaPrincipalGUI pantallaPrinc;
	
	private Juego() {
		this.topScores = new ArrayList<Jugador>();
		this.pantallaPrinc = new PantallaPrincipalGUI();
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
	
	
	/** Realiza un ciclo de la partida. Adem�s, si la partida termin� agrega al jugador a la lista. Para esto
	 * verifica que el jugador no est� ya en la lista, para evitar duplicados si siguen mandando turnos a 
	 * una partida terminada; si el arrego es vac�o, para no comparar en un arreglo vac�o; y luego si 
	 * el puntaje es mayor al m�nimo del arreglo, en ese caso se reemplaza uno por otro y se ordena
	 * el arreglo.
	 * @param dir La direcci�n en la que debe moverse F�lix durante este turno
	 * @param martillazos La cantidad de martillazos que debe dar F�lix durante este turno**/
	public void turno(String dir, int martillazos) {
		/**if (this.partidaActual.ciclo(dir, martillazos)) {
			if (!(this.topScores.contains(this.partidaActual.getJugador()))) {
				if (!this.topScores.isEmpty()) {
					if (this.partidaActual.getJugador().getPuntaje() > Collections.min(this.topScores).getPuntaje()) {
						this.topScores.add(this.partidaActual.getJugador());
						this.topScores.remove(Collections.min(this.topScores));
						Collections.sort(this.topScores);
					}
				} else this.topScores.add(this.partidaActual.getJugador());
			}
		}**/
	}
	
	/**Imprime los cinco puntajes m�s altos. **/
	public void imprimirTopScores() {
		System.out.println("------------Mejores puntajes------------");
		for (Jugador jug : this.topScores) {
			System.out.println(jug.toString());
		}
		System.out.println("----------------------------------------");
	}
}