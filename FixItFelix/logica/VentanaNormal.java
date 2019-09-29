package logica;
public class VentanaNormal extends Ventana {
	
	public VentanaNormal (Posicion pos, int dificultad){
		super(pos);
		this.salud = new Estado[2];
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
	
	
	public boolean generarNicelander(){
		boolean aux = false;
		if (this.salud[0] == Estado.ROTO) {
			double a = Math.random();
			if (a < 0.30) aux = true;
		}
		return aux;
	};
}
