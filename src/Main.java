import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String userInput;
        boolean game =true;
        Jeu jeu;
        System.out.println("Bienvenue dans le fôret de Shorewood!");
        System.out.println("Etes-vous 1.un nain ou 2.un humain ?");
        do {
            do{
                userInput = scn.nextLine();
            }while (!checkUserInputIsInt(userInput));
        }while (!checkUserInputHero(Integer.parseInt(userInput)));
        jeu = new Jeu(Integer.parseInt(userInput));
        do {
            print(jeu.getPlateau());
            System.out.println("Dans quel direction se déplacer ?");
            System.out.println("H: Haut / B: Bas / G:Gauche / D:Droite");
            do {
                do {
                    userInput = scn.nextLine();
                } while (!checkUserInputDirection(userInput));
            }while (!jeu.deplacement(userInput));
        }while (game == true);

    }

    private static boolean checkUserInputDirection(String choix) {
        if(choix.toLowerCase().equals("h") || choix.toLowerCase().equals("b") || choix.toLowerCase().equals("d") || choix.toLowerCase().equals("g")){
            return true;
        }else {
            System.out.println("Choix incorrect H:Haut B:Bas G:Gauche D:Droite");
            return false;
        }
    }

    public static boolean checkUserInputIsInt(String scn){
        try{
            Integer.parseInt(scn);
        }catch(Exception e){
            System.out.println("Vous n'avez pas rentré un nombre");
            System.out.println("Choix incorrect 1.Nain 2.Humain");
            return false;
        }
        return true;
    }

    public static boolean checkUserInputHero(int choix){
        if(choix == 1 || choix==2){
            return true;
        }else {
            System.out.println("Choix incorrect 1.Nain 2.Humain");
            return false;
        }
    }

    public static void print(Personnage[][] plateau){
        for (int i = 0;i<15;i++){
            for (int j = 0;j<15;j++){
                if(plateau[i][j] instanceof Monstre){
                    System.out.print("|M");
                }else if(plateau[i][j] instanceof Hero){
                    System.out.print("|H");
                }else{
                    System.out.print("| ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
}