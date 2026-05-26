package view;

import controller.ComplexBroController;
import controller.LvlController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BroComplexPane extends StackPane {

//    private static final int SIZE = 100;
    private Circle c;
    private Rectangle r;
    private Text t_nome;
    private Text t_vita;
    private Text t_vel;
    private Text t_lvl;
    private Text t_atk;
    private Button b;

    public BroComplexPane(int circleradius, Color col, String n, String vi, String ve, String lv, String a, ComplexBroController cbc){
        this.c = new Circle(circleradius);
        c.setFill(Color.GREEN);
        this.r = new Rectangle(130, 90);
        r.setFill(col);
        this.t_nome = new Text(n);
        this.t_vita = new Text(vi);
        this.t_vel = new Text(ve);
        this.t_lvl = new Text(lv);
        this.t_atk = new Text(a);
        this.b = new Button("+");

        this.setEventHandler(MouseEvent.MOUSE_CLICKED, cbc);

        HBox nl = new HBox();
        nl.getChildren().add(this.t_nome);
        nl.getChildren().add(this.t_lvl);
        nl.setSpacing(10);
        nl.setAlignment(Pos.CENTER);

        HBox vv = new HBox();
        vv.getChildren().add(this.t_vita);
        vv.getChildren().add(this.t_vel);
        vv.setSpacing(10);
        vv.setAlignment(Pos.CENTER);

        VBox v = new VBox();
        v.getChildren().add(nl);
        v.getChildren().add(vv);
        v.getChildren().add(t_atk);
        v.setAlignment(Pos.CENTER);

        StackPane sp = new StackPane();
        sp.getChildren().add(r);
        sp.getChildren().add(v);

        HBox hb = new HBox();
        hb.getChildren().add(sp);
        hb.getChildren().add(b);
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);

        this.getChildren().add(c);
        this.getChildren().add(hb);
        this.setAlignment(Pos.CENTER);
    }

    public void setLvl(String lvl) {
        this.t_lvl.setText(lvl);
    }

    public void setAtk(String s) {
        this.t_atk.setText(s);
    }

    public void setHP(String s) {
        this.t_vita.setText(s);
    }

    public void setLvlController(LvlController lc){
        this.b.setOnAction(lc);
    }

}
