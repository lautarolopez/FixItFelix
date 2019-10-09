package logica;
import java.util.*;
public class Seccion {

	protected ArrayList<ArrayList<Ventana>> etapa;
	
	public Seccion() {
	};
	
	
	public ArrayList<ArrayList<Ventana>> getEtapa(){
		return this.etapa;
	};
	
	/**@return boolean Devuelve verdadero si todos los paneles de todas las ventanas de la matriz
	 * están SANOS. */
	public boolean etapaTerminada() { //Devuelve verdadero si todos los paneles de todas las ventanas de la sección están sanos.
		for (ArrayList<Ventana> arrVent : this.etapa) {
			for (Ventana vent : arrVent) {
				if (!vent.arreglada()) return false;;
			}
		}
		return true;
	}
	
	//Solo lo implementan las secciones Media y MasAlta
	public boolean generarPajaro() { //Las subclases que lo implementen lo sobreescriben.
		return false;
	}
}
