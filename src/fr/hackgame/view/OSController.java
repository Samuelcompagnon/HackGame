package fr.hackgame.view;

import fr.hackgame.Launcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OSController {
	
	private Launcher launcher ;
	@FXML
	private Label userLabel;
	private String username = "";
	
	public OSController(){}
	
	@FXML
	void handleCancel(){
		launcher.getDialogStage().close();
	}

	@FXML
	private void initialize(){
		this.userLabel.setText(username);
	}

	public Launcher getLauncher() {
		return launcher;
	}



	public void setLauncher(Launcher launcher) {
		this.launcher = launcher;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
