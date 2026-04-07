package model.alimentazioni;

import model.enums.Alimentazionie;

public class AlimentazioneBatteria extends AbstractAlimentazioneElettrica{

    public AlimentazioneBatteria(){
        this.mult = 3;
        this.al = Alimentazionie.Batteria;
    }
}
