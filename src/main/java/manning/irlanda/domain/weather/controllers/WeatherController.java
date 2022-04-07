package manning.irlanda.domain.weather.controllers;

import lombok.extern.slf4j.Slf4j;
import manning.irlanda.domain.weather.models.WeatherApiResponse;
import manning.irlanda.domain.weather.services.WeatherService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("weather")
@Slf4j
@CrossOrigin("http://localhost:3000")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public  WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("")
    public ResponseEntity<WeatherApiResponse> requestWeather(@RequestParam(name = "lon", required = false) String lon,
                                                             @RequestParam(name= "lat", required = false) String lat){
        Optional<WeatherApiResponse> response = weatherService.requestDataFromApi(lat, lon);
        log.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
