package Tests.ServiceTests;

import Domain.Agenda;
import Domain.AgendaValidator;
import Repository.InMemoryRepository;
import Service.AgendaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgendaServiceTest {
    @Test
    void addAndUpdateServiceShouldAddAndUpdateClients() {
        AgendaValidator validator = new AgendaValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        AgendaService agendaService = new AgendaService(repository);

        Agenda agenda1 = new Agenda(1, "Test", "12.12.2012", "10.00", 15);
        Agenda agenda2 = new Agenda(2, "Test1", "10.12.2012", "11.00", 10);
        agendaService.addAndUpdate(1, "Test", "12.12.2012", "10.00", 15);
        agendaService.addAndUpdate(2, "Test1", "10.12.2012", "11.00", 10);

        assertEquals(agenda1, agendaService.getAll().get(0));
        assertEquals(agenda2, agendaService.getAll().get(1));
        assertEquals(1, agendaService.getAll().size());
    }
}
