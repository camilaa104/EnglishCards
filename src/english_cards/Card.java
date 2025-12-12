
package english_cards;

public class Card {
    private int reference;
    private Level level;
    private String clue;
    
    public Card(int reference, Level level, String clue){
        this.reference = reference;
        this.level = level;
        this.clue = clue;
    }
    
    @Override
    public String toString(){
        return ""+this.reference+":"+this.level+":"+this.clue;
    }

    public int getReference() {
        return reference;
    }

    public Level getLevel() {
        return level;
    }

    public String getClue() {
        return clue;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }
    
    
}
