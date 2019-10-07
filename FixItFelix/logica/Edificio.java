package logica;
import java.util.*;
public class Edificio {
	private ArrayList<Seccion> arregloSecciones;
	private int seccionActual;
	
	/**Crea un nuevo edificio con una sección Suelo, una Media y una Más Alta. Además inicia con secciónActual Suelo. **/
	public Edificio(int dificultad) {
		Seccion a = new SeccionSuelo(dificultad);
		Seccion b = new SeccionMedio(dificultad);
		Seccion c = new SeccionMasAlta(dificultad);
		this.arregloSecciones = new ArrayList<Seccion>();
		this.arregloSecciones.add(a);
		this.arregloSecciones.add(b);
		this.arregloSecciones.add(c);
		this.seccionActual = 0;	
	}
	
	public void reiniciarEtapa(int dificultad) {
		Seccion aux;
		switch (this.seccionActual) {
			case 0: {
				aux = new SeccionSuelo(dificultad);
				this.arregloSecciones.set(this.seccionActual, aux);
			}
			case 1: {
				aux = new SeccionMedio(dificultad);
				this.arregloSecciones.set(this.seccionActual, aux);
			}
			case 2: {
				aux = new SeccionMasAlta(dificultad);
				this.arregloSecciones.set(this.seccionActual, aux);
			}
		}
	}
	
	public boolean nivelTerminado() {
		if (this.seccionActual == 2) {  //Si estamos en la última sección, devuelve verdadero si está terminada
			return this.arregloSecciones.get(seccionActual).etapaTerminada(); 
		} else return false;
	}
	
	public boolean seccionTerminada() {
		return this.arregloSecciones.get(seccionActual).etapaTerminada();
	}
	
	public void proximaEtapa() {
		this.seccionActual++;
	}
	
	public ArrayList<ArrayList<Ventana>> getVentanas(){
		return this.arregloSecciones.get(seccionActual).getEtapa();
	}
	
	public int getSeccionActual() {
		return this.seccionActual;
	}
	
	public boolean generarPajaro() {
		if (this.seccionActual != 0) {
			return this.arregloSecciones.get(seccionActual).generarPajaro();
		} else return false;
	}
	

}
