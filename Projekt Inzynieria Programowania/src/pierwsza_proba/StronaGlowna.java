package pierwsza_proba;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

public class StronaGlowna {

	private JFrame frame;
	private PrintWriter output = null;
	private BufferedReader input = null;
	private Socket socket = null;
	private boolean flag = true;
	private JTextField textField_login;
	private JPasswordField passwordField;
 
	/**
	 * Create the application.
	 */
	public StronaGlowna(Socket socket) {
		this.socket = socket;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyActionListener myAction = new MyActionListener();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblWitaj = new JLabel("Witaj");
		lblWitaj.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_login = new JTextField();
		textField_login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_login.setColumns(10);

		JLabel lblHaslo = new JLabel("Haslo:");
		lblHaslo.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnWyjscie = new JButton("Wyjscie");
		btnWyjscie.setBackground(UIManager.getColor("ToggleButton.light"));
		btnWyjscie.addActionListener(myAction);

		

		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.setBackground(UIManager.getColor("ToggleButton.light"));
		btnZaloguj.addActionListener(myAction);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, btnWyjscie, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnWyjscie, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblHaslo, 120, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblHaslo, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_login, 67, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_login, 66, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_login, 266, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 70, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogin, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblWitaj, 11, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWitaj, 184, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, btnZaloguj, 23, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, btnZaloguj, 0, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblHaslo);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField_login);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, textField_login);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(lblWitaj);
		frame.getContentPane().add(lblLogin);
		frame.getContentPane().add(textField_login);
		frame.getContentPane().add(lblHaslo);
		frame.getContentPane().add(btnZaloguj);
		frame.getContentPane().add(btnWyjscie);
	}

	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ustawienieInputOutput();
			String co = ((JButton) e.getSource()).getText();
			switch (co) {
			case "Zaloguj":
				String login = textField_login.getText();
				String haslo1 = passwordField.getText();
				if (sprawdzanieHasla(login, haslo1)) {
					new ZalogujPracownik(login, socket);
					frame.setVisible(false);
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Niepoprawny login lub haslo");
					break;
				}
			case "Wyjscie":
				int tmp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz opuscic program?");
				if (tmp == JOptionPane.YES_OPTION) {
					String mess = "Wyjscie";
					io(output, input, mess);
					frame.setVisible(false);
					System.exit(0);
					break;
				}
			}

		}

		private void ustawienieInputOutput() {
			try {
				output = new PrintWriter(socket.getOutputStream(), true);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

		private boolean sprawdzanieHasla(String login, String haslo) {
			output.println("Zaloguj");
			output.flush();
			output.println(login);
			output.flush();
			output.println(haslo);
			output.flush();
			boolean flagHaslo = true;
			while (flagHaslo) {
				try {
					if (input.ready()) {
						String loginHaslo = input.readLine();
						System.out.println("Haslo " + loginHaslo);
						if (loginHaslo.contains("Poprawne"))
							return true;
						else
							return false;

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			return false;
		}

		private void io(PrintWriter output, BufferedReader input, String mess) {
			flag = true;
			output.println(mess);
			output.flush();
			while (flag) {
				try {
					if (input.ready()) {
						String aaa = input.readLine();
						System.out.println(aaa);
						flag = false;
					}
				} catch (IOException e1) {
					System.out.println("5");
					e1.printStackTrace();
				}
			}
		}
	}
}
// dodac produkt k
// podejrzec swoje dane
// lista kategorii -> lista produktow k
// robienie zamowienie na brakujace produkty k
// lista produktow ktorych data waznosci sie konczy
// po cenie
//