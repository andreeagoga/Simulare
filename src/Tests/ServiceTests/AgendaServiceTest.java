package Tests.ServiceTests;

import Domain.AgendaValidator;
import Repository.InMemoryRepository;
import Service.AgendaService;
import org.junit.jupiter.api.Test;

public class AgendaServiceTest {
    @Test
    void addAndUpdateServiceShouldAddAndUpdateClients() {
        AgendaValidator validator = new AgendaValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        AgendaService agendaService = new AgendaService(repository);


//        clientService.addAndUpdate(1, "TestFirst", "TestFirst", "8234567891234", "12.12.2012", "10.10.2020");
//        clientService.addAndUpdate(2, "TestSecond", "TestSecond", "9234567891234", "12.12.2012", "10.10.2020");
//        assertEquals(client1, clientService.getAll().get(0));
//        assertEquals(client2, clientService.getAll().get(1));
//        assertEquals(2, clientService.getAll().size());
    }
}
