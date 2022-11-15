public class Hero extends Personnage{
    int x,y;

    public Hero(int bonusEnd,int bonusFor) {
        super(bonusEnd,bonusFor,0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void position(int x, int y){
        this.x = x;
        this.y = y;
    }


}
