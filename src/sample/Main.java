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
        Parent root = FXMLLoader.load(getClass().getResource("VIew/sample.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 717, 443));
        primaryStage.show();
        try (Session session = HibernateUtils.getSession()) {
            session.beginTransaction();
            session.getTransaction().commit();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
