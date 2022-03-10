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

import Bombeiros.Modelos.Valvulas;
import Bombeiros.Repositorios.ValvulaRepository;

@RestController
@RequestMapping("valvulas")
@CrossOrigin
public class ValvulasController {
	@Autowired
	private ValvulaRepository repositorioVal;
	
	
	@GetMapping
	public ResponseEntity<?> listByAllId() {//Procurar por todos os idskkkkk isso vai ter

		return ResponseEntity.ok(this.repositorioVal.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable("id") Integer id){
		Optional<Valvulas> valvulas = this.repositorioVal.findById(id);
		
		if(valvulas.isPresent()) {
			return ResponseEntity.ok(this.repositorioVal.findById(id));
			
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Valvulas valvula){
		Valvulas valvulaCriada = this.repositorioVal.save(valvula);
		
		return new ResponseEntity<>(valvulaCriada, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		Optional<Valvulas> valvulas = this.repositorioVal.findById(id);

		try {
			this.repositorioVal.deleteById(id);
			return new ResponseEntity<>(valvulas, HttpStatus.NO_CONTENT);
		} catch(Exception e){
	
			return new ResponseEntity<>("Valvulas não encontrada.", HttpStatus.NOT_FOUND);
				
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,  @RequestBody Valvulas valvula){//Fazer update pelo id, usando a classe bombeiro
		this.repositorioVal.save(valvula);
		
		if(valvula.getId() != null && id.equals(valvula.getId())) {
			
			return ResponseEntity.ok(this.repositorioVal.save(valvula));
			
		}else {
			return new ResponseEntity<>( "Parâmetros errados",HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
}
