package model;

import controller.SubscriptionController;
import model.fans.AbstractFan;

import java.util.ArrayList;

public class Utente {

    private int funds=1000;
    private int monthlycosts=0;

    private final AbstractFan[] subscriptions;
    private int lastInsert = 0;

    public Utente(){
        subscriptions=new AbstractFan[5];
    }

    public int getCapitale() {
        return this.funds;
    }

    public void addSubscription(AbstractFan af) {
        if (lastInsert >= 5){
            return;
        }
        subscriptions[lastInsert] = af;
        lastInsert++;
    }

    public int spesaMensile() {
        int ret = 0;
        for (int i = 0; i < lastInsert; i++) {
            ret += subscriptions[i].getCosto();
        }
        this.monthlycosts = ret;
        return monthlycosts;
    }

    public boolean enoughFundsForOneMonth(){
        return this.funds > this.monthlycosts;
    }

    public void payOneMonth(){
        this.funds-=this.monthlycosts;
    }

    public boolean hasEnoughFundsFor(AbstractFan af) {
        return this.funds>af.getCosto();
    }

    public String toString(){
        String ret = "[";
        for (AbstractFan f :this.subscriptions) {
            ret += f.toString()+"\n,";
        }
        return ret+"]";
    }
}
