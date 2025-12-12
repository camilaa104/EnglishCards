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
                        System.out.println("aaaaaa"); // Aqui agregas el Enum de categorias
                        int categoriaG = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Escribe la frase: ");
                        String fraseG = entrada.nextLine();
                        System.out.println("Escribe la respuesta: ");
                        String respuestaG = entrada.nextLine();
                        System.out.println("Escribe la explicacion: ");
                        String explicacionG = entrada.nextLine();
                        System.out.println("Escribe el nivel: ");
                        String nivelG = entrada.nextLine();
                        System.out.println("Escribe la pista: ");
                        String pistaG = entrada.nextLine();
                        //Mnadarlo al documento Grammar
                        break;
                    case 2: // Vocabulary
                        System.out.println(""); // Aqui agregas el Enum de categorias
                        int categoriaV = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Escribe la frase: ");
                        String fraseV = entrada.nextLine();
                        System.out.println("Escribe la respuesta: ");
                        String respuestaV = entrada.nextLine();
                        System.out.println("Escribe la explicacion: ");
                        String explicacionV = entrada.nextLine();
                        System.out.println("Escribe el nivel: ");
                        String nivelV = entrada.nextLine();
                        System.out.println("Escribe la pista: ");
                        String pistaV = entrada.nextLine();
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