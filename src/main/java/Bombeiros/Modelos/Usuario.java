package Bombeiros.Modelos;

import javax.persistence.Column;
//import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	//Variaveis
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	  @Column (nullable =  false)
    private String nome;
	  @Column (nullable =  false)
    private String senha;
	  @Column (nullable =  false, unique = true)
    private String email;
	  @Column (nullable =  false, unique = true)
    private String documento;
	  @Column (nullable =  false)
    private String endereco;
	  @Column (nullable =  false)
    private int numero;
	  @Column (nullable =  false)
    private int cep;
	  @Column (nullable =  false)
    private String bairro;
    private String complemento;
    private String cidade;
    @Column (nullable =  false)
    private String telefone1;
    private String telefone2;
    @Column (nullable =  false)
    private String latitude;
    @Column(nullable =  false)
    private String longitude;
    
    public Usuario() {
    	
    }
    
  //Construtor sem objetos

	//Construtor com objetos
	


	//GETTERS E SETTERS
	
	
	public Integer getId() {
		return id;
	}
	
	public Usuario(int id, String nome, String senha, String email, String documento, String endereco, int numero, int cep,
		String bairro, String complemento, String cidade, String telefone1, String telefone2, String latitude,
		String longitude) {
	super();
	this.id = id;
	this.nome = nome;
	this.senha = senha;
	this.email = email;
	this.documento = documento;
	this.endereco = endereco;
	this.numero = numero;
	this.cep = cep;
	this.bairro = bairro;
	this.complemento = complemento;
	this.cidade = cidade;
	this.telefone1 = telefone1;
	this.telefone2 = telefone2;
	this.latitude = latitude;
	this.longitude = longitude;
}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
    
    
    
    
}
