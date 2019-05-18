package model;

import javafx.scene.control.DatePicker;

/**
 * @author HP
 *
 */
public class RegisterModel {
	
	private String login;
	private String pass;
	private String prenom;
    private String nom;	
    private String email;
	private String date;
	private String verif;
	
	public RegisterModel(){
	}
	
	
	public RegisterModel(String login,String pass,String verif,String prenom,String nom,String email, String date){
		this.login = login;
		this.pass=pass;
		this.verif = verif;
		this.prenom=prenom;
		this.nom = nom;
		this.email = email;
		this.date = date;
	}


	public String getVerif() {
		return verif;
	}


	public void setVerif(String verif) {
		this.verif = verif;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

    
   


}
