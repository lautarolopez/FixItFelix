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
	
	public void reset() { //Reinicia la posici�n y la invulnerabilidad se desactiva si est� activada, pero no cambian las vidas.
		this.posFelix = new Posicion (2, 0);
		this.invulnerable = false;
		this.timeLeftInv = 0;
	}
	
	
	public int repararVentana(Ventana[][] etapa, int martillazos, boolean ganeNivel) {
		int puntaje = 0;
		while (martillazos != 0){
			if (!etapa[this.posFelix.getX()][this.posFelix.getY()].arreglada()) { //Recupera la matriz de ventanas de la secci�n actual, y pregunta si el elemento en la ubicaci�n de F�lix necesita ser reparado.
					etapa[this.posFelix.getX()][this.posFelix.getY()].reparar();
					if (ganeNivel) { //Si la ventana fue la �ltima del nivel, la repara 
						System.out.print("500 puntos!");
						puntaje += 500;
					} else {
						System.out.print("100 puntos!");
						puntaje += 100;
					}
			}
			martillazos--;
		}
		return puntaje;
	}
	

	public Posicion getPosFelix() {
		return posFelix;
	}



	public void actualizarFelix (String dir) {	//Se mueve en la direcci�n recibida y actualiza el estado de invulnerabilidad.
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


	public void mover(String dir, Ventana[][] etapa) {
		switch(dir) {
		case "Arriba":
			if (this.posFelix.getY()+1 < 3) {  //Eval�o si al moverme hacia arriba no voy a caer afuera del tablero. De ser as� no me muevo.
				if (!etapa[this.posFelix.getX()][this.posFelix.getY()+1].tieneMacetero()) { //Eval�o que la ventana de arriba no tenga macetero. Si lo tiene no me muevo.
					if (!etapa[this.posFelix.getX()][this.posFelix.getY()].tieneMoldura()) { //Eval�o que la ventana en la que estoy parado no tenga moldura, si la tiene no me muevo.
						this.posFelix.moverAr();; //En el caso de poder moverme hacia arriba lo hago.
						System.out.println("Se movi� arriba!");
					}
				}
			}
		break;
		case "Abajo": 
			if (this.posFelix.getY()-1 >= 0) { //Las mismas evaluaciones que para arriba, pero para abajo.
				if (!etapa[this.posFelix.getX()][this.posFelix.getY()-1].tieneMoldura()) {
					if (!etapa[this.posFelix.getX()][this.posFelix.getY()].tieneMacetero()) {
						this.posFelix.moverAb();
						System.out.println("Se movi� abajo!");

					}
				}
			}
		break;
		case "Izquierda": 
			if (this.posFelix.getX()-1 >= 0) { //Eval�o si al moverme hacia la izquierda no voy a caer afuera del tablero. De ser as� no me muevo.
				if (etapa[this.posFelix.getX()-1][this.posFelix.getY()].estaAbierta()) { //Si la ventana de la izquierda es una ventana con hojas, tengo que preguntar si est� abierta para moverme. Si es una ventana normal directamente me muevo.
						this.posFelix.moverIzq();;
						System.out.println("Se movi� Izquierda!");
				}
			}
		break;
		case "Derecha": 
			if (this.posFelix.getX()+1 <= 4) { //Eval�o si al moverme hacia la izquierda no voy a caer afuera del tablero. De ser as� no me muevo.
				if (etapa[this.posFelix.getX()+1][this.posFelix.getY()].estaAbierta()) { //Si la ventana de la izquierda es una ventana con hojas, tengo que preguntar si est� abierta para moverme. Si es una ventana normal directamente me muevo.
						this.posFelix.moverDer();;
						System.out.println("Se movi� Derecha!");
				}
			}
		break;
		default : 
			System.out.println("Direcci�n inv�lida.");
		break;
		}
		System.out.println(this.posFelix.getX());
		System.out.println(this.posFelix.getY()); 
	}

	
	
}
