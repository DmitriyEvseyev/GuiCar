package com.dmitriyevseyev.gui_car;

public class RefreshHelper {
    private Controller helloController;
    private static RefreshHelper instance;

    private RefreshHelper() {
    }

    public static  RefreshHelper getInstance() {
        if (instance == null) {
            instance = new RefreshHelper();
        }
        return instance;
    }


    public Controller getHelloController () {
        return helloController;
    }

    public void setHelloController (Controller helloController) {
        this.helloController = helloController;
    }
}