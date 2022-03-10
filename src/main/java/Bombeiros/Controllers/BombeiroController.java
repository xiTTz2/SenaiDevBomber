package Bombeiros.Controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import Bombeiros.Modelos.Bombeiro;
import Bombeiros.Repositorios.BombeiroRepository;

@RestController
@RequestMapping("bombeiro")
@CrossOrigin
public class BombeiroController {

	@Autowired
	private BombeiroRepository repositorio;
	
	
	
	 

	@GetMapping
	public ResponseEntity<?> listByAllId() {//Procurar por todos os ids

		return ResponseEntity.ok(this.repositorio.findAll());
	}
	


	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable("id") Integer id) {//Procurar pelo id
		Optional<Bombeiro> bombeiro = this.repositorio.findById(id);
		
		if (bombeiro.isPresent()) {
			return ResponseEntity.ok(this.repositorio.findById(id));
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Bombeiro bombeiro) {//Criar pelo slaoq
		
		Bombeiro bombeiroCriado = this.repositorio.save(bombeiro);
		
		String passwordCrypt = BCrypt.hashpw(bombeiro.getSenha(), BCrypt.gensalt(12));
		bombeiro.setSenha(passwordCrypt);
		
		return new ResponseEntity<>(bombeiroCriado, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {//Deletar pelo id
		Optional<Bombeiro> bombeiro = this.repositorio.findById(id);

		try {
			this.repositorio.deleteById(id);
			return new ResponseEntity<>(bombeiro,HttpStatus.NO_CONTENT);
		} catch(Exception e){
				return new ResponseEntity<>("Bombeiro não encontrado.", HttpStatus.NOT_FOUND);
				
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,  @RequestBody Bombeiro bombeiro){//Fazer update pelo id, usando a classe bombeiro
		this.repositorio.save(bombeiro);
		
		if(bombeiro.getId() != null && id.equals(bombeiro.getId())) {
			
			String passwordCrypt = BCrypt.hashpw(bombeiro.getSenha(), BCrypt.gensalt(12));
			bombeiro.setSenha(passwordCrypt);
			
			return ResponseEntity.ok(this.repositorio.save(bombeiro));
			
		}else {
			return new ResponseEntity<>( "Parâmetros errados",HttpStatus.BAD_REQUEST);
		}
		
		
	}
	

}
