package fr.hackgame.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private String username ;
	private String password ;

	public User(String username, String password){
		this.setUsername(username) ;
		this.setPassword(password) ;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String toString(){
		return  "User : "+this.username+
				" Password : "+ this.password;
	}
}
