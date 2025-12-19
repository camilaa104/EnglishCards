package english_cards;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PracticeManager {
    public void startPractice(
    List<Card> cards, 
    PracticeMode mode,
    Scanner sc){
        ScoreTracker score = new ScoreTracker();
        List<Card> disponibles = cards.stream().filter(mode::supports).toList();
        Collections.shuffle(disponibles);
        for(Card c: disponibles){
            mode.play(c, sc, score);
        }
        System.out.println("Finaal Score: + el Score de score");
    }
    public void startMixedPractice(List<Card> cards, List<PracticeMode> modes, Scanner sc){
        ScoreTracker score = new ScoreTracker();
        Collections.shuffle(cards);
        for(Card c: cards){
            List<PracticeMode> compatibles = modes.stream().filter(m -> m.supports(c)).toList();
            PracticeMode elegido = elegirModo(compatibles);
            elegido.play(c, sc, score);
        }
        System.out.println("Final score: ");
    }
    private PracticeMode elegirModo(List<PracticeMode> modos){
        Collections.shuffle(modos);
        return modos.get(0);
    }
}
