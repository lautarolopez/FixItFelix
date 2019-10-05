package logica;
import java.util.*;
public class Seccion {

	protected ArrayList<ArrayList<Ventana>> etapa;
	
	public Seccion() {
	};
	
	
	public ArrayList<ArrayList<Ventana>> getEtapa(){
		return this.etapa;
	};
	
	public boolean etapaTerminada() { //Devuelve verdadero si todos los paneles de todas las ventanas de la sección están sanos.
		for (ArrayList<Ventana> arrVent : this.etapa) {
			for (Ventana vent : arrVent) {
				if (!vent.arreglada()) return false;;
			}
		}
		return true;
	}
	
	public boolean generarPajaro() { //Las subclases que lo implementen lo sobreescriben.
		return false;
	}
}
