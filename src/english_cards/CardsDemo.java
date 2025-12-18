package english_cards;

import java.util.Scanner;

public class CardsDemo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        CardsManager manager = new CardsManager();
        manager.cargarDesdeArchivo();
        System.out.println("Bienvenido a EnglishCards!!, su espacio de aprendizaje de ingles con "
                + "flashcards\n ¿Qué desea realizar? Ingrese el numero porfavor:");
        System.out.println(" --Menu--\n 1)Agregar\n 2)Editar\n 3)Eliminar\n 4)Listar\n 5)Practicar\n"
                + " 6)Salir");//seria buena idea agregar uno como buscar que te imprima toda la info de solo una tarjeta
        int menu = entrada.nextInt();
        entrada.nextLine();
        while(menu != 6){
            switch (menu) {
            case 1: //Agregar
                System.out.println(" ¿Qué tipo de carta desea agregar? Ingrese el numero porfavor:\n"
                        + " 1)Grammar\n 2)Vocabulary\n Ingrese cualquier otro numero para "
                        + "regresar al menu...");
                int agregar = entrada.nextInt();
                entrada.nextLine();
                switch(agregar){
                    case 1:
                        agregarGrammar(entrada, manager);
                        break;
                    case 2: 
                        agregarVocabulary(entrada, manager);
                        break;
                    default:
                        break;
                }
               break;
            case 2: //editar
                System.out.println("Agrege la referencia de la targeta a editar "
                        + "(si desea regresar al menu, ingrese -1): ");
                int referenciaEd = entrada.nextInt();
                entrada.nextLine();
                if(referenciaEd == -1){
                    break;
                } else{
                    // mandar referencia al documento y editarlo, me imagino que habra que hacer metodos externos
                    break;
                }
            case 3: //eliminar
                System.out.println("Agrege la referencia a la targeta a eliminar "
                        + "(si desea regresar al menu, ingrese -1): ");
                int deleteRef = entrada.nextInt();
                entrada.nextLine();
                if(deleteRef == -1){
                    break;
                } else{
                    manager.eliminar(deleteRef);
                    break;
                }
            case 4: //Listar
                System.out.println("Seleccione a cual desea listar\n 1)Grammar\n 2)Vocabulary\n "
                        + "3)Todos\n Presiona cualquier otro numero para regresar al menu");
                int Listar = entrada.nextInt();
                entrada.nextLine();
                switch(Listar){
                    case 1: //Grammar
                        manager.ListarGrammar();
                        break;
                    case 2: // Vocabulary
                        manager.ListarVocab();
                        break;
                    case 3: //Todos
                        manager.ListarTodos();
                        break;
                    default:
                        break;
                }
                break;
            case 5: //Practicar
                System.out.println("Seleccione a cual deseas practicar\n "
                        + "1)Grammar\n 2)Vocabulary\n 3)Aleatorio\n Preciona cualquier numero apra regresar al menu");
                int Practicar = entrada.nextInt();
                entrada.nextLine();
                switch(Practicar){
                    case 1: //Grammar
                        //Listar tarjetas de gramatica
                        break;
                    case 2: // Vocabulary
                        //Listar tarjetas de vocabulario
                        break;
                    case 3: // Aleatorio
                        //Practicar con todas las tarjetas
                        break;
                    default:
                        break;
                }
                break;
            default:
                System.out.println("Porfa selecciona una obcion valida");
                menu = entrada.nextInt();
                entrada.nextLine();
                break;
            }
            System.out.println("--Menu--\n 1)Agregar\n 2)Editar\n 3)Eliminar\n 4)Listar\n 5)Practicar\n 6)Salir");
            menu = entrada.nextInt();
            entrada.nextLine();
        }
        manager.guardarEnArchivo();
    }
    
    private static void agregarGrammar(Scanner entrada, CardsManager manager) {
    System.out.println("¿A qué categoría pertenece?");
    for (GrammarCategory g : GrammarCategory.values()) {
        System.out.println(g.getCode() + ". " + g.name());
    }
    int categoryG = entrada.nextInt();
    entrada.nextLine();

    System.out.println("Escribe la frase:");
    String phrase = entrada.nextLine();

    System.out.println("Escribe la respuesta:");
    String answer = entrada.nextLine();

    System.out.println("Escribe la explicación:");
    String explanation = entrada.nextLine();

    System.out.println("Selecciona el nivel:");
    for (Level l : Level.values()) {
        System.out.println(l.getCode() + ". " + l.name());
    }
    int level = entrada.nextInt();
    entrada.nextLine();

    System.out.println("Escribe la pista:");
    String clue = entrada.nextLine();

    manager.addGrammarCard(
        Level.fromCode(level),
        clue,
        GrammarCategory.fromCode(categoryG),
        phrase,
        answer,
        explanation
    );
}
    private static void agregarVocabulary(Scanner entrada, CardsManager manager){
        System.out.println("Seleccione el numero de la categoria "
                            + "de Vocabulario que desea agregar");
        for(VocabularyCategory Vcategory : VocabularyCategory.values()){
            System.out.println(Vcategory.getCode()+". "+Vcategory.name());
        }
        int categoryV = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Escribe la palabra: ");
        String word = entrada.nextLine();
        System.out.println("Escribe la traduccion (es decir, la plabra en español): ");
        String translation = entrada.nextLine();
        System.out.println("Escribe el significado (como la descripcion en ingles): ");
        String meaning = entrada.nextLine();
        System.out.println("Escribe un ejemplo en el que se use esa palabra: ");
        String example = entrada.nextLine();
        System.out.println("Escribe la pista: ");
        String clueV = entrada.nextLine();
        System.out.println("Seleccione el nivel");
        for(Level l: Level.values()){
            System.out.println(l.getCode()+". "+l.name());
        }
        int nivelV = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Seleccione uso de la palabra");
        for(UseTag use: UseTag.values()){
            System.out.println(use.getCode()+". "+use.name());
        }
        int useTag = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Seleccione el numero del tema");
        for(VocabularyTag topic: VocabularyTag.values()){
            System.out.println(topic.getCode()+". "+topic.name());
        }
        int tagV = entrada.nextInt();
        entrada.nextLine();
        manager.addVocabularyCard(
                Level.fromCode(nivelV), 
                clueV, 
                VocabularyCategory.fromCode(categoryV),
                VocabularyTag.fromCode(tagV),
                UseTag.fromCode(useTag), 
                word, 
                translation, 
                meaning, 
                example);
    }

}