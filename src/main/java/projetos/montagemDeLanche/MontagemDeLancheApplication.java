package projetos.montagemDeLanche;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetos.conversorDeTemperatura.ConversorApplication;

public class MontagemDeLancheApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MontagemDeLancheApplication.class.getResource("montagem-lanche-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Montagem de Lanche");
        stage.setScene(scene);
        stage.show();
    }
}
