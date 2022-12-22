package Scene.Home;
import Controller.ChapterController;
import Items.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BedRoom {
    final String name="BedRoom";
    private ArrayList<Item> items;
    private boolean door=false;
    public BedRoom(ArrayList<Item> Items){
        items=Items;
        items.get(0).setQuantity(1);
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public boolean getDoor(){
        return this.door;
    }
}
