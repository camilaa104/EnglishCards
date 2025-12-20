package english_cards;

public class Grammar extends Card{
    private GrammarCategory category;
    private String phrase;
    private String answer;
    private String explanation;

    public Grammar(int reference, Level level, String clue, 
            GrammarCategory category, String phrase, 
            String answer, String explanation) {
        super(reference, level, clue);
        this.category = category;
        this.phrase = phrase;
        this.answer = answer;
        this.explanation = explanation;
    }
    
    @Override 
    public String toString(){
        return "GRAMMAR:"+super.toString()+":"+this.category+":"+this.phrase+":"+
                this.answer+":"+this.explanation;
    }
    
    @Override
    public String toStringList(){
        return "\nLevel: "+super.getLevel()+"\n"+this.category+"\n\n Phrase: "+this.phrase+"\n\n Answer: "
                +this.answer+"\n Explanation: "+this.explanation+"\n clue: "+super.getClue();
    }
    
    @Override
    public String toStringFillMode(){
        return "the Phrase is: "+this.phrase+ "\nYour answer is: ";
    }
     /*escribir 2 metodos para imprimir la informacion, uno para el 
    modo quiz y uno para listar*/ 
    
    public GrammarCategory getCategory() {
        return category;
    }

    public void setCategory(GrammarCategory category) {
        this.category = category;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    
    
}
    

