package fr.hackgame.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.hackgame.Launcher;
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
	
	int i = 0 ;
	
	//Thread en fond qui permet MAJ 
	private Timeline timeline = new Timeline();
	
	public OSController(){
		//timeline = new Timeline(new KeyFrame(Duration.millis(1000), bt));
		timeline.setCycleCount(Animation.INDEFINITE);
		//tmps a passer pour la mise a jour
        Duration duration = Duration.millis(1000);
        //action a executer quand la KeyFrame est atteinte : ici MAJ
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

        		DateFormat format = new SimpleDateFormat("HH:mm");
        		labelHeure.setText(format.format(new Date()));
            }
        };
        
        //action de mettre a jour l'heure ou autre 
        KeyFrame keyFrame = new KeyFrame(duration, onFinished);
        timeline.getKeyFrames().add(keyFrame);
		timeline.play();
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
	//Mise a jour de l'affichage 
	public void updateScene(){
		this.menuBar.setWidth(launcher.getDialogStage().getWidth());
		this.userLabel.setText(username);
	}
	
	public Label getLabelHour() {
		return labelHeure;
	}

	public void setLabelHour(Label hour) {
		this.labelHeure = hour;
	}
	public void setLabelUsername(Label l){
		this.userLabel = l ;
	}
	public Label getUserLabel(){
		return this.userLabel;
	}
}
