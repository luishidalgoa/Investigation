package Player;
import Items.*;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> Inventory=new ArrayList<Item>();
    private String currentScene="BedRoom";

    /**
     * Constructor que crea una copia vacia del ArrayList Items. de este modo podremos luego sumarle o restarle items al inventario
     * @param Items Recive el ArrayList del metodo ChapterController el cual almacena Todos los ID de los items y propiedades
     */
    public Player(ArrayList<Item> Items){
        Inventory=Items;
    }
    public void addItem(int index){
        Inventory.get(index).setQuantity(1);
        System.out.println("was successfully added to your inventory "+ Inventory.get(index).getName());
    }
    public ArrayList<Item> getInventory() {
        return Inventory;
    }
    public String getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

}
