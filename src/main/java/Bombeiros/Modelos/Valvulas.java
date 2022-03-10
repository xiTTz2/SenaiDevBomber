package Bombeiros.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Valvulas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	@Column(nullable = false)
	private String dataDeValidade;
	private String tipoVal;//Modelo da Valvula
	@ManyToOne
	private Usuario usuario;
	
	
	
	
	public Valvulas(int id, String dataDeValidade, String tipoVal, Usuario usuario) {
		super();
		this.id = id;
		this.dataDeValidade = dataDeValidade;
		this.tipoVal = tipoVal;
		this.usuario = usuario;
	}

	public Valvulas() {
		
	}
	
	//GETTERS E SETTERS
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataDeValidade() {
		return dataDeValidade;
	}
	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	public String getTipoVal() {
		return tipoVal;
	}
	public void setTipoVal(String tipoVal) {
		this.tipoVal = tipoVal;
	}
 	
	
	
	
}
