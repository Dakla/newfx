package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtils;
import sample.domains.User;

public class tableTest {
    @FXML
    public TableView<User> tableTest;

    @FXML
    void initialize() {
//        TableColumn<User, String> tcFN = new TableColumn<>("Имя");
//        TableColumn<User, String> tcId = new TableColumn<>("id");
//        tcFN.setCellFactory(TextFieldTableCell.forTableColumn());
//        tcFN.setOnEditCommit(t -> {
//            t.getRowValue().setFirstName(t.getNewValue());
//            updateData(t.getRowValue());
//        });
//        TableColumn<User, String> tcLN = new TableColumn<>("Фамилия");
//        tcLN.setCellFactory(TextFieldTableCell.forTableColumn());
//        tcLN.setOnEditCommit(t -> {
//            t.getRowValue().setLastName(t.getNewValue());
//            updateData(t.getRowValue());
//        });
//        TableColumn<User, String> tcLog = new TableColumn<>("Логин");
//        tcLog.setCellFactory(TextFieldTableCell.forTableColumn());
//        tcLog.setOnEditCommit(t -> {
//            t.getRowValue().setUsername(t.getNewValue());
//            updateData(t.getRowValue());
//        });
//        TableColumn<User, String> tcCnt = new TableColumn<>("Страна");
//        tcCnt.setCellFactory(TextFieldTableCell.forTableColumn());
//        tcCnt.setOnEditCommit(t -> {
//            t.getRowValue().setLocation(t.getNewValue());
//            updateData(t.getRowValue());
//        });
//        TableColumn<User, String> tcGen = new TableColumn<>("Пол");
//        tcGen.setCellFactory(ChoiceBoxTableCell.forTableColumn("Мужчина", "Женщина"));
//        tcGen.setOnEditCommit(t -> {
//            t.getRowValue().setGender(t.getNewValue());
//            updateData(t.getRowValue());
//        });
//
//
//        try(Session session = HibernateUtils.getSession()) {
//            session.beginTransaction();
//
//            Query<User> query = session.createQuery("FROM User");
//            ObservableList<User> users = FXCollections.observableArrayList(query.getResultList());
//            if(!users.isEmpty()) {
//                tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
//                tcFN.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//                tcLN.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//                tcLog.setCellValueFactory(new PropertyValueFactory<>("username"));
//                tcCnt.setCellValueFactory(new PropertyValueFactory<>("location"));
//                tcGen.setCellValueFactory(new PropertyValueFactory<>("gender"));
//                tableTest.setItems(users);
//                tableTest.getColumns().addAll(tcId, tcFN, tcLN, tcLog, tcCnt, tcGen);
//            }
//            session.getTransaction().commit();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
    }

    private void updateData(User rowValue) {
        try(Session session = HibernateUtils.getSession()) {
            session.beginTransaction();
            session.update(rowValue);
            session.getTransaction().commit();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
