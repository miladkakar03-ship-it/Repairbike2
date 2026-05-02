package se.kth.iv1350.repairbike.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Entitetsklass som håller all information om en reparation.
 */
public class RepairOrder {
    private int orderId;
    private Customer customer;
    private Bike bike;
    private String problemDescription;
    private String diagnosticReport;
    private String state;
    private List<RepairTask> repairTasks = new ArrayList<>();

    public RepairOrder(Customer customer, Bike bike) {
        this.orderId = 12345;
        this.customer = customer;
        this.bike = bike;
        this.state = "Newly Created"; // Startstatus enligt Bild 3
    }

    // Bild 6: Skapar ett nytt RepairTask-objekt och lägger till i listan
    public void addRepairTask(String description, double cost) {
        repairTasks.add(new RepairTask(description, cost));
    }

    // Beräknar den totala summan baserat på alla tillagda moment
    public double getTotalCost() {
        double total = 0;
        for (RepairTask task : repairTasks) {
            total += task.getCost();
        }
        return total;
    }

    // Getters och Setters för att hantera objektets tillstånd
    public void setProblemDescription(String description) { this.problemDescription = description; }
    public void setDiagnosticReport(String report) { this.diagnosticReport = report; }
    public void setState(String newState) { this.state = newState; }
    
    public int getOrderId() { return orderId; }
    public String getState() { return state; }
    public Customer getCustomer() { return customer; }
    public Bike getBike() { return bike; }
    public String getProblemDescription() { return problemDescription; }
    public String getDiagnosticReport() { return diagnosticReport; }
    public List<RepairTask> getRepairTasks() { return repairTasks; }
}