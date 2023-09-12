package com.dmitriyevseyev.gui_car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCar {
    private static ListCar instance;

    public static ListCar getInstance() {
        if (instance == null) {
            instance = new ListCar();
        }
        return instance;
    }

    public List<Car> carList;

    private ListCar() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }
}
