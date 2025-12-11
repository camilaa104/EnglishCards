
package english_cards;

public class Card {
    private int referencia;
    
    public Card(int referencia){
        this.referencia = referencia;
    }
    
    @Override
    public String toString(){
        return ""+this.referencia;
    }
}
