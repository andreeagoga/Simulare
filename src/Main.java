import Domain.*;
import Domain.ClientValidator;
import Domain.IValidator;
import Domain.MedicineValidator;
import Domain.TransactionValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientService;
import Service.MedicineService;
import Service.TransactionService;
import UI.MainController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        Parent root = fxmlLoader.load();

        IValidator<Medicine> medicineValidator = new MedicineValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Medicine> medicineRepository = new InMemoryRepository<>(medicineValidator);
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        MedicineService medicineService = new MedicineService(medicineRepository);
        medicineService.addAndUpdate(1,"Medicine","A", "Producer", 10, false );
        medicineService.addAndUpdate(2,"Medicine","B", "Producer", 15, true );
        medicineService.addAndUpdate(3,"Medicine","C", "Producer", 17, false );

        ClientService clientService = new ClientService(clientRepository);
        clientService.addAndUpdate(1, "Andreea", "A", "1234567891234", "12.10.2010", "12.12.2019");
        clientService.addAndUpdate(2, "Maria", "B", "2234567891234", "13.10.2010", "12.13.2019");
        clientService.addAndUpdate(3, "Ioana", "C", "3234567891234", "14.10.2010", "12.14.2019");

        TransactionService transactionService = new TransactionService(transactionRepository);
        transactionService.addAndUpdate(1, 1, 1, 5, "12.12.2012","10:00");
        transactionService.addAndUpdate(2, 3, 3, 15, "12.12.2012","12:00");
        transactionService.addAndUpdate(3, 6, 6, 25, "12.12.2012","10:00");

        MainController mainController = fxmlLoader.getController();
        mainController.setServices(medicineService, clientService, transactionService);

        primaryStage.setTitle("Medicine manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
