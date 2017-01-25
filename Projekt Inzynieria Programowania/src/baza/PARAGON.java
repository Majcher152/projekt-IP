package baza;

import java.io.Serializable;

public class PARAGON implements Serializable {
 
	private int idParagonu;
	private int idPracownika;

	public PARAGON(int idParagonu, int idPracownika) {
		this.idParagonu = idParagonu;
		this.idPracownika = idPracownika;
	}

	@Override
	public String toString() {
		return "Paragon \nID = " + idParagonu + "\nID Pracownika = " + idPracownika;
	}

	public int getIdParagonu() {
		return idParagonu;
	}

	public int getIdPracownika() {
		return idPracownika;
	}

}
