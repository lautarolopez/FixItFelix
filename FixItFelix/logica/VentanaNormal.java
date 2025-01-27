package logica;
import java.util.*;
public class VentanaNormal extends Ventana {
	
	
	/**Una nueva instancia de VentanaNormal incia aleatoriamente el estado de sus paneles.
	 * @param pos Posicion de la ventana
	 * @param dificultad Dificultad o nivel actual **/
	public VentanaNormal (Posicion pos, int dificultad){
		super(pos);
		this.salud = new ArrayList<Estado>();
		double a;
		for (int i = 0; i < 2 ; i++) {
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
	
	
	public boolean generarNicelander(){ //Devuelve aleatoriamente si debe generar un nicelander o no, siempre y cuando el panel de m�s abajo est� roto.
		boolean aux = false;
		if (this.arreglada()) {
			double a = Math.random();
			if (a < 0.10) aux = true;
		}
		return aux;
	};
}
