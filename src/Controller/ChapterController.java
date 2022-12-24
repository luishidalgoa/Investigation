package Controller;
import Chapter.*;
import Items.*;
import Player.Player;

public class ChapterController {
    static String currentChapter;
    private Player player;

    /**
     * En este metodo creamos la lista de Items del juego, ademas de crear los items uno a uno y agregarlos a la lista
     * tambien creamos el jugador . y una vez creado todo entonces se ejecuta el flujo de capitulos
     */
    public ChapterController(){
        this.player = new Player("BedRoom");
        ChapterFlow();
    }

    /**
     * Metodo que ejecutara el primer capitulo. y cuando este finalice avanzara al siguiente hasta finalizar el juego
     */
    public void ChapterFlow(){
        currentChapter="Chapter one";
        System.out.println("CHECK INVENTORY "+ player.getInventory().searchQuantity(0));
        Chapter1 Chapter1=new Chapter1();
        System.out.println("CHECK INVENTORY "+ player.getInventory().searchQuantity(0));
        Chapter1.flowChapter(this.player);
        System.out.println("END");
    }
}
