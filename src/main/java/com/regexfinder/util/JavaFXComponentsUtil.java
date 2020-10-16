package com.regexfinder.util;

import static com.regexfinder.util.Constants.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class JavaFXComponentsUtil {

    public static GridPane addGridPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        return grid;
    }

    public static ComboBox addComboBox() {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        EMAIL_STRING,
                        PHONE_STRING,
                        DOMAIN_STRING
                );
        final ComboBox comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();

        return comboBox;
    }

    public static HBox addHBox(Button btn) {
        HBox hBtn = new HBox(10);
        hBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBtn.getChildren().add(btn);

        return hBtn;
    }
}
