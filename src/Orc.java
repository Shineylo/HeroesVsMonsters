public class Orc extends Monstre implements Bourse{
    public Orc() {
        super(0, 1);
        this.setGold(setGold());
    }

    @Override
    public int setGold() {
        De de = new De(1,6);
        return de.lancer();
    }
}
