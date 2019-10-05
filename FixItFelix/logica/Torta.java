package logica;
import java.util.*;
public class Torta extends Objeto{
	private int cicloDeVida;

	public Torta(Posicion posi, ArrayList<ArrayList<Ventana>> etapa) {
		super(posi, etapa);
		this.cicloDeVida = 2;
		etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerTorta();
	}
	
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
}
