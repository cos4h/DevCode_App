import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.io.IOException;
import java.util.Scanner;

public class DevCodeController {
    @FXML private MenuItem NewProyectItem;
    @FXML private MenuItem SaveItem;
    @FXML private TextArea textCode;
    @FXML private ToolBar toolBar;
    @FXML private BorderPane borderPane;

    private Path directoryCurrent;

    public void initialize() {

        // Aplicar el color de fondo al TextArea
        textCode.setStyle("-fx-control-inner-background: rgb(41, 42, 62);" +
                "-fx-font-size: 24;" + " -fx-border-color: rgb(41, 42, 62);");

    }

    public void onSaveButtonPressed(javafx.event.ActionEvent event) {
        try (Formatter output = new Formatter(directoryCurrent.toString())){
                output.format("%s", textCode.getText());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void OpenFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.setInitialDirectory(new File("D:"));
        File file = fileChooser.showOpenDialog(
                borderPane.getScene().getWindow());
        directoryCurrent = file.toPath();
        try(Scanner input = new Scanner(Paths.get(file.toPath().toString()))) {
            StringBuilder content = new StringBuilder();

            while (input.hasNext()) {
                content.append(input.nextLine()).append("\n");
            }
            textCode.setText(content.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void onNewProjectButtonPressed(javafx.event.ActionEvent event) {
        System.out.println("Hello");
    }

    public void onNewFileButtonPressed(ActionEvent event) {

    }

}
