package model.bros.comparators;

import model.bros.AbstractBro;
import java.util.Comparator;

public class BroHpComparator implements Comparator<AbstractBro> {

    @Override
    public int compare(AbstractBro o1, AbstractBro o2) {
        if (o1.getCurrMaxHP() == o2.getCurrMaxHP()){
            return o1.compareTo(o2);
        }
        return Integer.compare(o1.getCurrMaxHP(), o2.getCurrMaxHP());
    }
}
