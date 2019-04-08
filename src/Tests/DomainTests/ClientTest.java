package Tests.DomainTests;

import Domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void settersShouldSetFieldsCorrectly() {
        Client client1 = new Client(1, "Test", "Test", "1234567891234", "12.12.2010", "12.12.2018");
        client1.setName("Test");
        client1.setFirstName("Test");
        client1.setCNP("1234567891234");
        client1.setDateOfBirth("12.12.2010");
        client1.setDateOfRegistration("12.12.2018");

        assertEquals(1, client1.getId());
        assertEquals("Test", client1.getName());
        assertEquals("Test", client1.getFirstName());
        assertEquals("1234567891234", client1.getCNP());
        assertEquals("12.12.2010", client1.getDateOfBirth());
        assertEquals("12.12.2018", client1.getDateOfRegistration());
    }

    @Test
    void toStringShouldReturnALongEnoughString(){
        Client client1 = new Client(1, "Test", "Test", "1234567891234", "12.12.2010", "12.12.2018");

        assertTrue(client1.toString().length() > 10);
    }
}