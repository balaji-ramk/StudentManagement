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
import static res.pages.OpenPages.*;
import res.exceptions.InvalidRegNumberException;

public class SchoolManagementSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("School Management System");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));
        layout.setBackground(bg);

        Label helloLabel = new Label("Hello!");
        helloLabel.setStyle("-fx-font-size: 80; -fx-text-fill: black; -fx-font-weight: bold;");
        BorderPane.setAlignment(helloLabel, Pos.CENTER);

        VBox buttonsVBox = new VBox(20);
        buttonsVBox.setAlignment(Pos.CENTER);
        buttonsVBox.setPadding(new Insets(10));

        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 18; -fx-padding: 10 20;");
        loginButton.setOnAction(e -> {
            new Thread(() -> {
                Platform.runLater(() -> openLoginScreen(primaryStage));
            }).start();
        });

        Button createNewUserButton = new Button("Create New User");
        createNewUserButton.setStyle(
                "-fx-background-color: #FFA500; -fx-text-fill: white; -fx-font-size: 14; -fx-padding: 10 10;");
        createNewUserButton.setOnAction(e -> {
            new Thread(() -> {
                Platform.runLater(() -> openRegistrationPage(primaryStage));
            }).start();
        });

        buttonsVBox.getChildren().addAll(loginButton, createNewUserButton);
        layout.setTop(helloLabel);
        layout.setCenter(buttonsVBox);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void openRegistrationPage(Stage primaryStage) {
        Stage registrationStage = new Stage();
        registrationStage.initModality(Modality.APPLICATION_MODAL);
        registrationStage.setTitle("Create New User");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label regNumberLabel = new Label("Reg. No.:");
        TextField regNumberField = new TextField();

        Label semesterLabel = new Label("Semester:");
        TextField semesterField = new TextField();

        Label sectionLabel = new Label("Section:");
        TextField sectionField = new TextField();

        Label marksLabel = new Label("Attendances:");
        TextField marksField = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String regData = String.format("%s,%s,%s,%s,%s", regNumberField.getText(), nameField.getText(),
                    semesterField.getText(), sectionField.getText(), marksField.getText());
            appendToCSV(regData);
            registrationStage.close();
            start(primaryStage);
        });

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(regNumberLabel, 0, 1);
        grid.add(regNumberField, 1, 1);

        grid.add(semesterLabel, 0, 2);
        grid.add(semesterField, 1, 2);

        grid.add(sectionLabel, 0, 3);
        grid.add(sectionField, 1, 3);

        grid.add(marksLabel, 0, 4);
        grid.add(marksField, 1, 4);

        grid.add(submitButton, 1, 5);

        Scene scene = new Scene(grid, 300, 250);
        registrationStage.setScene(scene);
        registrationStage.show();
    }

    public void appendToCSV(String data) {
        try (FileWriter writer = new FileWriter("student_data.csv", true);
                BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openLoginScreen(Stage primaryStage) {
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
        loginButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 14;");

        loginButton.setOnAction(e -> {
            regNum = regNumberField.getText();
            try {
                if (isValidRegistrationNumber()) {
                    loginStage.close();
                    openMainMenu(primaryStage);
                } else {
                    throw new InvalidRegNumberException();
                }
            } catch (InvalidRegNumberException ex) {
                ex.showDialog();
            }
        });

        grid.add(regLabel, 0, 0);
        grid.add(regNumberField, 1, 0);
        grid.add(loginButton, 1, 1);

        Scene scene = new Scene(grid, 300, 150);
        loginStage.setScene(scene);
        loginStage.show();
    }

    public boolean isValidRegistrationNumber() {
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
            e.printStackTrace();
        }
        return isValid;
    }

    public void openMainMenu(Stage primaryStage) {
        primaryStage.setTitle("School Management System");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));
        layout.setBackground(bg);

        Label helloLabel = new Label("Home Page");
        helloLabel.setStyle("-fx-font-size: 60; -fx-text-fill: black; -fx-font-weight: bold;");
        BorderPane.setAlignment(helloLabel, Pos.CENTER);

        VBox buttonsVBox = new VBox(10);
        buttonsVBox.setAlignment(Pos.CENTER);
        buttonsVBox.setPadding(new Insets(10));

        Button attendanceButton = new Button("Attendance");
        attendanceButton
                .setStyle("-fx-background-color: orange; -fx-text-fill: black; -fx-font-size: 18; -fx-padding: 5 10;");
        attendanceButton.setOnAction(e -> openAttendancePage(primaryStage));

        Button marksButton = new Button("Marks");
        marksButton
                .setStyle("-fx-background-color: orange; -fx-text-fill: black; -fx-font-size: 18; -fx-padding: 5 10;");
        marksButton.setOnAction(e -> openMarksPage(primaryStage));

        Button personalDetailsButton = new Button("Personal Details");
        personalDetailsButton
                .setStyle("-fx-background-color: orange; -fx-text-fill: black; -fx-font-size: 18; -fx-padding: 5 10;");
        personalDetailsButton.setOnAction(e -> openPersonalDetailsPage(primaryStage));

        Button signOutButton = new Button("Sign Out");
        signOutButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-size: 10;");
        signOutButton.setOnAction(e -> {
            primaryStage.close();
            start(primaryStage);
        });
        BorderPane.setAlignment(signOutButton, Pos.BOTTOM_RIGHT);

        buttonsVBox.getChildren().addAll(attendanceButton, marksButton, personalDetailsButton);
        layout.setTop(helloLabel);
        layout.setCenter(buttonsVBox);
        layout.setBottom(signOutButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
