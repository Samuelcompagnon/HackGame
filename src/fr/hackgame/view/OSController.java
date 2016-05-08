package fr.hackgame.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.hackgame.Launcher;
import javafx.beans.property.StringProperty;
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
	@FXML
	private Label labelHeure ;
	private StringProperty hour ;
	
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
		DateFormat format = new SimpleDateFormat("HH:mm");
		labelHeure.setText(format.format(new Date()));
		this.menuBar.setWidth(launcher.getDialogStage().getWidth());
		this.userLabel.setText(username);
	}

	public StringProperty getHour() {
		return hour;
	}

	public void setHour(StringProperty hour) {
		this.hour = hour;
	}
	
}
