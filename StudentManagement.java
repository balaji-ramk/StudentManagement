// // import javafx.application.Application;
// // import javafx.geometry.Insets;
// // import javafx.scene.Scene;
// // import javafx.scene.control.Button;
// // import javafx.scene.control.Label;
// // import javafx.scene.control.Tab;
// // import javafx.scene.control.TabPane;
// // import javafx.scene.control.TextField;
// // import javafx.scene.layout.GridPane;
// // import javafx.scene.layout.VBox;
// // import javafx.stage.Stage;

// // public class Cringe extends Application {

// //     @Override
// //     public void start(Stage primaryStage) {
// //         // Create a tab pane
// //         TabPane tabPane = new TabPane();

// //         // Create a grid pane for the student information
// //         GridPane studentGridPane = new GridPane();
// //         studentGridPane.setPadding(new Insets(10, 10, 10, 10));
// //         studentGridPane.setVgap(5);
// //         studentGridPane.setHgap(5);

// //         // Add labels and text fields for the student information
// //         Label nameLabel = new Label("Name:");
// //         TextField nameTextField = new TextField();
// //         studentGridPane.add(nameLabel, 0, 0);
// //         studentGridPane.add(nameTextField, 1, 0);

// //         Label idLabel = new Label("ID:");
// //         TextField idTextField = new TextField();
// //         studentGridPane.add(idLabel, 0, 1);
// //         studentGridPane.add(idTextField, 1, 1);

// //         Label majorLabel = new Label("Course:");
// //         TextField majorTextField = new TextField();
// //         studentGridPane.add(majorLabel, 0, 2);
// //         studentGridPane.add(majorTextField, 1, 2);

// //         // Add buttons for the student information
// //         Button addButton = new Button("Add");
// //         Button deleteButton = new Button("Delete");
// //         Button updateButton = new Button("Update");
// //         studentGridPane.add(addButton, 0, 3);
// //         studentGridPane.add(deleteButton, 1, 3);
// //         studentGridPane.add(updateButton, 2, 3);

// //         // Create a tab for the student information
// //         Tab studentTab = new Tab("Student");
// //         studentTab.setContent(studentGridPane);

// //         // Create a VBox for the attendance information
// //         VBox attendanceVBox = new VBox();
// //         attendanceVBox.setPadding(new Insets(10, 10, 10, 10));
// //         attendanceVBox.setSpacing(5);

// //         // Add labels and text fields for the attendance information
// //         Label dateLabel = new Label("Date:");
// //         TextField dateTextField = new TextField();
// //         attendanceVBox.getChildren().add(dateLabel);
// //         attendanceVBox.getChildren().add(dateTextField);

// //         Label statusLabel = new Label("Status:");
// //         TextField statusTextField = new TextField();
// //         attendanceVBox.getChildren().add(statusLabel);
// //         attendanceVBox.getChildren().add(statusTextField);

// //         // Add buttons for the attendance information
// //         Button addAttendanceButton = new Button("Add");
// //         Button deleteAttendanceButton = new Button("Delete");
// //         Button updateAttendanceButton = new Button("Update");
// //         attendanceVBox.getChildren().add(addAttendanceButton);
// //         attendanceVBox.getChildren().add(deleteAttendanceButton);
// //         attendanceVBox.getChildren().add(updateAttendanceButton);

// //         // Create a tab for the attendance information
// //         Tab attendanceTab = new Tab("Attendance");
// //         attendanceTab.setContent(attendanceVBox);

// //         // Create a VBox for the personal records information
// //         VBox personalRecordsVBox = new VBox();
// //         personalRecordsVBox.setPadding(new Insets(10, 10, 10, 10));
// //         personalRecordsVBox.setSpacing(5);

// //         // Add labels and text fields for the personal records information
// //         Label recordLabel = new Label("Record:");
// //         TextField recordTextField = new TextField();
// //         personalRecordsVBox.getChildren().add(recordLabel);
// //         personalRecordsVBox.getChildren().add(recordTextField);

// //         // Add buttons for the personal records information
// //         Button addRecordButton = new Button("Add");
// //         Button deleteRecordButton = new Button("Delete");
// //         Button updateRecordButton = new Button("Update");
// //         personalRecordsVBox.getChildren().add(addRecordButton);
// //         personalRecordsVBox.getChildren().add(deleteRecordButton);
// //         personalRecordsVBox.getChildren().add(updateRecordButton);

// //         // Create a tab for the personal records information
// //         Tab personalRecordsTab = new Tab("Personal Records");
// //         personalRecordsTab.setContent(personalRecordsVBox);

// //         // Create a VBox for the academics information
// //         VBox academicsVBox = new VBox();
// //         academicsVBox.setPadding(new Insets(10, 10, 10, 10));
// //         academicsVBox.setSpacing(5);

// //         // Add labels and text fields for the academics information
// //         Label courseLabel = new Label("Course:");
// //         TextField courseTextField = new TextField();
// //         academicsVBox.getChildren().add(courseLabel);
// //         academicsVBox.getChildren().add(courseTextField);

// //         Label balanceLabel = new Label("Balance:");
// //         TextField balanceTextField = new TextField();
// //         academicsVBox.getChildren().add(balanceLabel);
// //         academicsVBox.getChildren().add(balanceTextField);

// //         // Add buttons for the academics information
// //         Button enrollButton = new Button("Enroll");
// //         Button payButton = new Button("Pay");
// //         academicsVBox.getChildren().add(enrollButton);
// //         academicsVBox.getChildren().add(payButton);

// //         // Create a tab for the academics information
// //         Tab academicsTab = new Tab("Academics");
// //         academicsTab.setContent(academicsVBox);

// //         // Add the tabs to the tab pane
// //         tabPane.getTabs().add(studentTab);
// //         tabPane.getTabs().add(attendanceTab);
// //         tabPane.getTabs().add(personalRecordsTab);
// //         tabPane.getTabs().add(academicsTab);

// //         // Create a scene and add the tab pane
// //         Scene scene = new Scene(tabPane, 400, 400);

// //         // Set the stage title and scene, and show the stage
// //         primaryStage.setTitle("Student Management System");
// //         primaryStage.setScene(scene);
// //         primaryStage.show();
// //     }

// //     public static void main(String[] args) {
// //         launch(args);
// //     }
// // }

// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.*;
// import javafx.stage.Stage;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.HashMap;
// import java.util.Map;

// public class StudentManagement extends Application {
//     private Map<String, Student> studentData = new HashMap<>();

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Student Lifecycle Management");

//         loadStudentDataFromCSV("student_data.csv");

//         VBox formLayout = new VBox(10);
//         formLayout.setPadding(new Insets(10));

//         Label regLabel = new Label("Enter Registration Number:");
//         TextField regNumberField = new TextField();
//         Button checkButton = new Button("Check");

//         formLayout.getChildren().addAll(regLabel, regNumberField, checkButton);

//         TextArea infoTextArea = new TextArea();
//         infoTextArea.setEditable(false);

//         checkButton.setOnAction(event -> {
//             String regNumber = regNumberField.getText();
//             Student student = studentData.get(regNumber);

//             if (student != null) {
//                 String studentInfo = "Student Name: " + student.getName() + "\n" +
//                         "Attendance: " + student.getAttendance() + "\n" +
//                         "Marks: " + student.getMarks() + "\n" +
//                         "Timetable: " + student.getTimetable();
//                 infoTextArea.setText(studentInfo);
//             } else {
//                 infoTextArea.setText("Student records not found.");
//             }
//         });

//         VBox mainLayout = new VBox(10);
//         mainLayout.setPadding(new Insets(10));
//         mainLayout.getChildren().addAll(formLayout, infoTextArea);

//         Scene scene = new Scene(mainLayout, 400, 300);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public void loadStudentDataFromCSV(String csvFilePath) {
//         try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] parts = line.split(",");
//                 if (parts.length == 5) {
//                     String regNumber = parts[0];
//                     String name = parts[1];
//                     String attendance = parts[2];
//                     String marks = parts[3];
//                     String timetable = parts[4];

//                     studentData.put(regNumber, new Student(name, attendance, marks, timetable));
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

// class Student {
//     private String name;
//     private String attendance;
//     private String marks;
//     private String timetable;

//     public Student(String name, String attendance, String marks, String timetable) {
//         this.name = name;
//         this.attendance = attendance;
//         this.marks = marks;
//         this.timetable = timetable;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getAttendance() {
//         return attendance;
//     }

//     public String getMarks() {
//         return marks;
//     }

//     public String getTimetable() {
//         return timetable;
//     }
// }

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StudentManagement extends Application {
    private Map<String, Student> studentData = new HashMap<>();
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Lifecycle Management");

        loadStudentDataFromCSV("student_data.csv");

        VBox formLayout = new VBox(10);
        formLayout.setPadding(new Insets(10));

        Label regLabel = new Label("Enter Registration Number:");
        TextField regNumberField = new TextField();
        Button checkButton = new Button("Check");

        formLayout.getChildren().addAll(regLabel, regNumberField, checkButton);

        TextArea infoTextArea = new TextArea();
        infoTextArea.setEditable(false);

        checkButton.setOnAction(event -> {
            String regNumber = regNumberField.getText();

            // Use the executor to perform the lookup in a separate thread
            Future<Student> futureStudent = executor.submit(() -> studentData.get(regNumber));

            try {
                Student student = futureStudent.get();
                if (student != null) {
                    String studentInfo = "Student Name: " + student.getName() + "\n" +
                            "Attendance: " + student.getAttendance() + "\n" +
                            "Marks: " + student.getMarks() + "\n" +
                            "Timetable: " + student.getTimetable();
                    infoTextArea.setText(studentInfo);
                } else {
                    infoTextArea.setText("Student records not found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(formLayout, infoTextArea);

        Scene scene = new Scene(mainLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadStudentDataFromCSV(String csvFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String regNumber = parts[0];
                    String name = parts[1];
                    String attendance = parts[2];
                    String marks = parts[3];
                    String timetable = parts[4];

                    studentData.put(regNumber, new Student(name, attendance, marks, timetable));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Student {
    private String name;
    private String attendance;
    private String marks;
    private String timetable;

    public Student(String name, String attendance, String marks, String timetable) {
        this.name = name;
        this.attendance = attendance;
        this.marks = marks;
        this.timetable = timetable;
    }

    public String getName() {
        return name;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getMarks() {
        return marks;
    }

    public String getTimetable() {
        return timetable;
    }
}
