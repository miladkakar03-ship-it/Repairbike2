package se.kth.iv1350.repairbike.model;

/**
 * Representerar ett specifikt jobb som utförs på cykeln, t.ex. "Byte av däck".
 */
public class RepairTask {
    private String description;
    private double cost;

    public RepairTask(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() { return description; }
    public double getCost() { return cost; }
}