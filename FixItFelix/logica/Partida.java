package logica;
import java.util.ArrayList;

public class Partida {

	private int tiempo;
	private int dificultad;
	private Felix pj;
	private Ralph boss;
	private Jugador player;
	private Edificio tablero;
	private ArrayList<Objeto> objetosPartida;
	
	public Partida(String nombre) {
		this.tiempo = 120;
		this.dificultad = 1;
		this.pj = new Felix();
		this.boss = new Ralph();
		this.player = new Jugador(nombre);
		this.tablero = new Edificio(this.dificultad);
		this.objetosPartida = new ArrayList<Objeto>();
	}
	
	
	public void ciclo(String dir, boolean martillazo) {
		
		if (this.tiempo != 0 && this.pj.getVidas() !=0) {
		
			//// BLOQUE DE ACCIONES
			
			/**Si F�lix da un martillazo en este ciclo repara la ventana en la que se encuentra siempre y cuando
			 * �sta tenga al menos un panel roto. Si el nivel termina el jugador obtiene 500 puntos pr arreglar
			 * el panel, de lo contrario obtiene 100 puntos.**/
			if (!this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].arreglada()) {
				if (martillazo) {
					this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].reparar();
					if (this.tablero.nivelTerminado()) {
						this.player.setPuntaje(500);
					} else {
						this.player.setPuntaje(100);
					}
				}
			}
			
			
			/**Recorre los objetos de la partida, si alguno est� en la posici�n de F�lix, de acuerdo a qu� objeto es
			 * se realizan las acciones correspondientes. **/
			for(Objeto obj : this.objetosPartida) {
				if (obj.getPosicion().equals(pj.getPosFelix())) {	
					if (obj instanceof Torta) {
						this.pj.setInvulnerable();
						this.objetosPartida.remove(obj);
					} else {
						if (obj instanceof Pajaro) {
							this.objetosPartida.removeAll(objetosPartida);
							this.tablero.reiniciarEtapa(dificultad);
						} else {
							if (obj instanceof Ladrillo) {
								this.pj.perderVida();
								this.tablero = new Edificio(dificultad);
								this.objetosPartida.removeAll(objetosPartida);
							}
						}
					}
				}
				if (dificultad != 1) { ///Si la dificultad es mayor a 1 los ladrillos se saltean posiciones, por eso hay que comparar que la posici�n de F�lix no est� entre la ubicaci�n actual del ladrillo y lo que se desplaz� en este ciclo.
					if (obj instanceof Ladrillo) {
						if (obj.getPosicion().getX() == this.pj.getPosFelix().getX()) {
							if((obj.getPosicion().getY() <= this.pj.getPosFelix().getY()) && (this.pj.getPosFelix().getY() <= (obj.getPosicion().getY()+dificultad))) {
								this.pj.perderVida();
								this.tablero = new Edificio(dificultad);
								this.objetosPartida.removeAll(objetosPartida);
							}
							}
					}
				}
			}
			
			
			////BLOQUE DE ACTUALIZACIONES
			
			if (tablero.generarPajaro()) {
				int y = (int) (Math.random()*2);
				double a = Math.random();
				int x = 0;
				if (a < 0.50) x = 4;
				Posicion posi = new Posicion(x, y);
				Objeto p = new Pajaro(posi);
				this.objetosPartida.add(p);
			}
			
			if (boss.generarLadrillo(dificultad)) {
				int x = (int) (Math.random()*4);
				Posicion posi = new Posicion(x, 2);
				Objeto l = new Ladrillo(posi);
				this.objetosPartida.add(l);
			}
			
			
			for (Objeto obj : this.objetosPartida) {
				obj.actualizar(dificultad);
				if (obj instanceof Nicelander) {
					Nicelander aux = (Nicelander)obj;
					if (aux.generarTorta()) {
						Objeto t = new Torta(aux.getPosicion());
						this.objetosPartida.add(t);
					}
				}
			}
			
			switch(dir) {
				case "Arriba": {
					if (this.pj.getPosFelix().getY()+1 < 3) {
						if (!this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()+1].tieneMacetero()) {
							if (!this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].tieneMoldura()) {
								this.pj.actualizarFelix(dir);
							}
						}
					}
				};
				case "Abajo": {
					if (this.pj.getPosFelix().getY()-1 > 0) {
						if (!this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()-1].tieneMoldura()) {
							if (!this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].tieneMacetero()) {
								this.pj.actualizarFelix(dir);
							}
						}
					}
				};
				case "Izquierda": {
					if (this.pj.getPosFelix().getX()-1 > 0) {
						if ((this.tablero.getVentanas()[this.pj.getPosFelix().getX()-1][this.pj.getPosFelix().getY()] instanceof VentanaConHojas)) {
							VentanaConHojas aux = (VentanaConHojas)this.tablero.getVentanas()[this.pj.getPosFelix().getX()-1][this.pj.getPosFelix().getY()]; 
							if (aux.estaAbierta()) {
								this.pj.actualizarFelix(dir);
							}
						} else {
							this.pj.actualizarFelix(dir);
						}
					}
				};
				case "Derecha": {
					if (this.pj.getPosFelix().getX()+1 < 5) {
						if ((this.tablero.getVentanas()[this.pj.getPosFelix().getX()+1][this.pj.getPosFelix().getY()] instanceof VentanaConHojas)) {
							VentanaConHojas aux = (VentanaConHojas)this.tablero.getVentanas()[this.pj.getPosFelix().getX()+1][this.pj.getPosFelix().getY()]; 
							if (aux.estaAbierta()) {
								this.pj.actualizarFelix(dir);
							}
						} else {
							this.pj.actualizarFelix(dir);
						}
					}
				};
			}
			
			
			for (Objeto obj : this.objetosPartida) {
				if (obj.destruir()) this.objetosPartida.remove(obj);
			}
		
			this.tiempo--;
		}
	}
	
	
	
	
}
