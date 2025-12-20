package english_cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PracticeManager {

    public void startPractice(
            List<Card> cards,
            List<PracticeMode> modes,
            PracticeType type,
            int maxQuestions,
            Scanner sc
    ) {
        if (type == PracticeType.SINGLE) {
            startSingle(cards, modes.get(0), maxQuestions, sc);
        } else if (type == PracticeType.MIXED) {
            startMixed(cards, modes, maxQuestions, sc);
        }
    }

    // ===== Internos =====

    private void startSingle(List<Card> cards, PracticeMode mode,int maxQuestions, Scanner sc) {
        ScoreTracker score = new ScoreTracker();

        List<Card> disponibles = new ArrayList<>(cards.stream()
                .filter(mode::supports)
                .toList());

        Collections.shuffle(disponibles);
        int n = 0;
        for (Card c : disponibles) {
            if(n >= maxQuestions) break;
            mode.play(c, sc, score);
            n++;
        }

        System.out.println("Final score: " + score.getScore());
    }

    private void startMixed(List<Card> cards, List<PracticeMode> modes,int maxQuestions, Scanner sc) {
        ScoreTracker score = new ScoreTracker();

        Collections.shuffle(cards);
        int n = 0;
        for (Card c : cards) {
            if(n>= maxQuestions)break;
            List<PracticeMode> compatibles = new ArrayList<>(
             modes.stream()
             .filter(m -> m.supports(c))
             .toList());
            if (compatibles.isEmpty()) continue;
            PracticeMode elegido = elegirModo(compatibles);
            elegido.play(c, sc, score);
            n++;
        }

        System.out.println("Final score: " + score.getScore());
    }

    private PracticeMode elegirModo(List<PracticeMode> modos) {
        Collections.shuffle(modos);
        return modos.get(0);
    }
}


