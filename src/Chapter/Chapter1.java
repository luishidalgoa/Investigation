package Chapter;

import Player.*;
import Items.*;
import Scene.Home.BedRoom;
import Utils.*;

import java.util.ArrayList;

public class Chapter1 {

    public static void Chapter1(Player player, BedRoom bedRoom, ArrayList<Item> Items) {
        boolean end = false;
        do {
            Scene(player, bedRoom);
        } while (end == false);
    }

    public static void Scene(Player player, BedRoom BedRoom) {
        if (player.getCurrentScene().equals("BedRoom")) {
            if (BedRoom.getDoor() == false && BedRoom.getItems().get(0).getQuantity() == 1) {
                String[] options = {"              Actions              ", "      [1]      Get key", "      [2]      Open the door", "              Move              "};
                Menu.showMenu(options);
                Control.bedRoom(player, BedRoom);
            }
        }
    }
}
