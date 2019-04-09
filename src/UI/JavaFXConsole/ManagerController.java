package UI.JavaFXConsole;

import Service.ClientService;
import Service.MedicineService;
import Service.TransactionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerController {
    public Button btnMedicine;
    public Button btnClient;
    public Button btnTransaction;

    private MedicineService medicineService;
    private ClientService clientService;
    private TransactionService transactionService;

    public void setServices(MedicineService medicineService, ClientService clientService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    public void btnMedicineClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SecondWindows/MedicineWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Medicine manager");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MedicineController controller =  fxmlLoader.getController();
            controller.setMedicineService(medicineService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnClientClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SecondWindows/ClientWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Client manager");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            ClientController controller =  fxmlLoader.getController();
            controller.setClientService(clientService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnTransactionClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SecondWindows/TransactionWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Transaction manager");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            TransactionController controller =  fxmlLoader.getController();
            controller.setTransactionService(transactionService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }
}
