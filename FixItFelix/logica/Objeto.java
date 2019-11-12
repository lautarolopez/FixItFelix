package logica;
import java.util.*;
public abstract class Objeto {
	protected Posicion posObjeto;
	
	public Objeto (Posicion posi, ArrayList<ArrayList<Ventana>> etapa){}
	
	public Posicion getPosicion() {
		return this.posObjeto;
	}
	
	public abstract boolean generarTorta();
	
	public abstract boolean destruir();
	
	public abstract void actualizar (int dificultad, ArrayList<ArrayList<Ventana>> etapa);
	
}
