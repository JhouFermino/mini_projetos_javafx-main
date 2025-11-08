package projetos.cadastroSimples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroSimplesApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CadastroSimplesApplication.class.getResource("cadastro-simples-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 448, 448);
        stage.setTitle("Cadastro Simples");
        stage.setScene(scene);
        stage.show();
    }
}
