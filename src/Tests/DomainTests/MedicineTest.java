package Tests.DomainTests;

import Domain.Medicine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicineTest {

    @Test
    void getIdShouldReturnCorrectId() {
        Medicine medicine1 = new Medicine(1, "Test", "Test", "Test", 5, false);
        assertEquals(1, medicine1.getId(), String.format("Returned: %s, Expected: %s", medicine1.getId(), 1));
        Medicine medicine2 = new Medicine(2, "Test", "Test", "Test", 5, false);
        assertEquals(2, medicine2.getId(), String.format("Returned: %s, Expected: %s", medicine2.getId(), 2));
    }

    @Test
    void setIdShouldSetTheGivenId() {
        Medicine medicine1 = new Medicine(1, "Test", "Test", "Test", 5, false);
        Integer setId = 7;
        assertEquals(setId, medicine1.getId(), String.format("Returned: %s, Expected: %s", medicine1.getId(), setId));
    }

    @Test
    void constructorShouldSetAllTheFildsCorectly(){
        Medicine medicine1 = new Medicine(1, "Test", "Test", "Test", 8, true);

        assertEquals(1, medicine1.getId());
        assertEquals("Test", medicine1.getName());
        assertEquals("Test", medicine1.getFirstName());
        assertEquals("Test", medicine1.getProducer());
        assertEquals(8, medicine1.getPrice());
        assertEquals(true, medicine1.isRecipe());

    }

    @Test
    void settersShouldSetFieldsCorrectly(){
        Medicine medicine = new Medicine(1, "Test", "Test", "Test", 8, true);
        medicine.setName("Test");
        medicine.setFirstName("Test");
        medicine.setProducer("Test");
        medicine.setPrice(8);
        medicine.setRecipe(true);

        assertEquals(1, medicine.getId());
        assertEquals("Test", medicine.getName());
        assertEquals("Test", medicine.getFirstName());
        assertEquals("Test", medicine.getProducer());
        assertEquals(8, medicine.getPrice());
        assertTrue(medicine.isRecipe() == true);
    }
}