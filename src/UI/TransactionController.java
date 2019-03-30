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
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveTransactionClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();

            transactionService.delete(id);

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllTransactionsClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();

            transactionService.getAll();

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
}
