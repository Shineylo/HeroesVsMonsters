import java.util.ArrayList;
import java.util.Collections;

public abstract class Personnage {
    private int endurance;
    private int force;
    private int pv;
    private int pvMax;
    private int bonusEnd;
    private int bonusFor;

    public Personnage(int bonusEnd,int bonusFor) {
        this.endurance = setStat();
        this.force = setStat();
        this.bonusEnd = bonusEnd;
        this.bonusFor = bonusFor;
        this.pv = this.endurance+this.bonusEnd + modificateur(this.endurance+this.bonusEnd);
        this.pvMax = this.pv;
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
    }

    public void frapper(Personnage personnage){
        De de = new De(1,4);
        personnage.recevoirDegat(de.lancer() + modificateur(this.force+this.bonusFor));
    }
}
