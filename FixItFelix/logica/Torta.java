package logica;
import java.util.*;
public class Torta extends Objeto{
	private int cicloDeVida;

	/**@param posi La posici�n en la que se va a instanciar la torta
	 * @param etapa Matriz de ventanas de la secci�n actual*/
	public Torta(Posicion posi, ArrayList<ArrayList<Ventana>> etapa) {
		super(posi, etapa);
		this.posObjeto = posi;
		this.cicloDeVida = 2;
		etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerTorta();
	}
	
	/**Actualiza el ciclo de vida de la torta.
	 * @param dificultad Dificultad o nivel actual
	 * @param etapa Matriz de ventanas de la secci�n actual */
	public void actualizar(int dificultad, ArrayList<ArrayList<Ventana>> etapa) {
		this.cicloDeVida--;
		if (this.cicloDeVida == 0) {
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).sacarTorta();
		}
	}
	
	public boolean destruir() {
		return this.cicloDeVida == 0;
	}
	
	public Posicion getPosicion() {
		return this.posObjeto;
	}
	
	public boolean generarTorta() {
		return false;
	}
}
