package Bombeiros.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Bombeiros.Modelos.Usuario;
import Bombeiros.Repositorios.UsuarioRepository;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorioUser;
	

	@GetMapping
	public ResponseEntity<?> listByAllId() {//Procurar por todos os idskkkkk isso vai ter

		return ResponseEntity.ok(this.repositorioUser.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable("id") Integer id) {//Procurar pelo id
		Optional<Usuario> usuario = this.repositorioUser.findById(id);

		if (usuario.isPresent()) {
			return ResponseEntity.ok(this.repositorioUser.findById(id));
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {//Criar pelo slaoq
		Usuario usuarioCriado = this.repositorioUser.save(usuario);
		return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {//Deletar pelo id
		Optional<Usuario> usuario = this.repositorioUser.findById(id);

		try {
			this.repositorioUser.deleteById(id);
			return new ResponseEntity<>(usuario,HttpStatus.NO_CONTENT);
		} catch(Exception e){
				return new ResponseEntity<>("Usuario não encontrado.", HttpStatus.NOT_FOUND);
				
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,  @RequestBody Usuario usuario){//Fazer update pelo id, usando a classe bombeiro
		this.repositorioUser.save(usuario);
		
		if(usuario.getId() != null && id.equals(usuario.getId())) {
			
			return ResponseEntity.ok(this.repositorioUser.save(usuario));
			
		}else {
			return new ResponseEntity<>( "Parâmetros errados",HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
	
}
