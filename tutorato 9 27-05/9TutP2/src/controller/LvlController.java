package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.bros.BroInterface;
import model.exceptions.CannotLevelUpException;
import view.BroComplexPane;

public class LvlController  implements EventHandler<ActionEvent> {

    private BroInterface bro;
    private BroComplexPane bcp;

    public LvlController(BroInterface b, BroComplexPane bp){
        this.bro = b;
        this.bcp = bp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.lvlup();
    }
    private void lvlup(){
        try {
            this.bro.lvlup();
            this.bcp.setLvl(this.bro.getLvl()+"");
            this.bcp.setAtk(this.bro.getAtk()+"");
            this.bcp.setHP(this.bro.getCurrMaxHP()+"");
        } catch (CannotLevelUpException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Livello massimo raggiunto");
            a.showAndWait();
        }
    }
}
