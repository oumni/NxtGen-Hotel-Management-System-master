package model;

public class LoginUserModel {
	private String login;
	private String motdepasse;
	
	public LoginUserModel(){
	}
	
	
	public LoginUserModel(String login,String motdepasse){
		this.login = login;
		this.motdepasse = motdepasse;
	
	}

    
    public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


    public String getMotDePasse() {
		return motdepasse;
	}


	public void setMotDePasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

}
