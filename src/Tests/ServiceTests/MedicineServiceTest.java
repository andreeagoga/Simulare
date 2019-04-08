package Tests.ServiceTests;

import Domain.Medicine;
import Domain.MedicineValidator;
import Repository.InMemoryRepository;
import Service.MedicineService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicineServiceTest {

    @Test
    void addAndUpdateServiceShouldAddAndUpdateMedicine() {
        MedicineValidator validator = new MedicineValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        MedicineService medicineService = new MedicineService(repository);
        Medicine medicine1 = new Medicine(1,"FirstMedicine", "FirstMedicine", "FirstMedicine", 5, false);

        medicineService.addAndUpdate(1,"FirstMedicine", "FirstMedicine", "FirstMedicine", 5, false);
        assertEquals(medicine1,medicineService.getAll().get(0));
        assertEquals(1, medicineService.getAll().size());
    }

    @Test
    void deleteServiceShouldRemoveMedicine() {
        MedicineValidator validator = new MedicineValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        MedicineService medicineService = new MedicineService(repository);
        Medicine medicine1 = new Medicine(1, "FirstMedicine", "FirstMedicine", "FirstMedicine", 5, false);

        medicineService.addAndUpdate(1, "FirstMedicine", "FirstMedicine", "FirstMedicine", 5, false);
        medicineService.delete(1);
        assertEquals(0, medicineService.getAll().size());
        assertFalse(medicineService.getAll().size() != 0);
    }

    @Test
    void getAllServiceShouldGetAllMedicines() {
        MedicineValidator validator = new MedicineValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        MedicineService medicineService = new MedicineService(repository);
        Medicine medicine1 = new Medicine(1, "FirstMedicine", "FirstMedicine", "FirstMedicine", 5, false);
        Medicine medicine2 = new Medicine(2, "SecondMedicine", "SecondMedicine", "SecondMedicine", 6, true);

        medicineService.addAndUpdate(1, "FirstMedicine", "FirstMedicine", "FirstMedicine", 5, false);
        medicineService.addAndUpdate(2, "SecondMedicine", "SecondMedicine", "SecondMedicine", 6, true);
        assertEquals(medicine1, medicineService.getAll().get(0));
        assertEquals(medicine2, medicineService.getAll().get(1));
        assertFalse(medicineService.getAll().size() != 2);
    }
}