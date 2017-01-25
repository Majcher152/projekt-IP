package baza;

import java.io.Serializable;

public class DOZAMOWIENIA implements Serializable {
 
	private int idZamowienia;
	private int idPracownika;
	private int idDostawcy;

	public DOZAMOWIENIA(int idZamowienia, int idPracownika, int idDostawcy) {
		this.idZamowienia = idZamowienia;
		this.idPracownika = idPracownika;
		this.idDostawcy = idDostawcy;
	}

	@Override
	public String toString() {
		return "Do zamowienia: \nID = " + idZamowienia + "\nID Pracownika = " + idPracownika + "\nID Dostawcy = "
				+ idDostawcy;
	}

	public int getIdZamowienia() {
		return idZamowienia;
	}

	public int getIdPracownika() {
		return idPracownika;
	}

	public int getIdDostawcy() {
		return idDostawcy;
	}
}
