package manning.irlanda.domain.randomjokes.services;

import lombok.extern.slf4j.Slf4j;

import manning.irlanda.domain.randomjokes.exceptions.JokeNotFoundException;
import manning.irlanda.domain.randomjokes.models.RandomJoke;
import manning.irlanda.domain.randomjokes.repos.RandomJokeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
public class RandomJokeServiceImpl implements RandomJokeService {
    private Logger logger = LoggerFactory.getLogger(RandomJokeServiceImpl.class);
    private RestTemplate restTemplate;
    private RandomJokeRepo jokeRepo;


    @Value("${jokes.api.host}")
    private String host;

    @Value("${jokes.api.key}")
    private String key;

    @Autowired
    public RandomJokeServiceImpl(RandomJokeRepo jokeRepo) {
        this.restTemplate = new RestTemplate();
        this.jokeRepo = jokeRepo;
    }
//
//    @PostConstruct
//    public void setup(){
//        requestJoke();
//    }

    @Override
    public RandomJoke save(RandomJoke joke) {
        return jokeRepo.save(joke);
    }

    @Override
    public RandomJoke requestJoke(Long id) throws JokeNotFoundException {
        Optional<RandomJoke> jokeOptional = jokeRepo.findById(id);
        if(jokeOptional.isEmpty()){
            throw new JokeNotFoundException("Joke Not Found");
        }
        return jokeOptional.get();
    }

    @Override
    public RandomJoke requestJoke() {
        return jokeRepo.save(requestJokeFromExternal());
    }

    private RandomJoke requestJokeFromExternal() {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-RapidAPI-Host", host);
            httpHeaders.set("X-RapidAPI-Key", key);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            String uri = String.format("https://joke-generator.p.rapidapi.com/generate-joke");
            ResponseEntity<RandomJoke> response = restTemplate.exchange(uri, HttpMethod.GET, entity, RandomJoke.class);
            RandomJoke currentJoke = response.getBody();
            logger.info(currentJoke.toString());
            return currentJoke;
    }
}
