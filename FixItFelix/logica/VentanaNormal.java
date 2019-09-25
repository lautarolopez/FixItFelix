package logica;
public class VentanaNormal extends Ventana {
	
	public VentanaNormal (Posicion pos){
		super(pos);
		Estado a = new Estado();
		Estado b = new Estado();
		this.salud = new Estado[2];
		this.salud[0] = a;
		this.salud[1] = b;
	}
	
	
	public void generarNicelander(){};
}
