package Items;

import java.util.ArrayList;

public class Items {
    private ArrayList<Item> items;

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
        boolean isTrue=false;
        if(quantity>0){
            for(int i=0;i<this.items.size() && isTrue==false;i++) {
                if(item.getId()==searchId(i)) {
                    item.setQuantity(quantity);
                    isTrue=true;
                }
            }
            if(isTrue==false){
                this.items.add(item);
                item.setQuantity(quantity);
            }
        }
    }

    /**
     * Este método tiene el objetivo de eliminar un item de la lista de items. Si se pasa una cantidad negativa,
     * el método asume que se quiere eliminar el item completo. Si se pasa una cantidad positiva,
     * el método asume que se quiere eliminar una cantidad específica de unidades del item.
     * @param item importa el item que vamos eliminar . y el item a comprobar que exista en el arraylist
     * @param quantity cantidad del item que eliminaremos del ArrayList
     * @return devuelve si se ha podido eliminar el objeto
     */
        public boolean removeItem(Item item,int quantity) {
            boolean isTrue=false;
            boolean isEnought=true;
            if(quantity<0){
                for(int i=0;i<this.items.size() && isTrue==false;i++) {
                    if(item.getId()==searchId(i)) {
                        if(quantity<=item.getQuantity()){
                            item.setQuantity(quantity);
                            isTrue=true;
                        }else{isTrue=false;}
                    }
                }
                if(isTrue==false && isEnought==true){
                    this.items.remove(item);
                }
            }
            return isTrue;
        }

    /**
     * Este metodo recoje el numero de un bucle para devolver el id del objeto que se posiciona en la posicion del ArrayList numero "i"
     * @param i el numero del bucle que identificara a la posicion del objeto en un ArrayList
     * @return devuelve el id del objeto ubicado en la posicion "i"
     */
    public int searchId(int i){
        int identificador=this.items.get(i).getId();
        return identificador;
    }
    public String searchName(Item item){
        return item.getName();
    }
    public int searchQuantity(Item item){
        return item.getQuantity();
    }
}

