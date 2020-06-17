package test;

import izlaz.RadSaMusterijama;
import modeli.Musterija;

public class Main {

	public static void main(String[] args) {
		
		Musterija musterija = RadSaMusterijama.ucitajMusteriju("2");
		musterija.setAdresa("Prde Prdica 28");;
		RadSaMusterijama.izmeniMusteriju(musterija);
	}
}