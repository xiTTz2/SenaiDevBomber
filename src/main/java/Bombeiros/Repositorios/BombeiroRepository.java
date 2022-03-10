package Bombeiros.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Bombeiros.Modelos.Bombeiro;


@Repository
public interface BombeiroRepository extends CrudRepository<Bombeiro, Integer>{
	

	public Bombeiro findByMatricula(@Param("matricula")String matricula);
	//List<Bombeiro> findByMatricula1(String matricula);
	List<Bombeiro> findByNomeDeGuerra(String nomeDeGuerra);
	List<Bombeiro> findByNome(String nome);
	
}
