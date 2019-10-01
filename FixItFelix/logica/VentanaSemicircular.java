package logica;
public class VentanaSemicircular extends Ventana {

	public VentanaSemicircular (Posicion pos, boolean p, int dificultad) { //Recibe un boolean para saber si es una ventana de la seccion suelo o seccion medio, ya que en el primer caso tiene cuatro paneles y en el segundo 8. Luego genera aleatoriamente el estado de los paneles.
		super(pos);
		int x = 8;
		if(p) x= 4;
		this.salud = new Estado[x];
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
		System.out.print("Se creó una ventana semicircular");
	}
}
