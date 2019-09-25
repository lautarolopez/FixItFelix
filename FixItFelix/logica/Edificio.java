package logica;
public class Edificio {
	private Seccion[] arregloSecciones;
	
	public Edificio() {
		Seccion a = new SeccionSuelo();
		Seccion b = new SeccionMedio();
		Seccion c = new SeccionMasAlta();
		this.arregloSecciones = new Seccion[2];
		this.arregloSecciones[0] = a;
		this.arregloSecciones[1] = b;
		this.arregloSecciones[2] = c;
	}
	
	public void generarNivel() {};
}
