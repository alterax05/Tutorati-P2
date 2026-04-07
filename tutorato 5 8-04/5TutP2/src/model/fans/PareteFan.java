package model.fans;

import model.alimentazioni.AbstractAlimentazione;
import model.enums.Marche;
import model.enums.TipologiaFan;

import java.util.Date;

public class PareteFan extends AbstractFan{
    public PareteFan(AbstractAlimentazione a, Marche marca){
        super(marca);
        this.tf = TipologiaFan.Parete;
        this.alimentazione = a;
        this.cost +=20;
        this.cost = this.calcolaCosto();
    }
}
