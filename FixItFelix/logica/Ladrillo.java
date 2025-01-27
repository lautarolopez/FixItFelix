package logica;
import java.util.*;
public class Ladrillo extends Objeto {
	private Integer freq;
	
	/** Una nueva instancia de Ladrillo le asigna una posici�n aleatoria en x y le asigna la m�xima altura.
	 * Adem�s incia la frecuencia de ca�da en 10, esto permite modificar la dificultad al actualizar. 
	 * @param posi Posici�n distinta de null, que ser� sobreescrita por una posici�n aleatoria.
	 * @param etapa Matriz de ventanas de la secci�n actual**/
	public Ladrillo (Posicion posi, ArrayList<ArrayList<Ventana>> etapa) {
		super(posi, etapa);
		int x = (int) (Math.random()*4);
		posi = new Posicion (x, 2);
		freq = 10;
		this.posObjeto = posi;
		etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerLadrillo();
	}
	
	
	
	/** Actualiza la posici�n del ladrillo. avis�ndole a las respectivas ventanas de su movimiento. Se mueve
	 * de acuerdo a la frecuencia de la instancia y la dificultad del nivel actual.
	 * @param dificultad Dificultad o nivel actual
	 * @etapa Matriz de ventanas de la secci�n actual **/
	public void actualizar(int dificultad, ArrayList<ArrayList<Ventana>> etapa) {
		this.freq -= dificultad;
		if (this.freq == 0) {
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).sacarLadrillo();
			this.posObjeto.moverAb();
			this.freq = 10-dificultad;
		}
		if (this.posObjeto.getY() >= 0) {
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerLadrillo();
		}
	}
	
	
	/** Se destruye una vez que llega al suelo. 
	 * @return boolean Verdadero si el Ladrillo cay� fuera del tablero**/
	public boolean destruir() { //Cuando cae fuera del tablero se destruye.
		return this.getPosicion().getY() < 0;
	}
	
	public boolean generarTorta() {
		return false;
	}
}
