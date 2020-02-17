package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtils;
import sample.domains.User;

public class EmpController {

    public Long userId;
    public Label userName;

    @FXML
    void initialize() { }

    public void setUserId(Long userId) {
        this.userId = userId;
        setUserName();
    }

    public void setUserName() {
        if(userId != null) {
            try(Session session = HibernateUtils.getSession()) {
                Query<?> q = session.createQuery("FROM User WHERE id=" + userId);
                if(!q.getResultList().isEmpty()) {
                    User user = (User) q.getSingleResult();
                    userName.setText("Здравствуй, " + user.getFirstName() + "!");
                }
            }
        }
    }
}
