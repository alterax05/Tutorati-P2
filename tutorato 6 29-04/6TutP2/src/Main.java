
import controller.QuestController;
import model.Geraldo;
import model.QuestLog;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Geraldo geraldo = new Geraldo();
        QuestLog questLog = new QuestLog();
        ConsoleView view = new ConsoleView();
        QuestController controller = new QuestController(geraldo, questLog, view);
        controller.run();
    }
}
