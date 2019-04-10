package Tests.DomainTests.ValidatorTests;

import Domain.Transaction;
import Domain.TransactionValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class TransactionValidatorTest {

    @Test
    void validateTransaction() {
        TransactionValidator transactionV = new TransactionValidator();
        Transaction transaction = new Transaction(1,1,1,1,"12.12.2019","12:00", false);
        transactionV.validate(transaction);
        //assertThrows(ExceptionValidatorDomain.class, () -> transactionV.validateTransaction(transaction));
        assertDoesNotThrow(() -> transactionV.validate(transaction));
    }
}