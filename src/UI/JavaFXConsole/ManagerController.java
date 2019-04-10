package UI.JavaFXConsole;

import Service.AgendaService;
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
    public Button btnAgenda;
    public Button btnMedicine;

    private AgendaService agendaService;

    public void setServices(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    /**
     *
     * @param actionEvent
     */
    public void btnAgendaClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/AgendaWindow.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("Agenda");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            AgendaController controller =  fxmlLoader.getController();
            controller.setAgendaService(agendaService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

}
