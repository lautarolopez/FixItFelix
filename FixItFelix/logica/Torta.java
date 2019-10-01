package logica;
public class Torta extends Objeto{
	private int cicloDeVida;

	public Torta(Posicion posi, Ventana[][] etapa) {
		super(posi, etapa);
		this.cicloDeVida = 2;
		etapa[this.posObjeto.getX()][this.posObjeto.getY()].ponerTorta();
	}
	
	public void actualizar(int dificultad, Ventana[][] etapa) {
		this.cicloDeVida--;
		if (this.cicloDeVida == 0) {
			etapa[this.posObjeto.getX()][this.posObjeto.getY()].sacarTorta();
		}
	}
	
	public boolean destruir() {
		return this.cicloDeVida == 0;
	}
	
	public Posicion getPosicion() {
		return this.posObjeto;
	}
}
