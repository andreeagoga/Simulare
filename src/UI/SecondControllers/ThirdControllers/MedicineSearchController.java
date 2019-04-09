package UI.SecondControllers.ThirdControllers;

import Domain.Medicine;
import Service.MedicineService;
import UI.Common;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;

public class MedicineSearchController {

    public Button btnCancel;
    public TextField txtMedicineSearch;
    public Button btnSearchMedicine;

    private MedicineService medicineService;
    private ObservableList<Medicine> medicine = FXCollections.observableArrayList();

    public void setService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void btnSearchMedicine(javafx.event.ActionEvent actionEvent) {
        try {
            String option = txtMedicineSearch.getText();
            List<Medicine> foundMedicines = medicineService.searchMedicine(option);
            medicine.clear();
            txtMedicineSearch.clear();
            medicine.addAll(foundMedicines);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnCancelClick(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

}
