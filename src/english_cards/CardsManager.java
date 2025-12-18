
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
    }
    
    public void addGrammarCard(Level level, String clue, 
            GrammarCategory category, String phrase, 
            String answer, String explanation){
        this.contador++;
        Grammar card = new Grammar(this.contador, level, clue, category, phrase, answer, explanation);
        cards.add(card);
    }
    
    public Card buscar(int reference){
        for(Card c : this.cards){
            if(c.getReference()== reference)
                return c;
        }
       return null;
    }
    
    public void ListarGrammar(){
        int i = 1;
        try (BufferedReader br = new BufferedReader(new FileReader("cards.txt"))){
            String line;
            while((line = br.readLine())!= null){
                Card card = fromLine(line);
                System.out.println("--------------------");
                System.out.println("Grammar");
                if(card instanceof Grammar grammar){
                    System.out.println(i +") "+ grammar.toStringListarGrammar());
                    System.out.println("--------------------");
                    i++;
                }
            }
        } catch(IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    
    public void ListarVocab(){
        int i = 1;
        try(BufferedReader br = new BufferedReader(new FileReader("cards.txt"))){
            String Line;
            while((Line = br.readLine())!= null){
                Card card = fromLine(Line);
                System.out.println("--------------------");
                System.out.println("Vocabulary");
                if(card instanceof Vocabulary vocab){
                    System.out.println(i +") "+ vocab.toStringListarVocab());
                    System.out.println("--------------------");
                    i++;
                }
            }
        } catch (IOException e){
            System.out.println("Archivo no valido");
        }
    }
    
    public void ListarTodos(){
        int i =1;
        try(BufferedReader br = new BufferedReader(new FileReader("carsds.txt"))){
            String Line;
            while((Line = br.readLine()) != null){
                Card card = fromLine(Line);
                System.out.println("--------------------");
                if(card instanceof Grammar grammar){
                    System.out.println(i +") "+ grammar.toStringListarGrammar());
                    System.out.println("--------------------");
                    i++;
                } else if(card instanceof Vocabulary vocab){
                    System.out.println(i +") "+vocab.toStringListarVocab());
                    System.out.println("--------------------");
                    i++;
                }
            }
        }catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
   
  //crear los metodos de listar vocabulary, grammar o todos 
    
    public void eliminar(int reference){
        Iterator<Card> it = cards.iterator();
        while(it.hasNext()){
            if(it.next().getReference() == reference){
               it.remove();
               break;
            }
        }
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

   /* crear el agregar, tambien el metodo de buscar por referencia,
   para editar y eliminar, y no se como gestionar que editar depende de la categoria, 
   yo creo que tocara mas bien que entren dos numeros, uno se refiere al tipo de tarjeta, 
   el otro al atributo y ahi se decide con ifs y se llama al  mismo método o si se hacen mas metodos pues
   que sean metodos internos */
   
   
}
    

