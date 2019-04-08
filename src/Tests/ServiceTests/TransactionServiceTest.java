package Tests.ServiceTests;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;;
import Service.TransactionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest  <T extends Entity> {

    @Test
    void addAndUpdateServiceShouldAddAndUpdateTransaction() {
        TransactionValidator validator = new TransactionValidator();
        InMemoryRepository repositoryT = new InMemoryRepository(validator);
        InMemoryRepository repositoryM = new InMemoryRepository(validator);
        TransactionService transactionService = new TransactionService(repositoryT, repositoryM);
        Transaction transaction1 = new Transaction(1, 1, 1, 5, "12.12.2012", "10:00");
        Transaction transaction2 = new Transaction(2, 2, 1, 6, "12.12.2012", "10:00");

        transactionService.addAndUpdate(1, 1, 1, 5, "12.12.2012", "10:00");
        transactionService.addAndUpdate(2, 2, 1, 6, "12.12.2012", "10:00");
        assertEquals(2, transactionService.getAll().size());
        assertEquals(transaction1, transactionService.getAll().get(0));
        assertEquals(transaction2, transactionService.getAll().get(1));
    }


    @Test
    void deleteServiceShouldRemoveTransaction() {
        TransactionValidator validator = new TransactionValidator();
        InMemoryRepository repositoryT = new InMemoryRepository(validator);
        InMemoryRepository repositoryM = new InMemoryRepository(validator);
        TransactionService transactionService = new TransactionService(repositoryT, repositoryM);
        Transaction transaction1 = new Transaction(1, 1, 1, 5, "12.12.2012", "10:00");

        transactionService.addAndUpdate(1, 1, 1, 5, "12.12.2012", "10:00");
        transactionService.delete(1);
        assertEquals(0, transactionService.getAll().size());
        assertTrue(transactionService.getAll().size() == 0);
    }

    @Test
    void getAllServiceShouldGetAllTransactions() {
        TransactionValidator validator = new TransactionValidator();
        InMemoryRepository repositoryT = new InMemoryRepository(validator);
        InMemoryRepository repositoryM = new InMemoryRepository(validator);
        TransactionService transactionService = new TransactionService(repositoryT, repositoryM);
        Transaction transaction3 = new Transaction(5, 1, 1, 5, "12.12.2012", "10:00 1");
        Transaction transaction4 = new Transaction(6, 1, 1, 5, "12.12.2012", "10:00 2");

        transactionService.addAndUpdate(5, 1, 1, 5, "12.12.2012", "10:00 1");
        transactionService.addAndUpdate(6, 1, 1, 5, "12.12.2012", "10:00 2");
        assertEquals(transaction3, transactionService.getAll().get(0));
        assertEquals(transaction4, transactionService.getAll().get(1));
        assertTrue(transactionService.getAll().size() == 2);
    }
}