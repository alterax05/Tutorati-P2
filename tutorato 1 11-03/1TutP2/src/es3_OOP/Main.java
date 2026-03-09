package es3_OOP;

// Separare il programma in un package "settings"
import es3_OOP.settings.Network;
import es3_OOP.settings.Settings;
import es3_OOP.settings.Status;
import es3_OOP.settings.Theme;

public class Main {
    public static void main(String[] args) {
        Settings s = Settings.getInstance();

        Network n = new Network(Status.CONNECTED, "192.168.0.10", "HomeWiFi");
        s.setNetwork(n);
        s.setTheme(Theme.DARK);

        System.out.println(s);

        Settings s2 = Settings.getInstance();

        // Questo dovrebbe stampare true
        System.out.println(s == s2);
    }
}
