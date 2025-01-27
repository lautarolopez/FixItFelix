package logica;

import java.util.*;
public class SeccionMasAlta extends Seccion{
	

	/**@param dificultad Dificultad o nivel actual */
	public SeccionMasAlta(int dificultad) { //Genera aleatoriamente una matriz de ventanas normales o con hojas, con mayor probabilidad de normales. FALTA IMPLEMENTAR QUE LA PROBABILIDAD CAMBIE CON LA DIFICULTAD.
		this.etapa = new ArrayList<ArrayList<Ventana>>();
		ArrayList<Ventana> auxVentanas1 = new ArrayList<Ventana>();
		ArrayList<Ventana> auxVentanas2 = new ArrayList<Ventana>();
		ArrayList<Ventana> auxVentanas3 = new ArrayList<Ventana>();
		ArrayList<Ventana> auxVentanas4 = new ArrayList<Ventana>();
		ArrayList<Ventana> auxVentanas5 = new ArrayList<Ventana>();
		this.etapa.add(auxVentanas1);
		this.etapa.add(auxVentanas2);
		this.etapa.add(auxVentanas3);
		this.etapa.add(auxVentanas4);
		this.etapa.add(auxVentanas5);
		Posicion posi;
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 3; y++) {
				posi = new Posicion(x, y);
				double r = Math.random();
				if (r < 0.70) {
					Ventana aux = new VentanaNormal(posi, dificultad);
					this.etapa.get(x).add(aux); 
				} else {
					Ventana aux = new VentanaConHojas(posi);
					this.etapa.get(x).add(aux);
				}
			}
		}
	}
	
	/**@return boolean Devuelve un valor aleatorio true o false */
	public boolean generarPajaro() {
		double a = Math.random();
		return a < 0.40;
	};
}
