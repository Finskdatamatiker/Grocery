/**
 * @author Päivi Eversbusch
 * @version 1.0
 * @since 8.9.2019
 */

import java.text.DecimalFormat;

public class GroceryList {
    /**
     * Klassen har ansvar for at behandle array, dvs. tilføje elementer, udregne totalpris og printe.
     */
    private GroceryItemOrder[] items;

    public GroceryList(GroceryItemOrder[] items) {
        this.items = items;
    }
    public GroceryItemOrder[] getItems() { return items; }

    /**
     * Metoden tilføjer et element til array, hvis det ikke er fyldt.
     * Vi ved, at der er plads, hvis det sidste element stadig er tomt.
     * @param index (placering i array)
     * @param itemName
     * @param quantity
     * @param pricePerUnit
     */
    public void addItem(int index, String itemName, double quantity, double pricePerUnit){
        if(items[items.length -1] == null) {
            items[index] = new GroceryItemOrder(itemName, quantity, pricePerUnit);
        }
    }

    /**
     * Metoden traveserer array og udregner prisen per element og tilføjer til summen.
     * Vi læser kun elementer, som ikke er NULL, dvs. tomme.
     * I de tomme elementer finder vi ikke doubles med getter og det ville give fejl i loopet.
     * @return double
     */
    public double getTotalCost() {
        double totalPris = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                double pris = items[i].getPricePerUnit();
                double quantity = items[i].getQuantity();
                double total = pris * quantity;
                totalPris += total;
            }
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
