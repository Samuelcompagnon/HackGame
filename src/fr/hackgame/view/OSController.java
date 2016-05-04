package fr.hackgame.view;

import fr.hackgame.Launcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class OSController {
	
	private Launcher launcher ;
	@FXML
	private Label userLabel;
	private String username = "";
	@FXML
	private Rectangle menuBar ;
	
	public OSController(){}
	
	@FXML
	void handleCancel(){
		launcher.getDialogStage().close();
	}

	@FXML
	private void initialize(){
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
	public void uptadeScene(){
		this.menuBar.setWidth(launcher.getDialogStage().getWidth());
		this.userLabel.setText(username);
	}
	
}
