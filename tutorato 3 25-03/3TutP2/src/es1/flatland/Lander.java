package es1.flatland;

public abstract class Lander {
	protected int nDimensioni;

	public abstract void reameDimensionale ();

	public boolean compare(Lander otherLander){
		return this.nDimensioni > otherLander.nDimensioni;
	}
}
