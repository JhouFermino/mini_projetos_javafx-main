package projetos.cadastroSimples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import projetos.cadastroSimples.entity.Aluno;

import java.util.ArrayList;
import java.util.List;

public class CadastroSimplesController {

    // Gerencia a lista de alunos e toda vez que é adicionado outro aluno ele atualiza a tabela automaticamente
    public final ObservableList<Aluno> alunos = FXCollections.observableArrayList();

    // Campos para registros
    @FXML
    public TextField tfNome;
    @FXML
    public TextField tfIdade;
    @FXML
    public ComboBox<String> cbCurso;

    //Local para Avisos
    @FXML
    public Label lbAviso;

    // Variáveis da tabela
    @FXML
    public TableView<Aluno> tbAlunos;
    @FXML
    public TableColumn<Aluno, String> tcNome;
    @FXML
    public TableColumn<Aluno, Integer> tcIdade;
    @FXML
    public TableColumn<Aluno, String> tcCurso;
    @FXML
    public TableColumn<Aluno, Void> tcAcao;


    public boolean eMaiorQueZero(TextField tf) {
        return Integer.parseInt(tf.getText()) > 0;
    }

    public boolean isInteger(TextField tf) {
        try {
            Integer.parseInt(tf.getText());
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void adicionarBotaoDeletar() {
        tcAcao.setCellFactory(param -> new TableCell<>() {
            private final Button botaoDeletar = new Button("Deletar");

            {
                botaoDeletar.setOnAction(event -> {
                    Aluno aluno = getTableView().getItems().get(getIndex());
                    alunos.remove(aluno); // remove da lista
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(botaoDeletar);
                }
            }
        });
    }

    @FXML
    public void initialize() {
        // Adicionando itens no ComboBox
        cbCurso.getItems().addAll("Curso 1", "Curso 2", "Curso 3", "Curso 4", "Curso 5");
        cbCurso.setValue("Curso 1"); // Valor Padrão

        // Referênciando as propriedades do objeto Aluno com as colunas da tabela
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tcCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));

        // Adicionando lista a tabela
        tbAlunos.setItems(alunos);

        adicionarBotaoDeletar();

    }

    @FXML
    public void onClickCadastrar() {
        if(tfNome.getText().isEmpty() || tfIdade.getText().isEmpty() || cbCurso.getValue().isEmpty()) {
            lbAviso.setText("Preencha todos os campos!");
        } else if(!isInteger(tfIdade)){
            lbAviso.setText("A idade precisa ser um número inteiro!");
        } else if(!eMaiorQueZero(tfIdade)) {
            lbAviso.setText("A idade precisa ser maior que zero");
        } else {
            String nome = tfNome.getText();
            Integer idade = Integer.parseInt(tfIdade.getText());
            String curso = cbCurso.getValue();
            Aluno alunoNovo = new Aluno(nome, idade, curso);
            alunos.add(alunoNovo);
            lbAviso.setText("");
            tfNome.clear();
            tfIdade.clear();
            cbCurso.setValue("Curso 1");
        }
    }
}
