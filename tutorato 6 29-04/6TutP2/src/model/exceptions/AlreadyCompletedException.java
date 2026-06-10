package model.exceptions;

public class AlreadyCompletedException extends QuestException {
    public AlreadyCompletedException(String msg) {
        super(msg);
    }
}
