package fr.hackgame;
import java.io.IOException;

import fr.hackgame.view.Inscription_Controller;
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

public class Launcher<InscriptionController> extends Application {

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
		primaryStage.show();
	
	LoginController control = loadLog.getController();
	control.setLauncher(this);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	public void initInscription(){
	
		try{
		FXMLLoader loadInsc = new FXMLLoader();
		loadInsc.setLocation(LoginController.class.getResource("Inscription.fxml"));
		AnchorPane page = (AnchorPane)loadInsc.load();
		
		Stage inStage = new Stage();
		inStage.setTitle("Inscrivez-vous � HackGame !!");
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
