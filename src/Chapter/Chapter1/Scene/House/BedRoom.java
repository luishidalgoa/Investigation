package Chapter.Chapter1.Scene.House;
import Items.*;
import Player.Player;
public class BedRoom {
    final String name="BedRoom";
    private Items SceneItems;
    private boolean door=false;
    private String[]moveToScene={"LivingRoom"};

    /**
     * Constructor inicial que construye todos los elementos necesarios dentro de un escenario.
     * Creandole por ejemplo el ArrayList de items donde almacenara los items
     */
    public BedRoom(){
        this.SceneItems=new Items();
        this.SceneItems.addItem(2,2);
        this.SceneItems.addItem(1,1);
        this.SceneItems.addItem(0,1);
    }

    /**
     * Este metodo recoge todos los items del escenario y devuelve un array con todas las opciones que tiene los items almacenados
     * @return
     */
    public String[] getOptionsItems(){ //Funciona Correctamente
        int n=0;
        int[]id = new int[this.SceneItems.getListItem().size()];
        for(int i=0;i<this.SceneItems.getListItem().size();i++){
            if(this.SceneItems.getListItem().get(i)!=null){
                n++;
                id[n-1]=i;
            }
        }
        String[]options=new String[n];//este array almacenara todos los comandos de cada item
        for(int i=0;i<n;i++){
            options[i]=this.SceneItems.getListItem().get(id[i]).getOption();
        }
        return options;
    }
    public String moveTo(int i){
        return this.moveToScene[i];
    }
    public String[] getMoveToScene(){ return this.moveToScene; }
}
