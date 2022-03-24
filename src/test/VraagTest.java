package test;

import static org.junit.Assert.*;

import app.Vraag;
import org.junit.Assert;
import org.junit.Test;

public class VraagTest {
    @Test
    public void testStudent() {
        Vraag vraagtest = new Vraag("antwoordA","antwoordB","goedAntwoord","deVraag");
        assertEquals("antwoordA", vraagtest.getAntwoord_A());
        assertEquals("antwoordB", vraagtest.getAntwoord_B());
        assertEquals("goedAntwoord",vraagtest.getCorrectAntwoord());
        assertEquals("deVraag",vraagtest.getVraagStelling());
    }
}
