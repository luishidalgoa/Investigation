package Items;

/**
 * Esta clase construye los items. Es utilizado por la clase id e Items.
 * almacena las propiedades de cada item como su id
 */
public class Item {
    /**
     * Id del objeto
     */
    private int id;
    /**
     * Nombre del objeto
     */
    private String name;
    /**
     * Descripcion del objeto
     */
    private String description;
    /**
     * Cantidad del objeto
     */
    private int quantity;
    /**
     * Nombre de los usos que puede tener el item
     */
    private String[] option=new String[2];

    /**
     * Constructor del item
     * @param name
     * @param desc descripcion del item
     * @param quantity cantidad almacenada
     */
    public Item(int id,String name,String desc,int quantity,String[] option){
        this.id=id;
        this.name=name;
        this.description=desc;
        this.quantity=quantity;
        this.option=option;
    }
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description=description;}
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int i){
        this.quantity+=i;
    }
    public String getOption(int n){
        return this.option[n];
    }
}