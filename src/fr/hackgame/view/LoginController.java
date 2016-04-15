package fr.hackgame.view;

import fr.hackgame.Launcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/*
 * Il faut set le launcher 
 */
public class LoginController {
	
	@FXML
	private TextField user_field ;// recuperer le contenu du champ utilisateur
	@FXML
	private TextField pass_field ; // pour recuperer le contenu du champ mot de passe
	@FXML
	private Label label_inco ; // label mdp ou user incorect
	
	private String username = "";
	private String password = "";

	
	private Launcher launcher ;// interaction entre le Lancher et le Login
	
	
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
		launcher.getDialogStage().close();
	}
	@FXML
	private void handleLogin(){
		if(this.user_field.getText().toLowerCase().equals("root")){
			if(pass_field.getText().equals("root")){
				System.out.println("Bonjour");
				launcher.getDialogStage().close();
			}
			else{
				label_inco.setVisible(true);
			}
		}
		else{
			label_inco.setVisible(true);
		}
	}
	@FXML
	private void handleHyperLink(){
		launcher.initInscription();
	}
	public String getPassword(){
		return this.password ;
	}
	public String getUsername(){
		return this.username ;
	}

	public Launcher getLauncher() {
		return launcher;
	}

	public void setLauncher(Launcher launcher) {
		this.launcher = launcher;
	}
}
