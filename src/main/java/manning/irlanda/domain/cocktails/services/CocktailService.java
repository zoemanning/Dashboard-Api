package manning.irlanda.domain.cocktails.services;

import manning.irlanda.domain.cocktails.exceptions.CocktailNotFoundException;
import manning.irlanda.domain.cocktails.models.Cocktail;

import java.util.Optional;

public interface CocktailService {
    Cocktail save(Cocktail cocktail);
    Cocktail requestCocktail(Long id)throws CocktailNotFoundException;
    Optional<Cocktail> requestCocktail();
}
