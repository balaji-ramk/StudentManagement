package res.pages;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import java.io.*;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import res.data.AttendanceData;
import res.data.MarksData;

public class OpenPages {
    public static String regNum;
    public static String parts[];
    public static Image backgroundImage = new Image("file:bg11.png");

    // Create the background image for the root layout
    public static BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
            false, true,
            true);
    public static BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    public static Background bg = new Background(background);

    public static void openMarksPage(Stage primaryStage) {
        Stage marksStage = new Stage();
        BorderPane layout = new BorderPane();
        layout.setBackground(bg);

        layout.setPadding(new Insets(20));

        Label title = new Label("Marks");
        title.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");
        BorderPane.setAlignment(title, Pos.CENTER);

        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                marksStage.close();
                primaryStage.show();
            }
        });
        TableView<MarksData> table = createMarksTable();
        layout.setTop(title);
        layout.setCenter(table);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        marksStage.setScene(scene);
        marksStage.show();
    }

    public static void openAttendancePage(Stage primaryStage) {
        Stage attendanceStage = new Stage();
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));
        layout.setBackground(bg);

        Label title = new Label("ATTENDANCE");
        title.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");
        BorderPane.setAlignment(title, Pos.CENTER);

        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                attendanceStage.close();
                primaryStage.show();
            }
        });

        TableView<AttendanceData> table = createAttendanceTable();
        layout.setTop(title);
        layout.setCenter(table);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        attendanceStage.setScene(scene);
        attendanceStage.show();
    }

    public static void openPersonalDetailsPage(Stage primaryStage) {
        Stage PersonStage = new Stage();

        BorderPane personalDetailsLayout = new BorderPane();
        personalDetailsLayout.setBackground(bg);

        VBox personalDetailsVBox = new VBox(10);
        personalDetailsVBox.setPadding(new Insets(20));
        personalDetailsVBox.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Name: " + parts[1]);
        Label regNumberLabel = new Label("Registration Number: " + parts[0]);
        Label semesterLabel = new Label("Semester: " + parts[2]);
        Label sectionLabel = new Label("Section: " + parts[3]);
        nameLabel.setStyle("-fx-text-fill: black; -fx-font-size: 14;-fx-font-weight: bold;");

        personalDetailsVBox.getChildren().addAll(nameLabel, regNumberLabel, semesterLabel, sectionLabel);
        personalDetailsLayout.setStyle("-fx-text-fill: black; -fx-font-size: 14;-fx-font-weight: bold;");
        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PersonStage.close();
                primaryStage.show();
            }
        });
        personalDetailsLayout.setCenter(personalDetailsVBox);
        personalDetailsLayout.setBottom(goBackButton);

        Scene personalDetailsScene = new Scene(personalDetailsLayout, 400, 300);
        PersonStage.setScene(personalDetailsScene);
        PersonStage.show();
    }

    public static TableView<MarksData> createMarksTable() {
        TableView<MarksData> table = new TableView<>();

        TableColumn<MarksData, Integer> serialNoColumn = new TableColumn<>("Serial No");
        serialNoColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));

        TableColumn<MarksData, String> subjectColumn = new TableColumn<>("Subjects");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<MarksData, Integer> midSemesterMarksColumn = new TableColumn<>("Mid Semester Marks");
        midSemesterMarksColumn.setCellValueFactory(new PropertyValueFactory<>("midSemesterMarks"));

        TableColumn<MarksData, Integer> internalMarksColumn = new TableColumn<>("Internal Marks");
        internalMarksColumn.setCellValueFactory(new PropertyValueFactory<>("internalMarks"));

        TableColumn<MarksData, Integer> endSemesterMarksColumn = new TableColumn<>("End Semester Marks");
        endSemesterMarksColumn.setCellValueFactory(new PropertyValueFactory<>("endSemesterMarks"));

        TableColumn<MarksData, Integer> totalMarksColumn = new TableColumn<>("Total Marks");
        totalMarksColumn.setCellValueFactory(new PropertyValueFactory<>("totalMarks"));

        table.getColumns().addAll(serialNoColumn, subjectColumn, midSemesterMarksColumn, internalMarksColumn,
                endSemesterMarksColumn, totalMarksColumn);

        ObservableList<MarksData> data = FXCollections.observableArrayList(
                new MarksData(1, "OOP", 25, 15, 45),
                new MarksData(2, "DS", 28, 18, 49),
                new MarksData(3, "MATH", 22, 12, 39),
                new MarksData(4, "FLAT", 26, 16, 48),
                new MarksData(5, "DSCO", 30, 20, 50),
                new MarksData(6, "IDA", 25, 17, 45)
        // Add more data as needed
        );
        table.setPrefSize(10, 10);

        table.setItems(data);
        return table;
    }

    public static TableView<AttendanceData> createAttendanceTable() {
        TableColumn<AttendanceData, Double> serialNumberColumn = new TableColumn<>("Serial Number");
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));

        TableColumn<AttendanceData, String> subjectColumn = new TableColumn<>("Subject");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<AttendanceData, Double> percentageColumn = new TableColumn<>("Percentage");
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));

        TableView<AttendanceData> table = new TableView<>();
        table.getColumns().addAll(serialNumberColumn, subjectColumn, percentageColumn);

        ObservableList<AttendanceData> data = FXCollections.observableArrayList(
                new AttendanceData(1, "MATH", Double.parseDouble(parts[4])),
                new AttendanceData(2, "OOP", Double.parseDouble(parts[5])),
                new AttendanceData(3, "DS", Double.parseDouble(parts[6])),
                new AttendanceData(4, "DSCO", Double.parseDouble(parts[7])),
                new AttendanceData(5, "FLAT", Double.parseDouble(parts[8])),
                new AttendanceData(6, "IDA", Double.parseDouble(parts[9])));

        table.setItems(data);
        return table;
    }

}
