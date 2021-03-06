package fr.hackgame;
import java.io.IOException;

import fr.hackgame.model.Os;
import fr.hackgame.model.User;
import fr.hackgame.view.Inscription_Controller;
import fr.hackgame.view.LoginController;
import fr.hackgame.view.OSController;
/*
 * Auteur : Justin Louazel / Samuel compagnon
 * Derniere modif : 31/03/2016
 * 
 * Classe principale, chargée de lancer les appli et les affichages 
 * Toute classe utilisée passe par ici. 
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Launcher extends Application {

	private Stage primaryStage ;
	private AnchorPane paneLogin ;
	private Os os ;
	
	/*
	 * methode appelé lors du lancement de l'appli
	 * Initialisation de la fenetre principale 
	 */
	@Override	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage ;
		this.primaryStage.setTitle("HackGame - Hack with fun !!");
		initLogin();
		primaryStage.show();
	}

	/*
	 * Methode pour lancer le login
	 */
	public void initLogin(){

	try {
	// Chargement du fichier XML
	FXMLLoader loadLog = new FXMLLoader();
	loadLog.setLocation(Launcher.class.getResource("view/Login.fxml"));
	paneLogin = (AnchorPane) loadLog.load();
	
	Image img = new Image(Launcher.class.getResourceAsStream("view/resources/wallp.png"),primaryStage.getWidth(),primaryStage.getHeight(),true,false);
	BackgroundImage myImg = new BackgroundImage(img,
			BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	paneLogin.setBackground(new Background(myImg));
	
	//Lancemement de laffichage
	Scene scene = new Scene(paneLogin);
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.setResizable(false);
		primaryStage.setFullScreenExitHint("test");
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		
		LoginController control = loadLog.getController();
		control.setLauncher(this);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	public void initOs(User user) {
		try {
			FXMLLoader loadOs = new FXMLLoader();
			loadOs.setLocation(Launcher.class.getResource("view/OperatingSystem.fxml"));
			AnchorPane paneOs = (AnchorPane)loadOs.load() ;

			OSController osControl = loadOs.getController();
			os = new Os (user);
			os.setController(osControl);
			os.getController().setLabelUsername(user.getUsername());
			os.getController().setLauncher(this);
			
			Scene osScene = new Scene(paneOs);
			primaryStage.setScene(osScene);
			primaryStage.setFullScreen(true);
			
		} catch (IOException e) {
		}
	}

	public void initInscription(){
	
		try{
		FXMLLoader loadInsc = new FXMLLoader();
		loadInsc.setLocation(LoginController.class.getResource("Inscription.fxml"));
		AnchorPane page = (AnchorPane)loadInsc.load();
		
		Stage inStage = new Stage();
		inStage.setTitle("Inscription");
		inStage.initModality(Modality.WINDOW_MODAL);
		inStage.initOwner(primaryStage);
		Scene scene= new Scene(page);
		inStage.setScene(scene);

		Inscription_Controller insControl = loadInsc.getController();
		insControl.setDialogStage(inStage);
		inStage.showAndWait();
		
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Stage getDialogStage(){
		return this.primaryStage ;
	}
}

