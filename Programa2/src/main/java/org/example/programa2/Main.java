package org.example.programa2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hola, bienvenido a JavaFX");
        Button button = new Button("Haz clic");
        button.setOnAction(e -> label.setText("Botón presionado"));

        Button boton2 = new Button("Salir");
        boton2.setOnAction(e -> stage.close());
        VBox layout = new VBox(10, label, button,boton2);
        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Primer programa con JavaFX");

        stage.setScene(scene);

        stage.setFullScreen(true);

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}