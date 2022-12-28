package Controller;

import Items.GameItems;
import Items.Items;
import Player.Player;
import Utils.Read;


import java.util.ArrayList;

public class ControlOptions {
    static String selectOption = null;
    static boolean ToHappend=false;

    public static void flowOption(Player player,ArrayList<Integer>id, Items ListArray, ArrayList<String> options) {
        ToHappend=false;
        int opcion = Read.leeEntero("Introdue the option valid");
        if (opcion < options.size()) {
            //averiguamos si hay items en el arrayList si los hay se procede a ejecutar las opciones del inventario del escenario
            if(ListArray.getListItem().size()>0 && opcion<ListArray.getListItem().size()){
                ItemsOptions(player, id, opcion, ListArray, options);
            }
            //debemos averigual la forma de acceder a valores del escenario que no sea items pero si interactuables
            if(!ToHappend){
                MoveToOption(player, opcion, options);
            }
            //Debemos averiguar la forma de acceder a los valores del inventario del jugador
            if(!ToHappend){
                PlayerInventory(player, id, opcion, ListArray, options);
            }
            player.lastOption = selectOption;
        } else {
            System.out.println("Introduce a option correct");
        }
    }

    /**
     * Este metodo se encarga de analizar todos los items del array de opciones disponibles. compara el string recivido
     *
     * @param player
     * @param options
     */
    public static void ItemsOptions(Player player,ArrayList<Integer>id, int opcion, Items ListArray, ArrayList<String> options) { //id almacena en la posicion del array el id del item que buscamos
        GameItems gameItems = new GameItems();
        //almacenamos la opcion elegida por el jugador
        if (options.get(opcion) != null) {
            selectOption = options.get(opcion);
        }
        for(boolean isTrue=false;!isTrue;) {
            int quantity = Read.leeEntero("Has got " + ListArray.getListItem().get(id.get(opcion)).getQuantity() + " of units. How much would you like get?");
            if (quantity <= ListArray.getListItem().get(id.get(opcion)).getQuantity()) {
                isTrue=true;
                //comparamos el id del item escogido para interactuar con todos los items del juego y si es correcto realizamos la operacion
                if (id != null && id.size() > opcion) {
                    //opcion del item 0
                    if (id.get(opcion) == gameItems.getItem(0).getId()) {
                        player.addItem(0, quantity);
                        ListArray.PickUpItem(0, quantity);
                        ToHappend=true;
                    } //opcion del item 1
                    else if (id.get(opcion) == gameItems.getItem(1).getId()) {
                        player.addItem(1, quantity);
                        ListArray.PickUpItem(1, quantity);
                        ToHappend=true;
                    }//opcion del item 2
                    else if (id.get(opcion) == gameItems.getItem(2).getId()) {//opcion bug
                        player.addItem(2, quantity);
                        ListArray.PickUpItem(2, quantity);
                        ToHappend=true;
                    }
                }
            }
        }
    }

    public static void MoveToOption(Player player, int opcion, ArrayList<String> options) {
        if (options.get(opcion) != null) {
            selectOption = options.get(opcion);
        }
        if (player.getCurrentScene().equals("BedRoom")) {
            if (options.get(opcion).equals("LivingRoom")) {
                player.setCurrentScene("LivingRoom");
                ToHappend=true;
            }
        } else if (player.getCurrentScene().equals("LivingRoom")) {
            if (options.get(opcion).equals("BedRoom")) {
                player.setCurrentScene("BedRoom");
                ToHappend=true;
            }
        }
    }

    public static void PlayerInventory(Player player,ArrayList<Integer>id, int opcion, Items ListArray, ArrayList<String> options) {
        GameItems gameItems = new GameItems();
        if (options.get(opcion) != null) {
            selectOption = options.get(opcion);
        }
        for(boolean isTrue=false;!isTrue;){
            int quantity=Read.leeEntero("Have you got "+player.getInventory().getListItem().get(options.size()-(id.size()+opcion)).getQuantity()+" of units. How much would like put?");
            if(quantity<=player.getInventory().getListItem().get(options.size()-(id.size()+opcion)).getQuantity()){
                isTrue=true;
                if (id != null && options.size()>opcion) {
                    //opcion del item 0
                    if (id.get(options.size()-(id.size()+opcion)) == gameItems.getItem(0).getId()) {
                        ListArray.addItem(0, player.getInventory().getListItem().get(0).getQuantity());
                        player.removeItem(0, player.getInventory().getListItem().get(0).getQuantity());
                        ToHappend=true;
                    } //opcion del item 1
                    else if (id.get(options.size()-(id.size()+opcion)) == gameItems.getItem(1).getId()) {
                        ListArray.addItem(id.get(opcion), player.getInventory().getListItem().get(1).getQuantity());
                        player.removeItem(1, player.getInventory().getListItem().get(1).getQuantity());
                        ToHappend=true;
                    }//opcion del item 2
                    else if (id.get(options.size()-(id.size()+opcion)) == gameItems.getItem(2).getId()) {//opcion bug
                        ListArray.addItem(id.get(opcion), player.getInventory().getListItem().get(2).getQuantity());
                        player.removeItem(2, player.getInventory().getListItem().get(2).getQuantity());
                        ToHappend=true;
                    }
                }else {
                    System.out.println("Introduce a option correct");
                }
            }
        }
    }
}