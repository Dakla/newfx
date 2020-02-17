package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtils;
import sample.Utils.SceneUtils;
import sample.domains.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    public Button loginLoginBtn;

    @FXML
    public Button loginRegBnt;

    @FXML
    private ResourceBundle resourceBundle;

    @FXML
    private URL location;

    @FXML
    private TextField loginLogin;

    @FXML
    private PasswordField loginPwd;

    @FXML
    void initialize() {
        loginLoginBtn.setOnAction(event -> {
            String loginText = loginLogin.getText().trim().toLowerCase();
            String password = loginPwd.getText().trim();

            if(!loginText.equals("") && !password.equals("")) {
                loginUser(loginText, password);
            } else {
                System.out.println("Error");
            }
        });

        loginRegBnt.setOnAction(event -> {
            try {
                loginRegBnt.getScene().setRoot(FXMLLoader.load(getClass().getResource("/sample/VIew/singUp.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loginUser(String loginText, String password) {
        try (Session session = HibernateUtils.getSession()){
            session.beginTransaction();
            Query<?> query = session.createQuery("FROM User WHERE login='" + loginText + "'");
            if(query.getResultList().isEmpty()) {
                throw new Throwable("UserNotFound");
            }
            else {
                User user = (User) query.getSingleResult();
                if (user.getPassword().equals(password)) {
                    switch (user.getRole()) {
                        case "Заказчик": {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/VIew/empWin.fxml"));
                            Parent root = loader.load();
                            EmpController controller = loader.getController();
                            controller.setUserId(user.getId());
                            loginLoginBtn.getScene().setRoot(root);
                            break;
                        }
                        case "Менеджер": loginLoginBtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("/sample/VIew/manWin.fxml"))); break;
                        case "Кладовщик": loginLoginBtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("/sample/VIew/kladWin.fxml")));break;
                        case "Дирекция": loginLoginBtn.getScene().setRoot(FXMLLoader.load(getClass().getResource("/sample/VIew/dirWin.fxml")));break;
                        default: break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Логин и пароль не совпадают", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }

            session.getTransaction().commit();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
