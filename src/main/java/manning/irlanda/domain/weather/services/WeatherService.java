package manning.irlanda.domain.weather.services;

import manning.irlanda.domain.weather.models.WeatherApiResponse;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherApiResponse> requestDataFromApi(String lat, String lon);
}
