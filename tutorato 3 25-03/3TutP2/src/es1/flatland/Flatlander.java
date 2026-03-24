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

	// In generale si tende ad evitare l'utilizzo di instanceof all'interno dei metodi
	// L'unica eccezione alla regola è il metodo equals
	// In questo caso, come avremmo potuto modificare la firma del metodo per evitare l'uso di instance of?
	public boolean isGenitore(Lander possibleParent){
		return (this.genere == Genere.POLIGONO) &&
				(possibleParent instanceof Flatlander) &&
				(((Flatlander) possibleParent).lati == this.lati - 1);
	}
}
