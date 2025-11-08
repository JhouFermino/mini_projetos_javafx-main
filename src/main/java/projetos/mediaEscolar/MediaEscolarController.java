package projetos.mediaEscolar;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class MediaEscolarController {
    DecimalFormat df = new DecimalFormat("0.0");

    @FXML
    public TextField tfNome;

    @FXML
    public TextField tfNota1;
    @FXML
    public TextField tfNota2;
    @FXML
    public TextField tfNota3;


    @FXML
    public Label lbResposta;


    public boolean eMaiorQueZero(TextField tf) {
        return Double.parseDouble(tf.getText()) >= 0;
    }

    public boolean isDouble(TextField tf) {
        try {
            Double.parseDouble(tf.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    @FXML
    public void onClickCalcularMedia() {
        if(tfNome.getText().isEmpty() || tfNota1.getText().isEmpty() || tfNota2.getText().isEmpty() || tfNota3.getText().isEmpty()) {
            lbResposta.setText("É necessário preencher todos os campos!");
        } else if(!isDouble(tfNota1) || !isDouble(tfNota2) || !isDouble(tfNota3)) {
            lbResposta.setText("Os campos de notas só aceitam números");
        } else if(!eMaiorQueZero(tfNota1) || !eMaiorQueZero(tfNota2) || !eMaiorQueZero(tfNota3)) {
            lbResposta.setText("As notas não podem ser menor que zero!");
        } else {
            String nome = tfNome.getText();
            Double nota1 = Double.parseDouble(tfNota1.getText());
            Double nota2 = Double.parseDouble(tfNota2.getText());
            Double nota3 = Double.parseDouble(tfNota3.getText());
            Double media = (nota1 + nota2 + nota3) / 3;

            String mensagemDeResultadoFinal = "Reprovado";
            if(media >= 7) {
                mensagemDeResultadoFinal = "Aprovado";
            } else if(media >= 4) {
                mensagemDeResultadoFinal = "Recuperação";
            }

            lbResposta.setText(nome + " — Média: " + df.format(media) + " — " + mensagemDeResultadoFinal);
        }
    }
}
