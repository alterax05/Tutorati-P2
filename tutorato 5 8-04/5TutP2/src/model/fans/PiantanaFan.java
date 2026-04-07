package model.fans;

import model.alimentazioni.AbstractAlimentazione;
import model.enums.Marche;
import model.enums.TipologiaFan;

import java.util.Date;

public class PiantanaFan extends AbstractFan{

    public PiantanaFan(AbstractAlimentazione a, Marche marca){
        super(marca);
        this.tf = TipologiaFan.Piantana;
        this.alimentazione = a;
        this.cost +=10;
        this.cost = this.calcolaCosto();
    }
}
