package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.repository.AbilityRepository;

@Service
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;

}
