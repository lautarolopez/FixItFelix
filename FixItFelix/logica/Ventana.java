package logica;
import java.util.*;
public abstract class Ventana {
	private Posicion posVent;
	private Obstaculo obst;
	protected ArrayList<Estado> salud;
	protected HashMap<String, Boolean> colisiones; 
	
	/**Una nueva instancia de Ventana establece una posición, crea un nuevo obstáculo aleatorio, e incia en falso
	 * los valores que indican si hay algún objeto en ella. **/
	public Ventana(Posicion posi){
		this.posVent = posi;
		this.obst = new Obstaculo();
		this.colisiones = new HashMap<String, Boolean>();
		this.colisiones.put("Pajaro", false);
		this.colisiones.put("Ladrillo", false);
		this.colisiones.put("Torta", false);
		this.colisiones.put("Nicelander", false);
	};
	
	
	
	public boolean arreglada() { //Retorna true si todos los paneles de la ventana están sanos.
		boolean aux = true;
		for (Estado est : this.salud) {
			if (!(est == Estado.SANO)) aux = false;
		}
		return aux;
	}
	
	public int cantidadRotos() {
		int x = 0;
		for (Estado est : this.salud) {
			if (est == Estado.ROTO) {
				x+=2;
			} else {
				if (est == Estado.CASIROTO) {
					x++;
				}
			}
		}
		return x;
	}
	
	public boolean esVentanaAbierta() {
		return false;
	}
	
	public boolean tieneMoldura() {
		return this.obst.tieneMoldura();
	}
	
	public boolean tieneMacetero() {
		return this.obst.tieneMacetero();
	}
	
	public boolean estaAbierta() {
		return false;
	}
	
	
	public void reparar (){ //Cuando encuentra un panel que no está sano cambia su estado de Roto a Casi roto o de Casi roto a Sano.	
		Iterator<Estado> iter = this.salud.iterator();
		int x = 0;
		Estado est = iter.next();
		while ((iter.hasNext()) && (est == Estado.SANO)) {
			est = iter.next();
			x++;
		}
		
		switch (est) {
			case ROTO:
				this.salud.set(x, Estado.CASIROTO);
			break;
			case CASIROTO: 
				this.salud.set(x, Estado.SANO);
			break;
			case SANO:
				this.salud.set(x, Estado.SANO);
			break;
		} 
	}
		
	public boolean generarNicelander() { //Las subclases que lo implementan deben sobreescribirlo.
		return false;
	}
	
	public Posicion getPos() {
		return this.posVent;
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
	
	public boolean pajaro() {
		return this.colisiones.get("Pajaro");
	}
	
	public boolean ladrillo() {
		return this.colisiones.get("Ladrillo");
	}
	
	public boolean torta() {
		return this.colisiones.get("Torta");
	}
	
	public boolean nicelander() {
		return this.colisiones.get("Nicelander");
	}
}
