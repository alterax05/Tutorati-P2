package view;

import controller.ComplexBroController;
import controller.LvlController;
import controller.SimpleBroController;
import controller.TargetController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Target;
import model.bros.AbstractBro;
import model.bros.comparators.BroHpComparator;

import java.util.ArrayList;
import java.util.Collections;

public class MainView extends BorderPane {
    private static final int SIZE = 300;

    private StackPane c;
    private Rectangle r;
    private ArrayList<AbstractBro> bros;

    public MainView(ArrayList<AbstractBro> bb, Target t){
        this.bros = bb;

        TargetPane tp = new TargetPane(t.getCurrHP()+"");
        TargetController tc = new TargetController(t,tp);
        tp.setReset(tc);
        this.setBottom(tp);

        this.drawTop(tc);

        Button sbhp = new Button("Ordina per Vita");
        sbhp.setOnAction(
                event -> {
                    BroHpComparator bhp = new BroHpComparator();
                    this.bros.sort(bhp);
                    this.drawTop(tc);
                }
        );
        Button sbpn = new Button("Ordina per Nome");
        sbpn.setOnAction(
                event -> {
                    Collections.sort(this.bros);
                    this.drawTop(tc);
                }
        );
        VBox v = new VBox();
        v.getChildren().add(sbhp);
        v.getChildren().add(sbpn);
        v.setSpacing(10);
        v.setAlignment(Pos.TOP_CENTER);
        this.setLeft(v);

        r = new Rectangle(SIZE, SIZE);
        r.setFill(Color.BLACK);
        this.c = new StackPane();
        this.c.getChildren().add(r);
        this.setCenter(c);
    }

    public void setCenterBro(AbstractBro bro, TargetController tc) {
        ComplexBroController cbc = new ComplexBroController(bro, tc);
        BroComplexPane bcp = new BroComplexPane(
                bro.getRange(), bro.getBroCol(),
                bro.getName(), bro.getCurrMaxHP()+"",
                bro.getSpeed(), bro.getLvl()+"",
                bro.getAtk(),
                cbc
        );
        LvlController lc = new LvlController(bro, bcp);
        bcp.setLvlController(lc);

        this.c.getChildren().removeAll(this.c.getChildren());
        this.c.getChildren().add(r);
        this.c.getChildren().add(bcp);
        this.setCenter(c);
    }

    private void drawTop(TargetController tc){
        HBox vb = new HBox();
        for (AbstractBro b: bros ) {
            SimpleBroController sbc = new SimpleBroController(b, this, tc);
            BroSimplePane bsp = new BroSimplePane(b.getName(), b.getBroCol(), sbc);
            vb.getChildren().add(bsp);
        }
        vb.setSpacing(10);
        vb.setAlignment(Pos.TOP_CENTER);
        this.setTop(vb);
    }
}
