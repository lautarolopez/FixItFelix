package logica;
public class Obstaculo {
	private boolean mold;
	private boolean mac;
	
	/**Establece aleatoriamente con un booleano los obstáculos Moldura y Macetero  **/
	public Obstaculo(){
		//double x = Math.random();
		//this.mold = x < 0.20;
		//double j = Math.random();
		//this.mac = j < 0.20;
		this.mold = false;
		this.mac = false;
	};

	
	public boolean tieneMoldura(){
		return mold;
	};
	
	public boolean tieneMacetero() {
		return mac;
	};
}
	