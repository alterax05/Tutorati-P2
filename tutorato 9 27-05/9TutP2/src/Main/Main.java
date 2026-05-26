package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Target;
import model.atks.*;
import model.bros.*;
import view.MainView;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<AbstractBro> bros = new ArrayList<>();
        AbstractAttack sbam = new BlastAttack("SBAM", 1000);
        AbstractBro franco = new TankBro("Franco", sbam);
        franco.lvlup();
        bros.add(franco);
        AbstractAttack bomba = new LobberAttack("Bomba", 2000);
        AbstractBro dina = new ArtilleryBro("Dinamichele", bomba);
        dina.lvlup();dina.lvlup();dina.lvlup();dina.lvlup();dina.lvlup();dina.lvlup();dina.lvlup();
        bros.add(dina);
        AbstractAttack bzz = new SingleAttack("Bzz", 2000);
        AbstractBro ape = new SniperBro("Ape", bzz);
        ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();ape.lvlup();
        bros.add(ape);
        AbstractAttack scia = new SingleAttack("Sciarpa", 500);
        AbstractBro edo = new TankBro("Edoardo", scia);
        bros.add(edo);
        AbstractAttack tent = new LobberAttack("Tentacolo", 1200);
        AbstractBro sal = new SniperBro("Salice", tent);
        bros.add(sal);

        Target t = new Target();

        MainView root = new MainView(bros, t);
        primaryStage.setTitle("Bro-Stelle");
        primaryStage.setScene(new Scene(root, 450, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}