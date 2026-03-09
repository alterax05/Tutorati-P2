package es1_OOP;

public class Nave {
    private final Auto[] autoArray;
    private int lastInsert;

    public Nave(int capacity) {
        assert (capacity > 0);
        lastInsert = -1;
        this.autoArray = new Auto[capacity];
    }

    // carica la prima Auto disponibile nell'array; ritorna true se caricata, false se piena
    public boolean caricaAuto(Auto a) {
        if(lastInsert == autoArray.length - 1) {
            return false;
        }
        this.lastInsert++;
        autoArray[lastInsert] = a;
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nave(capacità=").append(autoArray.length).append(", macchine=[");
        for (int i = 0; i < autoArray.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(autoArray[i] == null ? "null" : autoArray[i].toString());
        }
        sb.append("])");
        return sb.toString();
    }
}
