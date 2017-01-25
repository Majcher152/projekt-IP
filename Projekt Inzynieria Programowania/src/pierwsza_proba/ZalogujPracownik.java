package pierwsza_proba;

import java.awt.EventQueue;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class ZalogujPracownik {

	private JFrame frame;
	private Socket socket = null;
	private String login;
	private boolean flag = true;
	private PrintWriter output = null;
	private BufferedReader input = null;
 
	public ZalogujPracownik(String login, Socket socket) {
		this.login = login;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyActionListener myAction = new MyActionListener();

		JButton btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.addActionListener(myAction);

		JLabel lblWCzymMoge = new JLabel("Dostepne akcje ");
		lblWCzymMoge.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnDodajProdukt = new JButton("1. Dodaj produkt");
		btnDodajProdukt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnWyloguj.addActionListener(myAction);

		JButton btnZlozZamowienie = new JButton("2. Zloz zamowienie");
		btnZlozZamowienie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZlozZamowienie.addActionListener(myAction);

		JButton btnWyszukiwanie = new JButton("3. Wyszukiwanie");
		btnWyszukiwanie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnWyszukiwanie.addActionListener(myAction);

		JButton btnAnalizaProdukt = new JButton("4. Analiza produktu pod wzgledem daty waznosc");
		btnAnalizaProdukt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnalizaProdukt.addActionListener(myAction);

		JButton btnMojeDane = new JButton("5. Moje dane");
		btnMojeDane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMojeDane.addActionListener(myAction);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("ToolBar.background"));
		textArea.setEditable(false);
		textArea.setText(login);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(353, Short.MAX_VALUE)
						.addComponent(btnWyloguj).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(25).addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblWCzymMoge).addGap(71)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnMojeDane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAnalizaProdukt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnWyszukiwanie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnZlozZamowienie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDodajProdukt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 381,
										Short.MAX_VALUE)))
						.addContainerGap(28, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblWCzymMoge).addComponent(
						textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(11).addComponent(btnDodajProdukt).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnZlozZamowienie).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnWyszukiwanie).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnAnalizaProdukt).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnMojeDane)
				.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE).addComponent(btnWyloguj)
				.addContainerGap()));
		frame.getContentPane().setLayout(groupLayout);
	}

	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ustawienieInputOutput();
			String co = ((JButton) e.getSource()).getText();
			switch (co) {
			case "1. Dodaj produkt":
				break;
			case "2. Zloz zamowienie":
				break;
			case "3. Wyszukiwanie":
				break;
			case "4. Analiza produktu pod wzgledem daty waznosc":
				break;
			case "5. Moje dane":
				break;
			case "Wyloguj":
				// int tmp = JOptionPane.showConfirmDialog(null, "Czy na pewno
				// chcesz sie wylogowac?");
				// if (tmp == JOptionPane.YES_OPTION) {
				String mess = "Wyloguj";
				io(output, input, mess);
				frame.setVisible(false);
				new StronaGlowna(socket);
				break;
				// }
			//	break;
			}

		}

		private void ustawienieInputOutput() {
			try {
				output = new PrintWriter(socket.getOutputStream(), true);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		private void io(PrintWriter output, BufferedReader input, String mess) {
			flag = true;
			output.println(mess);
			output.flush();
		//	System.out.println("1");
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
