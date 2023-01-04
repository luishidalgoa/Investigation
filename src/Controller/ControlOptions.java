package Controller;

import Items.GameItems;
import Items.Items;
import Items.Objects.Objects;
import Player.Player;
import Utils.Menu;
import Utils.Read;


import java.util.ArrayList;

public class ControlOptions {
    static GameItems gameItems = new GameItems();
    static String selectOption = null;
    static boolean ToHappend = false;

    /**
     * Metodo encargado de controlar el flujo de opciones segun lo que elija el usuario. De este modo si el jugador decide
     * interactuar con un item de un escenario. solo se ejecutara el metodo ItemsOptions... asi con los demas metodos
     *
     * @param player
     * @param id
     * @param ListArray
     * @param options
     */
    public static void flowOption(Player player, ArrayList<Integer> id, Items ListArray, ArrayList<String> options, ArrayList<Objects> ObjectScene) {
        ToHappend = false;
        int opcion = Read.leeEntero("Introdue the option valid");
        if (opcion < options.size()) {
            //almacenamos la opcion elegida por el jugador
            if (options.get(opcion) != null) {
                selectOption = options.get(opcion);
            }
            //averiguamos si hay items en el arrayList si los hay se procede a ejecutar las opciones del inventario del escenario
            if (ListArray.getListItem().size() > 0 && opcion < ListArray.getListItem().size() && !options.get(opcion).equals("more")) {
                ItemsOptions(player, id, opcion, ListArray, options);
            }
            if (options.get(opcion).equals("more")) {
                if (ObjectScene.size() > 0) {
                    moreOptions(player, id, options, ObjectScene);
                } else {
                    System.out.println("No more options");
                }
            }
            //debemos averigual la forma de acceder a valores del escenario que no sea items pero si interactuables
            if (!ToHappend) {
                MoveToOption(player, opcion, options);
            }
            //Debemos averiguar la forma de acceder a los valores del inventario del jugador
            if (!ToHappend && !options.get(opcion).equals("more")) {
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
    public static void ItemsOptions(Player player, ArrayList<Integer> id, int opcion, Items ListArray, ArrayList<String> options) { //id almacena en la posicion del array el id del item que buscamos
        for (boolean isTrue = false; !isTrue; ) {
            int quantity = Read.leeEntero("Has got " + ListArray.getListItem().get(id.get(opcion)).getQuantity() + " of units. How much would you like get?");
            if (quantity <= ListArray.getListItem().get(id.get(opcion)).getQuantity()) {
                isTrue = true;
                //comparamos el id del item escogido para interactuar con todos los items del juego y si es correcto realizamos la operacion
                if (id != null && id.size() > opcion) {
                    //opcion del item 0
                    if (id.get(opcion) == gameItems.getItem(0).getId()) {
                        player.addItem(0, quantity);
                        ListArray.PickUpItem(0, quantity);
                        ToHappend = true;
                    } //opcion del item 1
                    else if (id.get(opcion) == gameItems.getItem(1).getId()) {
                        player.addItem(1, quantity);
                        ListArray.PickUpItem(1, quantity);
                        ToHappend = true;
                    }//opcion del item 2
                    else if (id.get(opcion) == gameItems.getItem(2).getId()) {//opcion bug
                        player.addItem(2, quantity);
                        ListArray.PickUpItem(2, quantity);
                        ToHappend = true;
                    }
                }
            }
        }
    }

    /**
     * Metodo encargado de mover al jugador de un escenario en otro segun el escenario en el cual este
     *
     * @param player
     * @param opcion
     * @param options
     */
    public static void MoveToOption(Player player, int opcion, ArrayList<String> options) {
        if (player.getCurrentScene().equals("BedRoom")) {
            if (options.get(opcion).equals("LivingRoom")) {
                player.setCurrentScene("LivingRoom");
                ToHappend = true;
            }
        } else if (player.getCurrentScene().equals("LivingRoom")) {
            if (options.get(opcion).equals("BedRoom")) {
                player.setCurrentScene("BedRoom");
                ToHappend = true;
            }
        }
    }

    /**
     * Metodo encargado de interactuar con el inventario del jugador.
     *
     * @param player
     * @param id
     * @param opcion
     * @param ListArray
     * @param options
     */
    public static void PlayerInventory(Player player, ArrayList<Integer> id, int opcion, Items ListArray, ArrayList<String> options) {
        GameItems gameItems = new GameItems();
        for (boolean isTrue = false; !isTrue; ) {
            int quantity = Read.leeEntero("Have you got " + player.getInventory().getListItem().get(player.getInventory().searchId(selectOption, 1)).getQuantity() + " of units. How much would like put?");
            if (quantity <= player.getInventory().getListItem().get(player.getInventory().searchId(selectOption, 1)).getQuantity()) {
                isTrue = true;
                if (id != null && options.size() > opcion) {
                    //opcion del item 0
                    if (id.get(player.getInventory().searchId(selectOption, 1)) == gameItems.getItem(0).getId()) {
                        ListArray.addItem(0, player.getInventory().getListItem().get(0).getQuantity());
                        player.removeItem(0, player.getInventory().getListItem().get(0).getQuantity());
                        ToHappend = true;
                    } //opcion del item 1
                    else if (id.get(player.getInventory().searchId(selectOption, 1)) == gameItems.getItem(1).getId()) {
                        ListArray.addItem(id.get(opcion), player.getInventory().getListItem().get(1).getQuantity());
                        player.removeItem(1, player.getInventory().getListItem().get(1).getQuantity());
                        ToHappend = true;
                    }//opcion del item 2
                    else if (id.get(player.getInventory().searchId(selectOption, 1)) == gameItems.getItem(2).getId()) {//opcion bug
                        ListArray.addItem(id.get(opcion), player.getInventory().getListItem().get(2).getQuantity());
                        player.removeItem(2, player.getInventory().getListItem().get(2).getQuantity());
                        ToHappend = true;
                    }
                } else {
                    System.out.println("Introduce a option correct");
                }
            }
        }
    }

    /**
     * Metodo encargado de mostrar los Items dentro de un objeto interactuable. este metodo genera 2 tipos de menus diferentes:
     * - el menu de los objetos interactuables (more)
     * - el menu de los items dentro del objeto
     *
     * @param player
     * @param id
     * @param options
     * @param ObjectScene
     */
    public static void moreOptions(Player player, ArrayList<Integer> id, ArrayList<String> options, ArrayList<Objects> ObjectScene) {
        ToHappend = true;
        id.clear();
        options.clear();
        options.add("----MORE----");
        for (int i = 0; i < ObjectScene.size(); i++) {
            options.add(ObjectScene.get(i).getDescription());
            id = ObjectScene.get(i).getObjectItems().getIdItems(id);
        }
        options.add("Back");
        Menu.showMenu(player, options);
        options.remove(0);
        int opcion = Read.leeEntero("Introdue the option valid");
        if (!options.get(opcion).equals("Back") && opcion < options.size() && ObjectScene.get(opcion).getObjectItems().getListItem().size() > 0) {
            boolean isTrue = false;
            if (ObjectScene.get(opcion).getValue() == false) {
                if (player.getInventory().searchID(ObjectScene.get(opcion).getUnlocker())!=-1) {
                    ObjectScene.get(opcion).setValue(true);
                    player.getInventory().getListItem().get(player.getInventory().searchID(ObjectScene.get(opcion).getUnlocker())).setQuantity(-1);
                    isTrue = true;
                    selectOption = options.get(opcion);
                    String[] Options;
                    Options = ObjectScene.get(opcion).getOptionsItems();
                    options.clear();
                    for (int i = 0; i < ObjectScene.get(opcion).getObjectItems().getListItem().size(); i++) {
                        options.add(Options[i]);
                    }
                    Menu.showMenu(player, options);
                    opcion = Read.leeEntero("Introdue the option valid");
                    if (opcion < options.size()) {
                        if (ObjectScene.get(opcion).getObjectItems().getListItem().size() > 0 && opcion < ObjectScene.get(opcion).getObjectItems().getListItem().size()) {
                            player.getInventory().getListItem().get(player.getInventory().searchID(ObjectScene.get(opcion).getUnlocker())).setQuantity(-1);
                        } else {
                            System.out.println("Introduce a option correct");
                        }
                    } else {
                        System.out.println("Introduce a option correct");
                    }
                }
            }
            if (ObjectScene.get(opcion).getValue() == true || isTrue) {
                ItemsOptions(player, id, opcion, ObjectScene.get(opcion).getObjectItems(), options);
            } else {
                System.out.println("This " + ObjectScene.get(opcion).getName() + " it´s closed. you need a " + gameItems.getItem(ObjectScene.get(opcion).getUnlocker()).getName() + " for unloock the " + ObjectScene.get(opcion).getName());
            }
        } else {
            System.out.println("The "+ObjectScene.get(opcion).getName()+" is empty");
        }
    }
}