package se.kth.iv1350.repairbike.model; // Modell-lagret

public class RepairOrderDTO { // Dataöverföringsobjekt för order
    private final int orderId; // Oföränderligt ID
    private final String status; // Oföränderlig status

    public RepairOrderDTO(RepairOrder order) { // Konstruktor
        this.orderId = order.getOrderId(); // Kopierar ID från ordern
        this.status = order.getState(); // Kopierar statusen (Accepted, etc)
    } // Slut på konstruktor

    public int getOrderId() { return orderId; } // Getter för vyn
    public String getStatus() { return status; } // Getter för vyn
} // Slut på klassen