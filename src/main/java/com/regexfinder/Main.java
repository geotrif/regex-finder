package com.regexfinder;

import static com.regexfinder.util.Constants.*;

import com.regexfinder.util.JavaFXComponentsUtil;
import com.regexfinder.util.RegexUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Regex Finder");

        GridPane grid = JavaFXComponentsUtil.addGridPane();

        Label filePathLabel = new Label("File Path: ");
        grid.add(filePathLabel, 0, 0);

        TextField filePathField = new TextField();
        grid.add(filePathField, 1, 0);

        final File[] file = {new File("")};
        Button filePathButton = new Button("...");
        grid.add(filePathButton, 2, 0);
        filePathButton.setOnAction(event -> activateFilePathButtonAction(file, primaryStage, filePathField));

        Label regexTypeLabel = new Label();
        regexTypeLabel.setText("Regex Type:");
        grid.add(regexTypeLabel, 0, 1);

        final ComboBox comboBox = JavaFXComponentsUtil.addComboBox();
        grid.add(comboBox, 1, 1);

        Button btn = new Button("Find by regex");
        HBox hBtn = JavaFXComponentsUtil.addHBox(btn);
        grid.add(hBtn, 1, 2);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        btn.setOnAction(event -> activateResultsButtonAction(actionTarget, file, comboBox));

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void activateFilePathButtonAction(File[] file, Stage primaryStage, TextField filePathField) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file[0] = fileChooser.showOpenDialog(primaryStage);
        filePathField.setText(file[0].getAbsolutePath());
    }

    private void activateResultsButtonAction(Text actionTarget, File[] file, ComboBox comboBox) {
        if (EMAIL_STRING.equals(comboBox.getValue())) {
            try {
                RegexUtil.matchStringByRegex(file[0].getAbsolutePath(), WRITE_FILE_PATH, EMAIL_REGEX);
                actionTarget.setText(String.format(FILE_CREATED_MESSAGE, comboBox.getValue(), WRITE_FILE_PATH));
            } catch (Exception e) {
                e.printStackTrace();
                actionTarget.setText(String.format(CANNOT_CREATE_FILE_MESSAGE, WRITE_FILE_PATH));
            }
        } else if (PHONE_STRING.equals(comboBox.getValue())) {
            try {
                RegexUtil.matchStringByRegex(file[0].getAbsolutePath(), WRITE_FILE_PATH, PHONE_REGEX);
                actionTarget.setText(String.format(FILE_CREATED_MESSAGE, comboBox.getValue(), WRITE_FILE_PATH));
            } catch (Exception e) {
                e.printStackTrace();
                actionTarget.setText(String.format(CANNOT_CREATE_FILE_MESSAGE, WRITE_FILE_PATH));
            }
        } else if (DOMAIN_STRING.equals(comboBox.getValue())) {
            try {
                RegexUtil.matchStringByRegex(file[0].getAbsolutePath(), WRITE_FILE_PATH, DOMAIN_REGEX);
                actionTarget.setText(String.format(FILE_CREATED_MESSAGE, comboBox.getValue(), WRITE_FILE_PATH));
            } catch (Exception e) {
                e.printStackTrace();
                actionTarget.setText(String.format(CANNOT_CREATE_FILE_MESSAGE, WRITE_FILE_PATH));
            }
        }
    }
}
