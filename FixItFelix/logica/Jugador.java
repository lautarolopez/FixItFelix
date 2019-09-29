package logica;
public class Jugador {
	
	private String nombre;
	private int puntaje;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntaje = 0;
	}
	
	public void setPuntaje(int x) {
		this.puntaje += x;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
