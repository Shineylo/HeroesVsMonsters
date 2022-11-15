import java.util.ArrayList;
import java.util.Collections;

public abstract class Personnage {
    private int endurance,force,pv,pvMax,bonusEnd,bonusFor,gold,cuire;
    private boolean enVie = true;

    public Personnage(int bonusEnd,int bonusFor,int gold,int cuire) {
        this.endurance = setStat();
        this.force = setStat();
        this.bonusEnd = bonusEnd;
        this.bonusFor = bonusFor;
        this.pv = this.endurance + this.bonusEnd + modificateur(this.endurance+this.bonusEnd);
        this.pvMax = this.pv;
        this.gold = gold;
        this.cuire = cuire;
    }

    public Personnage(int bonusEnd,int bonusFor) {
        this.endurance = setStat();
        this.force = setStat();
        this.bonusEnd = bonusEnd;
        this.bonusFor = bonusFor;
        this.pv = this.endurance+this.bonusEnd + modificateur(this.endurance+this.bonusEnd);
        this.pvMax = this.pv;
        this.gold = 0;
        this.cuire = 0;
    }


    public int modificateur(int base){
        if(base<=15){
            if(base<=10){
                if(base<=5){
                    return -1;
                }else{
                    return 0;
                }
            }else{
                return 1;
            }
        }else{
            return 2;
        }
    }

    public int setStat(){
        int stat = 0;
        De de = new De(1,6);
        ArrayList<Integer> lancerDe= new ArrayList<Integer>();
        for(int i =0; i<4;i++){
            lancerDe.add(de.lancer());
        }
        int min = Collections.min(lancerDe);
        lancerDe.remove(lancerDe.indexOf(min));
        for (int nb:lancerDe) {
            stat += nb;
        }
        return stat;
    }

    public void seSoigner(){
        this.pv = this.pvMax;
    }

    public void recevoirDegat(int damage){
        this.pv -= damage;
        if(this.pv <= 0){
            this.enVie = false;
        }
    }

    public void frapper(Personnage personnage){
        De de = new De(1,4);
        personnage.recevoirDegat(de.lancer() + modificateur(this.force+this.bonusFor));
    }

    public int getCuire() {
        return cuire;
    }

    public void setCuire(int cuire) {
        this.cuire = this.cuire + cuire;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = this.gold + gold;
    }
}
