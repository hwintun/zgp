/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util.oops;

/**
 *
 * @author John
 */
public class IncommingShipment {

    private String supplier, actualDate, transitionDate;

    public IncommingShipment() {
    }

    public IncommingShipment(String supplier, String actualDate, String transitionDate) {
        this.supplier = supplier;
        this.actualDate = actualDate;
        this.transitionDate = transitionDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public String getTransitionDate() {
        return transitionDate;
    }

    public void setTransitionDate(String transitionDate) {
        this.transitionDate = transitionDate;
    }
}
