package logica;

public class SeccionMasAlta extends Seccion{
	
	public void generarPajaro(){};

	public SeccionMasAlta() {
		this.etapa = new Ventana[5][3];
		Posicion posi;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 2; y++) {
				posi = new Posicion(x, y);
				double r = Math.random();
				if (r < 0.70) {
					this.etapa[x][x] = new VentanaNormal(posi);
				} else {
					this.etapa[x][y] = new VentanaConHojas(posi);
				}
			}
		}
	}
}
