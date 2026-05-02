package se.kth.iv1350.repairbike.controller;

import se.kth.iv1350.repairbike.integration.*;
import se.kth.iv1350.repairbike.model.*;

/**
 * Systemets enda controller. Hanterar kommunikation mellan vy och modell/integration.
 */
public class Controller {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private RepairOrder currentOrder; // Håller koll på den aktiva ordern under sessionen

    public Controller(CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
    }

    // Systemoperation 1: Söker efter kund och returnerar en säker DTO till vyn
    public CustomerDTO findCustomer(String phoneNumber) {
        Customer customer = customerRegistry.findCustomer(phoneNumber);
        return (customer != null) ? new CustomerDTO(customer) : null;
    }

    // Systemoperation 3 : Skapar en ny order och sparar den i systemet
    public RepairOrderDTO startNewRepair(CustomerDTO customerDTO) {
        Customer customer = customerRegistry.findCustomer(customerDTO.getPhoneNumber());
        this.currentOrder = repairOrderRegistry.createRepairOrder(customer, customer.getBike());
        return new RepairOrderDTO(currentOrder);
    }

    // Systemoperation 4: Hämtar en befintlig order och gör den aktiv i kontrollern
    public RepairOrderDTO findRepairOrder(int orderId) {
        this.currentOrder = repairOrderRegistry.getOrder(orderId);
        return new RepairOrderDTO(currentOrder);
    }

    // Systemoperation 4: Uppdaterar den aktiva ordern med kundens beskrivning
    public void addProblemDescription(String description) {
        currentOrder.setProblemDescription(description);
    }

    // Systemoperation 5: Registrerar diagnos och ändrar status till "Ready for approval"
    public RepairOrderDTO addDiagnosticReport(String report) {
        currentOrder.setDiagnosticReport(report);
        currentOrder.setState("Ready for approval");
        return new RepairOrderDTO(currentOrder);
    }

    // Systemoperation 6: Lägger till ett arbetsmoment i den aktiva ordern
    public void addRepairTask(String description, double cost) {
        currentOrder.addRepairTask(description, cost);
    }

    // Systemoperation 7: Slutgiltig bekräftelse av ordern
    public RepairOrderDTO confirmRepairOrder() {
        currentOrder.setState("Accepted");
        return new RepairOrderDTO(currentOrder);
    }
    
    public RepairOrder getActiveOrder() {
        return currentOrder;
    }
}