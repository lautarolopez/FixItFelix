package logica;
import java.util.*;
public class VentanaSemicircular extends Ventana {

	
	
	/**Una nueva instancia de VentanaSemicircular incia aleatoriamente el estado de sus paneles. La cantidad de paneles
	 * que tiene es de acuerdo a la secci�n a la que pertenece, indicado por un boolean que rebice por defecto. **/
	public VentanaSemicircular (Posicion pos, boolean p, int dificultad) { //Recibe un boolean para saber si es una ventana de la seccion suelo o seccion medio, ya que en el primer caso tiene cuatro paneles y en el segundo 8. Luego genera aleatoriamente el estado de los paneles.
		super(pos);
		int x = 8;
		if(p) x= 4;
		this.salud = new ArrayList<Estado>();
		double a;
		for (int i = 0; i < x; i++) {
			a = Math.random();
			if (a <= (0.33) + (dificultad * 0.1)) {
				Estado est = Estado.ROTO;
				this.salud.add(est);
			} else {
				if (a <= (0.66) + (dificultad * 0.1)) {
					Estado est = Estado.CASIROTO;
					this.salud.add(est);
				} else {
					Estado est = Estado.SANO;
					this.salud.add(est);
				}
			}
		}
	}
}
