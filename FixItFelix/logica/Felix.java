package logica;
import java.util.*;
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
	}
	
	
	/**Recibe la secci�n actual de ventanas y busca en la que est� parado actualmente. Si �sta no est� totalmente sana
	 * repara un panel por cada martilazo, cuya cantidad recibe por par�mtro. Adem�s devuelve la cantidad de puntos que sum� con el 
	 * total de reparaciones. 
	 * @param etapa La matriz de ventanas de la secci�n actual
	 * @param martillazos La cantidad de martillazos que se deben dar en este ciclo
	 * @param ganeNivel un valor booleano para saber si despu�s de reparar la ventana gan� el nivel
	 * actual o no.
	 * @retun int Cantidad de puntos conseguidos reparando las ventanas**/
	public int repararVentana(ArrayList<ArrayList<Ventana>> etapa) {
		int puntaje = 0;
		if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()).arreglada()) { //Recupera la matriz de ventanas de la secci�n actual, y pregunta si el elemento en la ubicaci�n de F�lix necesita ser reparado.
				etapa.get(this.posFelix.getX()).get(this.posFelix.getY()).reparar();
				if (Partida.getInstance().ganeNivel()) { //Si la ventana fue la �ltima del nivel, la repara 
					puntaje += 500;
				} else {
					puntaje += 100;
				}
			}
		return puntaje;
	}
	

	public Posicion getPosFelix() {
		return posFelix;
	}

	public void actualizarFelix () {	//Actualiza el estado de invulnerabilidad.
		if (this.invulnerable) this.timeLeftInv--;
		if (this.timeLeftInv == 0) this.invulnerable = false;
	}
	
	public void setInvulnerable() {
		this.invulnerable = !this.invulnerable;
	}
	
	public boolean isInvulnerable() {
		return this.invulnerable;
	}

	public void perderVida() {
		this.vidas--;
	}


	public int getVidas() {
		return vidas;
	}

	
	/**De acuerdo a la direcci�n que recibe eval�a si puede moverse hacia esa direcci�n, teniendo en cuenta los obst�culos,
	 * las ventanas abiertas y los l�mites del edificio. En el caso de encontrarse con alguna restricci�n simplemente
	 * no se mueve.
	 * @param dir Direcci�n en la que debe moverse F�lix, con primera letra capital y sin punto
	 * @param etapa Matriz de ventanas de la secci�n actual. **/	
	public boolean movArriba(ArrayList<ArrayList<Ventana>> etapa) {
		boolean seMovio= false;
		if (this.posFelix.getY()+1 < 3) {  //Eval�o si al moverme hacia arriba no voy a caer afuera del tablero. De ser as� no me muevo.
			if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()+1).tieneMacetero()) { //Eval�o que la ventana de arriba no tenga macetero. Si lo tiene no me muevo.
				if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()).tieneMoldura()) { //Eval�o que la ventana en la que estoy parado no tenga moldura, si la tiene no me muevo.
					this.posFelix.moverAr();; //En el caso de poder moverme hacia arriba lo hago.
					seMovio = true;
				}
			}
		}
		return seMovio;
	}
	
	public boolean movAbajo(ArrayList<ArrayList<Ventana>> etapa) {
		boolean seMovio = false;
		if (this.posFelix.getY()-1 >= 0) { //Las mismas evaluaciones que para arriba, pero para abajo.
			if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()-1).tieneMoldura()) {
				if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()).tieneMacetero()) {
					this.posFelix.moverAb();
					seMovio = true;
				}
			}
		}
		return seMovio;
	}
	
	public boolean movIzquierda(ArrayList<ArrayList<Ventana>> etapa) {
		boolean seMovio = false;
		if (this.posFelix.getX()-1 >= 0) { //Eval�o si al moverme hacia la izquierda no voy a caer afuera del tablero. De ser as� no me muevo.
			if (!etapa.get(this.posFelix.getX()-1).get(this.posFelix.getY()).estaAbierta()) { //Si la ventana de la izquierda es una ventana con hojas, tengo que preguntar si est� abierta para moverme. Si es una ventana normal directamente me muevo.
				if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()).estaAbierta()) {
					this.posFelix.moverIzq();;
					seMovio = true;
				}
			}
		}
		return seMovio;
	}
	
	public boolean movDerecha(ArrayList<ArrayList<Ventana>> etapa) {
		boolean seMovio = false;
		if (this.posFelix.getX()+1 < 5) { //Eval�o si al moverme hacia la izquierda no voy a caer afuera del tablero. De ser as� no me muevo.
			if (!etapa.get(this.posFelix.getX()+1).get(this.posFelix.getY()).estaAbierta()) { //Si la ventana de la izquierda es una ventana con hojas, tengo que preguntar si est� abierta para moverme. Si es una ventana normal directamente me muevo.
				if (!etapa.get(this.posFelix.getX()).get(this.posFelix.getY()).estaAbierta()) {
					this.posFelix.moverDer();;
					seMovio = true;
				}
			}
		}
 		return seMovio;
	}
	
}
