package model.gradi;

public class PlayerGrado {

    private Rank_Enms grado;
    private Liv_Enms lvl;

    public PlayerGrado(){
        this.grado = Rank_Enms.Gold;
        this.lvl = Liv_Enms.Expert;
    }

    public void lvl_up(){
        if (this.lvl == Liv_Enms.Expert){
            this.lvl = Liv_Enms.Beginner;
            this.gradoup();
        }
        if (this.lvl == Liv_Enms.Regular){
            this.lvl = Liv_Enms.Expert;
        }
        if (this.lvl == Liv_Enms.Beginner){
            this.lvl = Liv_Enms.Regular;
        }
    }
    private void gradoup(){
        if (this.grado == Rank_Enms.Gold){
            this.grado = Rank_Enms.Diamond;
            return;
        }
        if (this.grado == Rank_Enms.Diamond){
            this.grado = Rank_Enms.Master;
            return;
        }
        if (this.grado == Rank_Enms.Master){
            return;
        }
    }

    @Override
    public String toString(){
        return this.grado.toString()+" ("+this.lvl+")";
    }

    public boolean canPlay(Rank_Enms g) {
        return this.grado.ordinal() >= g.ordinal();
    }
}
