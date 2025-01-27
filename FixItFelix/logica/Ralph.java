package logica;
public class Ralph {
	
	private int ladrillosRestantes;
	private int frecuencia;
	
	public Ralph () {
		this.ladrillosRestantes = 40;
		this.frecuencia = 10;
	}
	
	/** Ralph genear un ladrillo con cierta frecuencia, que est� dada por la dificultad. En tal caso
	 * retorna verdadero.
	 * @param dificultad Dificultad o nivel actual
	 * @return boolean Verdadero si la frecuencia de Ralph indica que debe lanzar un ladrillo **/
	public boolean generarLadrillo(int dificultad){ //Genera una cantidad de ladrillos si frecuencia est� en cero, y actualiza frecuencia. Una vez generado un ladrillo aumenta la frecuencia de acuerdo a la dificultad.
		this.frecuencia--;
		if (frecuencia == 0) {
			this.ladrillosRestantes--;
			this.frecuencia = 10-dificultad;
			return true;
		}
		else return false;
	};
	

}
