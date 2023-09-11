package com.dmitriyevseyev.gui_car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Controller() {
    }

    @FXML
    private Label carManager;
    @FXML
    private Button modifyCar;
    @FXML
    private Button add;
    @FXML
    private Button deleteCar;
    @FXML
    TableView<Car> tableview;

    @FXML
    private TableColumn<Car, Integer> idColumn;
    @FXML
    private TableColumn<Car, String> nameColumn;
    @FXML
    private TableColumn<Car, String> colorColumn;
    @FXML
    private TableColumn<Car, Boolean> isAfterCrashColumn;
    @FXML
    private TableColumn<Car, String> actionColumn;

    ObservableList<Car> data;
    private ArrayList<Car> rows = new ArrayList<>();

    public void refresh() {

        for (int i = 0; i < rows.size(); i++) {
            rows.get(i).getCheckBox().setOnAction(actionEvent -> {
                selectedCheckBox();
            });
        }
        RefreshHelper.getInstance().setHelloController(this);
    }

    private void selectedCheckBox() {
        int count = 0;

        for (Car row : rows) {
            if (row.getCheckBox().isSelected()) {
                ++count;
            }
        }
        if (count == 0) {
            deleteCar.setDisable(true);
            modifyCar.setDisable(true);
        }
        if (count == 1) {
            deleteCar.setDisable(false);
            modifyCar.setDisable(false);
        }
        if (count > 1) {
            deleteCar.setDisable(false);
            modifyCar.setDisable(false);
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        rows.addAll(ListCar.carList);
        tableview.setItems(FXCollections.observableList(rows));

        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        colorColumn.setCellValueFactory(new PropertyValueFactory("color"));
        isAfterCrashColumn.setCellValueFactory(new PropertyValueFactory("isAfterCrash"));
        actionColumn.setCellValueFactory(new PropertyValueFactory("checkBox"));

        RefreshHelper.getInstance().setHelloController(this);
    }

    @FXML
    private void deleteSelectedRows(ActionEvent actionEvent) {
        int length = tableview.getItems().size();
        for (int i = 0; i < length && length > 0; i++) {
            if (tableview.getItems().get(i).getCheckBox().isSelected()) {
                tableview.getItems().remove(i);
                --i;
                --length;
            }
            selectedCheckBox();
        }
    }

    @FXML
    private void editSelectedRow() {
        int length = tableview.getItems().size();
        for (int i = 0; i < length; i++) {
            if (tableview.getItems().get(i).getCheckBox().isSelected()) {
                try {
                    // Загружаем fxml-файл и создаём новую сцену для всплывающего диалогового окна.
                    FXMLLoader loader = new FXMLLoader(Application.class.getResource("CarEditDialog.fxml"));
                    Scene scene = new Scene(loader.load());

                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("Edit Car");
                    dialogStage.setScene(scene);

                    // Передаём адресата в контроллер.
                    EditCarController controller = loader.getController();
                    controller.setDialogStage(dialogStage);
                    controller.setCar(tableview.getItems().get(i));

                    dialogStage.showAndWait();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            selectedCheckBox();
        }
    }
}

