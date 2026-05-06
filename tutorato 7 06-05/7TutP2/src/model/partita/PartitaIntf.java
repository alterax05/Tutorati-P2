package model.partita;

import model.Giocatore;
import model.bros.BroIntf;
import model.exceptions.*;

public interface PartitaIntf {

    void addBan(BroIntf b) throws CannotBanAgainException, CannotBanException;
    Partita_stages getStage();
    boolean addBro(BroIntf b) throws BroNonPermessoException, MaxSelectReachedException, AlreadyAddedException, AlreadyBannedException;
    void play(Giocatore g) throws InsufficientSomethingException;
}
