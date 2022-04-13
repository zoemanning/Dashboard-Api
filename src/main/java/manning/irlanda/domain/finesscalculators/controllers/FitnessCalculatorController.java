package manning.irlanda.domain.finesscalculators.controllers;

import manning.irlanda.domain.cocktails.models.Cocktail;
import manning.irlanda.domain.cocktails.services.CocktailService;
import manning.irlanda.domain.finesscalculators.exceptions.FitnessInfoNotFoundException;
import manning.irlanda.domain.finesscalculators.models.Info;
import manning.irlanda.domain.finesscalculators.services.FitnessCalculatorService;
import manning.irlanda.domain.randomjokes.controllers.RandomJokeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("fitness")
public class FitnessCalculatorController {

    private static Logger logger = LoggerFactory.getLogger(RandomJokeController.class);
    private FitnessCalculatorService fitnessService;
    private Integer height;
    private Integer weight;

    public FitnessCalculatorController(FitnessCalculatorService fitnessService) {
        this.fitnessService = fitnessService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Info> requestCocktail(@PathVariable Long id) throws FitnessInfoNotFoundException {
        Info response = fitnessService.requestFitnessInfo(id);
        logger.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Info> requestFitnessInfo(){
        Info response = fitnessService.requestDataFromApi(weight,height);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
