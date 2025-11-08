package projetos.cadastroDePessoa;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastroPessoaController {


    @FXML
    public TextField tfNome;
    @FXML
    public TextField tfIdade;

    @FXML
    public RadioButton rbMasculino;
    @FXML
    public RadioButton rbFeminino;
    @FXML
    public CheckBox cbEsportes;

    @FXML
    public Label labelResposta;

    @FXML
    public void onClickMasculino() {
        rbMasculino.setSelected(true);
        rbFeminino.setSelected(false);
    }
    @FXML
    public void onClickFeminino() {
        rbMasculino.setSelected(false);
        rbFeminino.setSelected(true);
    }

    public boolean isInteger(TextField tf) {
        try {
            Integer.parseInt(tf.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    @FXML
    public void onClickFazerAnalise() {
        if(tfIdade.getText().trim().isEmpty() || tfNome.getText().trim().isEmpty()) {
            labelResposta.setText("É necessário preencher os campos corretamente!");
        } else if(!isInteger(tfIdade)) {
            labelResposta.setText("O campo idade precisa ser um número inteiro!");
        } else if(!rbMasculino.isSelected() &&  !rbFeminino.isSelected()){
            labelResposta.setText("É necessário selecionar um dos campos de sexo!");
        }
        else if(Integer.parseInt(tfIdade.getText()) <= 0) {
            labelResposta.setText("A idade precisa ser maior que zero (0)!");
        } else {
            String nome = tfNome.getText();
            int idade = Integer.parseInt(tfIdade.getText());

            if(idade >= 18) {
                labelResposta.setText(nome + ", " + idade + " anos (maior de idade), do sexo " + (rbMasculino.isSelected()? "masculino" : "feminino") + "\n" + (cbEsportes.isSelected()? ", gosta de esportes" : ""));
            } else {
                labelResposta.setText(nome + ", " + idade + " anos (menor de idade), do sexo " + (rbMasculino.isSelected()? "masculino" : "feminino") + "\n" + (cbEsportes.isSelected()? ", gosta de esportes" : ""));
            }
        }
    }
}
