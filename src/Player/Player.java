package Player;

import Items.Items;

public class Player {
    private Items Inventory;
    private String currentScene;

    /**
     * Contructor que genera un nuevo inventario vacio del jugador y le dice en que posicion inicial esta
     *
     * @param currentScene Escenario de inicio en el cual se ubica el jugador
     */
    public Player(String currentScene) {
        this.currentScene = currentScene;
        this.Inventory = new Items();
    }

    /**
     * Metodo que su funcion es enviarle un mensaje al jugador de que se agrego un item a su inventario. Este
     * metodo hace uso de otro metodo de la clase Items.addItem(id,quantity)
     *
     * @param id       recive el id del item que deseamos agregar
     * @param quantity recive la cantidad del item que agregara
     */
    public void addItem(int id, int quantity) {
        Inventory.addItem(id, quantity);
        System.out.println("was successfully added to your inventory " + this.Inventory.getListItem().get(id).getName());
    }

    public void removeItem(int id, int quantity) {
        boolean isTrue = Inventory.PickUpItem(id, quantity);
        if (isTrue == false) {
            System.out.println("you haven´t got any " + Inventory.getListItem().get(id).getName());
        }
    }

    public Items getInventory() {
        return Inventory;
    }

    /**
     * Metodo que devuelve el nombre de la escena en la cual se ubica el jugador
     *
     * @return
     */
    public String getCurrentScene() {
        return currentScene;
    }

    /**
     * Metodo que establece el nombre de la escena en la cual el jugador se ha movido
     *
     * @param currentScene nombre de la escena
     */
    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

}

