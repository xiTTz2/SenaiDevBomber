package Bombeiros.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Bombeiros.Modelos.Mangueiras;


@Repository
public interface MangueiraRepository extends CrudRepository<Mangueiras, Integer>{
	
	List<Mangueiras> findByTipoMang(String tipoMang);
	
	
}
