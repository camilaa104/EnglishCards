
package english_cards;

public class Vocabulary extends Card{
    private String categoria;//luego pues hacer un enum
    private String tag; //hacer Enum
    private String nivel; //hacer Enum, A1, A2, B1, B2
    private String palabra;
    private String traduccion;
    private String significado;
    private String ejemplo;
    
    public Vocabulary(int referencia, String categoria, String palabra, String traduccion, String significado, String ejemplo, String tag, String nivel){
        super(referencia);
        this.categoria = categoria;
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.significado = significado;
        this.ejemplo = ejemplo;
        this.tag = tag;
        this.nivel = nivel;
    }
    
}
