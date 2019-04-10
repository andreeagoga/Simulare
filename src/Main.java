import Domain.Agenda;
import Domain.AgendaValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.AgendaService;
import UI.JavaFXConsole.ManagerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ManagerWindow.fxml"));
        Parent root = fxmlLoader.load();

        IValidator<Agenda> agendaValidator = new AgendaValidator();

        IRepository<Agenda> agendaRepository = new InMemoryRepository<>(agendaValidator);

        AgendaService agendaService = new AgendaService(agendaRepository);
        agendaService.addAndUpdate(1,"event", "15.10.2013", "10:00", 10 );
        agendaService.addAndUpdate(2,"even", "15.10.2013", "12:00", 50 );
        agendaService.addAndUpdate(3,"eve3", "16.10.2013", "11:00", 100 );

        ManagerController managerController = fxmlLoader.getController();
        managerController.setServices(agendaService);

        primaryStage.setTitle("Command manager");
        primaryStage.setScene(new Scene(root, 200, 100));
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
