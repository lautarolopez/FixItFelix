package logica;
import java.util.*;
public class Nicelander extends Objeto{
	private int cicloDeVida;
	
	public Nicelander(Posicion posi, ArrayList<ArrayList<Ventana>> etapa) {
		super(posi, etapa);
		this.posObjeto = posi;
		this.cicloDeVida = 2;
		etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerNicelander();
	}
	
	public boolean generarTorta() {
		return this.cicloDeVida == 0;
	}
	
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
