package UI.SecondControllers.ThirdControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MedicinePriceController {


    public TextField txtMedicinePriceShow;
    public Button btnMedicinePriceShow;
    public Button btnCancel;

    public void btnMedicinePriceShowClick(ActionEvent actionEvent) {

    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
