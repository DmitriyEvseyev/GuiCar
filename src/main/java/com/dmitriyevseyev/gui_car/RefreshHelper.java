package com.dmitriyevseyev.gui_car;

public class RefreshHelper {
    private HelloController helloController;
    private static RefreshHelper instance;

    private RefreshHelper() {
    }

    public static  RefreshHelper getInstance() {
        if (instance == null) {
            instance = new RefreshHelper();
        }
        return instance;
    }


    public HelloController getHelloController () {
        return helloController;
    }

    public void setHelloController (HelloController helloController) {
        this.helloController = helloController;
    }
}