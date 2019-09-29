package logica;
public class Obstaculo {
	private boolean mold;
	private boolean mac;
	
	public Obstaculo(){
		double x = Math.random();
		this.mold = x < 0.71;
		x = Math.random();
		this.mac = x > 0.71;
	};
	
	public boolean tieneObstaculo(){
		return mold && mac;
	};
	
	public boolean tieneMoldura(){
		return mold;
	};
	
	public boolean tieneMacetero() {
		return mac;
	};
}
