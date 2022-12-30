package Chapter.Chapter1;

import Chapter.Chapter1.Scene.House.BedRoom;
import Chapter.Chapter1.Scene.House.LivingRoom;
import Controller.ControlOptions;
import Items.Items;
import Items.Objects.Objects;
import Player.*;
import Utils.*;

import java.util.ArrayList;

public class Chapter1 {
    private final BedRoom  bedRoom;
    private final LivingRoom livingRoom;
    /**
     * Atributo usado en otros metodos para almacenar las opciones disponibles en un escenario tras calcularlo
     */
    private ArrayList<String> options=new ArrayList<>();
    /**
     * Atributo que es usado con el objetivo de apuntar en la misma zona en memoria que el inventario de los escenarios
     */
    private Items ArrayListScene;
    private ArrayList<Objects> ObjectScene;
    /**
     * Almacena en un ArrayList todos los id de los items del escenario
     */
    private ArrayList<Integer>id=new ArrayList<>();

    /**
     * Construye los escenarios del capitulo
     */
    public Chapter1() {
        this.bedRoom = new BedRoom();
        this.livingRoom = new LivingRoom();
    }

    /**
     * Metodo encargado de controlar el flujo del capitulo
     * @param player recive el objeto player
     */
    public void flowChapter(Player player) { //podriamos pensar una forma mejor en la cual ejecutar el control de flujo
        player.setCurrentScene("BedRoom");
        boolean end;
        do {
            end = false;
            optionScene(player);
        } while (!end);
    }

    /**
     * Metodo el cual calcula todos los items de un escenario y los lugares a los cuales puede ir el jugador atraves de ese escenario
     * una vez echos los calculos los envia al metodo Menu.showMenu(). el cual imprimira en pantalla las opciones
     * @param player importa el objeto Player
     */
    public void optionScene(Player player) {
        id.clear();
        String[] options;
        if(!this.options.isEmpty()){
            this.options.clear();
        }// Opcion a ejecutar si el jugador esta en el escenario BedRoom
        this.options.add("    "+player.getCurrentScene()+"    ");
        if (player.getCurrentScene().equals("BedRoom")) {
            this.options.add("----INTERACT----");
            options=bedRoom.getOptionsItems();
            for(int i=0;i<bedRoom.getOptionsItems().length;i++){
                this.options.add(options[i]);
            }
            this.options.add("more");
            this.options.add("----MOVE TO----");
            for(int i=0;i<bedRoom.getMoveToScene().length;i++){
                this.options.add(bedRoom.moveTo(i));
            }
            id=bedRoom.getIdItems(id);
            this.ArrayListScene=bedRoom.getSceneItems();
            this.ObjectScene=bedRoom.getObjects();

        } // Opcion a ejecutar si el escenario es LivingRoom
        else if (player.getCurrentScene().equals("LivingRoom")) {
            this.options.add("----INTERACT----");
            options=livingRoom.getOptionsItems();
            for(int i=0;i<livingRoom.getOptionsItems().length;i++){
                this.options.add(options[i]);
            }
            this.options.add("more");
            this.options.add("----MOVE TO----");
            for(int i=0;i<livingRoom.getMoveToScene().length;i++){
                this.options.add(livingRoom.moveTo(i));
            }
            id=livingRoom.getIdItems(id);
            this.ArrayListScene=livingRoom.getSceneItems();
            this.ObjectScene=livingRoom.getObjects();
        }
        //Almacenamos todos los items del inventario del jugador
        if(player.getInventory()!=null){
            this.options.add("----Inventory----");
            options=player.getOptionsItems();
            for(int i=0;i<player.getOptionsItems().length;i++){
                this.options.add(options[i]);
            }
            id=player.getInventory().getIdItems(id);
        }
        Menu.showMenu(player, this.options);
        //Eliminamos del arrayList la opcion Interact y moveTo
        for(int i=0;i<this.options.size();i++){
            if(this.options.get(i).equals("    "+player.getCurrentScene()+"    ")){
                this.options.remove(i);
            }
            if(this.options.get(i).equals("----INTERACT----")){
                this.options.remove(i);
            }
            if(this.options.get(i).equals("----MOVE TO----")){
                this.options.remove(i);
            }
            if(this.options.get(i).equals("----Inventory----")){
                this.options.remove(i);
            }
        }
        ControlOptions.flowOption(player,id,ArrayListScene,this.options,this.ObjectScene);
    }
}
/**
 * Debemos desarrollar el menu "more"
 */