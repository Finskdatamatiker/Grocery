/**
 * @author Päivi Eversbusch
 * @version 1.0
 * @since 8.9.2019
 */

public class GroceryItemOrder {
    /**
     * Klassen repræsenterer én vare.
     * @param itemName,
     * @param quantity,
     * @param pricePerUnit
     */

    private String itemName;
    private double quantity;
    private double pricePerUnit;

    public GroceryItemOrder(String itemName) { this.itemName = itemName; }

    public GroceryItemOrder(String itemName, double quantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    @Override
    public String toString(){
        String item = "Item: " + itemName;
        item += "\nQuantity: " + quantity;
        item += "\nPricePerUnit: " + pricePerUnit;
        item += "\n";
        return item;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof GroceryItemOrder){
            GroceryItemOrder other = (GroceryItemOrder) o;
            return this.itemName.equals(other.getItemName());
        }
        else return false;
    }
}
