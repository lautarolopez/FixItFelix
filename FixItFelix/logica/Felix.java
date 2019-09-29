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
	
	public void reset() { //Reinicia la posición y la invulnerabilidad se desactiva si está activada, pero no cambian las vidas.
		this.posFelix = new Posicion (2, 0);
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
		}
	}



	public Posicion getPosFelix() {
		return posFelix;
	}



	public void actualizarFelix (String dir) {	//Se mueve en la dirección recibida y actualiza el estado de invulnerabilidad.
		this.moverse(dir);
		if (this.invulnerable) this.timeLeftInv--;
		if (this.timeLeftInv == 0) this.invulnerable = false;
	}
	
	public void setInvulnerable() {
		this.invulnerable = true;
		this.timeLeftInv = 2;
	}

	public void perderVida() {
		this.vidas--;
	}


	public int getVidas() {
		return vidas;
	}




	
	
}
