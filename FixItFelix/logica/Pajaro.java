package logica;
import java.util.*;
public class Pajaro extends Objeto {
	
	private String direccion;
	
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
	

	public Posicion getPosicion() {
		return this.posObjeto;
	}
	
	public void actualizar(int dificultad, ArrayList<ArrayList<Ventana>> etapa) { //Se mueve de acuerdo a la direcci�n que lleva.
		if(this.direccion.equals("Izq")) {
			this.posObjeto.moverIzq();
			etapa.get(this.posObjeto.getX()+1).get(this.posObjeto.getY()).sacarPajaro();
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerPajaro();
		} else {
			this.posObjeto.moverDer();
			etapa.get(this.posObjeto.getX()-1).get(this.posObjeto.getY()).sacarPajaro();
			etapa.get(this.posObjeto.getX()).get(this.posObjeto.getY()).ponerPajaro();
		}
	}
	
	public boolean destruir() { //Si cae fuera del tablero se destruye.
		return ((this.posObjeto.getX() < 0) || (this.posObjeto.getX() > 4));
	}
}
