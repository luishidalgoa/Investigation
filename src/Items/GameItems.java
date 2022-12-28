package Items;

/**
 * Almacena todos los items del juego
 */
public class GameItems {
    /**
     * Array que actua de libreria de todos los Items del juego. Cada posicion del array es = al id
     */
    public Item[]Array=new Item[3];

    /**
     * Constructor que construye en una posicion del Array. Un nuevo Item
     * La posicion del array es = al id
     */
    public GameItems(){
        Array[0] = new Item(0, "key", "This key oppen the door of the bedroom", 0, new String[] {"Get key", "key"});
    }

    /**
     * Metodo que devuelve el item con el id buscado
     * @param pos recive la posicion en el array o id del item que buscamos
     */
    public Item getItem(int pos){
        return Array[pos];
    }
}
