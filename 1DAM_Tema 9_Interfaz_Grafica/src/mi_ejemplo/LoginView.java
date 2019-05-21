package mi_ejemplo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {
	
	//	Atributos Globales
	static JTextField userText = new JTextField(20);
	

	public static void main(String[] args) {
		//Creamos el Marco con el nombre de la ventana, le asignamos tamaño y acción de cierre
		JFrame frame = new JFrame("Demo application");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creamos el panel contenedor que lo tendrá todo
		JPanel panel = new JPanel();
		//Añadimos el panel a la ventana/marco
		frame.add(panel);
		//Le añadimos al panel los elementos que hemos creado en un metodo
		placeComponents(panel);
		//Hacemos que se muestre por pantalla
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		//Establecemos el payout que usaremos para la interfaz grafica
		panel.setLayout(null);
		//Creamos una etiqueta con el string "User", la colocamos (X,Y,ANCHO,TAMAÑO) y luego la añadimos al panel
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		
		//Hacemos lo mismo pero con un campo de texto
//		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);
		
		//Creamos una etiqueta con el string "Password", la colocamos (X,Y,ANCHO,TAMAÑO) y luego la añadimos al panel
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);
		
		//Volvemos a hacer lo mismo pero con un campo de texto que esconde el texto escrito en el
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);
		
		//Creamos 2 botones y los colocamos
		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		
		//Creamos un evento y se lo asignamos al boton de login
		ActionListener myButtonListener = new myButtonListener();
		loginButton.addActionListener(myButtonListener);
		
		//Creamos un evento y se lo asignamos al boton de register pero de forma corta
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bienvenido "+userText.getText());
				
			}
		});
		
	}

}
