package english_cards;

import java.util.Scanner;
import java.util.function.IntFunction;

public class CardsDemo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        CardsManager manager = new CardsManager();
        manager.cargarDesdeArchivo();

        while (true) {
            System.out.println("""
                -- MENU --
                1) Agregar tarjeta
                2) Editar tarjeta
                3) Eliminar tarjeta
                4) Listar tarjetas
                5) Practicar
                6) Buscar tarjeta por referencia
                7) Salir
                """);

            int menu = leerEntero(sc, "Seleccione una opción: ");

            switch (menu) {

                case 1 -> agregar(sc, manager);

                case 2 -> {
                    int ref = leerEntero(sc, "Referencia a editar (-1 para cancelar): ");
                    if (ref != -1 && editar(ref, sc, manager)) {
                        System.out.println("Carta editada con éxito.");
                    } else {
                        System.out.println("No se pudo editar la carta.");
                    }
                }

                case 3 -> {
                    int ref = leerEntero(sc, "Referencia a eliminar (-1 para cancelar): ");
                    if (ref != -1) {
                        boolean eliminado = manager.eliminar(ref);
                        if (eliminado) {
                            System.out.println("Tarjeta eliminada correctamente.");
                        } else {
                            System.out.println("No se encontró una tarjeta con esa referencia.");
                        }
                    }
                }

                case 4 -> listar(sc, manager);

                case 5 -> System.out.println("Modo práctica (pendiente de implementar)"); //esto faltaa

                case 6 -> {
                    int ref = leerEntero(sc, "Ingrese la referencia: ");
                    System.out.println(manager.buscar(ref).toStringList());
                }

                case 7 -> {
                    manager.guardarEnArchivo();
                    System.out.println("Datos guardados. ¡Hasta luego!");
                    return;
                }

                default -> System.out.println("Opción inválida.");
            }
        }
    }

    // ================= AGREGAR =================

    private static void agregar(Scanner sc, CardsManager manager) {
        System.out.println("""
            ¿Qué tipo de tarjeta desea agregar?
            1) Grammar
            2) Vocabulary
            """);

        int tipo = leerEntero(sc, "Seleccione opción: ");

        if (tipo == 1) agregarGrammar(sc, manager);
        else if (tipo == 2) agregarVocabulary(sc, manager);
    }

    private static void agregarGrammar(Scanner sc, CardsManager manager) {

        GrammarCategory category = pedirEnum(sc, GrammarCategory.values(), GrammarCategory::fromCode);
        String phrase = pedirTexto(sc, "Frase: ");
        String answer = pedirTexto(sc, "Respuesta: ");
        String explanation = pedirTexto(sc, "Explicación: ");
        Level level = pedirEnum(sc, Level.values(), Level::fromCode);
        String clue = pedirTexto(sc, "Pista: ");

        manager.addGrammarCard(level, clue, category, phrase, answer, explanation);
    }

    private static void agregarVocabulary(Scanner sc, CardsManager manager) {

        VocabularyCategory category = pedirEnum(sc, VocabularyCategory.values(), VocabularyCategory::fromCode);
        String word = pedirTexto(sc, "Palabra: ");
        String translation = pedirTexto(sc, "Traducción: ");
        String meaning = pedirTexto(sc, "Significado: ");
        String example = pedirTexto(sc, "Ejemplo: ");
        String clue = pedirTexto(sc, "Pista: ");
        Level level = pedirEnum(sc, Level.values(), Level::fromCode);
        UseTag use = pedirEnum(sc, UseTag.values(), UseTag::fromCode);
        VocabularyTag topic = pedirEnum(sc, VocabularyTag.values(), VocabularyTag::fromCode);

        manager.addVocabularyCard(level, clue, category, topic, use,
                word, translation, meaning, example);
    }

    // ================= EDITAR =================

    private static boolean editar(int reference, Scanner sc, CardsManager manager) {

        Card card = manager.buscar(reference);
        if (card == null) return false;

        if (card instanceof Grammar g) editarGrammar(g, sc);
        else if (card instanceof Vocabulary v) editarVocabulary(v, sc);
        manager.guardarEnArchivo();
        return true;
    }

    private static void editarGrammar(Grammar g, Scanner sc) {

        System.out.println("""
            1) Nivel
            2) Pista
            3) Categoría
            4) Frase
            5) Respuesta
            6) Explicación
            """);

        int op = leerEntero(sc, "Seleccione opción: ");

        switch (op) {
            case 1 -> g.setLevel(pedirEnum(sc, Level.values(), Level::fromCode));
            case 2 -> g.setClue(pedirTexto(sc, "Nueva pista: "));
            case 3 -> g.setCategory(pedirEnum(sc, GrammarCategory.values(), GrammarCategory::fromCode));
            case 4 -> g.setPhrase(pedirTexto(sc, "Nueva frase: "));
            case 5 -> g.setAnswer(pedirTexto(sc, "Nueva respuesta: "));
            case 6 -> g.setExplanation(pedirTexto(sc, "Nueva explicación: "));
        }
    }

    private static void editarVocabulary(Vocabulary v, Scanner sc) {

        System.out.println("""
            1) Nivel
            2) Pista
            3) Categoría
            4) Tema
            5) Uso
            6) Palabra
            7) Traducción
            8) Significado
            9) Ejemplo
            """);

        int op = leerEntero(sc, "Seleccione opción: ");

        switch (op) {
            case 1 -> v.setLevel(pedirEnum(sc, Level.values(), Level::fromCode));
            case 2 -> v.setClue(pedirTexto(sc, "Nueva pista: "));
            case 3 -> v.setCategory(pedirEnum(sc, VocabularyCategory.values(), VocabularyCategory::fromCode));
            case 4 -> v.setTopic(pedirEnum(sc, VocabularyTag.values(), VocabularyTag::fromCode));
            case 5 -> v.setUse(pedirEnum(sc, UseTag.values(), UseTag::fromCode));
            case 6 -> v.setWord(pedirTexto(sc, "Nueva palabra: "));
            case 7 -> v.setTranslation(pedirTexto(sc, "Nueva traducción: "));
            case 8 -> v.setMeaning(pedirTexto(sc, "Nuevo significado: "));
            case 9 -> v.setExample(pedirTexto(sc, "Nuevo ejemplo: "));
        }
    }

    
   

    // ================= LISTAR =================

    private static void listar(Scanner sc, CardsManager manager) {

        System.out.println("""
            1) Grammar
            2) Vocabulary
            3) Todas
            """);

        int op = leerEntero(sc, "Seleccione opción: ");

        switch (op) {
            case 1 -> manager.ListarGrammar();
            case 2 -> manager.ListarVocab();
            case 3 -> manager.ListarTodos();
            default -> {
            }
        }
    }

   // ================= HELPERS =================

    private static String pedirTexto(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private static int leerEntero(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    private static <T extends Enum<T> & CodeEnum> T pedirEnum(
            Scanner sc,
            T[] values,
            IntFunction<T> mapper
    ) {
        for (T v : values) {
            System.out.println(v.getCode()+ ". " +v.name());
        }

        while (true) {
            int code = leerEntero(sc, "Seleccione opción: ");
            T result = mapper.apply(code);
            if (result != null) return result;
            System.out.println("Opción inválida.");
        }
    }
}
