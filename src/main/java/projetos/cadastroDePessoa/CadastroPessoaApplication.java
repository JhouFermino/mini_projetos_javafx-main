package projetos.cadastroDePessoa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroPessoaApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CadastroPessoaApplication.class.getResource("cadastro-pessoa-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 448, 448);
        stage.setTitle("Cadastro de Pessoas");
        stage.setScene(scene);
        stage.show();
    }
}
