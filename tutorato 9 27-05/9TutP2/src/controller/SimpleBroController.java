package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.bros.AbstractBro;
import view.MainView;

public class SimpleBroController implements EventHandler<MouseEvent> {

    private AbstractBro bro;
    private MainView mv;
    private TargetController t;

    public SimpleBroController(AbstractBro b, MainView m, TargetController t){
        this.bro = b;
        this.mv = m;
        this.t = t;
    }

    @Override
    public void handle(MouseEvent event) {
        this.mv.setCenterBro(this.bro, this.t);
    }
}
