package Items;
import java.util.ArrayList;

public class Items {
    /**
     * Tendremos una zona en memoria asociada con la zona en memoria del objeto Items.
     * La cual contiene una libreria de todos los items
     */
    public GameItems GameItems;
    /**
     * En este ArrayList almacenamos todos los Items. Actua como inventario
     */
    private ArrayList<Item> ListItems;

    /**
     * Este constructor creara desde 0 todos los Items pertinentes . Ademas de una lista Vacia
     */
    public Items(){
        this.GameItems=new GameItems();
        this.ListItems=new ArrayList<>();
    }

    /**
     * recivie la posicion en el ArrayLIst del item que deseamos alterar. para posteriormente calcula el id del item
     * y modificarlo en el Inventario del escenario o jugador
     * @param pos posicion el el ArrayList del item a buscar
     * @return devolvera true o false . Que significa si la operacion a sido exitosa o fracaso
     */
    public boolean PickUpItem(int pos,int quantity){ //este metodo podriamos revisionarlo
        //Ya que importamos la posicion en el ArrayList del item en cuestion. traducimos la posicion en el ArrList por el id buscado
        pos=searchID(pos);
        boolean isTrue=false;
        if(ListItems.get(pos)!=null && this.ListItems.get(pos).getQuantity()>1){
            this.ListItems.get(pos).setQuantity(-quantity);
            isTrue=true;
        }else if(ListItems.get(pos)!=null){
            ListItems.get(pos).setQuantity(-quantity);
            ListItems.remove(pos);
            isTrue=true;
        }else {
            System.out.println("ERROR NO EXISTE EL ITEM A BORRAR");
        }
        return isTrue;
    }

    /**
     * Metodo que agrega un nuevo item en la misma posicion del id del Item.
     * Este metodo comprobara si la posicion esta vacia. Si lo esta lo agregara el item desde 0.
     * Si no le sumara la cantidad especificada
     * @param id Recive el id o posicion del objeto a crear
     */
    public void addItem(int id,int quantity){
        //isTrue nos indicara si el item esta creado o no
        boolean isTrue=false;
        try{
            if(this.ListItems.size()==0){
                isTrue=false;
            }else if(id>=this.ListItems.size()){
                isTrue=false;
            }else{
                isTrue=true;
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println("ERROR");
        }
        if(isTrue==false){
            this.ListItems.add(GameItems.getItem(id));
            int pos=searchID(id);
            if(pos!=-1){
                this.ListItems.get(pos).setQuantity(quantity);
            }
        }else{
            if(searchID(id)==-1){
                this.ListItems.add(GameItems.getItem(id));
            }else{
                this.GameItems.getItem(id).setQuantity(quantity);
            }
        }
    }

    /**
     * Devuelve la posicion en el ArrayList del id buscado
     * @param id recive el id del objeto que buscamos
     * @return devuelve la posicion en el array
     */
    public int searchID(int id){
        int pos=-1;
        for(int i=0;i<ListItems.size();i++){
            if(id==this.ListItems.get(i).getId()){
                pos=i;
            }
        }
        return pos;
    }
    /**
     * Metodo que devuelve el ArrayList con todos los items registrados en el Inventario del objeto x
     * @return
     */
    public ArrayList<Item> getListItem(){return this.ListItems;}
}
