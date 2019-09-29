package logica;
public class Ralph {
	
	private int ladrillosRestantes;
	private int frecuencia;
	
	public Ralph () {
		this.ladrillosRestantes = 40;
		this.frecuencia = 10;
	}
	
	public boolean generarLadrillo(int dificultad){ //Genera una cantidad de ladrillos si frecuencia está en cero, y actualiza frecuencia. Una vez generado un ladrillo aumenta la frecuencia de acuerdo a la dificultad.
		this.frecuencia--;
		if (frecuencia == 0) {
			this.ladrillosRestantes--;
			this.frecuencia = 10-dificultad;
			return true;
		}
		else return false;
	};

}
