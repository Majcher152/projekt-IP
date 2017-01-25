package baza;

import java.io.Serializable;
import java.util.Date;

public class PRODUKT implements Serializable {
 
	private int idProduktu;
	private int cena;
	private Date dataPrzydatnosc;
	private String kategoria;
	private int rodzajOpodatkowania;
	private int ilosc;
	private String nazwa;

	public PRODUKT(int idProduktu, int cena, Date dataPrzydatnosc, String kategoria, int rodzajOpodatkowania,
			int ilosc, String nazwa) {
		this.idProduktu = idProduktu;
		this.cena = cena;
		this.dataPrzydatnosc = dataPrzydatnosc;
		this.kategoria = kategoria;
		this.rodzajOpodatkowania = rodzajOpodatkowania;
		this.ilosc = ilosc;
		this.nazwa = nazwa;
	}

	@Override
	public String toString() {
		return "Produkt \nID = " + idProduktu + "\nNazwa = " + nazwa + "\nCena = " + cena + "\nData przydatnosc = " + dataPrzydatnosc
				+ "\nKategoria = " + kategoria + "\nRodzaj opodatkowania = " + rodzajOpodatkowania + "\nIlosc = "
				+ ilosc;
	}

	public String getNazwa() {
		return nazwa;
	}

	public int getIdProduktu() {
		return idProduktu;
	}

	public int getCena() {
		return cena;
	}

	public Date getDataPrzydatnosc() {
		return dataPrzydatnosc;
	}

	public String getKategoria() {
		return kategoria;
	}

	public int getRodzajOpodatkowania() {
		return rodzajOpodatkowania;
	}

	public int getIlosc() {
		return ilosc;
	}
}
