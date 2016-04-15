package fr.hackgame.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Inscription_Controller {

	
	//ComboBox pour la date de naisance
	@FXML
	private ComboBox<String> cJour = new ComboBox<String>();
	@FXML
	private ComboBox<String> cMois = new ComboBox<String>();
	@FXML
	private ComboBox<String> cAn  = new ComboBox<String>();
	
	private Stage dialogStage = new Stage();
	//Liste des valeurs de la ComboBox
	private ObservableList<String> valJour  = FXCollections.observableArrayList(
			"0","1","2","3","4","5","6","7","8","9",
			"10","11","12","13","14","15","16","17",
			"18","19","20","21","22","23","24","25",
			"26","27","28","29","30","31");

	private ObservableList<String> valMois = FXCollections.observableArrayList(
			"1","2","3","4","5","6","7","8","9","10","11","12");
	

	
	/*
	 * Methode appelée auto par quand la classe est appellée
	 */
	
	@FXML
	private void initialize(){
		cJour.getItems().addAll(valJour);
		cMois.getItems().addAll(valMois);
		
		for(int i = 1900 ; i <2016 ; i++){
			cAn.getItems().add(String.valueOf(i));
		}
	}
	@FXML
	private void handleCancel(){
		this.dialogStage.close();
	}
	@FXML
	private void handleValider(){
		
	}
	public Stage getDialogStage() {
		return dialogStage;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	
}
