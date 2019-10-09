package logica;
import java.util.*;
public class Nicelander extends Objeto{
	private int cicloDeVida;
	
	
	/**Una nueva instancia de Nicelander establece la posici�n que recibe por par�metro, establece
	 * un ciclo de vida y avisa a la ventana correspondiente que se encuentra ah�
	 @param posi Posici�n en la que se encontrar� el Nicelander
	 @param etapa Matriz de ventanas de la secci�n actual**/
	public Nicelander(Posicion posi, ArrayList<ArrayList<Ventana>> etapa) {
		super(posi, etapa);
		this.posObjeto = posi;
		this.cicloDeVida = 2;
		etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerNicelander();
	}
	
	
	/** Si el nicelander termina si ciclo de vida deja la instrucci�n de crear una nueva torta
	 * @return boolean Verdadero si el ciclo de vida del Nicelander termina **/
	public boolean generarTorta() {
		return this.cicloDeVida == 0;
	}
	
	
	/** En cada ciclo decrementa su ciclo de vida
	 * @param dificultad Dificultad o nivel actual
	 * @param etapa Matriz de ventanas de la secci�n actual **/
	public void actualizar (int dificultad, ArrayList<ArrayList<Ventana>> etapa) {
		if (this.cicloDeVida != 0) {
			this.cicloDeVida--;
		} else {
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).sacarNicelander();
		}
	}
	
	public int getCicloDeVida() {
		return this.cicloDeVida;
	}
	
	public boolean destruir() {
		return this.cicloDeVida == 0;
	}
	
	public Posicion getPosicion() {
		return this.posObjeto;
	}
}
