package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.bros.AbstractBro;

public class ComplexBroController implements EventHandler<MouseEvent> {

    private AbstractBro bro;
    private TargetController tc;

    public ComplexBroController(AbstractBro b, TargetController t){
        this.bro = b;
        this.tc = t;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        int amt = this.bro.getDannoFinale();
        this.tc.doDamage(amt);
    }
}
