package UI;

import Domain.Medicine;
import Service.ClientService;
import Service.MedicineService;
import Service.TransactionService;
import UI.Common;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    public TableColumn colMedicine;
    public TableView<Medicine> tblMedicine;
    public TableColumn colMedicineName;
    public TableColumn colMedicineFirstName;
    public TableColumn colMedicineProducer;
    public TableColumn colMedicinePrice;
    public TableColumn colMedicineRecipe;
    public TextField txtMedicineId;
    public TextField txtMedicineName;
    public TextField txtMedicineFirstName;
    public TextField txtMedicineProducer;
    public TextField txtMedicinePrice;
    public CheckBox chkMedicineRecipe;
    public Button btnAddAndUpdateMedicine;
    public Button btnRemoveMedicine;
    public Button btnGetAllMedicine;

    private MedicineService medicineService;
    private ClientService clientService;
    private TransactionService transactionService;

    private ObservableList<Medicine> medicine = FXCollections.observableArrayList();

    public void setServices(MedicineService medicineService, ClientService clientService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            medicine.addAll(medicineService.getAll());
            tblMedicine.setItems(medicine);
        });
    }

    public void btnAddAndUpdateMedicineClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            String name = txtMedicineName.getText();
            String firstName = txtMedicineFirstName.getText();
            String producer = txtMedicineProducer.getText();
            double price = Double.parseDouble(txtMedicinePrice.getText());
            boolean recipe = chkMedicineRecipe.isSelected();

            medicineService.addAndUpdate(id, name, firstName, producer, price, recipe);

            medicine.clear();
            medicine.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveMedicineClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            String name = txtMedicineName.getText();
            String firstName = txtMedicineFirstName.getText();
            String producer = txtMedicineProducer.getText();
            double price = Double.parseDouble(txtMedicinePrice.getText());
            boolean recipe = chkMedicineRecipe.isSelected();

            medicineService.delete(id);

            medicine.clear();
            medicine.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllMedicineClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            String name = txtMedicineName.getText();
            String firstName = txtMedicineFirstName.getText();
            String producer = txtMedicineProducer.getText();
            double price = Double.parseDouble(txtMedicinePrice.getText());
            boolean recipe = chkMedicineRecipe.isSelected();

            medicineService.getAll();

            medicine.clear();
            medicine.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

}
