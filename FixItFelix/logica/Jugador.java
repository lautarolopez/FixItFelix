package logica;
public class Jugador implements Comparable<Jugador> {
	
	private String nombre;
	private int puntaje;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntaje = 0;
	}
	
	
	/**Añade más puntos al puntaje del jugador
	 * @param x Cantidad de puntos a añadir al puntaje **/
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Nombre: " + nombre + ". Puntaje: " + puntaje + ".";
	}
	
	public void penalizacion() {
		this.puntaje /= 2; 
	}
}
