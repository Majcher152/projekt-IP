package baza;

import java.io.Serializable;

public class PARAGONPRODUKT implements Serializable {

	private int idParagonu;
	private int idProduktu;

	public PARAGONPRODUKT(int idParagonu, int idProduktu) {
		this.idParagonu = idParagonu;
		this.idProduktu = idProduktu;
	}

	@Override
	public String toString() {
		return "Paragon produkt \nID Paragonu = " + idParagonu + "\nID Produktu = " + idProduktu;
	}

	public int getIdParagonu() {
		return idParagonu;
	}

	public int getIdProduktu() {
		return idProduktu;
	}

}
