package com.stormramsland;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

class Task {
    private String name;
    private String description;
    private HBox taskHBox;
    private Label taskLabel;

    Task(String name, String description) {
        this.name = name;
        this.description = description;

        taskLabel = new Label(name);
        taskHBox = new HBox();
        taskHBox.getChildren().add(taskLabel);
    }

    public HBox getTaskHBox() {
        return taskHBox;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String string) {
        this.name = string;
        taskLabel.setText(string);
    }
    public void setDescription(String string) {
        this.description = string;
    }
}
