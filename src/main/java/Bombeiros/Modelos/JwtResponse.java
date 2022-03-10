package Bombeiros.Modelos;

public class JwtResponse {

	
	private final String jwttoken;
	
	
	public JwtResponse(String jwttoken) {
			this.jwttoken = jwttoken;
	}
	
	//GETTER
	public String getToken() {
		return this.jwttoken;
	}
	
	
}
