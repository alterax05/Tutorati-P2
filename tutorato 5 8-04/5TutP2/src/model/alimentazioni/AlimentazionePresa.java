package model.alimentazioni;

import model.enums.Alimentazionie;

public class AlimentazionePresa extends AbstractAlimentazioneElettrica{

    public AlimentazionePresa(){
        this.mult = 2;
        this.al = Alimentazionie.Presa;
    }
}
