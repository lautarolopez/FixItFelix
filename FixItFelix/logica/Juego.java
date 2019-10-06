package logica;
import java.util.*;
public class Juego {

	private ArrayList<Jugador> topScores;
	private Partida partidaActual;
	
	
	public Juego() {
		this.topScores = new ArrayList<Jugador>();
	}
	
	
	public void nuevoJuego(String nombre){
		this.partidaActual = new Partida(nombre);
	};
	
	
	/** Realiza un ciclo de la partida. Adem�s, si la partida termin� agrega al jugador a la lista. Para esto
	 * verifica que el jugador no est� ya en la lista, para evitar duplicados si siguen mandando turnos a 
	 * una partida terminada; si el arrego es vac�o, para no comparar en un arreglo vac�o; y luego si 
	 * el puntaje es mayor al m�nimo del arreglo, en ese caso se reemplaza uno por otro y se ordena
	 * el arreglo.**/
	public void turno(String dir, int martillazos) {
		if (this.partidaActual.ciclo(dir, martillazos)) {
			if (!(this.topScores.contains(this.partidaActual.getJugador()))) {
				if (!this.topScores.isEmpty()) {
					if (this.partidaActual.getJugador().getPuntaje() > Collections.min(this.topScores).getPuntaje()) {
						this.topScores.add(this.partidaActual.getJugador());
						this.topScores.remove(Collections.min(this.topScores));
						Collections.sort(this.topScores);
					}
				} else this.topScores.add(this.partidaActual.getJugador());
			}
		}
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