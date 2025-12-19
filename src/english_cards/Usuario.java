package english_cards;

public class Usuario {
    private String name;
    private int score;

    public Usuario(String nombre, int puntos) {
        this.name = nombre;
        this.score = puntos;
    }
    
    @Override
    public String toString(){
        return "Usuario"+ this.name + " Puntos: "+ this.score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
