package es2_OOP;

public enum Morfologia {
    COCCO("Cocco", "Sferica"),
    BACILLO("Bacillo", "Bastoncino"),
    SPIRILLO("Spirillo", "Spirale");

    private final String label;
    private final String forma;

    Morfologia(String label, String forma) {
        this.label = label;
        this.forma = forma;
    }

    public String getForma() {
        return forma;
    }

    @Override
    public String toString() {
        return label;
    }
}
