package Items.Objects;

import Items.*;

import java.util.ArrayList;

public class Objects {
    private String name;
    /**
     * Este atributo almacena el nombre de la accion interactuable. Es decir lo que se imprimira al jugador por ejemplo
     * "abrir cajon"
     */
    private String option;
    private boolean value;
    private int unlocker;
    private Items ObjectItems;
        public Objects(String name,String option,boolean value,int unlocker,int[] id,int[]quantity){
        this.name=name;
        this.option=option;
        this.value=value;
        this.unlocker=unlocker;
        this.ObjectItems=new Items();
        if(id.length>0 && quantity.length>0){
            addItems(id,quantity);
        }
    }
    public void addItems(int[]id,int[]quantity){
            for(int i=0;i<id.length;i++){
                this.ObjectItems.addItem(id[i],quantity[i]);
            }
    }
    /**
     * Este metodo recoge todos los items del escenario y devuelve un array con todas las opciones que tiene los items almacenados
     * @return
     */
    public String[] getOptionsItems(){
        int n=0;
        int[]id = new int[this.ObjectItems.getListItem().size()];
        for(int i=0;i<this.ObjectItems.getListItem().size();i++){
            if(this.ObjectItems.getListItem().get(i)!=null){
                n++;
                id[n-1]=i;
            }
        }
        String[]options=new String[n];//este array almacenara todos los comandos de cada item
        for(int i=0;i<n;i++){
            options[i]=this.ObjectItems.getListItem().get(id[i]).getOption(0);
        }
        return options;
    }
    public String getName(){return this.name;}
    public String getDescription(){
            return this.option;
    }
    public void setDescription(String msn){
        this.option=msn;
    }
    public boolean getValue(){return this.value;}
    public void setValue(boolean value){this.value=value;}
    public int getUnlocker() {
        return unlocker;
    }
    public Items getObjectItems(){return this.ObjectItems;}

}
//Esta clase nos permitira crear cajones, mesas, puertas... debemos implementarla dentro del Menu, y el Chapter1