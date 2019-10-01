package logica;

public class Ladrillo extends Objeto {
	private Integer freq;
	
	public Ladrillo (Posicion posi, Ventana[][] etapa) {
		super(posi, etapa);
		int x = (int) (Math.random()*4);
		posi = new Posicion (x, 2);
		freq = 10;
		etapa[this.posObjeto.getX()][this.posObjeto.getY()].ponerLadrillo();
	}
	
	public Posicion getPosicion() {
		return this.posObjeto;
	}
	
	public void actualizar(int dificultad, Ventana[][] etapa) {
		this.freq -= dificultad;
		if (this.freq == 0) {
			etapa[this.posObjeto.getX()][this.posObjeto.getY()].sacarLadrillo();
			this.posObjeto.moverAb();
			this.freq = 10;
		}
		etapa[this.posObjeto.getX()][this.posObjeto.getY()].ponerLadrillo();
	}
	
	public boolean destruir() { //Cuando cae fuera del tablero se destruye.
		return this.getPosicion().getY() < 0;
	}
}
