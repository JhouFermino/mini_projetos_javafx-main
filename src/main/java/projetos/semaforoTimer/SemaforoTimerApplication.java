package projetos.semaforoTimer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetos.montagemDeLanche.MontagemDeLancheApplication;

public class SemaforoTimerApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SemaforoTimerApplication.class.getResource("semaforo-timer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Montagem de Lanche");
        stage.setScene(scene);
        stage.show();
    }
}
