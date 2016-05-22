package fr.hackgame.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fr.hackgame.view.OSController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Os {
	private OSController controller ;
	
	private ArrayList<Application> applis = new ArrayList<Application>();
	int i = 0 ;
	
	//Thread en fond qui permet MAJ 
	private Timeline timeline = new Timeline();
	
	public Os(){
		
	}
	public Os(User user){
		//timeline = new Timeline(new KeyFrame(Duration.millis(1000), bt));
				timeline.setCycleCount(Animation.INDEFINITE);
				//tmps a passer pour la mise a jour
		        Duration duration = Duration.millis(1000);
		        //action a executer quand la KeyFrame est atteinte : ici MAJ
		        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent t) {

		        		DateFormat format = new SimpleDateFormat("HH:mm");
		        		controller.setLabelHour(format.format(new Date()));
		        		getController().getMenuBar().setWidth(getController().getLauncher().getDialogStage().getWidth());;
		            }
		        };
		        //action de mettre a jour l'heure ou autre 
		        KeyFrame keyFrame = new KeyFrame(duration, onFinished);
		        timeline.getKeyFrames().add(keyFrame);
				timeline.play();
	}

	public OSController getController() {
		return controller;
	}

	public void setController(OSController controller) {
		this.controller = controller;
	}
	
}
