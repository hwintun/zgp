/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util.oops;

/**
 *
 * @author John
 */
public class Items {

    private String itemsName, itemsCode, category, Supplier;
    private int unitPerGrams, stdPrices;

    public Items() {
    }

    public Items(String itemsName, String itemsCode, String category, String Supplier, int unitPerGrams, int stdPrices) {
        this.itemsName = itemsName;
        this.itemsCode = itemsCode;
        this.category = category;
        this.Supplier = Supplier;
        this.unitPerGrams = unitPerGrams;
        this.stdPrices = stdPrices;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsCode() {
        return itemsCode;
    }

    public void setItemsCode(String itemsCode) {
        this.itemsCode = itemsCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public int getUnitPerGrams() {
        return unitPerGrams;
    }

    public void setUnitPerGrams(int unitPerGrams) {
        this.unitPerGrams = unitPerGrams;
    }

    public int getStdPrices() {
        return stdPrices;
    }

    public void setStdPrices(int stdPrices) {
        this.stdPrices = stdPrices;
    }
}
