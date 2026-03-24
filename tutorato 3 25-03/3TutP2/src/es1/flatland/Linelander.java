package es1.flatland;

public class Linelander extends Lander{
	public enum Genere {
		RETTA, PUNTO
	}

	private Genere genere;

	public Linelander(Genere genere){
		this.genere = genere;
		this.nDimensioni = 1;
	}

	public Linelander(){
		this.genere = Genere.PUNTO;
		this.nDimensioni = 1;
	}

	@Override
	public void reameDimensionale () {
		System.out.println("Sono un Linelander " + this.genere + " quindi ho " +
				this.nDimensioni + " dimensione");
	}
}
