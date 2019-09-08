/**
 * @author Päivi Eversbusch
 * @version 1.0
 * @since 8.9.2019
 */

import java.text.DecimalFormat;
import java.util.List;

public class GroceryList2 {
    /**
     * Klassen har ansvar for at behandle arraylist, dvs. tilføje elementer, udregne totalpris og printe
     */
    private List<GroceryItemOrder> items;

    public GroceryList2(List<GroceryItemOrder>items) {
        this.items = items;
    }

    public List<GroceryItemOrder> getItems() { return items; }
    public void setItems(List<GroceryItemOrder> items) { this.items = items; }

    /**
     * Metoden tilføjer et element til arraylisten.
     * @param itemName
     * @param quantity
     * @param pricePerUnit
     */
    public void addItem(String itemName, double quantity, double pricePerUnit){
        items.add(new GroceryItemOrder(itemName,quantity,pricePerUnit));
    }

    /**
     * Metoden traveserer arraylisten og udregner prisen per element og tilføjer til summen.
     * @return double
     */
    public double getTotalCost() {
        double totalPris = 0;
        for (int i = 0; i < items.size(); i++) {
                double pris = items.get(i).getPricePerUnit();
                double quantity = items.get(i).getQuantity();
                double total = pris * quantity;
                totalPris += total;
        }
        return totalPris;
    }

    /**
     * Prisen bliver udregnet som double, men vi vil printe kun de to sidste decimaler med.
     * DecimalFormat runder tallet og giver to decimaler til kvitteringen.
     */
    public void printTotalCost(){
        double total = this.getTotalCost();
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println(df.format(total));
    }

    /**
     * Metoden forudsætter toString() i klassen GroceryItemOrder.
     * Ellers får man kun printet referencerne.
     */
    public void printItems() {
        for (GroceryItemOrder item : items) {
            System.out.println(item);
        }
    }
}

