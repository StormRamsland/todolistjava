package com.stormramsland;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.CornerRadii;

import java.util.ArrayList;

public class Main extends Application {

    //Creating a list for containing the tasks
    private ArrayList<Task> taskArrayList = new ArrayList<>();
    private VBox taskDescription = new VBox();
    private VBox taskView = new VBox();
    private Task selectedTask;
    private TextInputDialog changeNameDialog = new TextInputDialog("Change task name");
    private TextInputDialog changeDescriptionDialog;
    private Label viewDescriptionLabel;
    public void start (Stage primaryStage) {
        try {

            //Creating the borderpane
            BorderPane root = new BorderPane();
            Insets insets = new Insets(5);

            //Creating the buttons and separators for the toolbar
            Button buttonAdd = new Button("Add");
            Button buttonRemove = new Button("Remove");
            Separator separator = new Separator();
            Button buttonRename = new Button("Rename");
            Button buttonEdit = new Button("Edit");

            //Linking the methods to the buttons
            buttonAdd.setOnAction(event -> addButton());
            buttonRemove.setOnAction(event -> removeButton());
            buttonRename.setOnAction(event -> renameButton());
            buttonEdit.setOnAction(event -> editButton());

            //Creating the toolbar
            ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(buttonAdd, buttonRemove, separator, buttonRename, buttonEdit);

            //Adding the toolbar to the borderpane
            root.setTop(toolBar);

            //Setting the background color to white
            root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

            //Adding the VBox for viewing the tasks
            root.setLeft(taskView);
            BorderPane.setMargin(taskView,insets);
            taskView.setMaxWidth(50);

            //Adding the VBox for viewing the task description
            root.setCenter(taskDescription);
            BorderPane.setMargin(taskDescription,insets);
            taskDescription.setMaxWidth(430);

            //Adding a placeholder label
            viewDescriptionLabel = new Label("");
            taskDescription.getChildren().add(viewDescriptionLabel);
            viewDescriptionLabel.setWrapText(true);
            viewDescriptionLabel.setTextAlignment(TextAlignment.LEFT);

            //Creating example task
            createTask("Test", "Wow very cool");

            changeNameDialog.setHeaderText(null);
            changeNameDialog.setGraphic(null);

            //Creating the scene
            Scene scene = new Scene(root,500,500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("To-do list");
            primaryStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    //Creates the task and also creates functionality to select and view the tasks
    private void createTask(String name, String description) {
        Task task = new Task(name,description);
        taskArrayList.add(task);
        taskView.getChildren().add(task.getTaskHBox());

        task.getTaskHBox().setOnMouseClicked(event -> {
            for (Task value : taskArrayList) {
                value.getTaskHBox().setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            task.getTaskHBox().setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

            selectedTask = task;
            viewDescriptionLabel.setText(selectedTask.getDescription());

            changeDescriptionDialog = new TextInputDialog(selectedTask.getDescription());
            changeDescriptionDialog.setHeaderText(null);
            changeDescriptionDialog.setGraphic(null);
        });
    }

    //Method that
    private void addButton() {
        TaskDialog taskDialog = new TaskDialog();
        createTask(taskDialog.getTaskName(), taskDialog.getTaskDescription());
    }
    //Creates method for remove button functionality
    private void removeButton() {
        if (selectedTask != null) {
            taskView.getChildren().remove(selectedTask.getTaskHBox());
            viewDescriptionLabel.setText("");
            taskArrayList.remove(selectedTask);
            selectedTask = null;
        }
    }
    private void editButton() {
        if (selectedTask != null) {
            changeDescriptionDialog.showAndWait();
            changeDescriptionDialog.setResultConverter(okButton -> {
                if (okButton == ButtonType.OK) {
                    viewDescriptionLabel.setText(changeDescriptionDialog.getEditor().getText());
                }
                return null;
            });
        }
    }
    //Creates method for rename button functionality
    private void renameButton() {
        if (selectedTask != null) {
            changeNameDialog.showAndWait();
            changeNameDialog.setResultConverter(okButton -> {
                if (okButton == ButtonType.OK) {
                    selectedTask.setName(changeNameDialog.getEditor().getText());
                }
                return null;
            });
        }
    }
}