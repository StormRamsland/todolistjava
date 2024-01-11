package com.stormramsland;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

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
            buttonAdd.setOnAction(event ->  {
                addButton();
            });
            buttonRemove.setOnAction(event ->  {
                removeButton();
            });
            buttonRename.setOnAction(event ->  {
                renameButton();
            });
            buttonEdit.setOnAction(event ->  {
                editButton();
            });

            //Creating the toolbar
            ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(buttonAdd, buttonRemove, separator, buttonRename, buttonEdit);

            //Adding the toolbar to the borderpane
            root.setTop(toolBar);

            //Creating the vbox for viewing the tasks
            VBox taskView = new VBox();
            root.setLeft(taskView);
            BorderPane.setMargin(taskView,insets);

            VBox spacer = new VBox();
            spacer.setMaxWidth(20);
            spacer.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
            root.setCenter(spacer);

            //Creating the vbox for viewing the task description
            VBox taskDescription = new VBox();
            root.setRight(taskDescription);
            BorderPane.setMargin(taskDescription,insets);


            //Creating example task
            Task exampleTask = new Task("Example","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            createNewTask(exampleTask,taskView,taskDescription);


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
    //Method that adds the task as a label to the vbox
    private void createLabel(Task task,VBox vBox) {
        Label taskLabel = new Label(task.getName());
        taskLabel.setMaxWidth(50);
        HBox taskHBox = new HBox();
        taskHBox.getChildren().add(taskLabel);
        vBox.getChildren().add(taskHBox);
    }
    //Method that adds the task description as a label to the vbox
    private void createDescription(Task task,VBox vBox) {
        Label descriptionLabel = new Label(task.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setMaxWidth(430);
        vBox.getChildren().add(descriptionLabel);
    }
    //Method that adds the task label and description to the vbox
    private void createNewTask(Task task,VBox taskView,VBox taskDescription) {
        createLabel(task,taskView);
        createDescription(task,taskDescription);
    }
    //Method that
    private void addButton() {

    }
    private void removeButton() {

    }
    private void editButton() {

    }
    private void renameButton() {

    }
}