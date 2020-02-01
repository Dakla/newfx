package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import sample.Utils.HibernateUtils;
import sample.domains.User;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("VIew/tableTest.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 717, 443));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
