public class Hero extends Personnage{
    private int gold;
    private int cuire;

    public Hero(int bonusEnd,int bonusFor) {
        super(bonusEnd,bonusFor);
    }

    public void repos(){
        this.seSoigner();
    }

    public void depouiller(Monstre monstre){
        //Recois de monstre
    }
}
