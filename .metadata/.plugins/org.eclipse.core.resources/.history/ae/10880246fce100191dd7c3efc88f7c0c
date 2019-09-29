package logica;
import java.math.*;
public class Seccion {

	protected Ventana[][] etapa;
	
/** Incia la etapa creando una matriz de ventanas. En la posición x=2 y=0 se crea una nueva ventana semicircular.
 Si la instancia actual es la sección del suelo, entonces la ventana semicircular es de 4 paneles, en otro caso
 la sección es la del medio, por lo que la ventana circular es de 8 paneles. La sección superior
 sobreescribe este constructor, por lo que no se ve afectada por esto. El resto de las ventanas 
 se crean de forma aleatoria como instancias de ventanas normales o ventanas con hojas, con mayor
 probabilidad de ventanas normales. **/	
	public Seccion() {
		this.etapa = new Ventana[5][3];
		Posicion posi;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 2; y++) {
				posi = new Posicion(x, y);
				if ((x == 2) && (y == 0)) {
					this.etapa[x][y] = new VentanaSemicircular(posi, (this instanceof SeccionSuelo)); //el constructor de la clase VentanaSemicircular recibe también un booleano para saber si pertenece al suelo o al primer piso.
				} else {
					double r = Math.random();
					if (r < 0.70) {
						this.etapa[x][x] = new VentanaNormal(posi);
					} else {
						this.etapa[x][y] = new VentanaConHojas(posi);
					}
				}
			}
		}
	};
	
	public void nuevaEtapa(){};
}
