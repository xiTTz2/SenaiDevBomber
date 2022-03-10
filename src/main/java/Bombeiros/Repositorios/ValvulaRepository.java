package Bombeiros.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Bombeiros.Modelos.Valvulas;

@Repository
public interface ValvulaRepository extends CrudRepository<Valvulas, Integer>{

	List<Valvulas> findByTipoVal(String tipoVal);
	
}
