package Player;
import Items.*;

public class Player {
    private Items Inventory;
    private String currentScene;

    /**
     * Contructor que genera un nuevo inventario vacio del jugador y le dice en que posicion inicial esta
     * @param currentScene Escenario de inicio en el cual se ubica el jugador
     */
    public Player(String currentScene) {
        this.currentScene=currentScene;
        this.Inventory = new Items();
    }

    /**
     * Metodo que recive el item que agregaremos a nuestro inventario. El metodo addItem se encarga de comprobar si existe
     * ya ese item y si no existe lo agrega
     * @param item recive el item que agregara
     * @param quantity recive la cantidad del item que agregara
     */
    public void addItem(Item item, int quantity){
        Inventory.addItem(item,quantity);
        int id=item.getId();
        System.out.println("was successfully added to your inventory "+ this.Inventory.searchName(id));
    }
    public void removeItem(int id, int quantity){
        boolean isTrue=Inventory.removeItem(id,quantity);
        if(isTrue==false){
            System.out.println("you haven´t got any "+ Inventory.searchName(id));
        }
    }
    public Items getInventory() {
        return Inventory;
    }
    public String getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

}
