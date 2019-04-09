package UI.JavaFXConsole;

import Domain.Client;
import Service.ClientService;
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

public class ClientController {
    public TableView tblClient;
    public TableColumn colClient;
    public TableColumn colClientName;
    public TableColumn colClientFirstName;
    public TableColumn colClientCNP;
    public TableColumn colClientDateOfBirth;
    public TableColumn colClientDateOfRegistration;
    public TextField txtClientId;
    public TextField txtClientName;
    public TextField txtClientFirstName;
    public TextField txtClientCNP;
    public TextField txtClientDateOfBirth;
    public TextField txtClientDateOfRegistration;
    public Button btnAddAndUpdateClient;
    public Button btnRemoveClient;
    public Button btnGetAllClient;
    public Button btnClientSearch;
    public TextField txtClientSearch;
    public Button btnUndoClient;
    public Button btnRedoClient;

    private ClientService clientService;
    private ObservableList<Client> client = FXCollections.observableArrayList();

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            client.addAll(clientService.getAll());
            tblClient.setItems(client);
        });
    }

    /**
     *
     * @param actionEvent
     */
    public void btnAddAndUpdateClientClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());
            String name = txtClientName.getText();
            String firstName = txtClientFirstName.getText();
            String CNP = txtClientCNP.getText();
            String dateOfBirth = txtClientDateOfBirth.getText();
            String dateOfRegistration = txtClientDateOfRegistration.getText();

            clientService.addAndUpdate(id, name, firstName, CNP, dateOfBirth, dateOfRegistration);

            client.clear();
            client.addAll(clientService.getAll());
            txtClientId.clear();
            txtClientName.clear();
            txtClientFirstName.clear();
            txtClientCNP.clear();
            txtClientDateOfBirth.clear();
            txtClientDateOfRegistration.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void btnRemoveClientClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());

            clientService.delete(id);
            client.clear();
            client.addAll(clientService.getAll());
            txtClientId.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void btnGetAllClientsClick(ActionEvent actionEvent) {
        try {
            clientService.getAll();
            client.clear();
            client.addAll(clientService.getAll());
            txtClientId.clear();
            txtClientName.clear();
            txtClientFirstName.clear();
            txtClientCNP.clear();
            txtClientDateOfBirth.clear();
            txtClientDateOfRegistration.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void btnSearchClient(ActionEvent actionEvent) {
        try {
            String option = txtClientSearch.getText();
            List<Client> foundClients = clientService.searchClient(option);
            client.clear();
            client.addAll(foundClients);
            txtClientSearch.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void btnRedoClient(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent
     */
    public void btnUndoClient(ActionEvent actionEvent) {
    }
}
