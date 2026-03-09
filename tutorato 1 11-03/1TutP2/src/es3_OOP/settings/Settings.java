package es3_OOP.settings;

public class Settings {
    private static Settings instance;

    private Network network;
    private Theme theme;

    private Settings() {
        // default values
        this.network = new Network(Status.DISCONNECTED, "", "");
        this.theme = Theme.SYSTEM;
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public void setNetwork(Network n) {
        if (n != null) this.network = n;
    }

    public void setTheme(Theme theme) {
        if (theme != null) this.theme = theme;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Setting:\n");
        sb.append("Network: ");
        sb.append(network.getStatus());
        if (network.getStatus() == Status.CONNECTED) {
            sb.append(" ").append(network.getIP());
            sb.append(" ").append(network.getSSID());
        }
        sb.append("\n");
        sb.append("Theme: ").append(theme).append("\n");
        return sb.toString();
    }
}
