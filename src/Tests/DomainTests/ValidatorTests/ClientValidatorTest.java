package Tests.DomainTests.ValidatorTests;

import Domain.Client;
import Domain.ClientValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ClientValidatorTest {

    @Test
    void validateErrorsShouldNotThrowExceptions() {
        ClientValidator clientV= new ClientValidator();
        Client client= new Client(1,"Test","Test","2234567891234","15.12.2012","12.12.2012");
        Client client1= new Client(2,"A","B","1114567891283","15.12.2012","12.12.2012");
        clientV.validate(client);
        assertDoesNotThrow(() -> clientV.validate(client));
        assertDoesNotThrow(() -> clientV.validate(client1));
    }

}