package projetos.semaforoTimer;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class SemaforoTimerController {
    private String VERMELHO = "#e84118";
    private String AMARELO = "#fbc531";
    private String VERDE = "#4cd137";
    private String NEUTRO = "#2f3640";

    @FXML
    public Circle ccVermelho;
    @FXML
    public Circle ccAmarelo;
    @FXML
    public Circle ccVerde;

    @FXML
    public Button btnComecar;
    @FXML
    public Button btnParar;

    private Timeline timeline;

    public void initialize() {
        ccVermelho.setFill(Color.web(VERMELHO));
        ccAmarelo.setFill(Color.web(AMARELO));
        ccVerde.setFill(Color.web(VERDE));

        btnParar.setDisable(true);
    }

    @FXML
    public void onClickIniciar() {
        btnParar.setDisable(false);
        btnComecar.setDisable(true);
        ccVermelho.setFill(Color.web(NEUTRO));
        ccAmarelo.setFill(Color.web(NEUTRO));
        ccVerde.setFill(Color.web(NEUTRO));

        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(ccVermelho.fillProperty(), Color.web(VERMELHO), Interpolator.DISCRETE)),
                new KeyFrame(Duration.seconds(2), new KeyValue(ccVermelho.fillProperty(), Color.web(NEUTRO), Interpolator.DISCRETE), new KeyValue(ccAmarelo.fillProperty(), Color.web(AMARELO), Interpolator.DISCRETE)),
                new KeyFrame(Duration.seconds(4), new KeyValue(ccAmarelo.fillProperty(), Color.web(NEUTRO), Interpolator.DISCRETE), new KeyValue(ccVerde.fillProperty(), Color.web(VERDE), Interpolator.DISCRETE)),
                new KeyFrame(Duration.seconds(6), new KeyValue(ccVerde.fillProperty(), Color.web(NEUTRO), Interpolator.DISCRETE), new KeyValue(ccAmarelo.fillProperty(), Color.web(AMARELO), Interpolator.DISCRETE)),
                new KeyFrame(Duration.seconds(8), new KeyValue(ccAmarelo.fillProperty(), Color.web(NEUTRO), Interpolator.DISCRETE))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    @FXML
    public void onClickParar() {
        btnComecar.setDisable(false);
        btnParar.setDisable(true);
        ccVermelho.setFill(Color.web(VERMELHO));
        ccAmarelo.setFill(Color.web(AMARELO));
        ccVerde.setFill(Color.web(VERDE));
        timeline.stop();
    }
}
