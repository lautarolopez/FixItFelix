package logica;
import java.util.HashMap;
public class Ventana {
	private Posicion posVent;
	private Obstaculo obst;
	protected Estado[] salud;
	protected HashMap<String, Boolean> colisiones; 
	
	public Ventana(Posicion posi){
		this.posVent = posi;
		this.obst = new Obstaculo();
		this.colisiones = new HashMap<String, Boolean>();
		this.colisiones.put("Pajaro", false);
		this.colisiones.put("Ladrillo", false);
		this.colisiones.put("Torta", false);
		this.colisiones.put("Nicelander", false);
	};
	
	
	
	public boolean arreglada() { //Retorna si todos los paneles de la ventana est�n sanos.
		boolean aux = true;
		for (Estado est : this.salud) {
			if (!(est == Estado.SANO)) aux = false;
		}
		return aux;
	}
	
	public boolean tieneMoldura() {
		return this.obst.tieneMoldura();
	}
	
	public boolean tieneMacetero() {
		return this.obst.tieneMacetero();
	}
	
	public boolean estaAbierta() {
		return true;
	}
	
	
	public void reparar (){ //Cuando encuentra un panel que no est� sano cambia su estado de Roto a Casi roto o de Casi roto a Sano.

		int x = 0;
		while((this.salud[x] == Estado.SANO) && x < salud.length) {
			x++;
		}
		switch (salud[x]) {
			case ROTO:{
				this.salud[x]= Estado.CASIROTO;
				break;
			}
			case CASIROTO: {
				this.salud[x]= Estado.SANO;
				break;
			}
			case SANO: {
				this.salud[x] = Estado.SANO;
				break;
			}
		}

	}
	
	public boolean generarNicelander() { //Las subclases que lo implementan deben sobreescribirlo.
		return false;
	}
	
	public void ponerLadrillo() {
		this.colisiones.replace("Ladrillo", false, true);
	}
	
	public void sacarLadrillo() {
		this.colisiones.replace("Ladrillo", true, false);
	}
	
	public void ponerPajaro() {
		this.colisiones.replace("Pajaro", false, true);
	}
	
	public void sacarPajaro() {
		this.colisiones.replace("Pajaro", true, false);
	}
	
	public void ponerTorta() {
		this.colisiones.replace("Torta", false, true);
	}
	
	public void sacarTorta() {
		this.colisiones.replace("Torta", true, false);
	}
	
	public void ponerNicelander() {
		this.colisiones.replace("Nicelander", false, true);
	}
	
	public void sacarNicelander() {
		this.colisiones.replace("Nicelander", true, false);
	}
}
