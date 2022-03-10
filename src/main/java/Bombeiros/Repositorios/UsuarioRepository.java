package Bombeiros.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Bombeiros.Modelos.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	List<Usuario> findByCidade(String cidade);
	List<Usuario> findByCep(int cep);
	
	
}
