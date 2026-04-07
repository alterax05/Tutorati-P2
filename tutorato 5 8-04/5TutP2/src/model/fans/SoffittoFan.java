package model.fans;

import model.alimentazioni.AbstractAlimentazione;
import model.alimentazioni.AbstractAlimentazioneElettrica;
import model.enums.Marche;
import model.enums.TipologiaFan;

import java.util.Date;

public class SoffittoFan extends AbstractFan{

    public SoffittoFan(AbstractAlimentazioneElettrica a, Marche marca){
        super(marca);
        this.tf = TipologiaFan.Soffitto;
        this.alimentazione = a;
        this.cost +=2;
        this.cost = this.calcolaCosto();
    }
}
