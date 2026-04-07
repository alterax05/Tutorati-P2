import controller.SubscriptionController;
import model.Utente;
import model.Vetrina;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Utente utente = new Utente();
        Vetrina vetrina = new Vetrina();
        ConsoleView view = new ConsoleView();
        SubscriptionController controller = new SubscriptionController(utente, vetrina, view);
        controller.run();
    }
}
