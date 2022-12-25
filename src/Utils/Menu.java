package Utils;


public class Menu {
    public static void showMenu(String[] options) {
        int longitudMaxima = 0;
        if (options.length == 0) {
            // Asignamos un nuevo espacio en memoria al arreglo y agregamos el mensaje
            options = new String[1];
            options[0] = "No hay opciones disponibles";
        }

        // Calculamos la longitud máxima de las opciones
        for (String opcion : options) {
            if (opcion.length() > longitudMaxima) {
                longitudMaxima = opcion.length();
            }
        }

        // Dibujamos el cajón
        for (int i = 0; i < longitudMaxima + 14; i++) {
            System.out.print("-");
        }
        System.out.println();
        // Mostramos las opciones del menú
        System.out.print("|"); // Agregamos una línea en blanco entre el cajón y la primera opción
        for (int j = 0; j < longitudMaxima + 12; j++) {
            System.out.print(" ");
        }
        System.out.println("|");
        for (int i = 0; i < options.length; i++) {
            System.out.print("|    ["+i+"]    " + options[i]);
            for (int j = 0; j < longitudMaxima - options[i].length(); j++) {
                System.out.print(" ");
            }
            System.out.println(" |");
            System.out.print("|"); // Agregamos una línea en blanco entre opción y opción
            for (int j = 0; j < longitudMaxima + 12; j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        // Dibujamos el cajón
        for (int i = 0; i < longitudMaxima + 14; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("Elige una opción: ");
    }
}
