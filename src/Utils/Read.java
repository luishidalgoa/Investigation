package Utils;

import java.util.Scanner;

public class Read {
    static Scanner sc=new Scanner(System.in);

    /**
     * Metodo que imprime un mensaje y posteriormente pide al usuario introducir un numero entero
     * @param msn
     * @return
     */
    public static int leeEntero(String msn){
        int numero=0;
        try{
            System.out.println(msn);
            numero=sc.nextInt();
        }catch (Exception e){
            System.out.println(Utils.rojo+"Introduce un numero valido"+Utils.b);
        }
        sc.nextLine();
        return numero;
    }
}
