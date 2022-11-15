public class Dragonnet extends Monstre implements Bourse,Depecable{
    public Dragonnet() {
        super(1, 0);
        setCuire(setCuire());
        setGold(setGold());
    }

    @Override
    public int setGold() {
        De de = new De(1,6);
        return de.lancer();
    }

    @Override
    public int setCuire() {
        De de = new De(1,4);
        return de.lancer();
    }
}
