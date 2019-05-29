package practica_grafica_fichero;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class interfaz {
	
	//Metodo que introduce los componentes de la interfaz en un Jpanel
	private static void componentes(JPanel panel, String[] coche) {
		
		//Establecemos un layout nulo para colocar nosotros los componentes
		panel.setLayout(null);
		
		//--------------- Campos
		
		JLabel marcaLabel = new JLabel("Marca:");
		//X, Y, ancho, alto
		marcaLabel.setBounds(10, 10, 80, 25);
		panel.add(marcaLabel);

		JTextField marcaText = new JTextField(20);
		marcaText.setBounds(70, 15, 160, 25);
		panel.add(marcaText);
		
		JLabel modeloLabel = new JLabel("Modelo:");
		//X, Y, ancho, alto
		modeloLabel.setBounds(10, 40, 80, 25);
		panel.add(modeloLabel);

		JTextField modeloText = new JTextField(20);
		modeloText.setBounds(70, 45, 160, 25);
		panel.add(modeloText);
		
		JLabel colorLabel = new JLabel("Color:");
		//X, Y, ancho, alto
		colorLabel.setBounds(10, 70, 80, 25);
		panel.add(colorLabel);

		JTextField colorText = new JTextField(20);
		colorText.setBounds(70, 75, 160, 25);
		panel.add(colorText);
		
		JLabel puertasLabel = new JLabel("Puertas:");
		//X, Y, ancho, alto
		puertasLabel.setBounds(10, 100, 80, 25);
		panel.add(puertasLabel);
		
		JTextField puertasText = new JTextField(20);
		puertasText.setBounds(70, 105, 160, 25);
		panel.add(puertasText);
		
		//--------------------- Ubicación Texto para Botones
		JLabel navegacionLabel = new JLabel("Navegación:");
		//X, Y, ancho, alto
		navegacionLabel.setBounds(285, 5, 80, 25);
		panel.add(navegacionLabel);
		//Le añado un underLine
		Font font = navegacionLabel.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		navegacionLabel.setFont(font.deriveFont(attributes));
		
		JLabel edicionLabel = new JLabel("Edicion:");
		//X, Y, ancho, alto
		edicionLabel.setBounds(10, 150, 80, 25);
		panel.add(edicionLabel);
		//Le añado un underLine
		Font fontA = navegacionLabel.getFont();
		Map attributesA = fontA.getAttributes();
		attributesA.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		edicionLabel.setFont(fontA.deriveFont(attributesA));

		//------------------ Botones Navegación
		JButton avanzarButton = new JButton("Avanzar");
		avanzarButton.setBounds(270, 30, 100, 25);
		panel.add(avanzarButton);
		
		JButton atrasButton = new JButton("Atras");
		atrasButton.setBounds(270, 60, 100, 25);
		panel.add(atrasButton);
		
		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(270, 90, 100, 25);
		panel.add(salirButton);
		
		//------------------- Botones Edicion
		
		JButton insertarButton = new JButton("Insertar");
		insertarButton.setBounds(80, 150, 80, 30);
		panel.add(insertarButton);
		
		JButton modificarButton = new JButton("Modificar");
		modificarButton.setBounds(180, 150, 100, 30);
		panel.add(modificarButton);
		
		JButton eliminarButton = new JButton("Eliminar");
		eliminarButton.setBounds(300, 150, 80, 30);
		panel.add(eliminarButton);
		
		//#################### Escuchadores de eventos de navegación
		
		avanzarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ID<maxID) {
					ID++;
					if (ID<maxID) {
						actualizarCampos(marcaText, modeloText, colorText, puertasText);
					} else {
						marcaText.setText("");
						modeloText.setText("");
						colorText.setText("");
						puertasText.setText("");
					}
				}else if(ID==maxID){
					avanzarButton.setEnabled(false);
				}
				
				loop(avanzarButton, atrasButton);
			}
		});
		
		atrasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ID>0) {
					ID--;
					avanzarButton.setEnabled(true);
				}else if (ID==0) {
					atrasButton.setEnabled(false);
				}
				actualizarCampos(marcaText, modeloText, colorText, puertasText);
				loop(avanzarButton, atrasButton);
			}
		});
		
		salirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loop(avanzarButton, atrasButton);
				System.exit(0);
			}
		});
		
		//#################### Escuchadores de eventos de edicion
		
		insertarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Insertando");
				
				if (ID==maxID) {
					coche[0]=marcaText.getText();
					coche[1]=modeloText.getText();
					coche[2]=colorText.getText();
					coche[3]=puertasText.getText();
					
					if (listaCoches.size()==1) {
						listaCoches.add(coche[0]+"; "+coche[1]+"; "+coche[2]+"; "+coche[3]+"; ."+"\r\n");					
						loop(avanzarButton, atrasButton);
					}
					
					if(((marcaText.getText()=="")||(modeloText.getText()=="")||(colorText.getText()=="")||(puertasText.getText()==""))==true) {
						JOptionPane.showMessageDialog(null, "Error: Ningun campo puede estar vacio");
					}else {
						listaCoches.add(coche[0]+"; "+coche[1]+"; "+coche[2]+"; "+coche[3]+"; ."+"\r\n");					
						loop(avanzarButton, atrasButton);
					}
					avanzarButton.setEnabled(true);
					actualizarCampos(marcaText, modeloText, colorText, puertasText);
				}else {
					JOptionPane.showMessageDialog(null, "Esta entrada ya esta en la tabla, tal vez desee modificarla");
				}
				
				
				
			}
		});
		
		modificarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Modificando");
				coche[0]=marcaText.getText();
				coche[1]=modeloText.getText();
				coche[2]=colorText.getText();
				coche[3]=puertasText.getText();
				
				if(((marcaText.getText()=="")||(modeloText.getText()=="")||(colorText.getText()=="")||(puertasText.getText()==""))==true) {
					JOptionPane.showMessageDialog(null, "Error: Ningun campo puede estar vacio");
				}else {
					listaCoches.add(ID, coche[0]+"; "+coche[1]+"; "+coche[2]+"; "+coche[3]+"; ."+"\r\n");					
					loop(avanzarButton, atrasButton);
				}
			}
		});
		
		eliminarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Eliminando");
				//Elimino el item del arrayList
				listaCoches.remove(ID);
				
				//Pasamos al siguiente elemento de la lista
				if (ID<(maxID-1)) {
					ID++;
					actualizarCampos(marcaText, modeloText, colorText, puertasText);
				}else if((ID>0)&&(ID<maxID)){
					ID--;
					actualizarCampos(marcaText, modeloText, colorText, puertasText);
				}else if (ID==0) {
					ID++;
					marcaText.setText("");
					modeloText.setText("");
					colorText.setText("");
					puertasText.setText("");
					avanzarButton.setEnabled(false);
					
				}
				
				//Actualizo el fichero
				loop(avanzarButton, atrasButton);
				
				
			}
		});
		
		
		try {
			//Por defecto actualiza la primera posicion de los archivos del fichero (ID inicializado en 0)
			actualizarCampos(marcaText, modeloText, colorText, puertasText);
		}catch (Exception e) {
			// TODO: handle exception
			marcaText.setText("");
			modeloText.setText("");
			colorText.setText("");
			puertasText.setText("");
		}
		
		//Hago el Loop Inicial
		loop(avanzarButton, atrasButton);
		
	}

	//Metodo extraido que me genera la ventana grafica y sus componentes
	private static void generarVentana(String[] coche) {
		//Creamos el marco y le damos un tamaño
		JFrame frame = new JFrame("Programa: Gestion de Coches");
		frame.setSize(450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creamos un contenedor donde agregaremos los objetos
		JPanel panel = new JPanel();
		//le añadimos el contenedor al marco
		frame.add(panel);
		//le añadimos los componentes al contenedor
		componentes(panel, coche);
		//hacemos visible el marco
		frame.setVisible(true);
	}

	//Metodo local que me actualiza los campos de la parte grafica del programa
	private static void actualizarCampos(JTextField marcaText, JTextField modeloText, JTextField colorText,
			JTextField puertasText) {
		String string = listaCoches.get(ID);;
		String[] parts = string.split("; ");
		String Marca = parts[0];
		String Modelo = parts[1];
		String Color = parts[2];
		String Puertas = parts[3];
		
		// Por defecto cargamos el primer dato del fichero
		marcaText.setText(Marca+" ID: "+ID);
		modeloText.setText(Modelo+" Size: "+listaCoches.size());
		colorText.setText(Color);
		puertasText.setText(Puertas);
	}
	
	// Metodo de comprobaciones que se ejecuta cada vez que se cree un boton
	private static void loop(JButton avanzarButton, JButton atrasButton) {
		
		//Actualizo el tamaño maximo del puntero
		maxID = listaCoches.size();
		
		//Escribir/Actualizar Fichero Prueba
		datos.escribirFichero(listaCoches, ID, maxID);
		
		//Resetear estado de botones
		if(ID==listaCoches.size()){
			avanzarButton.setEnabled(false);
		}else if (ID<(listaCoches.size()-1)) {
			avanzarButton.setEnabled(true);
		}
		if (ID==0) {
			atrasButton.setEnabled(false);
		}else if (ID>0) {
			atrasButton.setEnabled(true);
		}
		
		//Retoques Finales
		if (listaCoches.size()<=0) {
			atrasButton.setEnabled(false);
		}
		
		
		
	}
	
	//Atributos Globales
		//Array que tendra la lista de coches de forma permanente
	private static ArrayList<String> listaCoches = new ArrayList<String>();
	private static int maxID = 0; //Atributo auxiliar que contiene el tamaño de listadeCoches, lo mantengo por legibilidad del codigo
	private static int ID = 0; //Puntero global
	
	public static void main(String[] args) {	
		
		//Vector Auxiliar que contendrá la información del coche de forma temporal
		String[] coche = new String[4];
		
		//leer/cargar contenido del archivo en listaCoches - //Si el archivo no existe, lo crea coches.txt
		datos.leerFichero(listaCoches);
		
		
		//Actualizo el tamaño maximo del puntero
		maxID = listaCoches.size();
		
		
		//generar la ventana (le paso por referencia las variables con las que trabaja el programa)
		generarVentana(coche);
		
		/*Pasamos a modo de escucha de eventos, esperamos hasta que el usuario interactue con el programa
		 * 
		 * 	botones segun acciones: 
		 * 
		 * Botones: 
	 			Navegación:
					Avanzar
					Atras
					Salir
				Edicion: 
					Insertar
						Inserta los datos de los inputs en el array, luego lo guarda en el fichero siguiendo un orden
					Modificar
						Modifica los datos de los inputs en esa posicion del array, luego lo guarda en el fichero
					Eliminar
						Inserta los datos de los inputs en el array, luego lo guarda en el fichero
		 * 
		 * */
		
	}
}
