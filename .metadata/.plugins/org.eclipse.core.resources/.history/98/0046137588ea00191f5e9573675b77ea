package logica;
public class Jugador implements Comparable<Jugador> {
	
	private String nombre;
	private int puntaje;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntaje = 0;
	}
	
	
	/**Recibe una cantidad de puntaje por una acción y la suma al puntaje del jugador. **/
	public void setPuntaje(int x) {
		this.puntaje += x;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int compareTo(Jugador jugador2) {
		return jugador2.getPuntaje()-this.getPuntaje();
	}
	
	public String toString() {
		return "Nombre: " + nombre + ". Puntaje: " + puntaje + ".";
	}
}
