package Controller;

import Items.GameItems;
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
                isTrue = bedRoom.pickUpItem(0,1);
                if (isTrue == true) {
                    player.addItem(GameItems.getKeyBedRoom(),+1);
                }
                break;
            case 2:
                System.out.println("CHECK1 "+ player.getInventory().searchName(0));
                System.out.println("CHECK2 "+ player.getInventory().searchName(0));
                if(player.getInventory().searchQuantity(0)>0) {
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
