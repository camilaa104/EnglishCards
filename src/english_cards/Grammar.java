package english_cards;

public class Grammar extends Card{
    private String categoria;
    private String nivel; //hacer Enum, A1, A2, B1, B2
    private String tag;
    private String frase;
    private String respuesta;
    private String explicacion;
    
    public Grammar(int referencia, String frase, String respuesta, String explicacion, String nivel, String tag) {
        super(referencia);
    }
    
}
