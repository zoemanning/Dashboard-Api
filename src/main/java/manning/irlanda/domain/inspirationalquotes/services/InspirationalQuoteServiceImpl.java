package manning.irlanda.domain.inspirationalquotes.services;


import lombok.extern.slf4j.Slf4j;
import manning.irlanda.domain.inspirationalquotes.models.InspirationalQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Slf4j
public class InspirationalQuoteServiceImpl implements InspirationalQuoteService{

    private Logger logger = LoggerFactory.getLogger(InspirationalQuote.class);
    private RestTemplate restTemplate;


    @Value("${quote.api.host}")
    private String host;
    @Value("{quote.api.key}")
    private String key;

    public InspirationalQuoteServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct
    public void setup(){
        requestDataFromApi("ipworld.info");
    }

    @Override
    public Optional<InspirationalQuote> requestDataFromApi(String token) {
        try {
            String uri = "https://quotes-inspirational-quotes-motivational-quotes.p.rapidapi.com/quote?token=%s";
            String requestUrl = String.format(uri,token);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-RapidAPI-Host", host);
            httpHeaders.set("X-RapidAPI-Key", key);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<InspirationalQuote> response = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, InspirationalQuote.class);
            InspirationalQuote quote = response.getBody();
            logger.info(quote.toString());
            return Optional.of(quote);
        } catch (HttpClientErrorException ex) {
            return Optional.empty();
        }
    }
}
