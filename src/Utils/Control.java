package Utils;
import Player.*;
import Scene.Home.BedRoom;

public class Control {
    public static void bedRoom(Player player,BedRoom bedRoom){
        int option=Read.sc.nextInt();
        switch (option){
            case 1:
                player.addItem(0);
                bedRoom.getItems().get(0).setQuantity(-1);
        }
    }
}
