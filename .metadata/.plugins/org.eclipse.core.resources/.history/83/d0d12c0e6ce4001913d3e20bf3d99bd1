package logica;

public class SeccionMedio extends Seccion {
	
	public SeccionMedio(int dificultad) { //Similar al constructor de la Seccion Suelo, pero avisa por booleano que es la Sección Medio.
		this.etapa = new Ventana[5][3];
		Posicion posi;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 2; y++) {
				posi = new Posicion(x, y);
				if ((x == 2) && (y == 0)) {
					this.etapa[x][y] = new VentanaSemicircular(posi, !(this instanceof SeccionMedio), dificultad); //el constructor de la clase VentanaSemicircular recibe también un booleano para saber si pertenece al suelo o al primer piso.
				} else {
					double r = Math.random();
					if (r < 0.70) {
						this.etapa[x][y] = new VentanaNormal(posi, dificultad);
					} else {
						this.etapa[x][y] = new VentanaConHojas(posi);
					}
				}
			}
		}
	}
	
	public boolean generarPajaro() { //Devuelve aleatoriamente si generar un pájaro o no.
		double a = Math.random();
		return a < 0.20;
	};
}
