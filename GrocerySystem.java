/**
 * @author Päivi Eversbusch
 * @version 1.0
 * @since 8.9.2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GrocerySystem {
    public static void main(String[] args) {
        /**
         * Klassen danner objekterne og tilføjer varerne til array
         */

        /**
         * ARRAY
         */
        GroceryItemOrder[] items = new GroceryItemOrder[10];
        GroceryList groceryList = new GroceryList(items);

        /**
         * LIST - jeg kan skifte mellem arrayList og LinkedList som parameter i GroceryList2
         */
        List<GroceryItemOrder> items2 = new ArrayList<>();
        List<GroceryItemOrder> items3 = new LinkedList<>();
        GroceryList2 groceryList2 = new GroceryList2(items2);

        try {
            /**
             * Reference til filen laves. Vi tager højde for FileNotFoundException.
             */
            String filNavn = "C:/C DATAMATIKER 2019//INTELLIJ//2019//Grocery//src//Liste";
            File file = new File(filNavn);
            if (!file.canRead()) {
                System.out.println("Filen kunne ikke læses");
            }

            /**
             * Scanner til at læse filen en linje ad gangen
             * Vi har brug for index-numre, så vi sætter læsningen af linjer i for-loop, hvor i
             * øger sin værdi hver omgang.
             * Vi læser linjen og kalder på metoden processLine() på den
             * Jeg laver en exception i try og catch i tilfældet af, at man prøver at
             * tilføje flere end 10 varer til listen.
             */
            Scanner input = new Scanner(file, "UTF-8");
            try {
                while (input.hasNextLine()) {
                    for (int i = 0; i < items.length; i++) {
                        String s = input.nextLine();
                        processLine(i, s, groceryList);
                    }
                }
            }catch(NoSuchElementException no){
                System.out.println("Der er ikke plads på listen til den sidste vare.\n");
            }
            input.close();

            /**
             * Array er nu fyldt op og vi printer array
             * Vi printer også den totale pris med metoden printTotalCost()
             */
            groceryList.printItems();
            System.out.println("Totalpris: ");
            groceryList.printTotalCost();
            System.out.println("\n");

            /**
             * Vi skal lave en ny skanner til arraylisten, fordi den først skanner
             * findes i bunden af filen, dvs. den rykker ikke af sig selv op.
             */
            Scanner input2 = new Scanner(file, "UTF-8");
            while (input2.hasNextLine()) {
                    String s = input2.nextLine();
                    processLine2(s, groceryList2);
                }
            groceryList2.printItems();
            System.out.println("Totalpris: ");
            groceryList2.printTotalCost();

            input2.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /**
     * En metode til at læse en linje med sin egen linjeskanner.
     * Når linjen er læst, tilføjes den som et element til array
     * @param index (placering i array)
     * @param linje (en linje per vare på listen)
     * @param groceryList (array, hvor vi tilføjer varerne)
     */
    public static void processLine(int index, String linje, GroceryList groceryList) {
        Scanner element = new Scanner(linje);
        String itemName = element.next().toUpperCase();
        double quantity = element.nextDouble();
        double pricePerUnit = element.nextDouble();
        groceryList.addItem(index, itemName, quantity, pricePerUnit);
        }

    /**
     * Den samme metode, man bare til List. Den eneste forskel er, at her har vi ikke 
     * brug for nogen index, fordi man altid kan tilføje et nyt element til List uafhængigt
     * af placeringen. 
     * @param linje
     * @param groceryList2
     */
    public static void processLine2(String linje, GroceryList2 groceryList2) {
        Scanner element = new Scanner(linje);
        String itemName = element.next();
        double quantity = element.nextDouble();
        double pricePerUnit = element.nextDouble();
        groceryList2.addItem(itemName, quantity, pricePerUnit);
    }
}
