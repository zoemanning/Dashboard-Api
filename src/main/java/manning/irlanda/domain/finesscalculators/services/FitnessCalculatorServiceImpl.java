package manning.irlanda.domain.finesscalculators.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import manning.irlanda.domain.finesscalculators.exceptions.FitnessInfoNotFoundException;
import manning.irlanda.domain.finesscalculators.models.Info;
import manning.irlanda.domain.finesscalculators.repos.FitnessCalculatorRepo;
import manning.irlanda.domain.randomjokes.services.RandomJokeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FitnessCalculatorServiceImpl implements FitnessCalculatorService{
    private Logger logger = LoggerFactory.getLogger(RandomJokeServiceImpl.class);
    private RestTemplate restTemplate;
    private FitnessCalculatorRepo fitnessRepo;

    @Value("${fitness.api.host}")
    private String host;

    @Value("${fitness.api.key}")
    private String key;


    public FitnessCalculatorServiceImpl() {
        this.restTemplate = new RestTemplate();
        //this.fitnessRepo = fitnessRepo;
    }

//    @PostConstruct
//    public void setup(){
//        requestDataFromApi(60,159);
//    }

    @Override
    public Info save(Info info) {
        return null;
    }

    @Override
    public Info requestFitnessInfo(Long id) throws FitnessInfoNotFoundException {
        Optional<Info> infoOptional = fitnessRepo.findById(id);
        if(infoOptional.isEmpty()){
            throw new FitnessInfoNotFoundException("Fitness Info Not Available");
        }
        return infoOptional.get();
    }

    @Override
    public Info requestDataFromApi(Integer weight, Integer height) {
        return requestFitnessDatFromApi(60,159);
    }

    private Info requestFitnessDatFromApi(Integer weight, Integer height) {
        String url = "https://mega-fitness-calculator1.p.rapidapi.com/bmi?weight=%d&height=%d";
        String requestUrl = String.format(url, weight, height);
        /** Setting our headers **/
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "mega-fitness-calculator1.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", key);
        /** combine the two for request **/
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity,JsonNode.class);
        JsonNode map = response.getBody();
        JsonNode infoNode = map.get("info");
        ObjectMapper mapper = new ObjectMapper();
        Info info = mapper.convertValue(infoNode, Info.class);
        logger.info(info.toString());
        return info;
    }
}
