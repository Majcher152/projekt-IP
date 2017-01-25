package baza;

import java.io.Serializable;
import java.util.Date;

public class PRACOWNIK implements Serializable {
 
	private int idPracownika;
	private String imie;
	private String nazwisko;
	private int pesel;
	private int nrTel;
	private String email;
	private String login;
	private String haslo;
	private boolean admin;

	public PRACOWNIK(int idPracownika, String imie, String nazwisko, int pesel, int nrTel, String email, String login,
			String haslo, boolean admin) {
		this.idPracownika = idPracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.nrTel = nrTel;
		this.email = email;
		this.login = login;
		this.haslo = haslo;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Pracownik: \nID = " + idPracownika + "\nImie = " + imie + "\nNazwisko = " + nazwisko + "\nPesel = "
				+ pesel + "\nNumer telefonu = " + nrTel + "\nEmail = " + email + "\nLogin = " + login + "\nHaslo = "
				+ haslo + "\nAdmin = " + admin;
	}

	public int getIdPracownika() {
		return idPracownika;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public int getPesel() {
		return pesel;
	}

	public int getNrTel() {
		return nrTel;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getHaslo() {
		return haslo;
	}

	public boolean isAdmin() {
		return admin;
	}
}
