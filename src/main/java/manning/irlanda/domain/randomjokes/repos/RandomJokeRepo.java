package manning.irlanda.domain.randomjokes.repos;

import manning.irlanda.domain.randomjokes.models.RandomJoke;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RandomJokeRepo extends CrudRepository<RandomJoke,Long> {
    Optional<RandomJoke> findById(Long id);
}
