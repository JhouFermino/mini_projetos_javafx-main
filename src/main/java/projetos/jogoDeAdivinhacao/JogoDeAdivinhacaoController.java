package projetos.jogoDeAdivinhacao;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class JogoDeAdivinhacaoController {

    @FXML
    public TextField tfNumero;
    @FXML
    public Button btnVerificar;
    @FXML
    public Label lbResultado;

    public boolean isInteger(TextField tf) {
        try {
            Integer.parseInt(tf.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    @FXML
    public void onClickVerificar() {
        Random random = new Random();
        int numeroSortido = random.nextInt(10) + 1;

        if(!isInteger(tfNumero)) {
            lbResultado.setText("É preciso colocar um número do tipo inteiro no campo!");
        } else {
            int numeroDigitado = Integer.parseInt(tfNumero.getText());
            if(numeroDigitado >= 1 && numeroDigitado <= 10) {

                if(numeroSortido == numeroDigitado) {
                    lbResultado.setText("Acertou!");
                    btnVerificar.setText("Verificar");
                } else {
                    lbResultado.setText("Errou! O número era " + numeroSortido);
                    btnVerificar.setText("Tentar Novamente");
                }

                tfNumero.clear();
            } else {
                lbResultado.setText("O número digitado é inválido!");
            }
        }
    }

}
