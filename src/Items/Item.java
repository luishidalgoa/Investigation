package Items;

/**
 * Esta clase construye los items. Es utilizado por la clase id e Items.
 * almacena las propiedades de cada item como su id
 */
public class Item {
    private int id;
    private String name;
    private String description;
    private int quantity;

    /**
     * Constructor del item
     * @param id
     * @param name
     * @param desc descripcion del item
     * @param quantity cantidad almacenada
     */
    public Item(int id,String name,String desc,int quantity){
        this.id=id;
        this.name=name;
        this.description=desc;
        this.quantity=quantity;
    }
    public Item(Item item,int quantity){
       this.id=item.getId();
       this.name=item.getName();
       this.description=item.getDescription();
       this.quantity=quantity;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){return this.name;}
    public String getDescription(){
        return this.description;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int i){
        this.quantity+=i;
    }
}
