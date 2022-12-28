package Utils;

public class Utils {
    public static String b = "\u001B[0m";
    public static String negro = "\033[30m";
    public static String rojo = "\033[31m";
    public static String verde = "\033[32m";
    public static String amarillo = "\033[33m";
    public static String azul = "\033[34m";
    public static String magenta = "\033[35m";
    public static String celeste = "\033[36m";
    public static String blanco = "\033[37m";
    public static void escribir(String msn){
        for(int i=0;i<msn.length();i++ ){
            System.out.print(msn.charAt(i));
            try{
                Thread.sleep(20);
            }catch(InterruptedException e ){}
        }
    }

    /**
     * Metodo que le pide al usuario una confirmacion definitiva antes de realizar una accion "importante"
     * @param msn mensaje que imprimira como advertencia
     * @return devuelve un booleano que representa si el jugador decide si o no
     */
    public static boolean confirmar(String msn){
        boolean confirm=false;
        String respuesta;
        int i=0;
        try{
            do{
                System.out.println("\033[32m");
                System.out.println(msn);
                System.out.println("Are you sure?");
                System.out.println("1. Yes, you accept");
                System.out.println("2. No: you decline");
                System.out.println("\u001B[0m");
                respuesta=Read.sc.nextLine();
                respuesta=respuesta.toUpperCase();
                if(respuesta.equals("YES")){
                    confirm=true;
                    i++;
                }else if(respuesta.equals("NO")){
                    confirm=false;
                    i++;
                }else{
                    System.out.println("\033[32m");
                    System.out.println("Enter a valid option");
                    System.out.println("\u001B[0m");
                }
            }while(i==0);
        }catch (ExceptionInInitializerError e){
            System.out.println(rojo+"Enter a valid option"+b);
        }
        return confirm;
    }
}
