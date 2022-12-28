package Utils;


import java.util.ArrayList;

public class Menu {
    /**
     * Menu que muestra un arraylist el cual almacena todos los items interactuables del escenario
     * ademas de los escenarios a los cuales puedes moverte
     * @param options
     */
    public static void showMenu(ArrayList<String>options) {
        // Calcula el ancho del cajón según la longitud de la opción más larga
        int width = 0;
        for (String option : options) {
            width = Math.max(width, option.length());
        }
        width += 2;  // Añade espacio para los caracteres '[' y ']'

        // Dibuja la parte superior del cajón
        for (int i = 0; i < width+4; i++) {
            System.out.print("=");
        }
        System.out.println();
        // Imprime cada opción del menú
        int c=0;
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            System.out.print("| ");
            if (!option.equals("----INTERACT----") && !option.equals("----MOVE TO----") && !option.equals("----Inventory----")) {
                System.out.print("[" +c+ "] ");
                System.out.print(option);
                for (int j = 0; j < width - option.length() - 4; j++) {
                    System.out.print(" ");
                }
            } else {
                System.out.print(option);
                for (int j = 0; j < width - option.length() ; j++) {
                    System.out.print(" ");
                }
                c--;
            }
            System.out.println(" |");
            c++;
        }

        // Dibuja la parte inferior del cajón
        for (int i = 0; i < width+4; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
