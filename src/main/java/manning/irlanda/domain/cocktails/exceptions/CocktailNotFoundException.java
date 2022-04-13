package manning.irlanda.domain.cocktails.exceptions;

import manning.irlanda.domain.cocktails.models.Cocktail;
import org.springframework.data.repository.CrudRepository;

public class CocktailNotFoundException extends Exception{
    public CocktailNotFoundException(String msg){
        super(msg);
    }
}
