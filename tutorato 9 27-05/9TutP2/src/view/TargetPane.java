package view;

import controller.TargetController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TargetPane extends HBox {

    private Text hp;
    private Button reset;

    public TargetPane(String h){
        this.hp = new Text("HP: "+h);
        this.reset = new Button("Reset");

        this.getChildren().add(this.hp);
        this.getChildren().add(this.reset);

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER_LEFT);
    }

    public void setReset(TargetController tc){
        this.reset.setOnAction(tc);
    }

    public void setHp(String n){
        this.hp.setText("HP "+n);
    }

}
