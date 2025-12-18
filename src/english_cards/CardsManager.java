
package english_cards;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardsManager{
   private final List<Card> cards;
   private int contador;
   
    public CardsManager(){
       this.cards = new ArrayList();
       this.contador = 0;   
    }
 
    public void addVocabularyCard(Level level, String clue,
            VocabularyCategory category, VocabularyTag topic, 
            UseTag use, String word, String translation,
            String meaning, String example ){
        this.contador++;
        Vocabulary card = new Vocabulary(this.contador, level, clue, category, topic, use, word, translation, meaning, example);
        cards.add(card);
        guardarEnArchivo();
    }
    
    public void addGrammarCard(Level level, String clue, 
            GrammarCategory category, String phrase, 
            String answer, String explanation){
        this.contador++;
        Grammar card = new Grammar(this.contador, level, clue, category, phrase, answer, explanation);
        cards.add(card);
        guardarEnArchivo();
    }
    
    public Card buscar(int reference){
        for(Card c : this.cards){
            if(c.getReference()== reference)
                return c;
        }
       return null;
    }
    
    public void ListarGrammar(){
      for(Card card : cards){
                if(card instanceof Grammar grammar){
                    System.out.println(grammar.toStringList());
                    System.out.println("--------------------");
                }
      }
    }
    
    public void ListarVocab(){
        for(Card card : cards){
                if(card instanceof Vocabulary vocabulary){
                    System.out.println(vocabulary.toStringList());
                    System.out.println("--------------------");
                }
      }
    }
    
    public void ListarTodos(){
        for(Card card: cards){
            System.out.println(card.toStringList());
        }
    }
       
    public boolean eliminar(int reference) {
    Iterator<Card> it = cards.iterator();
    while (it.hasNext()) {
        if (it.next().getReference() == reference) {
            it.remove();
            guardarEnArchivo();
            return true;   
        }
    }
    return false;
}
    
    public void cargarDesdeArchivo() {
    try (BufferedReader br = new BufferedReader(new FileReader("cards.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            Card card = fromLine(line);
            cards.add(card);
            this.contador = Math.max(this.contador, card.getReference());
        }
    } catch (IOException e) {
        System.out.println("Archivo no encontrado, iniciando vacío");
    }
}
    public static Card fromLine(String line) {
        String[] parts = line.split(":");
        
        switch (parts[0]) {
            case "VOCAB" -> {
                return new Vocabulary(
                        Integer.parseInt(parts[1]),
                        Level.valueOf(parts[2]),
                        parts[3],
                        VocabularyCategory.valueOf(parts[4]),
                        VocabularyTag.valueOf(parts[5]),
                        UseTag.valueOf(parts[6]),
                        parts[7], parts[8], parts[9], parts[10]
                );
            }
            case "GRAMMAR" -> {
                return new Grammar(
                        Integer.parseInt(parts[1]),
                        Level.valueOf(parts[2]),
                        parts[3],
                        GrammarCategory.valueOf(parts[4]),
                        parts[5], parts[6], parts[7]
                );
            }
        }
        return null;
    }
    
    public void guardarEnArchivo() {
    try (PrintWriter pw = new PrintWriter(new FileWriter("cards.txt"))) {
        for (Card c : cards) {
            pw.println(c.toString());
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
        }
    }    
}
    

