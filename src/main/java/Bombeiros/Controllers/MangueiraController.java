package Bombeiros.Controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Bombeiros.Modelos.Mangueiras;
import Bombeiros.Repositorios.MangueiraRepository;

@RestController
@RequestMapping("mangueiras")
@CrossOrigin
public class MangueiraController {

	@Autowired
	private MangueiraRepository repositorioMang;
	
	
	@GetMapping
	public ResponseEntity<?> listByAllId() {

		return ResponseEntity.ok(this.repositorioMang.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable("id") Integer id){
		Optional<Mangueiras> mangueiras = this.repositorioMang.findById(id);
		
		if(mangueiras.isPresent()) {
			return ResponseEntity.ok(this.repositorioMang.findById(id));
			
		}else {

			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		}
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Mangueiras mangueira){
		Mangueiras mangueiraCriada = this.repositorioMang.save(mangueira);
		
		return new ResponseEntity<>(mangueiraCriada, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		Optional<Mangueiras> mangueira = this.repositorioMang.findById(id);

		try {
			this.repositorioMang.deleteById(id);
			return new ResponseEntity<>(mangueira, HttpStatus.NO_CONTENT);
		} catch(Exception e){
	
			return new ResponseEntity<>("Mangueira não encontrada.", HttpStatus.NOT_FOUND);
				
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,  @RequestBody Mangueiras mangueira){//Fazer update pelo id, usando a classe bombeiro
		this.repositorioMang.save(mangueira);
		
		if(mangueira.getId() != null && id.equals(mangueira.getId())) {
			
			return ResponseEntity.ok(this.repositorioMang.save(mangueira));
			
		}else {
			return new ResponseEntity<>( "Parâmetros errados",HttpStatus.BAD_REQUEST);
		}
		
		
	}


}
