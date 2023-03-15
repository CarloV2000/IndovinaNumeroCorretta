package tdp.polito.it.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tdp.polito.it.IndovinaNumero.Model.Gioco;

public class FXMLController {
	//qui: gestione interfaccia grafica

	private Gioco model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNuovaPartita;

    @FXML
    private Button buttonProva;

    @FXML
    private TextArea txtCom;

    @FXML
    private TextField txtNMax;

    @FXML
    private TextField txtProva;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private TextField txtTMax;

    @FXML
    private TextField txtTentativi;

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	
    	model.iniziaGioco();
    	
    	//aggiorno i campi dell'interfaccia grafica
    	this.txtTentativi.setText(""+(this.model.getTMax()-this.model.getNTentativiFatti()));
    	this.txtRisultato.clear();
    	this.txtProva.clear();
    	this.txtCom.clear();
    	this.txtNMax.setText(Integer.toString(model.getNMax()));
    	this.txtTMax.setText(Integer.toString(model.getTMax()));
		this.buttonProva.setDisable(false);
    }

    @FXML
    void doProva(ActionEvent event) {
    	//leggere numero inserito e fare controlli sul numero
    	int guess;
    	try {
    		guess = Integer.parseInt(txtProva.getText());
    	}catch(NumberFormatException e){
    		this.txtCom.setText("Inserire un numero!");
    		return;
    	}
    	
    	//chiamare modello per effettuare tentativo
    	int risultato = this.model.faiTentativo(guess);
    	
    	//aggiornamento interfaccia grafica
       	this.txtTentativi.setText(Integer.toString(this.model.getTMax()-this.model.getNTentativiFatti()));
    	//giocare
    	if(risultato == 0) {
    		this.txtRisultato.appendText("Hai vinto, il numero segreto era : "+this.model.getNumeroSegreto());
    		this.buttonProva.setDisable(true);
    		return;
    	}
    	if(risultato == 1) {
    		this.txtRisultato.appendText("Hai perso");
    		this.buttonProva.setDisable(true);
    		return;
    	}
    	if(risultato == 2) {
    		this.txtRisultato.appendText("Numero troppo alto \n");
    	}
    	if(risultato == 3) {
    		this.txtRisultato.appendText("Numero troppo basso \n");
    	}
    }

    @FXML
    void initialize() {
        assert buttonNuovaPartita != null : "fx:id=\"buttonNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonProva != null : "fx:id=\"buttonProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNMax != null : "fx:id=\"txtNMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTMax != null : "fx:id=\"txtTMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Gioco model) {
    	this.model = model;
    }

}
