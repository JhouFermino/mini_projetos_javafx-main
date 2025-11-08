package projetos.mediaEscolar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MediaEscolarApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MediaEscolarApplication.class.getResource("media-escolar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 448, 448);
        stage.setTitle("Calculadora de Média");
        stage.setScene(scene);
        stage.show();
    }
}
