package manning.irlanda.domain.inspirationalquotes.controllers;

import lombok.extern.slf4j.Slf4j;
import manning.irlanda.domain.inspirationalquotes.models.InspirationalQuote;
import manning.irlanda.domain.inspirationalquotes.services.InspirationalQuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("quotes")
@CrossOrigin("http://localhost:3000")
@Slf4j
public class InspirationalQuoteController {
    private static Logger logger = LoggerFactory.getLogger(InspirationalQuoteController.class);
    private InspirationalQuoteService quoteService;

    @Autowired
    public InspirationalQuoteController(InspirationalQuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping("")
    public ResponseEntity<InspirationalQuote> requestQuote(@RequestParam(name = "token", required = false)String token){
        Optional<InspirationalQuote> quote = quoteService.requestDataFromApi(token);
        return new ResponseEntity(quote, HttpStatus.OK);
    }
}
