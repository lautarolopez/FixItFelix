package logica;
public class Posicion {
	private int posX;
	private int posY;
	
	public Posicion (int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	
	public void moverDer(){
		posX++;
	}
	
	public void moverIzq(){
		posX--;
	}
	
	public void moverAr(){
		posY++;
	}
	
	public void moverAb(){
		posY--;
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public boolean equals (Object o) {
		if ((o!= null) && (o instanceof Posicion)) {
			Posicion n = (Posicion)o;
			if ((this.posX == n.getX()) && (this.posY == n.getY())) {
				return true;
			} else {
				return false;
			}
		} else return false;
	}
	
	

}
