package logica;
public class Pajaro extends Objeto {
	
	private String direccion;
	
	public Pajaro(Posicion posi) {
		super(posi);
		this.direccion = "Izq o Der";
	}
	

	
	public void actualizar(int dificultad) {
		if(this.direccion.equals("Izq")) {
			this.posObjeto.moverIzq();
		} else {
			this.posObjeto.moverDer();
		}
	}
	
	public boolean destruir() {
		return ((this.posObjeto.getX() < 0) || (this.posObjeto.getX() > 4));
	}
}
