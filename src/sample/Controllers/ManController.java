package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManController {
    @FXML
    public Button ost;

    @FXML
    void initialize(){
        ost.setOnAction(actionEvent -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/VIew/tableTest.fxml"));
                Stage stage = new Stage();
                stage.initOwner(ost.getScene().getWindow());
                stage.setScene(new Scene(loader.load()));
                TableTest controller = loader.getController();
                controller.getText("Test num 1");
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
