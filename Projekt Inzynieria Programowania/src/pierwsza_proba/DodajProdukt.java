package pierwsza_proba;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class DodajProdukt {

	private JFrame frame;
	private Socket socket = null;
	private boolean flag = true;
	private PrintWriter output = null;
	private BufferedReader input = null;
	/**
	 * @wbp.nonvisual location=91,-31
	 */
	private final JTextField textField = new JTextField();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public DodajProdukt(Socket socket) {
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
		textField.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDodawanieProduktu = new JLabel("Dodawanie produktu");
		lblDodawanieProduktu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		
		JLabel lblCena = new JLabel("Cena:");
		
		JLabel lblDataPrzydatnosci = new JLabel("Data \r\nprzydatnosci:");
		
		JLabel lblKategoria = new JLabel("Kategoria:");
		
		JLabel lblRodzajOpo = new JLabel("Rodzaj opodatkowania:");
		
		JLabel lblIlosc = new JLabel("Ilosc:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnDodajProdukt = new JButton("Dodaj produkt");
		
		JButton btnPowrot = new JButton("Powrot");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(132)
							.addComponent(lblDodawanieProduktu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(lblDataPrzydatnosci))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(51)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNazwa)
										.addComponent(lblCena)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addComponent(lblKategoria))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblRodzajOpo))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addComponent(lblIlosc)))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_3)
									.addComponent(textField_2, Alignment.TRAILING)
									.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
									.addComponent(textField_4))
								.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
					.addGap(25))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDodajProdukt)
					.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
					.addComponent(btnPowrot)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDodawanieProduktu)
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNazwa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCena))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataPrzydatnosci))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKategoria))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRodzajOpo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIlosc))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodajProdukt)
						.addComponent(btnPowrot))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
