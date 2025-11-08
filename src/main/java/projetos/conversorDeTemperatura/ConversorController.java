package projetos.conversorDeTemperatura;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class ConversorController {
    DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    public TextField tfNumero;

    @FXML
    public Label  labelResultado;

    @FXML
    public void onClickConverterEmCelsius() {
        double numeroFarenheit = Double.parseDouble(tfNumero.getText());
        Double celsius = (numeroFarenheit - 32) * 5 / 9;

        labelResultado.setText("Resultado: " + df.format(celsius) + " °C");
    }

    @FXML
    public void onClickConverterEmFahrenheit() {
        double numeroCelsius = Double.parseDouble(tfNumero.getText());
        Double farenheit = (numeroCelsius * 9 / 5) + 32;

        labelResultado.setText("Resultado: " + df.format(farenheit) + " °F");
    }


}
