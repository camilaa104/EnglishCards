package english_cards;

public class ScoreTracker {
    private int correct;
    private int incorrect;
    private int Score;
    
    public void correct(){
        this.correct +=10;
    }
    
    public void incorrect(){
        this.incorrect +=-5;
    }
    
    public int getScore(){
        return this.Score = (this.correct*10) + (this.incorrect*5);
    }

    public int getCorrect() {
        return this.correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return this.incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }
    
    
    
}
