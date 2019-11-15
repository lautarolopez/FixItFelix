package logica;
import java.util.*;
public class Edificio {
	private ArrayList<Seccion> arregloSecciones;
	private int seccionActual;
	
	/**
	 * Crea un nuevo edificio con una secci�n Suelo, una Media y una M�s Alta. 
	 * Adem�s inicia con secci�nActual Suelo. 
	 * 
	 * @param dificultad La dificultad o nivel actual.**/
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
	
	/** Reinicia la secci�n actual, creando una nueva instancia correspondiente a la secci�n
	 * en la que se encuentra el juego y con �sta reemplaza la anteriormente existente.
	 * @param dificultad La dificultad o el nivel actual */
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
	
	/** Indica si la secci�n actual es la �ltima del nivel, y si esta etapa est� terminada.
	 * @return boolean Verdadero si todos los paneles de todas las ventanas de la �ltima secci�n est�n Sanos */
	public boolean nivelTerminado() {
		if (this.seccionActual == 2) {  
			return this.arregloSecciones.get(seccionActual).etapaTerminada(); 
		} else return false;
	}
	
	/** Indica si todos los paneles de la secci�n actual est�n sanos.
	 * @return boolean Verdadero si todos los paneles de la secci�n actual est�n sanos. */
	public boolean seccionTerminada() {
		return this.arregloSecciones.get(seccionActual).etapaTerminada();
	}
	
	public void proximaEtapa() {
		this.seccionActual++;
	}
	
	/**@return ArrayList<ArrayList<Ventana>> La matriz de ventanas correspondiente a la secci�n actual.*/
	public ArrayList<ArrayList<Ventana>> getVentanas(){
		return this.arregloSecciones.get(seccionActual).getEtapa();
	}
	
	public ArrayList<ArrayList<Ventana>> getVentanas(int secc){
		return this.arregloSecciones.get(secc).getEtapa();
	}	
	/**@return int La secci�n actual en la que nos encontramos, pudiendo ser 0, 1 o 2 para 
	 * Suelo, Media o M�sAlta */
	public int getSeccionActual() {
		return this.seccionActual;
	}
	
	/**@retun boolean Un valor aleatorio true o false. */
	public boolean generarPajaro() {
		if (this.seccionActual != 0) {
			return this.arregloSecciones.get(seccionActual).generarPajaro();
		} else return false;
	}
	
	

}
