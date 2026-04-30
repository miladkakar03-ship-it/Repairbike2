package se.kth.iv1350.repairbike.controller; // Anger att klassen tillhör controller-lagret

import se.kth.iv1350.repairbike.integration.*; // Importerar registren från integrationslagret
import se.kth.iv1350.repairbike.model.*; // Importerar alla modellklasser och DTO:er

/**
 * Detta är systemets enda controller. Alla anrop från vyn går genom denna klass.
 */
public class Controller { // Start på klassen Controller
    private CustomerRegistry customerRegistry; // Attribut: Referens till registret över kunder
    private RepairOrderRegistry repairOrderRegistry; // Attribut: Referens till registret över reparationsordrar
    private RepairOrder currentOrder; // Attribut: Håller koll på den order som hanteras just nu (viktigt för steg 4-7)

    /**
     * Skapar en ny instans av kontrollern.
     * @param custReg Referens till kundregistret.
     * @param repReg Referens till orderregistret.
     */
    public Controller(CustomerRegistry custReg, RepairOrderRegistry repReg) { // Konstruktor
        this.customerRegistry = custReg; // Sparar referensen till kundregistret i klassen
        this.repairOrderRegistry = repReg; // Sparar referensen till orderregistret i klassen
    } // Slut på konstruktorn

    /**
     * Bild 1, Index 1: Hittar en kund baserat på telefonnummer.
     * @param phoneNumber Telefonnumret att söka efter.
     * @return En CustomerDTO med kundens data, eller null om ingen hittas.
     */
    public CustomerDTO findCustomer(String phoneNumber) { // Metod för att söka efter kund
        Customer customer = customerRegistry.findCustomer(phoneNumber); // Bild 1, Index 1.1: Frågar registret
        if (customer != null) { // Kollar om kunden faktiskt hittades i listan
            return new CustomerDTO(customer); // Om ja, skapa och returnera en säker DTO till vyn
        } // Slut på if
        return null; // Returnerar null om kunden inte fanns i systemet
    } // Slut på metoden findCustomer

    /**
     * Bild 3, Index 1: Startar en ny reparation för en kund.
     * @param customerDTO Datan om kunden från Bild 1.
     * @return En RepairOrderDTO för den nyskapade ordern.
     */
    public RepairOrderDTO startNewRepair(CustomerDTO customerDTO) { // Metod för att skapa en ny order
        // Hämtar det riktiga Customer-objektet från registret (behövs för att skapa en RepairOrder)
        Customer customer = customerRegistry.findCustomer(customerDTO.getPhoneNumber()); 
        // Bild 3, Index 1.1: Ber registret skapa en order med kunden och kundens cykel
        RepairOrder repairOrder = repairOrderRegistry.createRepairOrder(customer, customer.getBike()); 
        return new RepairOrderDTO(repairOrder); // Skapar och returnerar en DTO av den nya ordern
    } // Slut på metoden startNewRepair

    /**
     * Bild 4, Index 1: Hämtar en befintlig order och sätter den som "aktiv" i kontrollern.
     * @param orderID ID-numret på ordern som ska hämtas.
     * @return En DTO med information om den hittade ordern.
     */
    public RepairOrderDTO findRepairOrder(int orderID) { // Metod för att hämta en specifik order
        // Bild 4, Index 1.1: Frågar registret efter ordern och sparar den i attributet currentOrder
        this.currentOrder = repairOrderRegistry.getOrder(orderID); 
        return new RepairOrderDTO(currentOrder); // Returnerar data om den nu aktiva ordern till vyn
    } // Slut på metoden findRepairOrder

    /**
     * Bild 4, Index 2: Lägger till en problembeskrivning på den aktiva ordern.
     * @param description Texten som beskriver kundens problem.
     */
    public void addProblemDescription(String description) { // Metod för att lägga till beskrivning
        // Bild 4, Index 2.1: Anropar metoden direkt på det aktiva RepairOrder-objektet
        currentOrder.setProblemDescription(description); 
    } // Slut på metoden addProblemDescription

    /**
     * Bild 5, Index 1: Registrerar en teknisk diagnos och uppdaterar status.
     * @param report Teknikerns rapport efter undersökning.
     * @return Uppdaterad RepairOrderDTO med status "Ready for approval".
     */
    public RepairOrderDTO addDiagnosticReport(String report) { // Metod för diagnosrapport
        currentOrder.setDiagnosticReport(report); // Bild 5, Index 1.1: Sparar rapporten i ordern
        currentOrder.setState("Ready for approval"); // Bild 5, Index 1.2: Uppdaterar orderns tillstånd
        return new RepairOrderDTO(currentOrder); // Returnerar uppdaterad data till vyn
    } // Slut på metoden addDiagnosticReport

    /**
     * Bild 6, Index 1: Lägger till ett arbetsmoment och dess kostnad.
     * @param description Beskrivning av vad som ska göras.
     * @param cost Priset för momentet.
     * @return Uppdaterad RepairOrderDTO.
     */
    public RepairOrderDTO addRepairTask(String description, double cost) { // Metod för att lägga till moment
        // Bild 6, Index 1.1: Ber ordern att lägga till och skapa ett nytt RepairTask-objekt
        currentOrder.addRepairTask(description, cost); 
        return new RepairOrderDTO(currentOrder); // Returnerar data så vyn kan visa t.ex. totalsumma
    } // Slut på metoden addRepairTask

    /**
     * Bild 7, Index 1: Bekräftar att kunden har godkänt reparationen.
     * @return Uppdaterad RepairOrderDTO med status "Accepted".
     */
    public RepairOrderDTO confirmRepairOrder() { // Metod för att godkänna ordern
        currentOrder.setState("Accepted"); // Bild 7, Index 1.1: Sätter status till Accepted
        return new RepairOrderDTO(currentOrder); // Returnerar den slutgiltiga ordern för utskrift i vyn
    } // Slut på metoden confirmRepairOrder
} // Slut på klassen Controller