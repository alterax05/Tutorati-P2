package es2_OOP;

public enum TipoMicroscopio {
    ELETTRONICO("elettronico"),
    OTTICO("ottico");

    private final String label;

    TipoMicroscopio(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
