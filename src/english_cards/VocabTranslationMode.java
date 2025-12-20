package english_cards;
import java.util.Scanner;

public class VocabTranslationMode implements PracticeMode {
     @Override
    public boolean supports(Card card) {
        return card instanceof Vocabulary;
    }

    @Override
    public void play(Card card, Scanner sc, ScoreTracker score) {
        Vocabulary v = (Vocabulary) card;
        System.out.println(v.toStringTraslationMode());
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase(v.getWord())) {
            System.out.println("Correct!");
            System.out.println("Example: " + v.getExample()+ "\n ----"
                + "------------------------------------");
            score.correct();
        } else {
            score.incorrect();
            manejarError(sc, v, score);
        }
    }
    
    private void manejarError(Scanner sc, Vocabulary v, ScoreTracker score) {
    System.out.println("Incorrect.");

    int opt = leerEntero(sc, """
    1) Try again
    2) See answer
    """);
    switch(opt){

        case 1 -> {
            System.out.println("Hint:" + v.getClue()+ "\n ----"
                + "------------------------------------");
            play(v, sc, score);
        }
        case 2 -> {
            System.out.println("the word is: " + v.getWord());
            System.out.println("Example: " + v.getExample()+ "\n ----"
                + "------------------------------------");
        }
        default -> System.out.println("opcion invalida\n");
    }
}
     private static int leerEntero(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.\n");
            }
        }
    }
    
}
