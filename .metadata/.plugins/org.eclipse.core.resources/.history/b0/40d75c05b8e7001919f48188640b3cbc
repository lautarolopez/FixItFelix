package logica;

public class Nicelander extends Objeto{
	private int cicloDeVida;
	
	public Nicelander(Posicion posi, Ventana[][] etapa) {
		super(posi, etapa);
		this.posObjeto = posi;
		this.cicloDeVida = 2;
		etapa[this.posObjeto.getX()][this.posObjeto.getY()].ponerNicelander();
	}
	
	public boolean generarTorta() {
		return this.cicloDeVida == 0;
	}
	
	public void actualizar (int dificultad, Ventana[][] etapa) {
		if (this.cicloDeVida != 0) {
			this.cicloDeVida--;
		} else {
			etapa[this.posObjeto.getX()][this.posObjeto.getY()].sacarNicelander();
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
