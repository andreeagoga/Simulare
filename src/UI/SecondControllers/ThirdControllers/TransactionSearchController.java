package UI.SecondControllers.ThirdControllers;

import Domain.Transaction;
import Service.TransactionService;
import UI.Common;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class TransactionSearchController {
    public TextField txtTransactionSearch;
    public Button btnSearchTransaction;
    public Button btnCancel;

    private TransactionService transactionService;

    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    public void setService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void btnSearchTransaction(ActionEvent actionEvent) {
        try {
            String option = txtTransactionSearch.getText();
            List<Transaction> foundTransactions = transactionService.searchTransaction(option);
            transactions.clear();
            transactions.addAll(foundTransactions);
            txtTransactionSearch.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
