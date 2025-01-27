package logica;

import java.io.*;
public class Fichero{
		String[] nombres = new String[5];
		int[] puntos = new int[5];
		int[] stats = new int[5];
		public String[] getNombres() {
			return nombres;
		}

		public int[] getPuntos() {
			return puntos;
		}
		
		public int[] getStats() {
			return stats;
		}
		
		public void leer() {
			String g,linea="";
		    for (int i=0;i<5;i++) {
		    	nombres[i]=" ";
		    	puntos[i]=0;
		    }
			try { /**
			        *SI SALTA AL TRY BUSCA LOS DATOS ALMACENADOS DE DATA
			        */
				FileReader in= new FileReader("data.txt"); 
				BufferedReader buffer= new BufferedReader(in);
			    int pos=0;
			    linea=buffer.readLine();
			    while(linea!=null){
			    	
					for(int i=0;i<linea.length();i++) {
						   if(linea.charAt(i)==':') {
							   nombres[pos]=linea.substring(0, i);
							   g=linea.substring((i+1));
							   puntos[pos]= Integer.parseInt(g);
						   }
						}
					pos++;
					linea=buffer.readLine();
			    }
			    buffer.close();
			}
			catch(IOException e){ /**
			                       *SI SALTA AL CATCH CREA UN DATA.TXT
				                  */
				try {           
	 				FileWriter out= new FileWriter("data.txt");
					BufferedWriter buffer= new BufferedWriter(out);
					linea= "puesto1" +":"+ puntos[0] + "\n" + "puesto2" +":"+ puntos[1] + "\n" + "puesto3" +":"+ puntos[2] + "\n" + "puesto4" +":"+ puntos[3] + "\n" + "puesto5" +":"+ puntos[4] + "\n";
				    buffer.write(linea);
				    buffer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		public void escribir(String [] nombres, int[] puntos) {
			try {
				String linea;
				FileWriter out= new FileWriter("data.txt");
				BufferedWriter buffer= new BufferedWriter(out);
				linea= nombres[0] +":"+ puntos[0] + "\n" + nombres[1] +":"+ puntos[1] + "\n" + nombres[2] +":"+ puntos[2] + "\n" + nombres[3] +":"+ puntos[3] + "\n" + nombres[4] +":"+ puntos[4] + "\n";
				buffer.write(linea);
			    buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void leerEstadisticas () {
			for (int i=0;i<2;i++) {
		    	stats[i]=0;
		    }
			String linea;
			try { /**
			        *SI SALTA AL TRY BUSCA LOS DATOS ALMACENADOS DE ESTADISTICAS
			        */
				FileReader in= new FileReader("estadisticas.txt"); 
				BufferedReader buffer= new BufferedReader(in);
			    int pos=0;
			    int j=0;
			    String g;
			    linea=buffer.readLine();
			    if (linea!=null){
					for(int i=0;i<linea.length();i++) {
						   if(linea.charAt(i)==':') {
							   g=linea.substring(0, i);
							   stats[pos]=Integer.parseInt(g);
							   j=i;
							   pos++;
						   }
						   if(linea.charAt(i)==';') {
							   g=linea.substring(j+1, i);
							   stats[pos]=Integer.parseInt(g);
							   pos++;
							   g=linea.substring((i+1));
							   stats[pos]=Integer.parseInt(g);
						   }
						}
			    }
			    buffer.close();
			}
			catch(IOException e){ /**
			                       *SI SALTA AL CATCH CREA UN ESTADISTICAS.TXT
				                  */
				try {           
	 				FileWriter out= new FileWriter("estadisticas.txt");
					BufferedWriter buffer= new BufferedWriter(out);
					linea= stats[0] +":"+ stats[1] + ";" + stats[2];
				    buffer.write(linea);
				    buffer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}}
			public void escribirEstadisticas (int [] stats) {
				try {
					String linea;
					FileWriter out= new FileWriter("estadisticas.txt");
					BufferedWriter buffer= new BufferedWriter(out);
					linea= stats[0] +":"+ stats[1] + ";" + stats[2];
					buffer.write(linea);
				    buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			public void aumentarCont(int x, Fichero f) {
				f.leerEstadisticas();
				int[]aux=f.getStats();
				aux[x]++;
				f.escribirEstadisticas(aux);
			}
}