package fr.hackgame.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private TextField user_field ;// recuperer le contenu du champ utilisateur
	@FXML
	private TextField pass_field ; // pour recuperer le contenu du champ mot de passe
	
	private String username = "";
	private String password = "";
	
	private Stage dialogStage ; // interaction entre le Lancher et le Login
	/*
	 * Lors de l'appui sur le bouton valider
	 */
	@FXML
	private void handleValidate(){
		this.username = this.user_field.getText();
		this.password = this.pass_field.getText();
	}
	
	/*
	 * Lors de l'appui sur quitter
	 */
	@FXML
	private void handleCancel(){
		dialogStage.close();
	}
	public void setDialogStage(Stage stage){
		this.dialogStage = stage;
	}
	public String getPassword(){
		return this.password ;
	}
	public String getUsername(){
		return this.username ;
	}
}
