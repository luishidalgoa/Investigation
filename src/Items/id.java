package Items;

/**
 * Clase que almacena una libreria de items del juego. Estos items son importados en otras clases u objetos
 */
public class id {
    private static Item keyBedRoom=new Item(0,"key","This key oppen the door of the bedroom",0); //0
    private static Item keyHouse=new Item(1,"key","This key oppen the door of the house",0); //1

    public static Item getKeyBedRoom() {
        return keyBedRoom;
    }
    public static Item getKeyHouse() {
        return keyHouse;
    }
}
