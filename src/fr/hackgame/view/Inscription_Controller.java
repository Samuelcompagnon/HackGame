package fr.hackgame.view;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.hackgame.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Inscription_Controller {

	//Recup des données password et user
	@FXML
	private TextField username ;
	@FXML
	private PasswordField password ;
	@FXML
	private PasswordField password_test ;
	//ComboBox pour la date de naisance
	@FXML
	private ComboBox<String> cJour = new ComboBox<String>();
	@FXML
	private ComboBox<String> cMois = new ComboBox<String>();
	@FXML
	private ComboBox<String> cAn  = new ComboBox<String>();
	
	private Stage dialogStage = new Stage();
	//Liste des valeurs de la ComboBox
	private ObservableList<String> valJour  = FXCollections.observableArrayList(
			"0","1","2","3","4","5","6","7","8","9",
			"10","11","12","13","14","15","16","17",
			"18","19","20","21","22","23","24","25",
			"26","27","28","29","30","31");

	private ObservableList<String> valMois = FXCollections.observableArrayList(
			"1","2","3","4","5","6","7","8","9","10","11","12");
	
	private ObjectOutputStream oos ;
	private ObjectInputStream buf_ois ;
	private File comptes = new File("comptes.user");
	/*
	 * Methode appelée auto par quand la classe est appellée
	 */
	private ArrayList <User>arrayUser = new ArrayList<User>();
	
	@FXML
	private Label inco ;
	@FXML
	private void initialize(){
		cJour.getItems().addAll(valJour);
		cMois.getItems().addAll(valMois);
		
		for(int i = 1900 ; i <2016 ; i++){
			cAn.getItems().add(String.valueOf(i));
		}
		
	}
	@FXML
	private void handleCancel(){
		this.dialogStage.close();
	}
	@FXML
	private void handleValider(){
		if(this.password.getText().equals(this.password_test.getText())){
			inco.setVisible(false);
			
			try {
				buf_ois = new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(this.comptes)));
				
				boolean hasObj = true ;
				
				while(hasObj){
					try{
						this.arrayUser.add((User)buf_ois.readObject());
					}catch(EOFException eofe){
						hasObj = false ;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buf_ois.close();
				
			} catch(FileNotFoundException a){
				a.printStackTrace();
			}catch(IOException i){
				i.printStackTrace();
			}
			try{
				oos = new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(
										new File("comptes.user"))));
			
			for(User u : arrayUser){
				oos.writeObject(u);
			}
			oos.writeObject(new User(username.getText(),password.getText()));
			
			oos.close();
			
			}catch(FileNotFoundException a){
				a.printStackTrace();
			}catch(IOException i){
				i.printStackTrace();
			}
			this.getDialogStage().close();
		}
		else{
			inco.setVisible(true); 
		}
	}
	public Stage getDialogStage() {
		return dialogStage;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	
}
