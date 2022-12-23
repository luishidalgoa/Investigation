package Controller;

import Items.id;
import Player.*;
import Scene.Home.BedRoom;
import Utils.Read;

public class Control {
    public static void bedRoom(Player player, BedRoom bedRoom) {
        int option = Read.sc.nextInt();
        switch (option) {
            /**
             * este case agregara el item key . si hay una key en el arrayList del escenario bedroom
             */
            case 1:
                boolean isTrue;
                isTrue = bedRoom.pickUpItem(id.getKeyBedRoom(),1);
                if (isTrue == true) {
                    player.addItem(id.getKeyBedRoom(),+1);
                }
                break;
            case 2:
                System.out.println("CHECK1 "+ player.getInventory().searchQuantity(id.getKeyBedRoom()));
                System.out.println("CHECK2 "+ bedRoom.getItems().searchQuantity(id.getKeyBedRoom()));
                if(player.getInventory().searchQuantity(id.getKeyBedRoom())>0) {
                    bedRoom.setDoor();
                    System.out.println("The door opened.");
                }else{
                    System.out.println("Please. Introduce the key");
                }
                break;
            default:
                System.out.println("introduce a correct option");
        }
    }
}
