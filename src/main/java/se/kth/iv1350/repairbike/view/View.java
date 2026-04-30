package se.kth.iv1350.repairbike.view; // Definierar paketet för användargränssnittet

import se.kth.iv1350.repairbike.controller.Controller; // Importerar kontrollern för att kunna göra systemanrop
import se.kth.iv1350.repairbike.model.*; // Importerar DTO:er och modeller

/**
 * Denna klass ersätter ett riktigt grafiskt gränssnitt.
 * Den innehåller hårdkodade anrop till kontrollern för att simulera ett användarfall.
 */
public class View { // Start på klassen View
    private Controller controller; // Attribut: Referens till kontrollern

    /**
     * Skapar en ny instans av View.
     * @param controller Kontrollern som ska användas för att prata med de lägre lagren.
     */
    public View(Controller controller) { // Konstruktor
        this.controller = controller; // Sparar kontrollern i attributet
    } // Slut på konstruktorn

    /**
     * Denna metod kör hela scenariot enligt Bild 1 till Bild 7.
     */
    public void run() { // Start på körningsmetoden
        
        // --- BILD 1: Kontrollera om kund finns ---
        String phoneNumber = "0701112233"; // Simulerar inmatning av telefonnummer
        System.out.println("Söker efter kund med nummer: " + phoneNumber); // Loggar sökningen
        CustomerDTO customerDTO = controller.findCustomer(phoneNumber); // Bild 1, Index 1: Anrop till controller
        
        if (customerDTO == null) { // Om kunden inte finns, avsluta (alternativt flöde Bild 2)
            System.out.println("Kunden hittades inte."); // Felmeddelande
            return; // Avbryter metoden
        } // Slut på if
        System.out.println("Kund hittad: " + customerDTO.getName()); // Bekräftar lyckad sökning

        // --- BILD 3: Starta ny reparation ---
        // Bild 3, Index 1: Ber kontrollern skapa en ny order baserat på kund-DTO
        RepairOrderDTO orderDTO = controller.startNewRepair(customerDTO); 
        System.out.println("Ny reparation startad. Order ID: " + orderDTO.getOrderId()); // Bekräftelse

        // --- BILD 4: Hämta order och lägg till problembeskrivning ---
        // Bild 4, Index 1: Hittar ordern vi precis skapade för att göra den aktiv i systemet
        int orderId = orderDTO.getOrderId(); // Sparar undan ID:t
        controller.findRepairOrder(orderId); // Gör ordern aktiv i kontrollerns 'currentOrder'
        
        // Bild 4, Index 2: Lägger till kundens beskrivning av felet
        String problem = "Cykeln tappar kraft i uppförsbackar."; // Simulerad beskrivning
        controller.addProblemDescription(problem); 
        System.out.println("Problembeskrivning tillagd: " + problem); // Loggar tillägget

        // --- BILD 5: Lägg till diagnosrapport och uppdatera status ---
        // Bild 5, Index 1: Teknikern lägger till sin analys
        String diagnostic = "Batteriet har dålig kontakt och behöver rengöras."; // Simulerad diagnos
        RepairOrderDTO diagnosticOrder = controller.addDiagnosticReport(diagnostic); 
        System.out.println("Diagnos registrerad. Ny status: " + diagnosticOrder.getStatus()); // Bör vara 'Ready for approval'

        // --- BILD 6: Lägg till reparationsmoment ---
        // Bild 6, Index 1: Lägger till specifika arbetsuppgifter och priser
        System.out.println("Lägger till reparationsmoment..."); // Loggar processen
        controller.addRepairTask("Rengöring av batterikontakter", 300.0); // Första momentet
        controller.addRepairTask("Mjukvaruuppdatering", 250.0); // Andra momentet

        // --- BILD 7: Bekräfta reparationsorder ---
        // Bild 7, Index 1: Kunden godkänner prisförslaget och arbetet
        RepairOrderDTO confirmedOrder = controller.confirmRepairOrder(); 
        
        // Slutlig utskrift av ordern (Seminarieuppgiftens krav på bevis)
        System.out.println("\n--- UTSKRIFT AV BEKRÄFTAD ORDER ---"); // Rubrik för kvitto/utskrift
        System.out.println("Order ID: " + confirmedOrder.getOrderId()); // Skriver ut ordernummer
        System.out.println("Slutgiltig status: " + confirmedOrder.getStatus()); // Skriver ut 'Accepted'
        System.out.println("-----------------------------------\n"); // Slut på utskrift
        
    } // Slut på metoden run
} // Slut på klassen View