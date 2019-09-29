package logica;
public class Torta extends Objeto{
	private int cicloDeVida;

	public Torta(Posicion posi) {
		super(posi);
		this.cicloDeVida = 2;
	}
	
	public void actualizar(int dificultad) {
		this.cicloDeVida--;
	}
	
	public boolean destruir() {
		return this.cicloDeVida == 0;
	}
}
