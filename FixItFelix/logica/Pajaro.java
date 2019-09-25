package logica;
public class Pajaro extends Objeto {
	
	private String direccion;
	
	public Pajaro() {
		super();
		this.direccion = "Izq o Der";
	}
	
	public void Mover() {
		if(this.direccion.equals("Izq")) {
			this.posObjeto.moverIzq();
		} else {
			this.posObjeto.moverDer();
		}
	}
}
