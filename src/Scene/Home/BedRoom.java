package Scene.Home;
import Items.*;
import Player.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BedRoom {
    /**
     * Nombre del escenario
     */
    final String name="BedRoom";
    /**
     * Lista de items del escenario
     */
    private ArrayList<Item> items;
    /**
     * Puerta principal de la habitacion
     */
    private boolean door=false;

    /**
     * este metodo devuelve el nombre de la habitacion . de este modo sabemos donde esta el jugador
     * @return
     */
    public String lookAround(){
        return name;
    }

    /**
     * Constructor que crea una copia vacia de la lista de items. y genera la cantidad de objetos que tendra el escenario
     */
    public BedRoom(){
        this.items=new ArrayList<>();
        this.items.add(0,GameItems.getKeyBedRoom());
        this.items.get(0).setQuantity(1);
        System.out.println("ArrayList BedRoom "+items.get(0).getQuantity());
    }

    /**
     * Este metodo devuelve la lista de items del escenario BedRoom
     * @return
     */
    public ArrayList<Item> getItems(){
        return this.items;
    }

    /**
     * Este metodo comprueba que el item buscado este dentro del escenario, si lo esta elimina -1 de cantidad
     * para posteriormente sumarselo al inventario del jugador
     * @param item item a buscar
     * @param quantity cantidad del item a buscar
     * @return
     */
    public boolean pickUpItem(int id,int quantity){
        boolean isTrue=false;
        if(this.items.get(id).getQuantity()>0){
            this.items.get(id).setQuantity(quantity);
            isTrue=true;
        }
        return isTrue;
    }

    /**
     * Este metodo podriamos utilizarlo para comprobar si un objeto puede ser utilizado en el escenario
     * @param index
     * @return
     */
    public boolean useItem(int index){
        boolean isTrue=false;
        return isTrue;
    }

    /**
     * Este metodo le dice al jugador a que escenario se ha trasladado
     * @param player recive al jugador
     */
    public void moveTo(Player player){
        //player.setCurrentScene("BedRoom");
    }

    /**
     * este metodo mostrara si la puerta esta abierta o cerrada
     * @return
     */
    public boolean getDoor(){
        return this.door;
    }

    /**
     * Metodo que permitira abrir la puerta del escenario
     */
    public void setDoor(){
        this.door=true;
    }
}
