package logica;

public class SeccionSuelo extends Seccion {

	public SeccionSuelo(int dificultad) {
		this.etapa = new Ventana[5][3];
		Posicion posi;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 2; y++) {
				posi = new Posicion(x, y);
				if ((x == 2) && (y == 0)) {
					this.etapa[x][y] = new VentanaSemicircular(posi, (this instanceof SeccionSuelo), dificultad); //el constructor de la clase VentanaSemicircular recibe tambi�n un booleano para saber si pertenece al suelo o al primer piso.
				} else {
					double r = Math.random();
					if (r < 0.70) {
						this.etapa[x][x] = new VentanaNormal(posi, dificultad);
					} else {
						this.etapa[x][y] = new VentanaConHojas(posi);
					}
				}
			}
		}
	}
	
	
	
}
