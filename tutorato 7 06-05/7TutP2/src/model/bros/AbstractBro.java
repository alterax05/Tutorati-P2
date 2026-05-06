package model.bros;

public abstract class AbstractBro implements BroIntf {

    private final String name;
    protected final int lvl;

    protected static final int XP_BASE = 100;

    protected AbstractBro(String n, int l){
        this.name = n;
        this.lvl = l;
    }

    @Override
    public String toString(){
        return this.name+" LV:"+this.lvl;
    }

    @Override
    public int getLevel() {
        return this.lvl;
    }
}
