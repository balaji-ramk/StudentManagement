/*import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SchoolManagementSystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("School Management System");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        Label helloLabel = new Label("Hello");
        helloLabel.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");

        VBox buttonsVBox = new VBox(20);
        buttonsVBox.setPadding(new Insets(10));
        buttonsVBox.setStyle("-fx-background-color: #f4f4f4; -fx-border-radius: 10; -fx-padding: 20;");

        Button attendanceButton = new Button("Attendance");
        attendanceButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14;");
        attendanceButton.setOnAction(e -> {
            AttendancePage attendancePage = new AttendancePage();
            attendancePage.start(new Stage());
        });

        Button marksButton = new Button("Marks");
        marksButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14;");
        marksButton.setOnAction(e -> {
            MarksPage marksPage = new MarksPage();
            marksPage.start(new Stage());
        });

        Button personalDetailsButton = new Button("Personal Details");
        personalDetailsButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white; -fx-font-size: 14;");
        personalDetailsButton.setOnAction(e -> {
            PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
            personalDetailsPage.start(new Stage());
        });

        buttonsVBox.getChildren().addAll(attendanceButton, marksButton, personalDetailsButton);
        layout.setTop(helloLabel);
        layout.setCenter(buttonsVBox);

        Scene scene = new Scene(layout, 400, 300);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class AttendancePage extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Attendance");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("ATTENDANCE");
        title.setStyle("-fx-font-size: 20; -fx-text-fill: #333;");

        Button goBackButton = new Button("GO back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            primaryStage.close();
            new SchoolManagementSystem().start(new Stage());
        });

        layout.setTop(title);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class MarksPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Marks");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("MARKS");
        title.setStyle("-fx-font-size: 20; -fx-text-fill: #333;");

        Button goBackButton = new Button("GO back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            primaryStage.close();
            new SchoolManagementSystem().start(new Stage());
        });

        layout.setTop(title);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class PersonalDetailsPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Details");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("PERSONAL DETAILS");
        title.setStyle("-fx-font-size: 20; -fx-text-fill: #333;");

        Button goBackButton = new Button("GO back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            primaryStage.close();
            new SchoolManagementSystem().start(new Stage());
        });

        layout.setTop(title);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SchoolManagementSystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("School Management System");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        Label helloLabel = new Label("Hello");
        helloLabel.setStyle("-fx-font-size: 36; -fx-text-fill: #333;");
        BorderPane.setAlignment(helloLabel, Pos.CENTER);

        VBox buttonsVBox = new VBox(20);
        buttonsVBox.setAlignment(Pos.CENTER);
        buttonsVBox.setPadding(new Insets(10));

        Button attendanceButton = new Button("Attendance");
        attendanceButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 18; -fx-padding: 10 20;");
        attendanceButton.setOnAction(e -> {
            openAttendancePage(primaryStage);
        });

        Button marksButton = new Button("Marks");
        marksButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 18; -fx-padding: 10 20;");
        marksButton.setOnAction(e -> {
            openMarksPage(primaryStage);
        });

        Button personalDetailsButton = new Button("Personal Details");
        personalDetailsButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white; -fx-font-size: 18; -fx-padding: 10 20;");
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

        Label title = new Label("MARKS");
        title.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");
        BorderPane.setAlignment(title, Pos.CENTER);

        Button goBackButton = new Button("GO back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            marksStage.close();
            primaryStage.show();
        });

        layout.setTop(title);
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

        Button goBackButton = new Button("GO back");
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
    private void openPersonalDetailsPage(Stage primaryStage) {
        Stage personalDetailsStage = new Stage();
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label title = new Label("PERSONAL DETAILS");
        title.setStyle("-fx-font-size: 24; -fx-text-fill: #333;");
        BorderPane.setAlignment(title, Pos.CENTER);

        Button goBackButton = new Button("GO back");
        goBackButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");
        goBackButton.setOnAction(e -> {
            personalDetailsStage.close();
            primaryStage.show();
        });

        layout.setTop(title);
        layout.setBottom(goBackButton);

        Scene scene = new Scene(layout, 400, 300);
        personalDetailsStage.setScene(scene);
        personalDetailsStage.show();
    }

    private TableView<AttendanceData> createAttendanceTable() {
        TableColumn<AttendanceData, Integer> serialNumberColumn = new TableColumn<>("Serial Number");
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));

        TableColumn<AttendanceData, String> subjectColumn = new TableColumn<>("Subject");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<AttendanceData, Double> percentageColumn = new TableColumn<>("Percentage");
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));

        TableView<AttendanceData> table = new TableView<>();
        table.getColumns().addAll(serialNumberColumn, subjectColumn, percentageColumn);

        ObservableList<AttendanceData> data = FXCollections.observableArrayList(
                new AttendanceData(1, "Maths", 85.5),
                new AttendanceData(2, "OOPS", 92.0),
                new AttendanceData(3, "DS", 78.3),
                new AttendanceData(4, "DSCO", 88.7),
                new AttendanceData(5, "FLAT", 75.9)
        );

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

        Button goBackButton = new Button("GO back");
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

        Button goBackButton = new Button("GO back");
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

        Button goBackButton = new Button("GO back");
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

// Similarly update the MarksPage and PersonalDetailsPage classes using the same approach.
