package Utils;

import java.util.Scanner;

public class Menu {
    public static void showMenu(String[] options) {
        System.out.println();
        int longitudMaxima = 0;
        boolean salir = false;
        // Calculamos la longitud máxima de las opciones
        for (String opcion : options) {
            if (opcion.length() > longitudMaxima) {
                longitudMaxima = opcion.length();
            }
        }

        // Dibujamos el cajón
        for (int i = 0; i < longitudMaxima + 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mostramos las opciones del menú
        for (int i = 0; i < options.length; i++) {
            System.out.print("| " + options[i]);
            for (int j = 0; j < longitudMaxima - options[i].length(); j++) {
                System.out.print(" ");
            }
            System.out.println(" |");
        }

        // Dibujamos el cajón
        for (int i = 0; i < longitudMaxima + 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("Elige una opción: ");
    }
}
