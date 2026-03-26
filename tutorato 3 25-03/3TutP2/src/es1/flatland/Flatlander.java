package es1.flatland;

import java.util.Objects;

public class Flatlander extends Lander {
	public enum Genere {
		POLIGONO, SEGMENTO
	}

	private Genere genere;
	private int lati;

	public Flatlander(Genere genere, int lati){
		this.genere = genere;
		this.lati = (this.genere == Genere.POLIGONO)? lati: 0;
		this.nDimensioni = 2;
	}

	@Override
	public void reameDimensionale () {
		System.out.println("Sono un Flatlander " + this.genere +" quindi ho " + this.lati + " lati e " +
				this.nDimensioni + " dimensioni");
	}
}
