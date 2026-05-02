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

    /**
     * Skapar en ny instans av en reparationsorder.
     * @param customer Kunden som äger cykeln.
     * @param bike Cykeln som ska repareras.
     */
    public RepairOrder(Customer customer, Bike bike) {
        this.orderId = 12345;
        this.customer = customer;
        this.bike = bike;
        this.state = "Newly Created"; // Startstatus enligt Bild 3
    }

    /**
     * Skapar ett nytt RepairTask-objekt och lägger till i listan över utfört arbete.
     * @param description Beskrivning av arbetsmomentet.
     * @param cost Kostnaden för momentet.
     */
    public void addRepairTask(String description, double cost) {
        repairTasks.add(new RepairTask(description, cost));
    }

    /**
     * Beräknar den totala summan baserat på alla tillagda arbetsmoment.
     * @return Den totala kostnaden för reparationen.
     */
    public double getTotalCost() {
        double total = 0;
        for (RepairTask task : repairTasks) {
            total += task.getCost();
        }
        return total;
    }

    /**
     * Uppdaterar beskrivningen av det problem kunden upplever.
     * @param description Beskrivning av felet.
     */
    public void setProblemDescription(String description) { this.problemDescription = description; }

    /**
     * Registrerar mekanikerns diagnostiska rapport efter undersökning.
     * @param report Rapportens innehåll.
     */
    public void setDiagnosticReport(String report) { this.diagnosticReport = report; }

    /**
     * Uppdaterar orderns nuvarande tillstånd/status.
     * @param newState Den nya statusen (t.ex. "Accepted").
     */
    public void setState(String newState) { this.state = newState; }
    
    /** @return Orderns unika ID-nummer. */
    public int getOrderId() { return orderId; }

    /** @return Orderns nuvarande status. */
    public String getState() { return state; }

    /** @return Kunden som är kopplad till denna order. */
    public Customer getCustomer() { return customer; }

    /** @return Cykeln som omfattas av reparationen. */
    public Bike getBike() { return bike; }

    /** @return Den lagrade beskrivningen av felet. */
    public String getProblemDescription() { return problemDescription; }

    /** @return Den lagrade diagnostiska rapporten. */
    public String getDiagnosticReport() { return diagnosticReport; }

    /** @return En lista på alla registrerade arbetsmoment. */
    public List<RepairTask> getRepairTasks() { return repairTasks; }
}