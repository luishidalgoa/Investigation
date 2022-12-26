package Controller;
import Items.GameItems;
import Items.Item;
import Items.Items;
import Player.Player;
import Utils.Read;


import java.util.ArrayList;

public class ControlOptions {
    /**
     * Este metodo se encarga de analizar todos los items del array de opciones disponibles. compara el string recivido
     * @param player
     * @param options
     */
    public static void ControlOptions(Player player, int[]id, Items ListArray,ArrayList<String>options){ //id almacena en la posicion del array el id del item que buscamos
        GameItems gameItems=new GameItems();
        int opcion= Read.leeEntero("Introduce opcion");
        for(int i=opcion;i<opcion+1;i++){
            //comparamos el id del item escogido para interactuar con todos los items del juego y si es correcto realizamos la operacion
            if(id!=null && id.length>opcion){
                if(id[opcion]== gameItems.getItem(0).getId()){
                    player.addItem(0,ListArray.getListItem().get(0).getQuantity());
                    ListArray.PickUpItem(id[i],ListArray.getListItem().get(0).getQuantity());
                } else if(id[opcion]== gameItems.getItem(1).getId()){
                    player.addItem(1,ListArray.getListItem().get(1).getQuantity());
                    ListArray.PickUpItem(id[i],ListArray.getListItem().get(1).getQuantity());
                }if(id[opcion]== gameItems.getItem(2).getId()){//opcion bug

                }
            }else {
                if(player.getCurrentScene().equals("BedRoom")){
                    if(options.get(opcion).equals("LivingRoom")){
                        player.setCurrentScene("LivingRoom");
                    }
                }else if(player.getCurrentScene().equals("LivingRoom")){
                    if(options.get(opcion+1).equals("BedRoom")){
                        player.setCurrentScene("BedRoom");
                    }
                }
            }
        }
    }
    public static void PlayerOptions(Player player,ArrayList<String>options){

    }
}
