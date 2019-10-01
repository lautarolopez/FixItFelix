package logica;
public class VentanaNormal extends Ventana {
	
	public VentanaNormal (Posicion pos, int dificultad){
		super(pos);
		this.salud = new Estado[2];
		double a;
		for (Estado est : this.salud) {
			a = Math.random();
			if (a <= (0.33) + (dificultad * 0.1)) {
				est = Estado.ROTO;
				System.out.print(est.toString());
			} else {
				if (a <= (0.66) + (dificultad * 0.1)) {
					est = Estado.CASIROTO;
					System.out.print(est.toString());
				} else {
					est = Estado.SANO;
					System.out.print(est.toString());
				}
			}
		}
		System.out.print("Se creo una ventana normal");
	}
	
	
	public boolean generarNicelander(){ //Devuelve aleatoriamente si debe generar un nicelander o no, siempre y cuando el panel de m�s abajo est� roto.
		boolean aux = false;
		if (this.salud[0] == Estado.ROTO) {
			double a = Math.random();
			if (a < 0.30) aux = true;
		}
		return aux;
	};
}
