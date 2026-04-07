package model.fans;

import model.alimentazioni.AbstractAlimentazione;
import model.enums.Marche;
import model.enums.TipologiaFan;

import java.util.Date;

public abstract class AbstractFan implements FanInterface{

    protected int cost =10;
    protected AbstractAlimentazione alimentazione;
    protected Marche marca;

    protected TipologiaFan tf;

    protected AbstractFan(Marche marca){
        this.marca = marca;
    }

    public int getCosto(){
        return this.cost;
    }

    protected int calcolaCosto(){
        this.cost = this.alimentazione.calcolaCostoFinale(this.cost);
        return this.cost;
    }

    public String toString(){
        return this.marca.toString()+" \n" +
                "Tipo: "+this.tf.name()+" " +
                "Alimentazione: "+this.alimentazione.toString()+"\n" +
                "Costo: "+this.cost;
    }

    public static int fanToInt(AbstractFan a){
        if (a instanceof PiantanaFan){
            return 0;
        }
        if (a instanceof PareteFan){
            return 1;
        }
        if (a instanceof SoffittoFan){
            return 2;
        }
        return -1;
    }
}
