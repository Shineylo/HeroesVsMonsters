import java.sql.Array;

public class Jeu {
    private boolean enCours = true;
    private Personnage[][] plateau = new Personnage[15][15];

    private Hero joueur;

    public Jeu(int choix) {
        choixHero(choix);
    }

    void choixHero(int choix){
        switch (choix){
            case 1:
                this.joueur = new Nain();
                this.plateau = setupPlateau(plateau,joueur );
                break;
            case 2:
                this.joueur = new Humain();
                this.plateau = setupPlateau(plateau,joueur);
                break;
        }
    }

    public Personnage[][] getPlateau() {
        return this.plateau.clone();
    }

    public Personnage[][] setupPlateau(Personnage[][] plateau,Hero joueur){
        Personnage[][] plateauVerif = new Personnage[19][19];
        int i=0;
        while (i<11){
            int x = (int) (Math.random() * 15);
            int y = (int) (Math.random() * 15);
            if(plateauVerif[y+2][x+2+2] == null){
                if (plateauVerif[y+2 + 1][x+2] == null && plateauVerif[y+2 - 1][x+2] == null && plateauVerif[y+2][x+2 + 1] == null && plateauVerif[y+2][x+2 - 1] == null) {
                    if (plateauVerif[y+2 + 2][x+2] == null && plateauVerif[y+2 - 2][x+2] == null && plateauVerif[y+2][x+2 + 2] == null && plateauVerif[y+2][x+2 - 2] == null) {
                        if (plateauVerif[y+2 + 1][x+2 + 1] == null && plateauVerif[y+2 + 1][x+2 + 1] == null && plateauVerif[y+2 - 1][x+2 + 1] == null && plateauVerif[y+2 - 1][x+2 - 1] == null) {
                            if(i<10) {
                                System.out.println(x +" " + y);
                                plateau[y][x] = aleatoireMonstre();
                                plateauVerif[y + 2][x + 2] = plateau[y][x];
                                i++;
                            }else{
                                joueur.position(x,y);
                                plateau[y][x] = joueur;
                                plateauVerif[y + 2][x + 2] = plateau[y][x];
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return plateau;
    }

    public Personnage aleatoireMonstre(){
        return switch ((int) (Math.random() * 3)) {
            case 0 -> new Loup();
            case 1 -> new Orc();
            case 2 -> new Dragonnet();
            default -> null;
        };
    }

    public boolean deplacement(String choix){
        switch (choix.toLowerCase()){
            case "g":
                try {
                    if (plateau[joueur.getX()][joueur.getY() + 1] == null) {
                        System.out.println("gauche");
                        plateau[joueur.getY()][joueur.getX() + 1] = joueur;
                        plateau[joueur.getY()][joueur.getX()] = null;
                        joueur.position(joueur.getX()+1,joueur.getY());
                        System.out.println("oui");
                        return true;
                    }else{
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }
            case "d":
                try {
                    if (plateau[joueur.getY()][joueur.getX() - 1] == null) {
                        System.out.println("droite");
                        plateau[joueur.getY()][joueur.getX() - 1] = joueur;
                        plateau[joueur.getY()][joueur.getX()] = null;
                        joueur.position(joueur.getX()-1,joueur.getY());
                        return true;
                    }else{
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }
            case "h":
                try {
                    if (plateau[joueur.getY()-1][joueur.getX()] == null) {
                        System.out.println("haut");
                        plateau[joueur.getY()-1][joueur.getX()] = joueur;
                        plateau[joueur.getY()][joueur.getX()] = null;
                        joueur.position(joueur.getX(),joueur.getY()-1);
                        return true;
                    }else{
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }
            case "b":
                try {
                    System.out.println("base");
                    if (plateau[joueur.getY()+1][joueur.getX()] == null) {
                        plateau[joueur.getY()+1][joueur.getX()] = joueur;
                        plateau[joueur.getY()][joueur.getX()] = null;
                        joueur.position(joueur.getX(),joueur.getY()+1);
                        return true;
                    }else{
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }
        }
        return false;
    }

}
