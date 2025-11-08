package projetos.calculadoraDeOperacoesBasicas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class CalculadoraController {
    DecimalFormat df = new DecimalFormat("0.0");

    @FXML
    public TextField tfPrimeiroNumero;
    @FXML
    public TextField tfSegundoNumero;

    @FXML
    public Label  labelResultado;

    @FXML
    public void onClickAdicao() {
        double primeiroNumero = Double.parseDouble(tfPrimeiroNumero.getText());
        double segundoNumero = Double.parseDouble(tfSegundoNumero.getText());

        Double resultado = primeiroNumero + segundoNumero;

        labelResultado.setText("Resultado: " + df.format(resultado));
    }

    @FXML
    public void onClickSubtracao() {
        double primeiroNumero = Double.parseDouble(tfPrimeiroNumero.getText());
        double segundoNumero = Double.parseDouble(tfSegundoNumero.getText());

        Double resultado = primeiroNumero - segundoNumero;

        labelResultado.setText("Resultado: " + df.format(resultado));
    }

    @FXML
    public void onClickDivisao() {
        double primeiroNumero = Double.parseDouble(tfPrimeiroNumero.getText());
        double segundoNumero = Double.parseDouble(tfSegundoNumero.getText());

        Double resultado = primeiroNumero / segundoNumero;

        labelResultado.setText("Resultado: " + df.format(resultado));
    }

    @FXML
    public void onClickMultiplicacao() {
        double primeiroNumero = Double.parseDouble(tfPrimeiroNumero.getText());
        double segundoNumero = Double.parseDouble(tfSegundoNumero.getText());

        Double resultado = primeiroNumero * segundoNumero;

        labelResultado.setText("Resultado: " + df.format(resultado));
    }
    @FXML
    public void onClickClearFields() {
        tfPrimeiroNumero.setText("");
        tfSegundoNumero.setText("");
        labelResultado.setText("O resultado vai aparecer aqui!");
    }


}
