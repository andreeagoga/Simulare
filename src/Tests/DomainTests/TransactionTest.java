//package Tests.DomainTests;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TransactionTest {
//
//    @Test
//    void equalsShouldCompareTheTransactionCorectly() {
//        Transaction transaction1 = new Transaction(1, 1,1,5, "12.12.2012","10:00",true);
//        Transaction transaction2 = new Transaction(1, 1,1,5, "12.12.2012","10:00", true);
//        Transaction transaction3 = new Transaction(3, 1,1,10, "12.12.2012","10:00", false);
//
//        assertEquals(transaction1, transaction2);
//        assertEquals(transaction2, transaction1);
//        assertNotEquals(transaction1, transaction3);
//        assertNotEquals(transaction3, transaction1);
//        assertNotEquals(transaction2, transaction3);
//        assertNotEquals(transaction3, transaction2);
//    }
//    @Test
//    void constructorShouldSetAllTheFildsCorectly(){
//        Transaction transaction1 = new Transaction(1, 1,1,5, "12.12.2012","10:00", true);
//
//        assertEquals(1, transaction1.getId());
//        assertEquals(1, transaction1.getIdMedicine());
//        assertEquals(1,transaction1.getIdClientCard());
//        assertEquals(5, transaction1.getNumberMedicine());
//        assertEquals("12.12.2012", transaction1.getDate());
//        assertEquals("10:00", transaction1.getHour());
//    }
//
//    @Test
//    void settersShouldSetFieldsCorrectly() {
//        Transaction transaction1 = new Transaction(1, 1, 1, 5, "12.12.2010", "12:00", true);
//
//        transaction1.setIdMedicine(1);
//        transaction1.setIdClientCard(1);
//        transaction1.setNumberMedicine(5);
//        transaction1.setDate("12.12.2012");
//        transaction1.setHour("12:00");
//
//        assertEquals(1, transaction1.getId());
//        assertEquals(1, transaction1.getIdMedicine());
//        assertEquals(1,transaction1.getIdClientCard());
//        assertEquals(5, transaction1.getNumberMedicine());
//        assertEquals("12.12.2012", transaction1.getDate());
//        assertEquals("12:00", transaction1.getHour());
//    }
//
//    @Test
//    void toStringShouldReturnALongEnoughString() {
//        Transaction transaction = new Transaction(1, 1, 1, 6, "12.12.2010", "12:00", true);
//
//        assertTrue(transaction.toString().length() > 10);
//    }
//}