package com.example.demo3;

import com.example.demo3.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public HelloController() {
    }

    @FXML
    private Label CarManager;
    @FXML
    private Button modifyCar;
    @FXML
    private Button add;
    @FXML
    private Button deleteCar;
    @FXML
    TableView<Car> tableview;

    @FXML
    private TableColumn<Car, Integer> IdColumn;
    @FXML
    private TableColumn<Car, String> NameColumn;
    @FXML
    private TableColumn<Car, String> ColorColumn;
    @FXML
    private TableColumn<Car, Boolean> isAfterCrashColumn;
    @FXML
    private TableColumn<Car, String> ActionColumn;

    ObservableList<Car> data;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList(ListCar.carList);

        IdColumn.setCellValueFactory(new PropertyValueFactory("id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        ColorColumn.setCellValueFactory(new PropertyValueFactory("color"));
        isAfterCrashColumn.setCellValueFactory(new PropertyValueFactory("isAfterCrash"));
        ActionColumn.setCellValueFactory(new PropertyValueFactory("checkbox"));

        tableview.setItems(data);
    }

    @FXML
    private void deleteSelectedRows() {

        ObservableList<Car> dataListRemove = FXCollections.observableArrayList();

        for (Car bean : data) {
            if (bean.getCheckbox().isSelected() == true) {
                dataListRemove.add(bean);
                break;
            }
            if (bean.getCheckbox().isSelected() == false) {
                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("No Selection");
                alert.setHeaderText("No Person Selected");
                alert.setContentText("Please select a car in the table.");

                alert.showAndWait();
            }
        }

        data.removeAll(dataListRemove);
    }

    @FXML
    private void editSelectedRow() {
        for (Car bean : data) {
            if (bean.getCheckbox().isSelected() == true) {
                try {
                    // Загружаем fxml-файл и создаём новую сцену для всплывающего диалогового окна.
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("CarEditDialog.fxml"));
                    Scene scene = new Scene(loader.load());

                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("Edit Car");
                    dialogStage.setScene(scene);

                    // Передаём адресата в контроллер.
                    EditCarController controller = loader.getController();
                    controller.setDialogStage(dialogStage);
                    controller.setCar(bean);

                    dialogStage.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

