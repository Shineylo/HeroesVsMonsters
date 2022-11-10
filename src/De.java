public class De {
    private int max;
    private int min;

    public De(int min, int max) {
        this.max = max;
        this.min = min;
    }

    public int lancer(){
        return (int)(Math.random() * max-min)+min;
    }
}
