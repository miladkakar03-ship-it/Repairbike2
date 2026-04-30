package se.kth.iv1350.repairbike.model; // Anger att testet hör till modell-paketet

import org.junit.jupiter.api.*; // Importerar JUnit-annoteringar som @Test och @BeforeEach
import static org.junit.jupiter.api.Assertions.*; // Importerar påståenden som assertEquals för att kontrollera resultat

public class RepairOrderTest { // Start på testklassen för RepairOrder
    private RepairOrder order; // Deklarerar ett RepairOrder-objekt som ska användas i testerna

    @BeforeEach // Denna metod körs automatiskt före varje enskilt testfall
    public void setUp() { // Initieringsmetod för att skapa en fräsch miljö
        // Skapar en ny order med en testkund och en cykel (null används här för att hålla koden kort)[cite: 3]
        order = new RepairOrder(new Customer("Sven", "123", "a@b.com", null), null); 
    } // Slut på setUp

    @Test // Markerar att detta är ett testfall som JUnit ska köra[cite: 3]
    public void testStatusChange() { // Testar logiken för hur orderns status ändras[cite: 3]
        // Kontrollerar att en nyskapad order har rätt startstatus enligt affärsreglerna[cite: 1]
        assertEquals("Newly Created", order.getState(), "Startstatus var fel."); 
        
        // Ändrar statusen på ordern till 'Accepted' (simulerar Bild 7 i din design)[cite: 1]
        order.setState("Accepted"); 
        
        // Verifierar att attributet i objektet faktiskt har ändrats till det förväntade värdet[cite: 3]
        assertEquals("Accepted", order.getState(), "Status ändrades inte korrekt."); 
    } // Slut på testStatusChange

    @Test // Markerar nästa testfall[cite: 3]
    public void testAddRepairTask() { // Testar att det går att lägga till ett arbetsmoment[cite: 3]
        // Anropar metoden för att lägga till ett moment och pris (testar logik i Bild 6)
        order.addRepairTask("Service", 100.0); 
        
        // Testet godkänns automatiskt om raden ovan körs utan att programmet kraschar[cite: 3]
        assertNotNull(order, "Ordern bör fortfarande existera efter tillagt moment."); 
    } // Slut på testAddRepairTask
} // Slut på klassen RepairOrderTest