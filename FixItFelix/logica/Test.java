package logica;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		
		Juego game = new Juego();
		game.nuevoJuego();
		game.turno("Arriba", true);
		game.turno("Derecha", true);
		game.turno("Abajo", true);
		game.turno("Arriba", true);
		game.turno("Izquierda", true);
		game.turno("Arriba", true);
		game.turno("Derecha", true);
	} 

}
