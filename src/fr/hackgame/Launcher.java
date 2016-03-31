package fr.hackgame;
import java.io.IOException;

import fr.hackgame.view.LoginController;
/*
 * Auteur : Justin Louazel
 * Derniere modif : 31/03/2016
 * 
 * Classe principale, chargée de lancer les appli et les affichages 
 * Toute classe utilisée passe par ici. 
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Launcher extends Application {

	private Stage primaryStage ;
	private AnchorPane paneLogin ;
	
	/*
	 * methode appelé lors du lancement de l'appli
	 * Initialisation de la fenetre principale 
	 */
	@Override	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage ;
		this.primaryStage.setTitle("HackGame - Hack with fun !!");
		initLogin();
	}

	/*
	 * Methode pour lancer le login
	 */
	public void initLogin(){
		
	try {
	// Chargement du fichier XML
	FXMLLoader load_log = new FXMLLoader();
	load_log.setLocation(Launcher.class.getResource("view/Login.fxml"));
	paneLogin = (AnchorPane) load_log.load();
	
	//Lancemement de laffichage
	Scene scene = new Scene(paneLogin);
	primaryStage.setScene(scene);
	primaryStage.show();
	
	LoginController control = load_log.getController();
	control.setDialogStage(primaryStage);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
