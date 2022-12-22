package Items;

public class Item {
    private String name;
    private String description;
    private int quantity=0;

    public Item(String name,String desc){
        this.name=name;
        this.description=desc;
    }
    public String getName(){return this.name;}
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int i){
        this.quantity+=i;
    }
}
