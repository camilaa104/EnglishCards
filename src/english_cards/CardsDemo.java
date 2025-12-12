package english_cards;

import java.util.Scanner;

public class CardsDemo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Buenas, selesccione el numero de lo que desea realizar:");
        System.out.println(" --Menu--\n 1)Agregar\n 2)Editar\n 3)Eliminar\n 4)Listar\n 5)Practicar\n 6)Salir");
        int menu = entrada.nextInt();
        
        while(menu != 6){
            switch (menu) {
            case 1: //Agregar
                System.out.println("Seleccione a cual desea agregar\n 1)Grammar\n 2)Vocabulary\n 3)Regresar al Menu\n");
                int agregar = entrada.nextInt();
                switch(agregar){
                    case 1: //Grammar
                        System.out.println(""); // Aqui agregas el Enum de categorias
                        int categoriaG = entrada.nextInt();
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
                    case 3: // Regresar Menu
                        break;
                    }
            case 2: //editar
                System.out.println("Agrege la referencia de la targeta a editar (si desea regresar al menu, ingrese 1234): ");
                int referenciaEd = entrada.nextInt();
                if(referenciaEd == 1234){
                    break;
                } else{
                    // mandar referencia al documento
                    break;
                }
            case 3: //eliminar
                System.out.println("Agrege la referencia a la targeta a eliminar: ");
                int referenciaEl = entrada.nextInt();
                
                break;
            case 4: //Listar
                break;
            case 5: //Practicar
                break;
            default:
                System.out.println("Porfa selecciona una obcion valida");
                menu = entrada.nextInt();
                break;
            }
        }
    }
}