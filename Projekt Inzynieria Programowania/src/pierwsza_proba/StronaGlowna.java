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

public class StronaGlowna {

	private JFrame frame;
	private PrintWriter output = null;
	private BufferedReader input = null;
	private Socket socket = null;
	private boolean flag = true;
	private JTextField textField_login;
	private JTextField textField_haslo;
 
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

		textField_haslo = new JTextField();
		textField_haslo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_haslo.setColumns(10);

		JButton btnWyjscie = new JButton("Wyjscie");
		btnWyjscie.setBackground(new Color(255, 255, 255));


		

		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.setBackground(new Color(255, 255, 255));
		btnZaloguj.addActionListener(myAction);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addGap(184).addComponent(lblWitaj))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(lblLogin).addGap(18).addComponent(textField_login,
												GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblHaslo)
										.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnZaloguj).addComponent(textField_haslo))))
						.addContainerGap(168, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(335, Short.MAX_VALUE)
						.addComponent(btnWyjscie).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblWitaj).addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblLogin).addComponent(
						textField_login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblHaslo).addComponent(
						textField_haslo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnZaloguj).addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
				.addComponent(btnWyjscie).addContainerGap()));
		frame.getContentPane().setLayout(groupLayout);
	}

	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ustawienieInputOutput();
			String co = ((JButton) e.getSource()).getText();
			switch (co) {
			case "Zaloguj":
				String login = textField_login.getText();
				String haslo1 = textField_haslo.getText();
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