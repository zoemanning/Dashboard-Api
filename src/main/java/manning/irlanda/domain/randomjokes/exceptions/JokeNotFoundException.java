package manning.irlanda.domain.randomjokes.exceptions;

public class JokeNotFoundException extends Exception{
    public JokeNotFoundException(String msg){
        super(msg);
    }
}
