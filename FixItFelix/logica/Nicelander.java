package logica;

public class Nicelander extends Objeto{
	private int cicloDeVida;
	
	public Nicelander(Posicion posi) {
		super(posi);
		this.cicloDeVida = 2;
	}
	
	public boolean generarTorta() {
		return this.cicloDeVida == 0;
	}
	
	public void actualizar (int dificultad) {
		if (this.cicloDeVida != 0) this.cicloDeVida--;
	}
	
	public int getCicloDeVida() {
		return this.cicloDeVida;
	}
	
	public boolean destruir() {
		return this.cicloDeVida == 0;
	}
}
