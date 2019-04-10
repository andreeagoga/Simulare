package UI.JavaFXConsole;

import Domain.Agenda;
import Service.AgendaService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AgendaController {
    public TableView tblAgenda;
    public TableColumn colAgenda;
    public TableColumn colDenumire;
    public TableColumn colZi;
    public TableColumn colOra;
    public TableColumn colDurata;
    public TextField txtAgendaId;
    public TextField txtAgendaDenumire;
    public TextField txtAgendaZi;
    public TextField txtAgendaOra;
    public TextField txtAgendaDurata;
    public Button btnAddAndUpdateAgenda;
    public Button btnGetAllEvents;
    public TextField txtAgendaSearchDay;
    public Button btnAgendaSearch;

    private AgendaService agendaService;
    private ObservableList<Agenda> agenda = FXCollections.observableArrayList();

    public void setAgendaService(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            agenda.addAll(agendaService.getAll());
            tblAgenda.setItems(agenda);
        });

    }

    /**
     * Add/Update an event in the calendar
     * @param actionEvent add/update the event
     */
    public void btnAddAndUpdateAgendaClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtAgendaId.getText());
            String denumire = txtAgendaDenumire.getText();
            String zi = txtAgendaZi.getText();
            String ora = txtAgendaOra.getText();
            int durata = Integer.parseInt(txtAgendaDurata.getText());

            agendaService.addAndUpdate(id, denumire, zi, ora, durata);

            agenda.clear();
            agenda.addAll(agendaService.getAll());
            txtAgendaId.clear();
            txtAgendaDenumire.clear();
            txtAgendaZi.clear();
            txtAgendaOra.clear();
            txtAgendaDurata.clear();

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Show all the agenda
     * @param actionEvent show all the events
     */
    public void btnGetAllEventsClick(ActionEvent actionEvent) {
        try {
            agendaService.getAll();
            agenda.clear();
            agenda.addAll(agendaService.getAll());
            txtAgendaId.clear();
            txtAgendaDenumire.clear();
            txtAgendaZi.clear();
            txtAgendaOra.clear();
            txtAgendaDurata.clear();
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void btnSearchEvent(ActionEvent actionEvent) {
    }
}
