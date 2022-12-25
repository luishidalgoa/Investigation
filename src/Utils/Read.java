package Utils;

import java.util.Scanner;

public class Read {
    static Scanner sc=new Scanner(System.in);
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
