package projetos.contaDeLuz;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ContaDeLuzController {

    private String RESIDENCIAL = "Residencial";
    private String COMERCIAL = "Comercial";
    private String INDUSTRIAL = "Industrial";

    @FXML
    public TextField tfNome;
    @FXML
    public TextField tfConsumo;

    // Tipo de residência
    @FXML
    public ComboBox<String> cbResidencia;

    // Campo do resultado
    @FXML
    public Label lbResposta;

    public void initialize() {
        cbResidencia.getItems().addAll(RESIDENCIAL, COMERCIAL, INDUSTRIAL);
        cbResidencia.setValue("Residencial");
    }

    public boolean isDouble(TextField tf) {
        try {
            Double.parseDouble(tf.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public boolean eMaiorQueZero(TextField tf) { return Double.parseDouble(tf.getText()) > 0; }

    @FXML
    public void onClickCalcular() {
        DecimalFormat df = new DecimalFormat("0.00");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        if(tfNome.getText().isEmpty() || tfConsumo.getText().isEmpty()) {
            lbResposta.setText("Todos os campos devem ser preenchidos!");
        } else if(!isDouble(tfConsumo)) {
            lbResposta.setText("O campo consumo precisa ser preenchido com números!");
        } else if(!eMaiorQueZero(tfConsumo)) {
            lbResposta.setText("O valor de consumo precisa ser maior que zero!");
        } else {
            String nome =  tfNome.getText();
            double consumo = Double.parseDouble(tfConsumo.getText());
            String tipoResidencia = cbResidencia.getValue();
            double valorDaConta;

            if(tipoResidencia.equals(RESIDENCIAL)) {
                valorDaConta = consumo * 0.60;
            } else if(tipoResidencia.equals(COMERCIAL)) {
                valorDaConta = consumo * 0.48;
            } else {
                valorDaConta = consumo * 0.75;
            }

            lbResposta.setText("Cliente: " + nome + " — Tipo: " + tipoResidencia + " — Consumo: " + df.format(consumo) + " kWh — Valor: " + nf.format(valorDaConta));
        }
    }
}
