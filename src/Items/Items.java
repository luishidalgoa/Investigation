package Items;

import java.util.ArrayList;

public class Items {
    private ArrayList<Item> items;
    private int count=0;

    /**
     * Constructor para crear una nueva lista de Items
     */
    public Items() {
        this.items = new ArrayList<Item>();
    }

    /**
     * recorre todo el arraylist buscando que el id del item que deseamos agregar. este registrado en el arraylist.
     * Si se encuentra ese item. se le agrega la cantidad requerida si no crea ese nuevo item en el arrayList
     * @param item importa el item que vamos agregar . y el item a comprobar que exista en el arraylist
     * @param quantity cantidad del item que agregaremos al ArrayList
     */
    public void addItem(Item item,int quantity) {
        this.items.add(this.count,item);
        count++;
    }

    /**
     * Este método tiene el objetivo de eliminar un item de la lista de items. Si se pasa una cantidad negativa,
     * el método asume que se quiere eliminar el item completo. Si se pasa una cantidad positiva,
     * el método asume que se quiere eliminar una cantidad específica de unidades del item.
     * @param item importa el item que vamos eliminar . y el item a comprobar que exista en el arraylist
     * @param quantity cantidad del item que eliminaremos del ArrayList
     * @return devuelve si se ha podido eliminar el objeto
     */
        public boolean removeItem(int id,int quantity) {
            boolean isTrue=false;
            if(quantity<0){
                for(int i=0;i<this.items.size() && isTrue==false;i++) {
                    if(searchId(i,id)==true) {
                        if(quantity<this.items.get(i).getQuantity()){
                            this.items.get(i).setQuantity(quantity);
                            isTrue=true;
                        }else if(isTrue==false){
                            this.items.remove(this.items.get(i));
                        }
                    }
                }
            }
            return isTrue;
        }

    /**
     * Este metodo devuelve el id del item que se encuentra en la posicion i del ArrayList
     * @param i el numero del item de la posicion del ArrayList
     * @return devuelve el id del objeto ubicado en la posicion "i"
     */
    public boolean searchId(int i,int id){
        boolean isTrue=false;
        if(id==this.items.get(i).getId()){
            isTrue=true;
        }
        return isTrue;
    }
    public String searchName(int id){
        boolean isTrue=false;
        String name=null;
        for(int i=0;i<this.items.size() && isTrue==false;i++){
            if(searchId(i,id)){
                name=this.items.get(i).getName();
            }
        }
        return name;
    }
    public int searchQuantity(int id){
        int result=-1;
        for(int i=0;i<items.size();i++){
            if(searchId(i,id)==true){
                result=items.get(i).getQuantity();
            }
        }
        return result;
    }
}

