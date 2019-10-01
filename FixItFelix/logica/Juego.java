package logica;
public class Juego {

	private int[] topScores;
	private Partida partidaActual;
	
	
	public Juego() {
		
	}
	
	
	public void nuevoJuego(){
		this.partidaActual = new Partida("prueba");
	};
	
	public void turno(String dir, boolean martillazo) {
		this.partidaActual.ciclo(dir, martillazo);
	}
}
