//package sample.Controllers;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.ChoiceBoxTableCell;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.image.ImageView;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import sample.Utils.HibernateUtils;
//import sample.domains.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TableTest {
//    @FXML
//    public TableView<User> tableTest;
//    public Button back;
//
//    public void getText(String text) {
//        System.out.println(text);
//    }
//
//    public void setBack(String url) {
//        Label backUrl = new Label();
//        backUrl.setText(url);
//        backUrl.setVisible(false);
//    }
//
//    @FXML
//    void initialize() {
//        back.setText("Назад");
//        back.setOnAction(actionEvent -> {
//            back.getScene().getWindow().hide();
//        });
//        TableColumn<User, String> tcId = new TableColumn<>("id");
//        TableColumn<User, String> tcFN = new TableColumn<>("Имя");
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
//        TableColumn<User, ImageView> tcCnt = new TableColumn<>("Страна");
//        tcCnt.setCellFactory(new PropertyValueFactory<User, ImageView>());
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
//                List<TableColumn<User, String>> tcs = new ArrayList<>();
//                tcs.add(tcId);
//                tcs.add(tcFN);
//                tcs.add(tcLN);
//                tcs.add(tcLog);
//                tcs.add(tcCnt);
//                tcs.add(tcGen);
//                tableTest.getColumns().addAll(tcs);
//            }
//            session.getTransaction().commit();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//
//    private void updateData(User rowValue) {
//        try(Session session = HibernateUtils.getSession()) {
//            session.beginTransaction();
//            session.update(rowValue);
//            session.getTransaction().commit();
//        } catch (Throwable ex) {
//            ex.printStackTrace();
//        }
//    }
//}
