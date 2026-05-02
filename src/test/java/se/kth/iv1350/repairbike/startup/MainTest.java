package se.kth.iv1350.repairbike.startup;

import org.junit.jupiter.api.Test;

/**
 * Testar programmets startpunkt för att säkerställa att hela 
 * applikationen kan initieras och köras utan fel.
 */

public class MainTest {

    @Test
    public void testMain() {
        String[] args = {};
        Main.main(args);
    }
}