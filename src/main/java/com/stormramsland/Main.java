package com.stormramsland;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public void start (Stage primaryStage) {
        try {
            //Creating the borderpane
            BorderPane root = new BorderPane();

            //Creating the buttons and separators for the toolbar
            Button buttonAdd = new Button("Add");
            Button buttonRemove = new Button("Remove");
            Separator separator = new Separator();
            Button buttonRename = new Button("Rename");
            Button buttonEdit = new Button("Edit");

            //Creating the toolbar
            ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(buttonAdd, buttonRemove, separator, buttonRename, buttonEdit);

            //Adding the toolbar to the borderpane
            root.setTop(toolBar);

            //Creating the scene
            Scene scene = new Scene(root,400,400);
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
}