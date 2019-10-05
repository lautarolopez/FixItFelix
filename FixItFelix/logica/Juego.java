package logica;
public class Juego {

	private int[] topScores;
	private Partida partidaActual;
	
	
	public Juego() {
		
	}
	
	public void pruebaMatriz () {
		this.partidaActual.pruebaMatriz();
	}
	
	public void nuevoJuego(){
		this.partidaActual = new Partida("prueba");
	};
	
	public void nuevoJuego(String nombre){
		this.partidaActual = new Partida("nombre");
	};
	
	public void turno(String dir, int martillazos) {
		this.partidaActual.ciclo(dir, martillazos);
	}
}
