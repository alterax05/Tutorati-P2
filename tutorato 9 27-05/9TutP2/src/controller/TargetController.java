package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Target;
import model.exceptions.TargetDeadException;
import view.TargetPane;

public class TargetController implements EventHandler<ActionEvent> {

    private Target t;
    private TargetPane tp;

    public TargetController(Target t, TargetPane tp){
        this.t = t;
        this.tp = tp;
    }

    public Target getT() {
        return t;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.reset();
    }

    public void doDamage(int amt){
        try {
            this.t.decreaseHP(amt);
            this.updateTP();
        } catch (TargetDeadException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Killed, resetting");
            a.showAndWait();
            this.reset();
        }
    }
    private void reset(){
        this.t.reset();
        this.updateTP();
    }
    private void updateTP(){
        this.tp.setHp(this.t.getCurrHP()+"");
    }
}
