package org.cms.cateringmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CMSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CMSApplication.class.getResource("index.fxml"));
        Font.loadFont(getClass().getResourceAsStream("src/main/resources/org/cms/cateringmanagementsystem/css/Montserrat-MediumItalic.ttf"), 14);
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("catering_logo.jpeg")));
        Scene scene = new Scene(fxmlLoader.load());

        scene.setFill(Color.BLACK);
        stage.setTitle("CMS (Catering Management System)");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}