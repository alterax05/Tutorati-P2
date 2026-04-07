package model;

import model.alimentazioni.AlimentazioneBatteria;
import model.alimentazioni.AlimentazioneMeccanica;
import model.alimentazioni.AlimentazionePresa;
import model.enums.Marche;
import model.fans.AbstractFan;
import model.fans.PareteFan;
import model.fans.PiantanaFan;
import model.fans.SoffittoFan;

import java.util.ArrayList;

public class Vetrina {
    public AbstractFan[] fandisponibili = new AbstractFan[5];

    public Vetrina(){
        PiantanaFan f1 = new PiantanaFan(
                new AlimentazioneBatteria(),
                Marche.Ariete
        );
        this.fandisponibili[0] = (f1);

        PareteFan f2 = new PareteFan(
                new AlimentazionePresa(),
                Marche.Bosch
        );
        this.fandisponibili[1] = (f2);

        PareteFan f3 = new PareteFan(
                new AlimentazioneMeccanica(),
                Marche.Bosch
        );
        this.fandisponibili[2] = (f3);

        SoffittoFan f4 = new SoffittoFan(
                new AlimentazioneBatteria(),
                Marche.Bosch
        );
        this.fandisponibili[3] = (f4);

        SoffittoFan f5 = new SoffittoFan(
                new AlimentazionePresa(),
                Marche.Parkside
        );
        this.fandisponibili[4] = (f5);
    }

    public String toString(){
        String ret = "[";
        for (AbstractFan f :this.fandisponibili) {
            ret += f.toString()+"\n,";
        }
        return ret+"]";
    }
}
