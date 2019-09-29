package logica;
public class Seccion {

	protected Ventana[][] etapa;
	
	public Seccion() {
	};
	
	
	public Ventana[][] getEtapa(){
		return this.etapa;
	}
	
	public boolean etapaTerminada() {
		for (Ventana[] arrVent : this.etapa) {
			for (Ventana vent : arrVent) {
				if (!vent.arreglada()) return false;;
			}
		}
		return true;
	}
	
	public boolean generarPajaro() {
		return false;
	}
}
