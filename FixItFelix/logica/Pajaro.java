package logica;
import java.util.*;
public class Pajaro extends Objeto {
	
	private String direccion;
	
	
	/**Una nueva instancia de P�jaro le asigna aleatoriamente una direcci�n de donde empezar y una
	 * altura. Adem�s avisa a la ventana en la que aparece que est� ah�.
	 * @param posi Una posici�n que ser� sobreescrita por una posici�n aleatoria donde aparece el p�jaro
	 * @param etapa Matriz de ventanas de la secci�n actual **/
	public Pajaro (Posicion posi, ArrayList<ArrayList<Ventana>> etapa) {
		super(posi, etapa);
		int y = (int) (Math.random()*2);
		double a = Math.random();
		int x = 0;
		if (a < 0.50) x = 4;
		posi = new Posicion(x, y);
		this.posObjeto = posi;
		this.direccion = "Izq o Der";
		etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerPajaro();

	}
	

	
	/**El p�jaro se mueve un lugar de acuerdo a la direcci�n que lleva. Adem�s avisa a la ventana en la que estaba
	 * que ya no se encuentra ah�, y a la ventana a la que lleg� que ahora est� en ese lugar.
	 * @param dificultad Dificultad o nivel actual
	 * @param etapa Matriz de ventanas de la secci�n actual**/
	public void actualizar(int dificultad, ArrayList<ArrayList<Ventana>> etapa) { //Se mueve de acuerdo a la direcci�n que lleva.
		if(this.direccion.equals("Izq")) {
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).sacarPajaro();
			this.posObjeto.moverIzq();
			if (this.posObjeto.getX() >= 0) etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerPajaro();
		} else {
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).sacarPajaro();
			this.posObjeto.moverDer();
			if (this.posObjeto.getX() < 5) etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerPajaro();
		}
	}
	
	/**@return boolean Verdadero si el p�jaro cae fuera del tablero */
	public boolean destruir() { //Si cae fuera del tablero se destruye.
		return ((this.posObjeto.getX() < 0) || (this.posObjeto.getX() > 4));
	}
	
	public boolean generarTorta() {
		return false;
	}
}
