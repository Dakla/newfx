package sample.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class SceneUtils {
    public static void changeScene(String newScene, Scene scene) {
        scene.getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SceneUtils.class.getResource("/sample/VIew/" + newScene));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
