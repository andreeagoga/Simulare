package UI;

import Domain.Medicine;
import Service.MedicineService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MedicineController {
    public TableView tblMedicine;
    public TableColumn colMedicine;
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
    private ObservableList<Medicine> medicine = FXCollections.observableArrayList();

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
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

    public void btnGetAllMedicinesClick(ActionEvent actionEvent) {
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
