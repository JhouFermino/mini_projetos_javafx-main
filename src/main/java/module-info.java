module projetos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens projetos.calculadoraDeOperacoesBasicas to javafx.fxml;
    exports projetos.calculadoraDeOperacoesBasicas;

    opens projetos.conversorDeTemperatura to javafx.fxml;
    exports projetos.conversorDeTemperatura;

    opens projetos.cadastroDePessoa to javafx.fxml;
    exports projetos.cadastroDePessoa;

    opens projetos.mediaEscolar to javafx.fxml;
    exports projetos.mediaEscolar;

    opens projetos.cadastroSimples to javafx.fxml;
    exports projetos.cadastroSimples;
    exports projetos.cadastroSimples.entity;
    opens projetos.cadastroSimples.entity to javafx.fxml;

    opens projetos.montagemDeLanche to javafx.fxml;
    exports projetos.montagemDeLanche;

    opens projetos.contaDeLuz to javafx.fxml;
    exports projetos.contaDeLuz;

    opens projetos.jogoDeAdivinhacao to javafx.fxml;
    exports projetos.jogoDeAdivinhacao;

    opens projetos.semaforoTimer to javafx.fxml;
    exports projetos.semaforoTimer;
}