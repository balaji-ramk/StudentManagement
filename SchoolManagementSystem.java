import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class SchoolManagementSystem extends Application {
    private static final String CSV_FILE_PATH = "users.csv";
    public static String regNum;
    static String parts[];

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("School Management System");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        Label helloLabel = new Label("Hello!");
        helloLabel.setStyle("-fx-font-size: 36; -fx-text-fill: #333;");
        BorderPane.setAlignment(helloLabel, Pos.CENTER);

        VBox buttonsVBox = new VBox(20);
        buttonsVBox.setAlignment(Pos.CENTER);
        buttonsVBox.setPadding(new Insets(10));

        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 18; -fx-padding: 10 20;");
        loginButton.setOnAction(e -> openLoginScreen(primaryStage));
        buttonsVBox.getChildren().addAll(loginButton);

        layout.setTop(helloLabel);
        layout.setCenter(buttonsVBox);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openLoginScreen(Stage primaryStage) {
        Stage loginStage = new Stage();
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Label regLabel = new Label("Enter Reg. No.:");
        TextField regNumberField = new TextField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            regNum = regNumberField.getText(); // Update the class variable here
            if (isValidRegistrationNumber()) {
                loginStage.close();
                openMainMenu(primaryStage);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Registration Number");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid registration number.");
                alert.showAndWait();
            }
        });

        grid.add(regLabel, 0, 0);
        grid.add(regNumberField, 1, 0);
        grid.add(loginButton, 1, 1);

        Scene scene = new Scene(grid, 300, 150);
        loginStage.setScene(scene);
        loginStage.show();
    }

    private boolean isValidRegistrationNumber() {
        boolean isValid = false;
        try (BufferedReader br = new BufferedReader(new FileReader("student_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(regNum)) {
                    isValid = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return isValid;
    }

    private void openMainMenu(Stage primaryStage) {
        primaryStage.setTitle("School Management System");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        Label helloLabel = new Label("Home Page");
        helloLabel.setStyle("-fx-font-size: 60; -fx-text-fill: black;-fx-font-weight: bold;");
        BorderPane.setAlignment(helloLabel, Pos.CENTER);

        Image backgroundImage = new Image("file:bg11.png");

        // Create the background image for the root layout
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true,
                true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background bg = new Background(background);
        layout.setBackground(bg);
        VBox buttonsVBox = new VBox(20);
        buttonsVBox.setAlignment(Pos.CENTER);
        buttonsVBox.setPadding(new Insets(10));

        Button attendanceButton = new Button("Attendance");
        attendanceButton.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 18; -fx-padding: 10 20;");
        attendanceButton.setOnAction(e -> {
            openAttendancePage(primaryStage);
        });

        Button marksButton = new Button("Marks");
        marksButton.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 18; -fx-padding: 10 20;");
        marksButton.setOnAction(e -> {
            openMarksPage(primaryStage);
        });

        Button personalDetailsButton = new Button("Personal Details");
        personalDetailsButton.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 18; -fx-padding: 10 20;");
        personalDetailsButton.setOnAction(e -> {
            openPersonalDetailsPage(primaryStage);
        });

        buttonsVBox.getChildren().addAll(attendanceButton, marksButton, personalDetailsButton);
        layout.setTop(helloLabel);
        layout.setCenter(buttonsVBox);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openMarksPage(Stage primaryStage) {
        Stage marksStage = new Stage();
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("Marks");
        title.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");
        BorderPane.setAlignment(title, Pos.CENTER);

        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            marksStage.close();
            primaryStage.show();
        });
        TableView<MarksData> table = createMarksTable();
        layout.setTop(title);
        layout.setCenter(table);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        marksStage.setScene(scene);
        marksStage.show();
    }

    private void openAttendancePage(Stage primaryStage) {
        Stage attendanceStage = new Stage();
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("ATTENDANCE");
        title.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");
        BorderPane.setAlignment(title, Pos.CENTER);

        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            attendanceStage.close();
            primaryStage.show();
        });

        TableView<AttendanceData> table = createAttendanceTable();
        layout.setTop(title);
        layout.setCenter(table);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        attendanceStage.setScene(scene);
        attendanceStage.show();
    }

    private TableView<MarksData> createMarksTable() {
        TableView<MarksData> table = new TableView<>();

        TableColumn<MarksData, Integer> serialNoColumn = new TableColumn<>("Serial No");
        serialNoColumn.setCellValueFactory(new PropertyValueFactory<>("serialNo"));

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

    private void openPersonalDetailsPage(Stage primaryStage) {
        Stage PersonStage = new Stage();

        BorderPane personalDetailsLayout = new BorderPane();

        VBox personalDetailsVBox = new VBox(10);
        personalDetailsVBox.setPadding(new Insets(20));

        // Predefined personal details
        Label nameLabel = new Label("Name: " + parts[1]);
        Label regNumberLabel = new Label("Registration Number: " + parts[0]);
        Label semesterLabel = new Label("Semester: " + parts[2]);
        Label sectionLabel = new Label("Section: " + parts[3]);

        personalDetailsVBox.getChildren().addAll(nameLabel, regNumberLabel, semesterLabel, sectionLabel);

        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            PersonStage.close();
            primaryStage.show();
        });

        personalDetailsLayout.setCenter(personalDetailsVBox);
        personalDetailsLayout.setBottom(goBackButton);

        Scene personalDetailsScene = new Scene(personalDetailsLayout, 400, 300);
        PersonStage.setScene(personalDetailsScene);
        PersonStage.show();
    }

    private TableView<AttendanceData> createAttendanceTable() {
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
                new AttendanceData(6, "IDA", Double.parseDouble(parts[6])));

        table.setItems(data);
        return table;
    }

    public static class AttendanceData {
        private final Integer serialNumber;
        private final String subject;
        private final Double percentage;

        public AttendanceData(Integer serialNumber, String subject, Double percentage) {
            this.serialNumber = serialNumber;
            this.subject = subject;
            this.percentage = percentage;
        }

        public Integer getSerialNumber() {
            return serialNumber;
        }

        public String getSubject() {
            return subject;
        }

        public Double getPercentage() {
            return percentage;
        }
    }

    public static class MarksData {
        private int serialNo;
        private String subject;
        private int midSemesterMarks;
        private int internalMarks;
        private int endSemesterMarks;

        public MarksData(int serialNo, String subject, int midSemesterMarks, int internalMarks, int endSemesterMarks) {
            this.serialNo = serialNo;
            this.subject = subject;
            this.midSemesterMarks = Math.min(midSemesterMarks, 30);
            this.internalMarks = Math.min(internalMarks, 20);
            this.endSemesterMarks = Math.min(endSemesterMarks, 50);
        }

        public int getSerialNo() {
            return serialNo;
        }

        public String getSubject() {
            return subject;
        }

        public int getMidSemesterMarks() {
            return midSemesterMarks;
        }

        public int getInternalMarks() {
            return internalMarks;
        }

        public int getEndSemesterMarks() {
            return endSemesterMarks;
        }

        public int getTotalMarks() {
            return midSemesterMarks + internalMarks + endSemesterMarks;
        }
    }
}

class AttendancePage {
    private Stage primaryStage;

    AttendancePage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void open() {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("ATTENDANCE");
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

class MarksPage {
    private Stage primaryStage;

    MarksPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void open() {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("MARKS");
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

class PersonalDetailsPage {
    private Stage primaryStage;

    PersonalDetailsPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void open() {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("PERSONAL DETAILS");
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