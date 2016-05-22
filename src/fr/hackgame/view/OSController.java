package fr.hackgame.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fr.hackgame.Launcher;
import fr.hackgame.model.Application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class OSController {
	
	private Launcher launcher ;
	@FXML
	private Label userLabel;
	private String username = "";
	@FXML
	private Rectangle menuBar ;
	
	@FXML
	private Label labelHeure ;
	
	public OSController(){
		
		}

	@FXML
	void handleCancel(){
		launcher.getDialogStage().close();
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
	
	public Label getLabelHour() {
		return labelHeure;
	}

	public void setLabelHour(String hour) {
		this.labelHeure.setText(hour);
	}
	public void setLabelUsername(String l){
		this.userLabel.setText(l );
	}
	public Label getUserLabel(){
		return this.userLabel;
	}
	public Rectangle getMenuBar(){
		return this.menuBar ;
	}
	public void setMenuBar(Rectangle r){
		this.menuBar = r ;
	}
}
