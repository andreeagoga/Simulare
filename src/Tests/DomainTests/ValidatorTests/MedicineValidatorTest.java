package Tests.DomainTests.ValidatorTests;

import Domain.Medicine;
import Domain.MedicineValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MedicineValidatorTest{

    @Test
    public void validateMedicine() {
        MedicineValidator medicineV= new MedicineValidator();
        Medicine medicine = new Medicine(1,"Test","Test","Test",15,true);
        medicineV.validate(medicine);
        assertDoesNotThrow(() -> medicineV.validate(medicine));

    }
}