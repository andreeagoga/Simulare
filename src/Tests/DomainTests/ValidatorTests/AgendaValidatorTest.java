    package Tests.DomainTests.ValidatorTests;

import Domain.Agenda;
import Domain.AgendaValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AgendaValidatorTest {

    @Test
    void validateErrorsShouldNotThrowExceptions() {
        AgendaValidator agendaValidate= new AgendaValidator();
        Agenda agenda1= new Agenda(1,"Test","12.12.2012","10:00",10);

        agendaValidate.validate(agenda1);
        assertDoesNotThrow(() -> agendaValidate.validate(agenda1));
    }

}

