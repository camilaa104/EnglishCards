package english_cards;

import java.util.Scanner;

public class CardsDemo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Buenas, selesccione el numero de lo que desea realizar:");
        System.out.println(" --Menu--\n 1)Agregar\n 2)Editar\n 3)Eliminar\n 4)Listar\n 5)Practicar\n 6)Salir");
        int menu = entrada.nextInt();
        entrada.nextLine();
        while(menu != 6){
            switch (menu) {
            case 1: //Agregar
                System.out.println("Seleccione a cual desea agregar\n 1)Grammar\n 2)Vocabulary\n Preciona cualquier otro numero para regresar al menu");
                int agregar = entrada.nextInt();
                entrada.nextLine();
                switch(agregar){
                    case 1: //Grammar
                        System.out.println("Seleccione el numero de la categoria de gramatica que desea agregar");
                        for(int i=1; i<=18;i++){
                            System.out.println(i+" "+GrammarCategory.fromCode(i));
                        }
                        int categoriaG = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Escribe la frase: ");
                        String fraseG = entrada.nextLine();
                        System.out.println("Escribe la respuesta: ");
                        String respuestaG = entrada.nextLine();
                        System.out.println("Escribe la explicacion: ");
                        String explicacionG = entrada.nextLine();
                        System.out.println("Selecciona el numero del nivel que deseas agregar");
                        for(int i=1; i<=6; i++){
                            System.out.println(i+" "+Level.fromCode(i));
                        }
                        String nivelG = entrada.nextLine();
                        System.out.println("Escribe la pista: ");
                        String pistaG = entrada.nextLine();
                        //Mnadarlo al documento Grammar
                        break;
                    case 2: // Vocabulary
                        System.out.println("Seleccione el numero de la categoria que desea agregar");
                        for(int i=1; i<=10; i++){
                            System.out.println(i+" "+VocabularyCategory.fromCode(i));
                        }
                        int categoriaV = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Escribe la frase: ");
                        String fraseV = entrada.nextLine();
                        System.out.println("Escribe la respuesta: ");
                        String respuestaV = entrada.nextLine();
                        System.out.println("Escribe la explicacion: ");
                        String explicacionV = entrada.nextLine();
                        System.out.println("Escribe la pista: ");
                        String pistaV = entrada.nextLine();
                        System.out.println("Seleccione el numero del nivel que desea agregar");
                        for(int i=1; i<6; i++){
                            System.out.println(i+" "+Level.fromCode(i));
                        }
                        int nivelV = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Sleccione el numero del tag general que desea agregar");
                        for(int i=1; i<6; i++){
                            System.out.println(i+" "+UseTag.fromCode(i));
                        }
                        int useTag = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Seleccione el numero del tag especifico que desea agregar");
                        for(int i=0; i<17; i++){
                            System.out.println(i+" "+VocabularyTag.fromCode(i));
                        }
                        int vocabularyTAG = entrada.nextInt();
                        entrada.nextLine();
                        //Mnadarlo al documento Vocabulary
                        break;
                    default:
                        break;
                }
               break;
            case 2: //editar
                System.out.println("Agrege la referencia de la targeta a editar (si desea regresar al menu, ingrese 1234): ");
                int referenciaEd = entrada.nextInt();
                entrada.nextLine();
                if(referenciaEd == 1234){
                    break;
                } else{
                    // mandar referencia al documento y editarlo
                    break;
                }
            case 3: //eliminar
                System.out.println("Agrege la referencia a la targeta a eliminar (si desea regresar al menu, ingrese 1234): ");
                int referenciaEl = entrada.nextInt();
                entrada.nextLine();
                if(referenciaEl == 1234){
                    break;
                } else{
                    // mandar referencia al documento y eliminarlo
                    break;
                }
            case 4: //Listar
                System.out.println("Seleccione a cual desea listar\n 1)Grammar\n 2)Vocabulary\n 3)Todos\n Preciona cualquier otro numero para regresar al menu");
                int Listar = entrada.nextInt();
                entrada.nextLine();
                switch(Listar){
                    case 1: //Grammar
                        //Listar tarjetas de gramatica
                        break;
                    case 2: // Vocabulary
                        //Listar tarjetas de vocabulario
                        break;
                    case 3: //Todos
                        //Listar todas las tarjetas
                        break;
                    default:
                        break;
                }
                break;
            case 5: //Practicar
                System.out.println("Seleccione a cual deseas practicar\n 1)Grammar\n 2)Vocabulary\n 3)Aleatorio\n Preciona cualquier numero apra regresar al menu");
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
    }
}