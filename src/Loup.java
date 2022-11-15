public class Loup extends Monstre implements Depecable{
    public Loup() {
        super(0,0);
    }

    @Override
    public int setCuire() {
        De de = new De(1,6);
        return de.lancer();
    }
}
