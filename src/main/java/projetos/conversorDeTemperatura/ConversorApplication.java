package projetos.conversorDeTemperatura;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConversorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConversorApplication.class.getResource("conversor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 448, 448);
        stage.setTitle("Conversor");
        stage.setScene(scene);
        stage.show();
    }
}
