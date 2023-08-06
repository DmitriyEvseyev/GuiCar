package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditCarController {

    public EditCarController() {
    }

    @FXML
    private TextField IdField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField ColorField;
    @FXML
    private TextField isAfterCrashField;

    private Stage dialogStage;
    private Car car;
    private boolean okClicked = false;

    /**     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.     */
    @FXML
    private void initialize() {
    }

    /**      * Устанавливает сцену для этого окна.     *     * @param dialogStage     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**     * Задаёт адресата, информацию о котором будем менять.    * @param     */
    public void setCar(Car car) {
        this.car = car;

        IdField.setText(Integer.toString(car.getId()));
        NameField.setText(car.getName());
        ColorField.setText(car.getColor());
        isAfterCrashField.setText(Boolean.toString(car.isIsAfterCrash()));
    }

    /**     * Returns true, если пользователь кликнул OK, в другом случае false.    *    * @return     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**     * Вызывается, когда пользователь кликнул по кнопке OK.    */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            car.setId(Integer.parseInt((IdField.getText())));
            car.setName(NameField.getText());
            car.setColor(ColorField.getText());
            car.setIsAfterCrash(Boolean.parseBoolean(isAfterCrashField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**     * Вызывается, когда пользователь кликнул по кнопке Cancel.     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**     * Проверяет пользовательский ввод в текстовых полях. * @return true, если пользовательский ввод корректен*/
    private boolean isInputValid() {
        String errorMessage = "";

        if (IdField.getText() == null || IdField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (ColorField.getText() == null || ColorField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (isAfterCrashField.getText() == null || isAfterCrashField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            try {
                Boolean.parseBoolean((isAfterCrashField.getText()));
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
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




