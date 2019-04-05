package UI.SecondControllers;

import Domain.Medicine;
import Service.MedicineService;
import UI.Common;
import UI.SecondControllers.ThirdControllers.MedicinePriceController;
import UI.SecondControllers.ThirdControllers.MedicineSearchController;
import UI.SecondControllers.ThirdControllers.MedicineSortController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Button btnMedicineSearch;
    public TextField txtMedicineSearch;
    public Button btnMedicineSort;
    public Button btnMedicineExpensive;

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
            txtMedicineId.clear();
            txtMedicineName.clear();
            txtMedicineFirstName.clear();
            txtMedicineProducer.clear();
            txtMedicinePrice.clear();
            chkMedicineRecipe.setSelected(false);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveMedicineClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            medicineService.delete(id);
            medicine.clear();
            medicine.addAll(medicineService.getAll());
            txtMedicineId.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllMedicinesClick(ActionEvent actionEvent) {
        try {
            medicineService.getAll();
            medicine.clear();
            medicine.addAll(medicineService.getAll());
            txtMedicineId.clear();
            txtMedicineName.clear();
            txtMedicineFirstName.clear();
            txtMedicineProducer.clear();
            txtMedicinePrice.clear();
            chkMedicineRecipe.setSelected(false);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnSearchMedicineClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SecondWindows/MedicineSearchWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Medicine search");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MedicineSearchController controller =  fxmlLoader.getController();
            controller.setMedicineService(medicineService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
//        try {
//            String option = txtMedicineSearch.getText();
//            List<Medicine> foundMedicines = medicineService.searchMedicine(option);
//            medicine.clear();
//            medicine.addAll(foundMedicines);
//            txtMedicineSearch.clear();
//        } catch (RuntimeException rex) {
//            Common.showValidationError(rex.getMessage());
//        }
    }

    public void btnSortMedicinesClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SecondWindows/MedicineSortWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Sort medicines");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MedicineSortController controller =  fxmlLoader.getController();
            controller.setMedicineService(medicineService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnIncreaseMedicinesClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SecondWindows/MedicinePriceWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Medicine price increase");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MedicinePriceController controller =  fxmlLoader.getController();
            controller.setMedicineService(medicineService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }
}
