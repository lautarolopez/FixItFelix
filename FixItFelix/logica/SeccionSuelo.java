package logica;
import java.util.*;
public class SeccionSuelo extends Seccion {

	/**@param dificultad Dificultad o nivel actual */
	public SeccionSuelo(int dificultad) { //Crea aletoriamente una matriz de ventanas aleatorias, y en el medio del piso más bajo la ventana es semicircular con 4 paneles.
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
		for (int x = 0; x <= 4; x++) {
			for (int y = 0; y <= 2; y++) {
				posi = new Posicion(x, y);
				if ((x == 2) && (y == 0)) {
					Ventana aux = new VentanaSemicircular(posi, (this instanceof SeccionSuelo), dificultad); //el constructor de la clase VentanaSemicircular recibe también un booleano para saber si pertenece al suelo o al primer piso.
					this.etapa.get(x).add(aux);
				} else {
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
	}
	
	
	
	
}
