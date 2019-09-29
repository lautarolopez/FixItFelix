package logica;
public class Seccion {

	protected Ventana[][] etapa;
	
	public Seccion() {
	};
	
	
	public Ventana[][] getEtapa(){
		return this.etapa;
	}
	
	public boolean etapaTerminada() { //Devuelve verdadero si todos los paneles de todas las ventanas de la sección están sanos.
		for (Ventana[] arrVent : this.etapa) {
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
