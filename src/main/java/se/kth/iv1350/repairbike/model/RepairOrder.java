package se.kth.iv1350.repairbike.model; // Modell-lagret

import java.util.ArrayList; // Importerar lista för att lagra moment
import java.util.List; // Importerar List-interface

public class RepairOrder { // Representerar hela reparationsärendet
    private int orderId; // Unikt ID för ordern
    private Customer customer; // Kunden som äger ordern
    private Bike bike; // Cykeln som lagas
    private String problemDescription; // Kundens beskrivning (Bild 4)
    private String diagnosticReport; // Teknikerns rapport (Bild 5)
    private String state; // Status: NewlyCreated, ReadyForApproval, Accepted (Bild 3, 5, 7)
    private List<RepairTask> repairTasks = new ArrayList<>(); // Lista med moment (Bild 6)

    public RepairOrder(Customer customer, Bike bike) { // Bild 3, Index 1.1.2: Skapar ordern
        this.orderId = 1; // Enkel hårdkodad ID för detta exempel
        this.customer = customer; // Sparar kunden
        this.bike = bike; // Sparar cykeln
        this.state = "Newly Created"; // Sätter startstatus (Bild 3)
    } // Slut på konstruktorn

    public void setProblemDescription(String description) { // Bild 4, Index 2.1: Sätter beskrivning
        this.problemDescription = description; // Sparar texten i attributet
    } // Slut på metoden

    public void setDiagnosticReport(String report) { // Bild 5, Index 1.1: Sätter rapport
        this.diagnosticReport = report; // Sparar rapporten i attributet
    } // Slut på metoden

    public void setState(String newState) { // Bild 5 Index 1.2 & Bild 7 Index 1.1: Ändrar status
        this.state = newState; // Sparar den nya statusen (Accepted/ReadyForApproval)
    } // Slut på metoden

    public void addRepairTask(String description, double cost) { // Bild 6, Index 1.1: Lägger till moment
        RepairTask repairTask = new RepairTask(description, cost); // Bild 6, Index 1.1.1: Skapar momentet
        this.addTaskToList(repairTask); // Bild 6, Index 1.1.2: Sparar det i listan
    } // Slut på metoden

    private void addTaskToList(RepairTask repairTask) { // Bild 6, Index 1.1.2: Intern spar-metod
        this.repairTasks.add(repairTask); // Lägger till objektet i listan
    } // Slut på metoden

    public int getOrderId() { return orderId; } // Getter för ordernummer
    public String getState() { return state; } // Getter för status
    public Customer getCustomer() { return customer; } // Getter för kund
} // Slut på klassen