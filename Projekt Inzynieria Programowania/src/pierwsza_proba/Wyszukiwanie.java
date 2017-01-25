package pierwsza_proba;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

public class Wyszukiwanie {

	private JFrame frame;
	private Socket socket = null;
	private boolean flag = true;
	private PrintWriter output = null;
	private BufferedReader input = null;

	public Wyszukiwanie(Socket socket) {
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
	}

}
