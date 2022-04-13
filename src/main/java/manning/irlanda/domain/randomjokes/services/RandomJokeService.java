package manning.irlanda.domain.randomjokes.services;

import manning.irlanda.domain.randomjokes.exceptions.JokeNotFoundException;
import manning.irlanda.domain.randomjokes.models.RandomJoke;

//dependency inversion
public interface RandomJokeService {
    RandomJoke save(RandomJoke joke);
    RandomJoke requestJoke (Long id)throws JokeNotFoundException;
    RandomJoke requestJoke();
}
