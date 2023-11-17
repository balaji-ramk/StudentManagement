package res.exceptions;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.*;

public class InvalidRegNumberException extends Exception {
    public void showDialog() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Registration Number");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid registration number.");
                alert.showAndWait();
            }
        });
    }
}
