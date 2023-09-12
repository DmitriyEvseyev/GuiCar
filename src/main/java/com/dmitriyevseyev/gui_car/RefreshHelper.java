package com.dmitriyevseyev.gui_car;

public class RefreshHelper {
    private Controller controller;
    private static RefreshHelper instance;

    private RefreshHelper() {
    }

    public static RefreshHelper getInstance() {
        if (instance == null) {
            instance = new RefreshHelper();
        }
        return instance;
    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}