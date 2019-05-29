package practica_grafica_fichero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class datos {
	
	/* Pruebas unitarias de la clase
	 * 
	private static final int ID = 0;
	static ArrayList<String> listaCoches = new ArrayList<String>();
	
	public static void main(String[] args) {
		int maxID = 0;
		listaCoches.add("Pedro");
		listaCoches.add("Pedro1");
		listaCoches.add("Pedro2");
		listaCoches.add("Pedro3");
		maxID = listaCoches.size();
		escribirFichero(listaCoches, ID, maxID);
		leerFichero(listaCoches);
	}*/
	
	
	//Metodo que lee todo el contenido del fichero y lo mete en un arraylist String por String
	static void leerFichero(ArrayList<String> listaCoches) {
		
		File f = null;
		int id = 0; //puntero
		String fichero =  "coches.txt";
		
		try {
			f = new File(fichero);
			if (f.exists()) {
				
				try(DataInputStream dis=new DataInputStream(new FileInputStream(fichero));){
					
		            try {
						while (true) {
							listaCoches.add(id,dis.readUTF());
							id++;
						}
					} catch (EOFException e) {
						// TODO: handle exception
					}
		 
		        }catch(IOException e){
		            System.out.println("Error E/S");
		        }
				
			}

		} catch (Exception en) {
			System.out.println("Error 1: Leyendo Fichero");
			en.printStackTrace();
		} 

	}
	
	//Metodo que escribe el contenido de un arraylist en un fichero, string por string (Sobrescribe lo que habia antes)
	static void escribirFichero(ArrayList<String> listaCoches, int ID, int maxID) {
		
		String fichero = "coches.txt";
				
		File f = new File(fichero);
		
		try {
			if (f.exists()) {
				
		        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(fichero, false));){
		        	 
		            for (int i = 0; i < maxID; i++) {
		            	dos.writeUTF(listaCoches.get(i));
					}
		 
		        }catch(IOException e){
		            System.out.println("Error E/S");
		        }
			}

		} catch (Exception en) {
			en.printStackTrace();
		}
		
	}


}
