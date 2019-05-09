/**
 * 
 */
package interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.*;

/**
 * @author pedro
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame ventana = new JFrame();
		JPanel panel = new JPanel();
		JLabel etiqueta = new JLabel("Hola Mundo");
		
		JTextField nombre = new JTextField(20);
		JButton inicio = new JButton("Empezar");
		FlowLayout lienzo = new FlowLayout();
		
		
		lienzo.setVgap(5);
		lienzo.setHgap(5);
		
		
		panel.setLayout(lienzo);
		lienzo.setAlignment(FlowLayout.CENTER);
		
		panel.add(etiqueta);
		panel.add(nombre);
		panel.add(inicio);
		ventana.setContentPane(panel);
		ventana.setLocation(200,200);
		ventana.setSize(320, 320);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
