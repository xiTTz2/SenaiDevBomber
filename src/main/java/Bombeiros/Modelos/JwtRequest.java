package Bombeiros.Modelos;

public class JwtRequest {

	private String matricula;
	private String password;
	
	
	public JwtRequest() {}
	
	public JwtRequest(String matricula, String password) {
		super();
		this.matricula = matricula;
		this.password = password;
	}
	
	//GETTERS E SETTERS
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String username) {
		this.matricula = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
