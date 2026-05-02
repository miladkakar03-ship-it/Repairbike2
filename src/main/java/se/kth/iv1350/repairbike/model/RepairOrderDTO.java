package se.kth.iv1350.repairbike.model;

/**
 * En förenklad version av ordern som skickas till vyn för att visa status och ID.
 * Denna klass är oföränderlig (immutable) för att skydda domändata.
 */
public class RepairOrderDTO {
    private final int orderId;
    private final String status;

    /**
     * Skapar en ny RepairOrderDTO genom att kopiera relevant data från en order.
     * @param order Den RepairOrder-instans som data ska hämtas från.
     */
    public RepairOrderDTO(RepairOrder order) {
        this.orderId = order.getOrderId();
        this.status = order.getState();
    }

    /** @return Orderns unika ID. */
    public int getOrderId() { return orderId; }

    /** @return Orderns nuvarande status. */
    public String getStatus() { return status; }
}