package UI.JavaFXConsole;

import Domain.Transaction;
import Service.TransactionService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public TextField txtTransactionEndDateShow;
    public TextField txtTransactionStartDateShow;
    public Button btnTransactionTimeShow;
    public TextField txtTransactionStartDateRemove;
    public TextField txtTransactionEndDateRemove;
    public CheckBox chkTransactionRecipe;
    public TableColumn colTransactionRecipe;

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

    /**
     *
     * @param actionEvent
     */
    public void btnAddAndUpdateTransactionClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();
            boolean withRecipe = Boolean.parseBoolean(chkTransactionRecipe.getText());

            transactionService.addAndUpdate(id, idMedicine, idClientCard, numberMedicine, date, hour, withRecipe);
            transaction.clear();
            transaction.addAll(transactionService.getAll());
            txtTransactionId.clear();
            txtTransactionIdMedicine.clear();
            txtTransactionIdClientCard.clear();
            txtTransactionNumberMedicine.clear();
            txtTransactionDate.clear();
            txtTransactionHour.clear();
            chkTransactionRecipe.setSelected(false);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
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

    /**
     *
     * @param actionEvent
     */
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
            chkTransactionRecipe.setSelected(false);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
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

    /**
     *
     * @param actionEvent
     */
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

    /**
     *
     * @param actionEvent
     */
    public void btnTransactionPrice(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent
     */
    public void btnTransactionTimeRemoveClick(ActionEvent actionEvent) {
        try {
            String date1 = txtTransactionStartDateRemove.getText();
            String date2 = txtTransactionEndDateRemove.getText();
            List<Transaction> foundTransactions = transactionService.removeTransactionByDate(date1, date2);
            transaction.clear();
            transaction.remove(foundTransactions);
            txtTransactionStartDateRemove.clear();
            txtTransactionEndDateRemove.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void btnTransactionTimeShowClick(ActionEvent actionEvent) {
        try {
            String date1 = txtTransactionStartDateShow.getText();
            String date2 = txtTransactionEndDateShow.getText();
            List<Transaction> foundTransactions = transactionService.showTransactionByDate(date1, date2);
            transaction.clear();
            transaction.addAll(foundTransactions);
            txtTransactionStartDateShow.clear();
            txtTransactionEndDateShow.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
