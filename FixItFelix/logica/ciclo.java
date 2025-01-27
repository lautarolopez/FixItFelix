/**Cada ciclo representa una unidad de tiempo del juego, donde se hacen todas las comprobaciones y comparaciones
	 * necesarias.
	 * @param dir Direcci�n en la que debe moverse F�lix en este ciclo
	 * @param martillazos Cantidad de martillazos que debe dar F�lix en este ciclo
	 * @return boolean verdadero si la partida termin�, por haber terminado 10 niveles, porque se
	 * agot� el tiempo o porque F�lix se qued� sin vidas  **/
public boolean ciclo(String dir, int martillazos) {
		
		if (this.tiempo != 0 && this.pj.getVidas() !=0 && this.dificultad < 11) { ///Ejecuta el ciclo si todav�a hay tiempo, si F�lix todav�a tiene vidas y si no terminamos los diez niveles.
		
			//// BLOQUE DE ACCIONES
			
			
			
			/**Suma puntos si F�lix repara una ventana. (Set puntaje aumenta el puntaje, no lo setea.)**/
			this.player.setPuntaje(this.pj.repararVentana(this.tablero.getVentanas(), martillazos, this.tablero.nivelTerminado()));
			
			
			/**M�todo privado que analiza si hubo alg�n evento entre F�lix y los objetos de la partida que afecte
			 *  el estado de la partida. **/
			this.gestionarColisiones();
			
			/**Si el tablero decide generar un p�jaro (es aleatorio) agrega un Objeto P�jaro a los elementos de la partida.**/
			if (tablero.generarPajaro()) {
				Posicion posi = new Posicion(0, 0);
				Objeto p = new Pajaro(posi, this.tablero.getVentanas());
				this.objetosPartida.add(p);
				System.out.println("Se cre� un p�jaro en " + p.getPosicion().toString());
			}
			
			
			/**Si Ralph decide generar un ladrillo agrega un nuevo Objeto Ladrillo al vector de objetos de la partida. **/
			if (boss.generarLadrillo(dificultad)) {
				Posicion posi = new Posicion(0, 0);
				Objeto l = new Ladrillo(posi, this.tablero.getVentanas());
				this.objetosPartida.add(l);
				System.out.println("Se cre� un ladrillo en " + l.getPosicion().toString());
			}
			///Con respecto a los ladrillos, la interpretaci�n del enunciado fue que Ralph lanzaba ladrillos
			///de a uno por vez, aunque despu�s jugando a la versi�n original vimos que lanza varios ladrillos
			///simult�neamente. En tal caso solo agregar�amos un for (0 a dificultad) para que haga esta acci�n
			///y se generen m�s ladrillos.
			
			
			
			////BLOQUE DE ACTUALIZACIONES
	
			/**Actualiza todos los objetos del arreglo de Objetos de la partida, cada uno implementa 
			 * una actualizaci�n distinta. Adem�s consulta si debe generar alguna torta, solo los nicelanders
			 * responder�n verdadero si corresponde, entonces crea una nueva instancia de Objeto Torta y la agrega
			 * a una lista auxiliar. Si se agreg� efectivamente alg�n elemento a la lista auxiliar, �sta se agrega
			 * a la lista de objetos de la partida.**/
			ArrayList<Objeto> auxObj = new ArrayList<Objeto>();
			for (Objeto obj : this.objetosPartida) {
				obj.actualizar(dificultad, this.tablero.getVentanas());
				if (obj.generarTorta()) {
					Objeto t = new Torta(obj.getPosicion(), this.tablero.getVentanas());
					auxObj.add(t);
					System.out.println("Se cre� una torta en " + t.getPosicion().toString());
				}
			}
			if (!(auxObj.isEmpty())) this.objetosPartida.addAll(auxObj);
			
			
			
			
			/** Consulta a todas las ventanas si debe generar un Nicelander. Cada ventana lo implementa a su manera. Si le retornan
			 * verdadero crea una nueva instancia de Objeto Nicelander y lo agrega a la lista de elementos de la partida.  **/
			for (ArrayList<Ventana> arrVent : this.tablero.getVentanas()) {
				for (Ventana vent : arrVent) {
					if (vent.generarNicelander()) {
						Objeto n = new Nicelander(vent.getPos(), this.tablero.getVentanas());
						this.objetosPartida.add(n);
						System.out.println("Se cre� un Nicelander en " + n.getPosicion().toString());
					}
				}
			}
			
			
			
			/**Pregunta a cada elemento si debe destruirlo. De ser as� lo elimina del arreglo de objetos de la partida. 
			 * Cada Objeto sabe cu�ndo debe ser destru�do. **/
			Iterator<Objeto> iter = this.objetosPartida.iterator();
			while (iter.hasNext()) {
				Objeto obj = iter.next();
				if (obj.destruir()) {
					System.out.println("Se destruy� " + obj.toString() + " por terminar su ciclo de vida.");
					iter.remove();
				};
			}
			
						
			// Actualiza el tiempo de invulnerabilidad de F�lix
			this.pj.actualizarFelix();
					
			
			/**Si se termin� el nivel se crea un nuevo tablero con mayor dificultad. Es importante
			 * verificar primero el nivel y luego la etapa porque si terminamos la �ltima etapa el
			 * tablero va a intentar llevarnos a la etapa 4 del nivel, que no existe. **/
			if (this.tablero.nivelTerminado()) {
				this.dificultad++;
				this.tablero = new Edificio (dificultad);
				this.pj.reset();
				this.objetosPartida.removeAll(objetosPartida);
				System.out.println("Terminaste el nivel " + dificultad + ", felicidades!");
			}
			
			
			
			/** Si termina la secci�n avanzamos a la pr�xima etapa.**/
			if (this.tablero.seccionTerminada()) {
				this.tablero.proximaEtapa();
				this.pj.reset();
				this.objetosPartida.removeAll(objetosPartida);
				System.out.println("Siguiente etapa.");
			}
			
			
			////BLOQUE DE INFORMACI�N DE ESTADO ////
			/** Este bloque brinda informaci�n del estado de la partida para verificar el correcto funcionamiento de todo el 
			 * ecosistema del juego en curso. **/
			this.tiempo--; //Decrementamos el tiempo para el pr�ximo ciclo.
			System.out.println("Tiempo restante: " + tiempo);
			System.out.println("Vidas restantes: " + pj.getVidas());
			System.out.println("Nivel actual: " + dificultad);
			switch (this.tablero.getSeccionActual()) {
			case 0: {
				System.out.println("Secci�n actual: Suelo");
				break;
			}
			case 1:{
				System.out.println("Secci�n actual: Media");
				break;
			}
			case 2:{
				System.out.println("Secci�n actual: M�s alta");
				break;
			}
			}
			System.out.println("-------------------------FIN DE CICLO-----------------------");
			return false;
		
		} else { //Si el tiempo o las vidas de F�lix llegan a cero se termina el juego. Si la dificultad (que a su vez es el nivel) es mayor que diez el jugador gan� el juego.
			if (this.dificultad <= 10) {
				System.out.println("Game over!");
			} else {
				System.out.println("Ganaste cruck!");
			}
		return true;	
		}
		
	}