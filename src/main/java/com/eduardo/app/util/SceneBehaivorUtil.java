package com.eduardo.app.util;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneBehaivorUtil {
    private static double xOffset;
    private static double yOffset;

    public static void behaviorMove(Parent root) {

        root.setOnMousePressed(event -> {
            root.setCursor(Cursor.HAND);
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        root.setOnMouseReleased((event) -> {
            root.setCursor(Cursor.DEFAULT);
        });

    }

}
