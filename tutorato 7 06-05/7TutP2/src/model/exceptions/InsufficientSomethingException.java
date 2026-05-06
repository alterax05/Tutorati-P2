package model.exceptions;

public class InsufficientSomethingException extends Exception{
    private String what;

    public InsufficientSomethingException(String w){
        this.what = w;
    }

    public String getWhat() {
        return what;
    }
}
