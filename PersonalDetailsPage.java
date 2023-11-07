package com.schoolmanagement.pages;

import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import com.schoolmanagement.pages.AttendancePage;

public class PersonalDetailsPage extends AttendancePage {
    private Stage primaryStage;

    PersonalDetailsPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}