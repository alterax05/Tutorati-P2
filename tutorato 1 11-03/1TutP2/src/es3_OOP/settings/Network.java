package es3_OOP.settings;

public class Network {
    private String IP;
    private String SSID;
    private Status status;

    public Network(Status status, String IP, String SSID) {
        this.status = status;
        this.IP = IP;
        this.SSID = SSID;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
