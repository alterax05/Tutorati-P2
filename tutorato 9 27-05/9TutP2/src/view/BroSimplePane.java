package view;

import controller.SimpleBroController;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BroSimplePane extends StackPane {

    private static final int SIZE = 70;
    private Rectangle r;
    private Text t;

    public BroSimplePane(String n, Color c, SimpleBroController sc){
        this.r = new Rectangle(SIZE,SIZE);
        this.r.setFill(c);
        this.t = new Text();
        t.setText(n);
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, sc);

        this.getChildren().add(r);
        this.getChildren().add(t);
    }
}
