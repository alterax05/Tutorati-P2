package model.exceptions;

public class PreviousQuestNotCompletedException extends QuestException {
    public PreviousQuestNotCompletedException(String msg) {
        super(msg);
    }
}
