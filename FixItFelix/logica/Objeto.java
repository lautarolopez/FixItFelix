package logica;
public abstract class Objeto {
	protected Posicion posObjeto;
	
	public Objeto (Posicion posi, Ventana[][] etapa){}
	
	public abstract Posicion getPosicion();
	
	public abstract boolean destruir();
	
	public abstract void actualizar (int dificultad, Ventana[][] etapa);
	
}
