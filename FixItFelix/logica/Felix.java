package logica;
public class Felix {
	
	private Posicion posFelix;
	private int vidas;
	private boolean invulnerable;
	private int timeLeftInv;
	
	public Felix() {
		this.posFelix = new Posicion(2, 0);
		this.vidas = 3;
		this.invulnerable = false;
		this.timeLeftInv = 0;
	}
	
	public void moverse(String dir){
		switch(dir) {
		  case "Arriba":
		    this.posFelix.moverAr();
		    break;
		  case "Abajo":
			    this.posFelix.moverAb();
			    break;
		  case "Derecha":
			    this.posFelix.moverDer();
			    break;
		  case "Izquierda":
			    this.posFelix.moverIzq();
			    break;
		  default:
		    // code block
		}
	}
	
	public void reparar() {}
}
