package english_cards;

public class Vocabulary extends Card{

    private VocabularyCategory category;
    private VocabularyTag topic;
    private UseTag use;
    private String word;
    private String translation;
    private String meaning;
    private String example;

    public Vocabulary(int reference, Level level, String clue,
            VocabularyCategory category, VocabularyTag topic, 
            UseTag use, String word, String translation,
            String meaning, String example) {
        
        super(reference, level, clue);
        this.category = category;
        this.topic = topic;
        this.use = use;
        this.word = word;
        this.translation = translation;
        this.meaning = meaning;
        this.example = example;
    }

    
    @Override 
    public String toString(){
        return super.toString()+":"+this.category+":"+this.topic+":"+
                this.use+":"+this.word+":"+this.translation+":"+this.meaning+":"+
                this.example;
    }
    /*escribir 3 metodos para imprimir la informacion, uno para cada 
    modo de quiz y uno para listar*/ 
    
    public VocabularyCategory getCategory() {
        return category;
    }

    public VocabularyTag getTopic() {
        return topic;
    }

    public UseTag getUse() {
        return use;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }

    public void setCategory(VocabularyCategory category) {
        this.category = category;
    }

    public void setTopic(VocabularyTag topic) {
        this.topic = topic;
    }

    public void setUse(UseTag use) {
        this.use = use;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setExample(String example) {
        this.example = example;
    }

    
}
    

