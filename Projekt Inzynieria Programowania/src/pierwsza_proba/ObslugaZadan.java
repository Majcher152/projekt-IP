package pierwsza_proba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ObslugaZadan extends Thread {
	private int paczka_ID = 0;
	// Strumienie gniazda komunikacji z klientem(odczyt + zapis)
	private BufferedReader in = null;
	private PrintWriter out = null;
	// Gniazdo klienta
	private Socket connection = null;
	private boolean flag = true;

	PolaczenieZBazaDanych polaczenieBD;

	public ObslugaZadan(Socket connection, PolaczenieZBazaDanych polaczenieBD) {
		// Ustawienie gniazda klienta
		this.connection = connection;
		this.polaczenieBD = polaczenieBD;
		// Klient.ktoryKlient++;
	}

	public void run() {
		// Utworzenie strumieni kominukacji z klientem (odczyt+zapis)
		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			out = new PrintWriter(connection.getOutputStream(), true);
			out.println("Klient "); // + KlientSerwer.ktoryKlient);
			out.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (flag) {
			try {
				String komunikat = "";
				if (in.ready()) {
					komunikat = in.readLine();
					ObslugaKomunikatowOdKlienta(komunikat);
				}
			} catch (Exception exc) {
				System.out.println(flag + " 2");
				exc.printStackTrace();
				System.out.println(flag + " 3");
				// Zamkniecie gniazda klienta
				try {
					connection.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;

			}
		}

	}

	private void ObslugaKomunikatowOdKlienta(String komunikat) {
		if (komunikat.contains("Zaloguj")) {
			String login = odczytWiadomosciOdKlienta();
			String haslo = odczytWiadomosciOdKlienta();
			String czyHasloPoprawne = sprawdzanieHasla(login, haslo);
			out.println(czyHasloPoprawne + " ... OK");
			out.flush();
		} else if (komunikat.contains("Wyloguj")) {
			out.println(komunikat + " ... OK");
			out.flush();
		} else if (komunikat.contains("Wyjscie")) {
			out.println(komunikat + " ... Exit");
			out.flush();
		}
	}

	private String odczytWiadomosciOdKlienta() {
		boolean flagWiadomoscOdKlienta = true;
		String wiadomoscOdKlienta = null;
		while (flagWiadomoscOdKlienta) {
			try {
				if (in.ready()) {
					wiadomoscOdKlienta = in.readLine();
					flagWiadomoscOdKlienta = false;
				}
			} catch (Exception exc) {
				exc.printStackTrace();
				try {
					// Zamkniecie gniazda klienta
					connection.close();
					flagWiadomoscOdKlienta = false;
				} catch (Exception e) {
				}
			}
		}
		return wiadomoscOdKlienta;
	}

	private String sprawdzanieHasla(String login, String haslo) {
		if (polaczenieBD.czyHasloPoprawne(login, haslo)) {
			return "Poprawne";
		} else
			return "Bledne";
	}
}
