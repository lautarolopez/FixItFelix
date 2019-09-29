package logica;
public class Ventana {
	private Posicion posVent;
	private Obstaculo obst;
	protected Estado[] salud;
	
	public Ventana(Posicion posi){
		this.posVent = posi;
		this.obst = new Obstaculo();
	};
	
	
	
	public boolean arreglada() {
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
	
	
	public void reparar (){
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
	
	public boolean generarNicelander() {
		return false;
	}
}
