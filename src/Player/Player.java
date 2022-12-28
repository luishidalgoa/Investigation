package Player;

import Items.Items;

import java.util.ArrayList;

public class Player {
    private Items Inventory;
    private String currentScene;
    public String lastOption;

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
        System.out.println("was successfully added to your inventory " + this.Inventory.GameItems.getItem(id).getName());
    }

    /**
     * Metodo el cual elimina un item en concreto
     * @param id recive el identificador del item a eliminar
     * @param quantity cantidad deseada a eliminar
     */
    public void removeItem(int id, int quantity) {
        boolean isTrue = Inventory.PickUpItem(id, quantity);
        if (!isTrue) {
            System.out.println("you haven´t got any " + Inventory.getListItem().get(id).getName());
        }
    }

    /**
     * Este metodo retorna el Inventario del jugador en forma de ArrayList
     * @return devuelve el inventario
     */
    public String[] getOptionsItems(){ //Funciona Correctamente
        int n=0;
        int[]id = new int[this.Inventory.getListItem().size()];
        for(int i=0;i<this.Inventory.getListItem().size();i++){
            if(this.Inventory.getListItem().get(i)!=null){
                n++;
                id[n-1]=i;
            }
        }
        String[]options=new String[n];//este array almacenara todos los comandos de cada item
        for(int i=0;i<n;i++){
            options[i]=this.Inventory.getListItem().get(id[i]).getOption(1);
        }
        return options;
    }

    /**
     * Metodo el cual devolvera uno a uno el id de los items que contiene
     * @return
     */
    public ArrayList<Integer> getIdItems(ArrayList<Integer>id){ //Funciona Correctamente
        for(int i=0;i<this.Inventory.getListItem().size();i++){
            if(this.Inventory.getListItem().get(i)!=null){
                id.add(this.Inventory.getListItem().get(i).getId());
            }
        }
        return id;
    }
    public Items getInventory() {
        return Inventory;
    }

    /**
     * Metodo que devuelve el nombre de la escena en la cual se ubica el jugador
     * @return devuelve el nombre del escenario en el cual el jugador esta
     */
    public String getCurrentScene() {
        return currentScene;
    }

    /**
     * Metodo que establece el nombre de la escena en la cual el jugador se ha movido
     * @param currentScene nombre de la escena
     */
    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

}

