package manning.irlanda.domain.inspirationalquotes.services;

import manning.irlanda.domain.inspirationalquotes.models.InspirationalQuote;

import java.util.Optional;

public interface InspirationalQuoteService {
    Optional<InspirationalQuote> requestDataFromApi(String token);
}
