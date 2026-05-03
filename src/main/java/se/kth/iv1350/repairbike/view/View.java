package se.kth.iv1350.repairbike.view;

import se.kth.iv1350.repairbike.controller.Controller;
import se.kth.iv1350.repairbike.model.*;

/**
 * Simulerar användarens interaktion med systemet via terminalen.
 */
public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Kör ett scenario som motsvarar systemoperationerna i Systemoperation 1-7.
     */
    public void run() {
        // Steg 1: Kontrollera om kund finns
        String phoneNumber = "12345678";
        CustomerDTO customerDTO = controller.findCustomer(phoneNumber);
        if (customerDTO == null) return;

        // Steg 2: Starta reparation för kunden
        RepairOrderDTO orderDTO = controller.startNewRepair(customerDTO);

        // Steg 3: Lägg till beskrivningar och diagnoser
        controller.findRepairOrder(orderDTO.getOrderId());
        controller.addProblemDescription("Cykeln tappar kraft.");
        controller.addDiagnosticReport("Batterikontakt trasig.");

        // Steg 4: Registrera arbete och kostnader
        controller.addRepairTask("Byte av kontakt", 400.0);
        controller.addRepairTask("Serviceavgift", 150.0);

        // Steg 5: Godkännande och utskrift
        controller.confirmRepairOrder();
        printReceipt();
    }

    /**
     * Skriver ut den bekräftade ordern i ett snyggt format.
     */
    private void printReceipt() {
        RepairOrder order = controller.getActiveOrder();
        Customer customer = order.getCustomer();

        System.out.println("========================================");
        System.out.println("      BEKRÄFTAD REPARATIONSORDER        ");
        System.out.println("========================================");
        System.out.printf("Order ID:      %d\n", order.getOrderId());
        System.out.printf("Status:        %s\n", order.getState());
        System.out.println("----------------------------------------");
        System.out.printf("KUND:          %s\n", customer.getName());
        System.out.printf("TELEFON:       %s\n", customer.getPhoneNumber());
        System.out.printf("EMAIL:         %s\n", customer.getEmail());
        System.out.printf("CYKEL:         %s\n", order.getBike().toString());
        System.out.println("----------------------------------------");
        System.out.printf("PROBLEM:       %s\n", order.getProblemDescription());
        System.out.printf("DIAGNOS:       %s\n", order.getDiagnosticReport());
        System.out.println("----------------------------------------");
        System.out.println("SPECIFIKATION:");
        
        for (RepairTask task : order.getRepairTasks()) {
            System.out.printf("- %-28s %8.2f kr\n", task.getDescription(), task.getCost());
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("TOTALT ATT BETALA:                %8.2f kr\n", order.getTotalCost());
        System.out.println("========================================");
    }
}