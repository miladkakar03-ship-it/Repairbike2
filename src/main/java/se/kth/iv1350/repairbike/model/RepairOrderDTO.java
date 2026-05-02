package se.kth.iv1350.repairbike.model;

/**
 * En förenklad version av ordern som skickas till vyn för att visa status och ID.
 */
public class RepairOrderDTO {
    private final int orderId;
    private final String status;

    public RepairOrderDTO(RepairOrder order) {
        this.orderId = order.getOrderId();
        this.status = order.getState();
    }

    public int getOrderId() { return orderId; }
    public String getStatus() { return status; }
}