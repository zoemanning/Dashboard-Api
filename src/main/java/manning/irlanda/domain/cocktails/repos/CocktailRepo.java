package manning.irlanda.domain.cocktails.repos;

import manning.irlanda.domain.cocktails.models.Cocktail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CocktailRepo  {
    Optional<Cocktail> findById(Long id);
}
