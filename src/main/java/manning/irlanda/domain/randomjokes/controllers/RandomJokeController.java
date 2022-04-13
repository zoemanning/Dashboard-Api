package manning.irlanda.domain.randomjokes.controllers;

import manning.irlanda.domain.randomjokes.exceptions.JokeNotFoundException;
import manning.irlanda.domain.randomjokes.models.RandomJoke;
import manning.irlanda.domain.randomjokes.services.RandomJokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//allows the class to handle the requests made by the client…Public interface for our API
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("jokes")
public class RandomJokeController {
    private static Logger logger = LoggerFactory.getLogger(RandomJokeController.class);
    private RandomJokeService jokeService;

    public RandomJokeController(RandomJokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RandomJoke> requestJoke(@PathVariable Long id) throws JokeNotFoundException {
        RandomJoke response = jokeService.requestJoke(id);
        logger.info(response.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<RandomJoke> requestJokes(){
        RandomJoke response = jokeService.requestJoke();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
