package projetos.contaDeLuz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetos.montagemDeLanche.MontagemDeLancheApplication;

public class ContaDeLuzApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ContaDeLuzApplication.class.getResource("conta-de-luz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Simulador de Conta de Luz");
        stage.setScene(scene);
        stage.show();
    }
}
