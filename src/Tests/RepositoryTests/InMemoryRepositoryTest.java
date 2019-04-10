//package Tests.RepositoryTests;
//
//import Domain.Entity;
//import Repository.IRepository;
//import Repository.InMemoryRepository;
//import org.junit.jupiter.api.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class InMemoryRepositoryTest <T extends Entity>{
//
//    @Test
//    void addAndUpdateShouldAddAndUpdateClients() {
//        IRepository<Client> repository = new InMemoryRepository<>(new ClientValidator());
//        Client client1 = new Client(1, "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
//        Client client2 = new Client(2, "TestSecond", "TestSecond", "1234567891234", "12.12.2012", "10.10.2020");
//        Client client1Duplicate = new Client(1, "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
//
//        repository.addAndUpdate(client1);
//        repository.addAndUpdate(client2);
//        assertEquals(client1, repository.getAll().get(0));
//        assertEquals(2, repository.getAll().size());
//
//        try{
//            repository.addAndUpdate(client1Duplicate);
//            fail("Exception not throw for client duplicates");
//        } catch (RuntimeException rex){
//            assertTrue(true);
//        }
//    }
//
//
//    @Test
//    void deleteShouldRemoveClients() {
//        IRepository<Client> repository = new InMemoryRepository<>(new ClientValidator());
//        Client client1 = new Client(1, "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
//        Client client2 = new Client(2, "TestSecond", "TestSecond", "1234567891234", "12.12.2012", "10.10.2020");
//
//        repository.addAndUpdate(client1);
//        repository.addAndUpdate(client2);
//        repository.remove(client1.getId());
//        repository.remove(client2.getId());
//        assertEquals(0, repository.getAll().size());
//        assertFalse(repository.getAll().size() != 0);
//    }
//
//    @Test
//    void getAll() {
//        IRepository<Client> repository = new InMemoryRepository<>(new ClientValidator());
//        Client client1 = new Client(1, "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
//        Client client2 = new Client(2, "TestSecond", "TestSecond", "1234567891234", "12.12.2012", "10.10.2020");
//
//        repository.addAndUpdate(client1);
//        repository.addAndUpdate(client2);
//        assertEquals(client1, repository.getAll().get(0));
//        assertEquals(client2, repository.getAll().get(1));
//        assertTrue(repository.getAll().size() == 2);
//    }
//}
