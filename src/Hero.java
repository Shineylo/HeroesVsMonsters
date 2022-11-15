public class Hero extends Personnage{

    public Hero(int bonusEnd,int bonusFor) {
        super(bonusEnd,bonusFor,0,0);
    }

    public void repos(){
        this.seSoigner();
    }

    public void depouiller(Monstre monstre){
        if(monstre instanceof Bourse){
            this.setGold(monstre.getGold());
        }
        if(monstre instanceof Depecable){
            this.setCuire(monstre.getCuire());
        }
    }
}
