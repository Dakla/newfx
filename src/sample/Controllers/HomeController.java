package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sample.Utils.SceneUtils;

public class HomeController {

    @FXML
    public ImageView imgBtn;
    @FXML
    public Button back;

    @FXML
    void initialize() {
        back.setOnAction(actionEvent -> {
            SceneUtils.changeScene("sample.fxml", back.getScene());
        });
    }
}
