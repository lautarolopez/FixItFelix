package logica;

public class Ladrillo extends Objeto {
	
	public Ladrillo (Posicion posi) {
		super(posi);
	}
	
	public void actualizar(int dificultad) {
		for (int i = 0; i < dificultad; i++) {
			this.posObjeto.moverAb(); // repetir x veces de acuerdo a la dificultad
		}
	}
}
