package projetos.jogoDeAdivinhacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetos.contaDeLuz.ContaDeLuzApplication;

public class JogoDeAdivinhacaoApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(JogoDeAdivinhacaoApplication.class.getResource("jogo-adivinhacao-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Jogo de Adivinhação");
        stage.setScene(scene);
        stage.show();
    }
}
