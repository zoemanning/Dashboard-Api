package manning.irlanda.domain.finesscalculators.services;

import manning.irlanda.domain.finesscalculators.exceptions.FitnessInfoNotFoundException;
import manning.irlanda.domain.finesscalculators.models.Info;

import java.util.Optional;

public interface FitnessCalculatorService {
    Info save(Info info);
    Info requestFitnessInfo(Long id) throws FitnessInfoNotFoundException;
    Info requestDataFromApi(Integer weight, Integer height);
}
