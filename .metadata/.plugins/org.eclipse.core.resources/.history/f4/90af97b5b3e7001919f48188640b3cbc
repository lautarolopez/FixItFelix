package logica;

public class SeccionMasAlta extends Seccion{
	

	public SeccionMasAlta(int dificultad) { //Genera aleatoriamente una matriz de ventanas normales o con hojas, con mayor probabilidad de normales. FALTA IMPLEMENTAR QUE LA PROBABILIDAD CAMBIE CON LA DIFICULTAD.
		this.etapa = new Ventana[5][3];
		Posicion posi;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 2; y++) {
				posi = new Posicion(x, y);
				double r = Math.random();
				if (r < 0.70) {
					this.etapa[x][y] = new VentanaNormal(posi, dificultad);
				} else {
					this.etapa[x][y] = new VentanaConHojas(posi);
				}
			}
		}
	}
	
	public Ventana[][] getVentanas(){
		return this.etapa;
	}
	
	public boolean generarPajaro() {
		double a = Math.random();
		return a < 0.20;
	};
}
