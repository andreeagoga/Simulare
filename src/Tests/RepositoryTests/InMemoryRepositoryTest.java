package Tests.RepositoryTests;

import Domain.Agenda;
import Domain.AgendaValidator;
import Domain.Entity;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryRepositoryTest <T extends Entity>{

    @Test
    void addAndUpdateShouldAddAndUpdateAgenda() {
        IRepository<Agenda> repository = new InMemoryRepository<>(new AgendaValidator());
        Agenda agenda1 = new Agenda(1, "Test", "12.12.2012", "10.00", 15);
        Agenda agenda2 = new Agenda(2, "Test1", "10.12.2012", "11.00", 10);

        repository.addAndUpdate(agenda1);
        repository.addAndUpdate(agenda2);
        assertEquals(agenda1, repository.getAll().get(0));
        assertEquals(1, repository.getAll().size());
    }

    @Test
    void getAll() {
        IRepository<Agenda> repository = new InMemoryRepository<>(new AgendaValidator());
        Agenda agenda1 = new Agenda(1, "Test", "12.12.2012", "10.00", 15);
        Agenda agenda2 = new Agenda(2, "Test1", "10.12.2012", "11.00", 10);

        repository.addAndUpdate(agenda1);
        repository.addAndUpdate(agenda2);
        assertEquals(agenda1, repository.getAll().get(0));
        assertEquals(agenda2, repository.getAll().get(1));
        assertTrue(repository.getAll().size() == 1);
    }
}
