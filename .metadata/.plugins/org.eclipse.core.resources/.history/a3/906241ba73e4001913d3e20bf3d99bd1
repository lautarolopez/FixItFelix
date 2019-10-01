package logica;
public class VentanaConHojas extends Ventana {
	
	private boolean abierta;
	
	public VentanaConHojas(Posicion pos) { //Establece aletoriamente si la ventana está abierta o cerrada. FALTA IMPLEMENTAR QUE LAS POSIBILIDADES DEPENDAN DE LA DIFICULTAD.
		super(pos);
		double x = Math.random();
		this.abierta = x < 0.70;
		this.salud = new Estado[2];
		for (Estado est : this.salud) {
			est = Estado.SANO;
		}
	}
	
	public boolean estaAbierta() {
		return this.abierta;
	}
}
