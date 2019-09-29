package logica;
public class VentanaSemicircular extends Ventana {

	public VentanaSemicircular (Posicion pos, boolean p, int dificultad) {
		super(pos);
		int x = 8;
		if(p) x= 4;
		this.salud = new Estado[x];
		double a;
		for (Estado est : this.salud) {
			a = Math.random();
			if (a < (0.33) + (dificultad * 0.1)) {
				est = Estado.ROTO;
			} else {
				if (a < (0.66) + (dificultad * 0.1)) {
					est = Estado.CASIROTO;
				} else {
					est = Estado.SANO;
				}
			}
		}
	}
}
