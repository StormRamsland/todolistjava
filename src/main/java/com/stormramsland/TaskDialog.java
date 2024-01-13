package com.stormramsland;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.util.Pair;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import java.util.Optional;

public class TaskDialog {
    private String taskName;
    private String taskDescription;
    //Creating the dialog for adding a task
    TaskDialog(){
        Dialog<Pair<String, String>> createTaskDialog = new Dialog<>();
        createTaskDialog.setTitle(null);
        createTaskDialog.setHeaderText(null);
        createTaskDialog.setGraphic(null);

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        createTaskDialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField name = new TextField();
        name.setPromptText("Task name");
        grid.add(name, 1, 0);
        TextField description = new TextField();
        description.setPromptText("Description");
        grid.add(description, 1, 1);

        createTaskDialog.getDialogPane().setContent(grid);

        createTaskDialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                taskName = name.getText();
                taskDescription = description.getText();
            }
            return null;
        });
        Optional<Pair<String, String>> result = createTaskDialog.showAndWait();
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }
}
