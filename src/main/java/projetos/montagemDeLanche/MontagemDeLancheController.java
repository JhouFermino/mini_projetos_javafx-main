package projetos.montagemDeLanche;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class MontagemDeLancheController {

    // Manipulação de RadioButtons
    public ToggleGroup group = new ToggleGroup();

    // Manipulação de CheckBoxes
    public List<CheckBox> checkBoxes = new ArrayList<>();

    // Itens gerais do SceneBuilder
    @FXML
    public TextField tfNome;
    @FXML
    public Label lbResposta;
    @FXML
    public Button btnGerarPedido;


    // RadioButtons - Única escolha
    @FXML
    public RadioButton rbBovina;
    @FXML
    public RadioButton rbFrango;
    @FXML
    public RadioButton rbSoja;


    // CheckBoxes - Multipla Escolha
    @FXML
    public CheckBox cbBacon;
    @FXML
    public CheckBox cbQueijo;
    @FXML
    public CheckBox cbSalada;
    @FXML
    public CheckBox cbMolho;

    // Menu Suspenso
    @FXML
    public ComboBox<String> cbTipoDePao;

    // Função que executa seu bloco antes do programa inicializar
    public void initialize(){
        // Adicionando itens no menu suspenso
        cbTipoDePao.getItems().addAll("Francês", "Integral", "Australiano");
        cbTipoDePao.setValue("Francês");

        // Validando CheckBoxes
        rbBovina.setToggleGroup(group);
        rbFrango.setToggleGroup(group);
        rbSoja.setToggleGroup(group);

        // Armazenando CheckBoxes
        checkBoxes.add(cbBacon);
        checkBoxes.add(cbQueijo);
        checkBoxes.add(cbSalada);
        checkBoxes.add(cbMolho);
    }

    @FXML
    public void onClickGerarPedido(){
        if(tfNome.getText().isEmpty() | group.getSelectedToggle() == null){
            lbResposta.setText("Preencha os dados!");
        } else {
            // Criando lista para os CheckBoxes Marcados
            List<CheckBox> checkBoxesMarcados = new ArrayList<>();
            // Verificando quais checkboxes estão marcados e adicinando eles na lista acima
            for(CheckBox checkBox : checkBoxes){
                if(checkBox.isSelected()){
                    checkBoxesMarcados.add(checkBox);
                }
            }

            String nome = tfNome.getText();
            String tipoDePao = cbTipoDePao.getValue();
            RadioButton radioButtonEscolhido = (RadioButton) group.getSelectedToggle();
            String tipoDeCane = radioButtonEscolhido.getText();

            // Verifica se há itens adicionais marcados
            if(checkBoxesMarcados.isEmpty()){
                lbResposta.setText("Pedido de " + nome + ": pão " + tipoDePao + " com carne " +  tipoDeCane + "!");
            } else {
                lbResposta.setText("Pedido de " + nome + ": Pão " + tipoDePao + " com carne " +  tipoDeCane);
                // Adicionando itens adicionais na mensagem
                int contador = 0;
                for(CheckBox checkBox : checkBoxesMarcados){
                    String adicionado = checkBox.getText();
                    String lbRespostaAtual =  lbResposta.getText();
                    if(lbRespostaAtual.contains(rbSoja.getText()) && adicionado.equals(cbBacon.getText())){
                        lbResposta.setText("Vegano come bacon????");
                        break;
                    }
                    boolean ultimo = contador == checkBoxesMarcados.size() - 1;
                    if(ultimo){
                        lbRespostaAtual = lbRespostaAtual + " e " + adicionado;
                    } else {
                        lbRespostaAtual = lbRespostaAtual + ", " + adicionado;
                    }
                    lbResposta.setText(lbRespostaAtual);
                    contador++;
                }
            }


        }
    }
}
