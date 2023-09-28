package com.dmitriyevseyev.gui_car;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditCarController {

    public EditCarController() {
    }

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField dateField;
    @FXML
    private DatePicker dp;
    @FXML
    private TextField colorField;
    @FXML
    private CheckBox isAfterCrashField;

    private Stage dialogStage;
    private Car car;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void ShowDate(javafx.event.ActionEvent actionEvent) {
        LocalDate ld = dp.getValue();
        dateField.setText(ld.toString());
    }

    public void setCar(Car car) {
        this.car = car;

        idField.setText(Integer.toString(car.getId()));
        nameField.setText(car.getName());
        dateField.setText(car.getDate());
        colorField.setText(car.getColor());
        isAfterCrashField.setSelected(car.isIsAfterCrash());
        // isAfterCrashField.setText(Boolean.toString(car.isIsAfterCrash()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            car.setId(Integer.parseInt((idField.getText())));
            car.setName(nameField.getText());
            car.setDate(dateField.getText());
            car.setColor(colorField.getText());
            car.setIsAfterCrash(isAfterCrashField.isSelected());
            //car.setIsAfterCrash(Boolean.parseBoolean(isAfterCrashField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /* Проверяет пользовательский ввод в текстовых полях. * @return true, если пользовательский ввод корректен*/
    private boolean isInputValid() {
        String errorMessage = "";

        if (idField.getText() == null || idField.getText().length() == 0) {
            errorMessage += "Invalid Id!\n";
        } else {
            try {
                Integer.parseInt((idField.getText()));
            } catch (NumberFormatException e) {
                errorMessage += "No valid (id must be an integer)!\n";
            }
        }
        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (dateField.getText() == null || dateField.getText().length() == 0) {
            errorMessage += "No valid date!\n";
        }
        if (colorField.getText() == null || colorField.getText().length() == 0) {
            errorMessage += "Invalid color!\n";
        }

        /*if (isAfterCrashField.getText() == null || isAfterCrashField.getText().length() == 0) {
            errorMessage += "Invalid isAfterCrashField!\n";
        } else {
            try {
                Boolean.parseBoolean((isAfterCrashField.getText()));
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }*/

        if (errorMessage.length() == 0) {
            return true;

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}





