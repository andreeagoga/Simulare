package Tests.DomainTests;

import Domain.Agenda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    void settersShouldSetFieldsCorrectly() {
        Agenda agenda1 = new Agenda(1, "Test", "12.12.2012", "10.00", 15);
        agenda1.setDenumire("Test");
        agenda1.setZi("12.12.2012");
        agenda1.setOra("10:00");
        agenda1.setDurata(15);

        assertEquals(1, agenda1.getId());
        assertEquals("Test", agenda1.getDenumire());
        assertEquals("12.12.2012", agenda1.getZi());
        assertEquals("10:00", agenda1.getOra());
        assertEquals(15, agenda1.getDurata());

    }

    @Test
    void constructorShouldSetAllTheFildsCorectly(){
        Agenda agenda1 = new Agenda(1, "Test", "12.12.2012", "10.00", 15);
        assertEquals(1, agenda1.getId());
        assertEquals("Test", agenda1.getDenumire());
        assertEquals("12.12.2012", agenda1.getZi());
        assertEquals("10:00", agenda1.getOra());
        assertEquals(15, agenda1.getDurata());

    }

    @Test
    void toStringShouldReturnALongEnoughString() {
        Agenda agenda1 = new Agenda(1, "Test", "12.12.2012", "10.00", 15);

        assertTrue(agenda1.toString().length() > 10);
    }

}