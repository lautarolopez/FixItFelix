package logica;
import java.util.*;
public class VentanaConHojas extends Ventana {
	
	private boolean abierta;
	
	/**@pram pos Posición de la ventana */
	public VentanaConHojas(Posicion pos) { //Establece aletoriamente si la ventana está abierta o cerrada. FALTA IMPLEMENTAR QUE LAS POSIBILIDADES DEPENDAN DE LA DIFICULTAD.
		super(pos);
		double x = Math.random();
		this.abierta = x < 0.70;
		this.salud = new ArrayList<Estado>();
		Estado est = Estado.SANO;
		this.salud.add(est);
		this.salud.add(est);
	}
	
	public boolean estaAbierta() {
		return this.abierta;
	}
	
	public boolean esVentanaAbierta() {
		return true;
	}
}
