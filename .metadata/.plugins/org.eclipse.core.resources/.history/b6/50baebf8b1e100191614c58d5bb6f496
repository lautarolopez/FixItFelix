package logica;
import java.math.*;
public class Estado {
	
	private String estadoPanel;
	
	public Estado(){
		double x = Math.random();
		if (x <= 0.33) {
			this.estadoPanel = "Roto";
		} else {
			if (x <= 0.66) {
				this.estadoPanel = "Casi Roto";
			} else {
				this.estadoPanel = "Sano";
			}
		}
	};
	
	public String getEstado(){
		return this.estadoPanel;
	};
	
	public boolean sePuedeReparar() {
		return estadoPanel.equalsIgnoreCase("Sano");
	};
}
