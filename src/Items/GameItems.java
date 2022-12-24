package Items;

/**
 * Clase que almacena una libreria de items del juego. Estos items son importados en otras clases u objetos
 */
public class GameItems { //ERROR . LOS ARRAYLIST APUNTAN A ESTOS ITEMS. POR LO QUE SI LA CANTIDAD DE 1 . SUBEN LA DE TODOS. creo que el problema viene de los gets ya que devuelven
    private static Item keyBedRoom=new Item(0,"key","This key oppen the door of the bedroom",0); //0
    private static Item keyHouse=new Item(1,"key","This key oppen the door of the house",0); //1

    public static Item getKeyBedRoom() {
        return keyBedRoom;
    }
    public static Item getKeyHouse() {
        return keyHouse;
    }
}
