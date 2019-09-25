package logica;
public class Ventana {
	private Posicion posVent;
	private Obstaculo obst;
	protected Estado[] salud;
	
	public Ventana(Posicion pos){
		this.posVent = pos;
		this.obst = new Obstaculo();
	};
	
	public void serReparada(){};
	public void romper(){};
}
