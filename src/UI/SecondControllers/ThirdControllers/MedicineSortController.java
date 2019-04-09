package UI.SecondControllers.ThirdControllers;

import Domain.Medicine;
import Service.MedicineService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicineSortController {
    private MedicineService medicineService;
    private ObservableList<Medicine> medicine = FXCollections.observableArrayList();

    public void setService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }
}
