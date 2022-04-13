package manning.irlanda.domain.finesscalculators.repos;

import manning.irlanda.domain.finesscalculators.models.Info;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FitnessCalculatorRepo  {
    Optional<Info> findById(Long id);
}
