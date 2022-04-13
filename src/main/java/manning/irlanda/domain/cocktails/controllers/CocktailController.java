package manning.irlanda.domain.cocktails.controllers;

import manning.irlanda.domain.cocktails.exceptions.CocktailNotFoundException;
import manning.irlanda.domain.cocktails.models.Cocktail;
import manning.irlanda.domain.cocktails.services.CocktailService;
import manning.irlanda.domain.randomjokes.controllers.RandomJokeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("cocktails")
public class CocktailController {
    private static Logger logger = LoggerFactory.getLogger(RandomJokeController.class);
    private CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cocktail> requestCocktail(@PathVariable Long id) throws CocktailNotFoundException {
        Cocktail response = cocktailService.requestCocktail(id);
        logger.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Cocktail> requestCocktails(){
        Optional<Cocktail> response = cocktailService.requestCocktail();
        return new ResponseEntity(response.get(), HttpStatus.OK);
    }

}
