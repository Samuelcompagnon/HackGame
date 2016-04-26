package fr.hackgame.view;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import fr.hackgame.Launcher;
import fr.hackgame.model.User;
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
	
	private ArrayList <User> users = new ArrayList<User>();//liste des comptes enregistrés
	
	private ObjectInputStream ois ;
	
	private boolean passwordOk = false ;
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
		
		loadUserAccount(); // load comptes existants
		for(User u : users){
			
			if(this.user_field.getText().equals(u.getUsername())){
				if(pass_field.getText().equals(u.getPassword())){
					passwordOk = true ;
					System.out.println("Bonjour " + u.getUsername());
					launcher.getDialogStage().close();
				}
			}
		}
		if(!passwordOk){
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
	
	/*
	 * Chargement des comptes enregistrés. 
	 */
	private int loadUserAccount(){
	 try {
		ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("comptes.user"))));

		
		
			boolean hasObj = true ;
			
			while(hasObj){
				try{
					this.users.add((User)ois.readObject());
				}catch(EOFException eofe){
					hasObj = false ;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		ois.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
		return 0;
		
	}
}
