
package english_cards;

import java.util.Scanner;

public class GrammarFillMode implements PracticeMode{
     @Override
    public boolean supports(Card card) {
        return card instanceof Grammar;
    }

    @Override
    public void play(Card card, Scanner sc, ScoreTracker score) {
        Grammar g = (Grammar) card;
        System.out.println(g.toStringFillMode());
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase(g.getAnswer())) {
            System.out.println("Correct!");
            System.out.println(g.getExplanation());
            score.correct();
        } else {
           score.incorrect();
            manejarError(sc, g, score);
        }
    }
     private void manejarError(Scanner sc, Grammar g, ScoreTracker score) {
    System.out.println("Incorrect.");

    int opt = leerEntero(sc, """
    1) Try again
    2) See answer
    """);
    switch(opt){

        case 1 -> {
            System.out.println("Hint:" + g.getClue());
            play(g, sc, score);
        }
        case 2 -> {
            System.out.println("Answer: " + g.getAnswer());
            System.out.println("Example: " + g.getExplanation());
        }
        default -> System.out.println("opcion invalida");
    }
}
     private static int leerEntero(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}
