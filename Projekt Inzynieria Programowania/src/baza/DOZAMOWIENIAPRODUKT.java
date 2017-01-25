package baza;

import java.io.Serializable;

public class DOZAMOWIENIAPRODUKT implements Serializable {
 
	private int idZamowienia;
	private int idProduktu;

	public DOZAMOWIENIAPRODUKT(int idZamowienia, int idProduktu) {
		this.idZamowienia = idZamowienia;
		this.idProduktu = idProduktu;
	}

	@Override
	public String toString() {
		return "Do zamowienia produkt \nID Zamowienia = " + idZamowienia + "\nID Produktu = " + idProduktu;
	}

	public int getIdZamowienia() {
		return idZamowienia;
	}

	public int getIdProduktu() {
		return idProduktu;
	}

}
