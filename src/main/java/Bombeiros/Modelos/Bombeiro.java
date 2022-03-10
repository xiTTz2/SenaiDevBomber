package Bombeiros.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bombeiro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	@Column (nullable =false)
    private String nome;
    @Column (nullable =false, unique =true)
	private String matricula;
    @Column (nullable =false )
	private String senha;
	private String perfilAcesso;
	 @Column (unique =true)
	private String email;
	private String nomeDeGuerra;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfilAcesso() {
		return perfilAcesso;
	}
	public void setPerfilAcesso(String perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeDeGuerra() {
		return nomeDeGuerra;
	}
	public void setNomeDeGuerra(String nomeDeGuerra) {
		this.nomeDeGuerra = nomeDeGuerra;
	}
	public Bombeiro(Integer id, String nome, String matricula, String senha, String perfilAcesso, String email,
			String nomeDeGuerra) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.perfilAcesso = perfilAcesso;
		this.email = email;
		this.nomeDeGuerra = nomeDeGuerra;
	}
	
	public Bombeiro() {
		
	}
	}
