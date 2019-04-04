package UI;

import Domain.Transaction;
import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

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


    public void btnTransactionTimeClick(ActionEvent actionEvent) {
    }

    public void btnTransactionTimeRemoveClick(ActionEvent actionEvent) {
    }
}
