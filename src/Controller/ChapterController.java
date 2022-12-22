package Controller;
import Chapter.*;
import Player.Player;
import Items.Item;
import Scene.Home.BedRoom;

import java.util.ArrayList;

public class ChapterController {
    static String currentChapter="LivingRoom";
    public static void create(){
        ArrayList<Item> Items=new ArrayList<>();
        //Generamos los items del juego
        Item key=new Item("key","this key oppen the dor"); //0
        Items.add(key);
        System.out.println(Items.size());
        System.out.println(Items.get(0));

        Player player=new Player(Items);
        BedRoom bedRoom=new BedRoom(Items);
        ChapterFlow(player,bedRoom, Items);
    }

    /**
     * Metodo que ejecutara el primer capitulo. y cuando este finalice avanzara al siguiente hasta finalizar el juego
     * @param player recive el objeto Player
     * @param Items recive un arrayList con todos los items del juego
     */
    public static void ChapterFlow(Player player,BedRoom bedRoom, ArrayList<Item> Items){
        currentChapter="Chapter one";
        Chapter1.Chapter1(player,bedRoom,Items);
        System.out.println("END");
    }
}
