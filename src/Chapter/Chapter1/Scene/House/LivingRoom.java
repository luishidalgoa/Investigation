package Chapter.Chapter1.Scene.House;

import Items.Items;

public class LivingRoom {
    /**
     * Atributo con el nombre del escenario
     */
    final String name="LivingRoom";
    /**
     * Objeto Items el cual se encargara de crear un nuevo inventario de items, generar todos los items del juego...
     */
    private Items SceneItems;
    /**
     * Array que almacena todos los escenarios accesibles
     */
    private String[]moveToScene={"BedRoom"};

    /**
     * Constructor inicial que construye todos los elementos necesarios dentro de un escenario.
     * Creandole por ejemplo el ArrayList de items donde almacenara los items
     */
    public LivingRoom(){
        this.SceneItems=new Items();
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
    /**
     * Extrae todos los id de los items almacenados en el escenario. De este modo podemos extraer el id del item
     * y asignarle en controlOptions su correspondiente comando
     * @return
     */
    public int[] getIdItems(){ //Funciona Correctamente
        int n=0;
        int[]id = new int[this.SceneItems.getListItem().size()];
        for(int i=0;i<this.SceneItems.getListItem().size();i++){
            if(this.SceneItems.getListItem().get(i)!=null){
                n++;
                id[n-1]=this.SceneItems.getListItem().get(i).getId();
            }
        }
        return id;
    }

    /**
     * Este metodo recive la posicion del array que identifica a la habitacion a la cual se mueve el jugador
     * @param i posicion del array moveToScene de la clase BedRoom.
     * @return devuelve el nombre de la habitacion a la cual se mueve el jugador
     */
    public String moveTo(int i){
        return this.moveToScene[i];
    }

    /**
     * Es utilizado para conocer el tamaño del array de lugares accesibles. De este modo sabemos a cuantas escenas se puede
     * move el jugador
     * @return devuelve el array con el tamaño del array de las escenas disponibles
     */
    public String[] getMoveToScene(){ return this.moveToScene; }
    public Items getSceneItems(){
        return this.SceneItems;
    }
}
