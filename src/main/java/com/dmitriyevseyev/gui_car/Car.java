package com.dmitriyevseyev.gui_car;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.util.Objects;

public class Car {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty color;
    private SimpleBooleanProperty isAfterCrash;
    private CheckBox checkBox;

    public Car() {
    }

    public Car(Integer id, String name, String color, Boolean isAfterCrash) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleStringProperty(color);
        this.isAfterCrash = new SimpleBooleanProperty(isAfterCrash);
        this.checkBox = new CheckBox();
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public boolean isIsAfterCrash() {
        return isAfterCrash.get();
    }

    public SimpleBooleanProperty isAfterCrashProperty() {
        return isAfterCrash;
    }

    public void setIsAfterCrash(boolean isAfterCrash) {
        this.isAfterCrash.set(isAfterCrash);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isAfterCrash == car.isAfterCrash &&
                Objects.equals(id, car.id) &&
                Objects.equals(name, car.name) &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, isAfterCrash);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", isAfterCrash=" + isAfterCrash +
                '}';
    }
}

