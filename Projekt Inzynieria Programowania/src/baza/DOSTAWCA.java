package baza;

import java.io.Serializable;

public class DOSTAWCA implements Serializable {
 
	private int idDostawcy;
	private String nazwa;
	private int nrTel;
	private String email;

	public DOSTAWCA(int idDostawcy, String nazwa, int nrTel, String email) {
		this.idDostawcy = idDostawcy;
		this.nazwa = nazwa;
		this.nrTel = nrTel;
		this.email = email;
	}

	@Override
	public String toString() {
		return "DOSTAWCA: \nID = " + idDostawcy + "\nNazwa = " + nazwa + "\nNumer telefonu = " + nrTel + "\nEmail = "
				+ email;
	}

	public int getIdDostawcy() {
		return idDostawcy;
	}

	public String getNazwa() {
		return nazwa;
	}

	public int getNrTel() {
		return nrTel;
	}

	public String getEmail() {
		return email;
	}
}
