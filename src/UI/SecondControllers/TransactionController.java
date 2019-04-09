package UI.SecondControllers;

import Domain.Transaction;
import Service.TransactionService;
import UI.Common;
import UI.SecondControllers.ThirdControllers.TransactionPriceController;
import UI.SecondControllers.ThirdControllers.TransactionTimeController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionController {
    public TableView tblTransaction;
    public TableColumn colTransaction;
    public TableColumn colTransactionIdMedicine;
    public TableColumn colTransactionIdClientCard;
    public TableColumn colTransactionNumberMedicine;
    public TableColumn colTransactionDate;
    public TableColumn colTransactionHour;
    public TextField txtTransactionId;
    public TextField txtTransactionIdMedicine;
    public TextField txtTransactionIdClientCard;
    public TextField txtTransactionNumberMedicine;
    public TextField txtTransactionDate;
    public TextField txtTransactionHour;
    public Button btnAddAndUpdateTransaction;
    public Button btnRemoveTransaction;
    public Button btnGetAllTransaction;
    public TextField txtTransactionSearch;
    public Button btnTransactionSearch;
    public Button btnTransactionTime;
    public Button btnTransactionTimeRemove;
    public Button btnTransactionPrice;
    public Button btnTransactionIDCardClientSort;

    private TransactionService transactionService;
    private ObservableList<Transaction> transaction = FXCollections.observableArrayList();

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            transaction.addAll(transactionService.getAll());
            tblTransaction.setItems(transaction);
        });
    }

    public void btnAddAndUpdateTransactionClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();

            transactionService.addAndUpdate(id, idMedicine, idClientCard, numberMedicine, date, hour);
            transaction.clear();
            transaction.addAll(transactionService.getAll());
            txtTransactionId.clear();
            txtTransactionIdMedicine.clear();
            txtTransactionIdClientCard.clear();
            txtTransactionNumberMedicine.clear();
            txtTransactionDate.clear();
            txtTransactionHour.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveTransactionClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            transactionService.delete(id);
            transaction.clear();
            transaction.addAll(transactionService.getAll());
            txtTransactionId.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllTransactionsClick(ActionEvent actionEvent) {
        try {
            transactionService.getAll();
            transaction.clear();
            transaction.addAll(transactionService.getAll());
            txtTransactionId.clear();
            txtTransactionIdMedicine.clear();
            txtTransactionIdClientCard.clear();
            txtTransactionNumberMedicine.clear();
            txtTransactionDate.clear();
            txtTransactionHour.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnTransactionSearchClick(ActionEvent actionEvent) {
        try {
            String option = txtTransactionSearch.getText();
            List<Transaction> foundTransactions = transactionService.searchTransaction(option);
            transaction.clear();
            transaction.addAll(foundTransactions);
            txtTransactionSearch.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnIDClientCardDiscountSortClick(ActionEvent actionEvent) {
        try{
            transactionService.getAll();
            transaction.clear();
            List<Transaction> sortedIDClientCardByDiscount = transactionService.sortClientCardsByDiscount();
            transaction.addAll(sortedIDClientCardByDiscount);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnTransactionTimeClick(ActionEvent actionEvent) {
    }

//    public void btnTransactionTimeClick(ActionEvent actionEvent) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/TransactionTimeWindow.fxml"));
//
//            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
//            Stage stage = new Stage();
//            stage.setTitle("Show transaction from a time interval");
//            stage.setScene(scene);
//            stage.initModality(Modality.APPLICATION_MODAL);
//            TransactionTimeController controller =  fxmlLoader.getController();
//            controller.setTransactionService(transactionService);
//            stage.showAndWait();
//        } catch (IOException e) {
//            Logger logger = Logger.getLogger(getClass().getName());
//            logger.log(Level.SEVERE, "Failed to create new Window", e);
//        }
//    }
//
//    public void btnTransactionPrice(ActionEvent actionEvent) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/TransactionPriceWindow.fxml"));
//
//            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
//            Stage stage = new Stage();
//            stage.setTitle("Show transaction price after increase");
//            stage.setScene(scene);
//            stage.initModality(Modality.APPLICATION_MODAL);
//            TransactionPriceController controller =  fxmlLoader.getController();
//            controller.setTransactionService(transactionService);
//            stage.showAndWait();
//        } catch (IOException e) {
//            Logger logger = Logger.getLogger(getClass().getName());
//            logger.log(Level.SEVERE, "Failed to create new Window", e);
//        }
//    }
}
