
package english_cards;
import java.util.Scanner;

public interface PracticeMode {
    boolean supports(Card card);
    void play(Card card, Scanner sc, ScoreTracker score);//ponerle al score el nombre del tracker
    
}
