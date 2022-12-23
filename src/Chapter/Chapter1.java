package Chapter;

import Controller.Control;
import Player.*;
import Items.*;
import Scene.Home.BedRoom;
import Utils.*;

public class Chapter1 {
    BedRoom bedRoom;

    /**
     * Constructor que construye todos los escenarios del capitulo
     */
    public Chapter1(){
        this.bedRoom=new BedRoom();
    }

    public void flowChapter(Player player) {
        player.setCurrentScene("BedRoom");
        boolean end = false;
        do {
            System.out.println("CHECK");
            optionScene(player);
        } while (end == false);
    }

    public void optionScene(Player player) {
        if (player.getCurrentScene().equals("BedRoom")) {
            if (this.bedRoom.getDoor() == false) { //&& this.bedRoom.getItems().searchQuantity(id.getKeyBedRoom())== 1
                String[] options = {"              Actions              ", "      [1]      Get key", "      [2]      Open the door", "              Move              "};
                Menu.showMenu(options);
                Control.bedRoom(player, bedRoom);
            }else{
                System.out.println("EROR");
            }
        }
    }
}
