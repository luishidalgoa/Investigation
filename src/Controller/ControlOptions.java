package Controller;
import Items.GameItems;
import Items.Item;
import Items.Items;
import Player.Player;
import Utils.Read;


import java.util.ArrayList;

public class ControlOptions {
    static String selectOption=null;
    public static void flowOption(Player player, int[]id, Items ListArray,ArrayList<String>options){
        int opcion= Read.leeEntero("Introduce opcion");
        if(opcion<options.size()){
            if(options.get(0).equals("----MOVE TO----")){
                options.remove(0);
            }
            ItemsOptions(player,id,opcion,ListArray,options);
            //debemos averigual la forma de acceder a valores del escenario que no sea items pero si interactuables
            MoveToOption(player,opcion,options);
            //Debemos averiguar la forma de acceder a los valores del inventario del jugador
            player.lastOption=selectOption;
        }else{
            System.out.println("Introduce a option correct");
        }
    }
    /**
     * Este metodo se encarga de analizar todos los items del array de opciones disponibles. compara el string recivido
     * @param player
     * @param options
     */
    public static void ItemsOptions(Player player, int[]id,int opcion, Items ListArray,ArrayList<String>options){ //id almacena en la posicion del array el id del item que buscamos
        GameItems gameItems=new GameItems();
        //almacenamos la opcion elegida por el jugador
        if(options.get(opcion)!=null){
            selectOption=options.get(opcion);
        }
        for(int i=opcion;i<opcion+1;i++){
            //comparamos el id del item escogido para interactuar con todos los items del juego y si es correcto realizamos la operacion
            if(id!=null && id.length>opcion){
                if(id[opcion]== gameItems.getItem(0).getId()){
                    player.addItem(0,ListArray.getListItem().get(0).getQuantity());
                    ListArray.PickUpItem(id[i],ListArray.getListItem().get(0).getQuantity());
                } else if(id[opcion]== gameItems.getItem(1).getId()){
                    player.addItem(1,ListArray.getListItem().get(1).getQuantity());
                    ListArray.PickUpItem(id[i],ListArray.getListItem().get(1).getQuantity());
                }else if(id[opcion]== gameItems.getItem(2).getId()){//opcion bug
                    player.addItem(2,ListArray.getListItem().get(2).getQuantity());
                    ListArray.PickUpItem(id[i],ListArray.getListItem().get(2).getQuantity());
                }
            }
        }
    }
    public static void MoveToOption(Player player,int opcion, ArrayList<String> options){
        if(options.get(opcion)!=null){
            selectOption=options.get(opcion);
        }
        if(player.getCurrentScene().equals("BedRoom")){
            if(options.get(opcion).equals("LivingRoom")){
                player.setCurrentScene("LivingRoom");
            }
        }else if(player.getCurrentScene().equals("LivingRoom")){
            if(options.get(opcion).equals("BedRoom")){
                player.setCurrentScene("BedRoom");
            }
        }
    }
    public static void PlayerInventory(Player player,ArrayList<String>options){

    }
}
