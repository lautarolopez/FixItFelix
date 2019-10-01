package logica;
import java.util.*;

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
	
	
	public void ciclo(String dir, int martillazos) {
		
		if (this.tiempo != 0 && this.pj.getVidas() !=0 && this.dificultad < 11) { ///Ejecuta el ciclo si todav�a hay tiempo, si F�lix todav�a tiene vidas y si no terminamos los diez niveles.
		
			//// BLOQUE DE ACCIONES
			
			
			
			/**Suma puntos si F�lix repara una ventana**/
			this.player.setPuntaje(this.pj.repararVentana(this.tablero.getVentanas(), martillazos, this.tablero.nivelTerminado()));
			
			System.out.println("1------------------------");
			
			
			this.gestionarColisiones();
			
			System.out.println("2------------------------");
			
			
			////BLOQUE DE ACTUALIZACIONES
			
			
			/**Si el tablero decide generar un p�jaro agrega un Objeto P�jaro a los elementos de la partida,
			 * instanci�ndolo con una altura aleatoria y una direcci�n (si comienza a la izquierda o derecha) aleatoria. **/
			if (tablero.generarPajaro()) {
				Posicion posi = new Posicion(0, 0);
				Objeto p = new Pajaro(posi, this.tablero.getVentanas());
				this.objetosPartida.add(p);
			}

			System.out.println("3------------------------");

			
			/**Si Ralph decide generar un ladrillo agrega un nuevo Objeto Ladrillo al vector de objetos de la partida, 
			 * instanci�dolo con una posici�n aleatoria en x y siempre en la parte m�s alta de la secci�n. **/
			if (boss.generarLadrillo(dificultad)) {
				Posicion posi = new Posicion(0, 0);
				Objeto l = new Ladrillo(posi, this.tablero.getVentanas());
				this.objetosPartida.add(l);
			}

			System.out.println("4------------------------");

			
			/**Actualiza todos los objetos del arreglo de Objetos de la partida, cada uno implementa 
			 * una actualizaci�n distinta. Adem�s, si hay un Nicelander pregunta si hay que generar una torta. En tal caso
			 * crea un nuevo Objeto Torta en la posici�n del Nicelander. **/
			for (Objeto obj : this.objetosPartida) {
				obj.actualizar(dificultad, this.tablero.getVentanas());
			}
			
			System.out.println("5------------------------");
			
			
			
			/**MOVER Y TODAS LAS COMPARACIONES SE FUERON A UN M�TODO DE F�LIX. **/
			this.pj.mover(dir, this.tablero.getVentanas());
			
			System.out.println("6------------------------");
			
			
			
			/**Pregunta a cada elemento si debe destruirlo. De ser as� lo elimina del arreglo de objetos de la partida. 
			 * Cada Objeto sabe cu�ndo debe ser destru�do. **/
			Iterator<Objeto> iter = this.objetosPartida.iterator();
			while (iter.hasNext()) {
				Objeto obj = iter.next();
				if (obj.destruir()) iter.remove();;
			}
			
			
			System.out.println("7------------------------");
			
			
			for (Ventana[] arrVent : this.tablero.getVentanas()) {
				for (Ventana vent : arrVent) {
					if (vent.generarNicelander()) {
						Objeto n = new Nicelander(vent.getPos(), this.tablero.getVentanas());
						this.objetosPartida.add(n);
					}
				}
			}

			
			System.out.println("8------------------------");

			
			
			/**Si se termin� el nivel se crea un nuevo tablero con mayor dificultad. Es importante
			 * verificar primero el nivel y luego la etapa porque si terminamos la �ltima etapa el
			 * tablero va a intentar llevarnos a la etapa 4 del nivel, que no existe. **/
			if (this.tablero.nivelTerminado()) {
				this.dificultad++;
				this.tablero = new Edificio (dificultad);
				this.pj.reset();
				this.objetosPartida.removeAll(objetosPartida);
			}
			
			System.out.println("9------------------------");

			
			
			/** Si termina la secci�n avanzamos a la pr�xima etapa.**/
			if (this.tablero.seccionTerminada()) {
				this.tablero.proximaEtapa();
				this.pj.reset();
				this.objetosPartida.removeAll(objetosPartida);
			}
			
			System.out.println("10------------------------");
			
		
			this.tiempo--; //Decrementamos el tiempo para el pr�ximo ciclo.
			System.out.println("FINDECICLOFINDECICLOFINDECICLOFINDECICLOFINDECICLO");
		
		} else { //Si el tiempo o las vidas de F�lix llegan a cero se termina el juego. Si la dificultad (que a su vez es el nivel) es mayor que diez el jugador gan� el juego.
			if (this.dificultad <= 10) {
				System.out.print("Game over!");
			} else {
				System.out.print("Ganaste cruck!");
			}
			
		}
		
	}
	
	private void gestionarColisiones() {
		if (this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].pajaro()) {
			this.objetosPartida.removeAll(objetosPartida);
			this.tablero.reiniciarEtapa(dificultad);
			this.pj.reset();
		} else {
			if (this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].ladrillo()) {
				this.pj.perderVida();
				this.tablero = new Edificio(dificultad);
				this.objetosPartida.removeAll(objetosPartida);
				this.pj.reset();
			} else {
				if (this.tablero.getVentanas()[this.pj.getPosFelix().getX()][this.pj.getPosFelix().getY()].ladrillo()){
					this.pj.setInvulnerable();
				}
			}
		}
	}
	
	
	
}
