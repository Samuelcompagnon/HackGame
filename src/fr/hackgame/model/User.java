package fr.hackgame.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private String username ;
	private String password ;
	private int day ;
	private int month ;
	private int year ;
	public User(String username, String password){
		this.setUsername(username) ;
		this.setPassword(password) ;
	}
	public User(String user, String password, int day, int month, int year){

		this.setUsername(username) ;
		this.setPassword(password) ;
		this.setYear(year) ;
		this.setDay(day) ;
		this.setMonth(month) ;
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
