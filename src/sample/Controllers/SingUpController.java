package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import sample.Utils.HibernateUtils;
import sample.Utils.SceneUtils;
import sample.domains.User;

import javax.swing.*;

public class SingUpController {
    @FXML
    public TextField singUpName;
    @FXML
    public TextField singUpLogin;
    @FXML
    public PasswordField singUpPwd;
    @FXML
    public Button singUpBtn;
    @FXML
    public TextField singUpLastName;
    @FXML
    public TextField singUpCountry;
    @FXML
    public ToggleGroup Gender;

    @FXML
    void initialize() {
        singUpBtn.setOnAction(event -> {
            String name = singUpName.getText().trim();
            String lastName = singUpLastName.getText().trim();
            String login = singUpLogin.getText().trim().toLowerCase();
            String location = singUpCountry.getText().trim();
            RadioButton selectRb = (RadioButton) Gender.getSelectedToggle();
            String gend = selectRb.getText();
            String password = singUpPwd.getText().trim();
            if(!name.isEmpty() && !lastName.isEmpty() && !login.isEmpty() &&
                    !location.isEmpty() && !gend.isEmpty() && !password.isEmpty()
            ) {
                try(Session session = HibernateUtils.getSession()) {
                    session.beginTransaction();
                    User user = new User(name, lastName, login, password, location, gend);
                    session.save(user);
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Вы успешно зарегистрировались",
                            "Registration", JOptionPane.INFORMATION_MESSAGE);
                    SceneUtils.changeScene("sample.fxml", singUpBtn.getScene());
                } catch (Throwable cause) {
                    cause.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Что-то пошло не так", "Registration",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
