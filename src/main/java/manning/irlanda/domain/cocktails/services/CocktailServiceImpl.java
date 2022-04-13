package manning.irlanda.domain.cocktails.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import manning.irlanda.domain.cocktails.exceptions.CocktailNotFoundException;
import manning.irlanda.domain.cocktails.models.Cocktail;
import manning.irlanda.domain.cocktails.repos.CocktailRepo;
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
@Slf4j
public class CocktailServiceImpl implements CocktailService {
    private static Logger logger = LoggerFactory.getLogger(CocktailServiceImpl.class);
    private RestTemplate template;
    private CocktailRepo cocktailRepo;

    @Value("${cocktail.api.host}")
    private String host;

    @Value("${cocktail.api.key}")
    private String key;

    @Autowired
    public CocktailServiceImpl() {
        this.template = new RestTemplate();
        this.cocktailRepo = cocktailRepo;
    }

    @Override
    public Cocktail save(Cocktail cocktail) {
        return null;
    }

    @Override
    public Cocktail requestCocktail(Long id) throws CocktailNotFoundException {
        Optional<Cocktail> cocktailOptional = cocktailRepo.findById(id);
        if(cocktailOptional.isEmpty()){
            throw new CocktailNotFoundException("Cocktail not in repertory");
        }
        return cocktailOptional.get();
    }

    @Override
    public Optional<Cocktail> requestCocktail() {
        return requestCocktailFromExternal();
        }


    private Optional<Cocktail> requestCocktailFromExternal() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-RapidAPI-Host", host);
        httpHeaders.set("X-RapidAPI-Key", key);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String uri = String.format("https://cocktails3.p.rapidapi.com/random");
        ResponseEntity<JsonNode> response = template.exchange(uri, HttpMethod.GET, entity, JsonNode.class);
        JsonNode map = response.getBody();
        JsonNode drinkBody = map.get("body");
        ObjectMapper mapper = new ObjectMapper();
        Cocktail[] drinks = mapper.convertValue(drinkBody, Cocktail[].class);
        return Optional.of(drinks[0]);
    }
}


