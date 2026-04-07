package model.alimentazioni;

import model.enums.Alimentazionie;


public abstract class AbstractAlimentazione {
    protected int mult;
    protected Alimentazionie al;

    public int calcolaCostoFinale(int costo){
        return mult * costo;
    }

    public String toString(){
        return this.al.name();
    }
}
