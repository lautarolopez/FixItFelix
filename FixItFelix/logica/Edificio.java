package logica;
public class Edificio {
	private Seccion[] arregloSecciones;
	private int seccionActual;
	
	public Edificio(int dificultad) {
		Seccion a = new SeccionSuelo(dificultad);
		Seccion b = new SeccionMedio(dificultad);
		Seccion c = new SeccionMasAlta(dificultad);
		this.arregloSecciones = new Seccion[2];
		this.arregloSecciones[0] = a;
		this.arregloSecciones[1] = b;
		this.arregloSecciones[2] = c;
		this.seccionActual = 0;
	}
	
	public void reiniciarEtapa(int dificultad) {
		Seccion aux;
		switch (this.seccionActual) {
			case 0: {
				aux = new SeccionSuelo(dificultad);
				this.arregloSecciones[this.seccionActual] = aux;
			}
			case 1: {
				aux = new SeccionMedio(dificultad);
				this.arregloSecciones[this.seccionActual] = aux;
			}
			case 2: {
				aux = new SeccionMasAlta(dificultad);
				this.arregloSecciones[this.seccionActual] = aux;
			}
		}
	}
	
	public boolean nivelTerminado() {
		for (Seccion secc : this.arregloSecciones) {
			if (!secc.etapaTerminada())	return false;
		}
		return true;
	}
	
	public Ventana[][] getVentanas(){
		return this.arregloSecciones[this.seccionActual].getEtapa();
	}
	
	public int getSeccionActual() {
		return this.seccionActual;
	}
	
}
