package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtils;
import sample.Utils.SceneUtils;
import sample.domains.User;

import javax.swing.*;
import java.io.IOException;

public class SingUpController {
    @FXML
    public TextField name;
    @FXML
    public TextField login;
    @FXML
    public PasswordField password;
    @FXML
    public Button singUp;
    @FXML
    public ChoiceBox<String> role;
    @FXML
    public Label error;
    @FXML
    public Button back;

    @FXML
    void initialize() {
        role.getItems().removeAll();
        role.getItems().addAll("Заказчик", "Менеджер", "Кладовщик", "Дирекция");
        role.getSelectionModel().select("Заказчик");
        singUp.setOnAction(event -> {
            String userName = name.getText().trim();
            String userLogin = login.getText().trim().toLowerCase();
            String userPassword = password.getText().trim();
            String userRole = role.getValue();
            if(!userRole.isEmpty() && !userLogin.isEmpty() && !userPassword.isEmpty()) {
                try(Session session = HibernateUtils.getSession()) {
                    session.beginTransaction();
                    Query<?> query = session.createQuery("FROM User WHERE login='" + userLogin + "'");
                    if(query.getResultList().isEmpty()) {
                        User user = new User(userLogin, userPassword, userRole);
                        if(!userName.isEmpty()) user.setFirstName(userName);
                        session.save(user);
                        singUp.getScene().setRoot(FXMLLoader.load(getClass().getResource("/sample/VIew/sample.fxml")));
                    } else {
                        error.setVisible(true);
                        error.setText("Логин уже занят");
                    }
                    session.getTransaction().commit();
                } catch (Throwable cause) {
                    cause.printStackTrace();
                }
            } else {
                error.setVisible(true);
                error.setText("Введены неверные данные");
            }
        });
        back.setOnAction(actionEvent -> {
            try {
                back.getScene().setRoot(FXMLLoader.load(getClass().getResource("/sample/VIew/sample.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
