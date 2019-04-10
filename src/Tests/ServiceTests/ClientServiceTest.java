//package Tests.ServiceTests;
//
//import Repository.InMemoryRepository;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ClientServiceTest {
//
//    @Test
//    void addAndUpdateServiceShouldAddAndUpdateClients() {
//        ClientValidator validator = new ClientValidator();
//        InMemoryRepository repository = new InMemoryRepository(validator);
//        ClientService clientService = new ClientService(repository);
//        Client client1 = new Client(1, "TestFirst", "TestFirst", "8234567891234", "12.12.2012", "10.10.2020");
//        Client client2 = new Client(2, "TestSecond", "TestSecond", "9234567891234", "12.12.2012", "10.10.2020");
//
//        clientService.addAndUpdate(1, "TestFirst", "TestFirst", "8234567891234", "12.12.2012", "10.10.2020");
//        clientService.addAndUpdate(2, "TestSecond", "TestSecond", "9234567891234", "12.12.2012", "10.10.2020");
//        assertEquals(client1, clientService.getAll().get(0));
//        assertEquals(client2, clientService.getAll().get(1));
//        assertEquals(2, clientService.getAll().size());
//    }
//
//    @Test
//    void deleteServiceShouldRemoveClient() {
//        ClientValidator validator = new ClientValidator();
//        InMemoryRepository repository = new InMemoryRepository(validator);
//        ClientService clientService = new ClientService(repository);
//
//        clientService.addAndUpdate(1, "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
//        clientService.addAndUpdate(2, "TestSecond", "TestSecond", "2234567891234", "12.12.2012", "10.10.2020");
//        clientService.delete(1);
//        clientService.delete(2);
//        assertEquals(0, clientService.getAll().size());
//        assertFalse(clientService.getAll().size() != 0);
//    }
//
//    @Test
//    void getAllServiceShouldShowAllClients() {
//        ClientValidator validator = new ClientValidator();
//        InMemoryRepository repository = new InMemoryRepository(validator);
//        ClientService clientService = new ClientService(repository);
//        Client client1 = new Client(1, "TestFirst", "TestFirst", "1234567891237", "12.12.2012", "10.10.2020");
//        Client client2 = new Client(2, "TestSecond", "TestSecond", "1234567891238", "12.12.2012", "10.10.2020");
//
//        clientService.addAndUpdate(1, "TestFirst", "TestFirst", "1234567891237", "12.12.2012", "10.10.2020");
//        clientService.addAndUpdate(2, "TestSecond", "TestSecond", "1234567891238", "12.12.2012", "10.10.2020");
//        assertEquals(client1, clientService.getAll().get(0));
//        assertEquals(client2, clientService.getAll().get(1));
//        assertTrue(clientService.getAll().size() == 2);
//    }
//}