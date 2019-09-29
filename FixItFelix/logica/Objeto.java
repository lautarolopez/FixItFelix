package logica;
public class Objeto {
	protected Posicion posObjeto;
	
	public Objeto (Posicion posi) {
		this.posObjeto = posi;
	};
	
	public Posicion getPosicion() {
		return this.posObjeto;
	}
	
	public boolean destruir() {
		return false;
	};
	
	public void actualizar (int dificultad) {}
}
