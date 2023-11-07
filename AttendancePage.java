package com.schoolmanagement.pages;

import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;

public class AttendancePage {
    private Stage primaryStage;
    String labelNameIn;

    AttendancePage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        labelNameIn = "ATTENDANCE";
    }

    void open() {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label(labelNameIn);
        title.setStyle("-fx-font-size: 20; -fx-text-fill: #333;");

        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            Stage stage = (Stage) goBackButton.getScene().getWindow();
            stage.close();
            primaryStage.show();
        });

        layout.setTop(title);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}