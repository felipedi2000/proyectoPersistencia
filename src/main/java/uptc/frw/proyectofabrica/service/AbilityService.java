package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Ability;
import uptc.frw.proyectofabrica.jpa.repository.AbilityRepository;

import java.util.List;

@Service
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;

    public List<Ability> findAllAbilities() {
        return abilityRepository.findAll();
    }

    public Ability findAbilityById(long id){
        return abilityRepository.findById(id).orElse(null);
    }

    public Ability saveAbility (Ability ability) {
        return abilityRepository.save(ability);
    }

    public void deleteAbility (long id) {
        abilityRepository.deleteById(id);
    }

    public Ability updateAbility (Ability newAbility) {
        Ability Ability = findAbilityById(newAbility.getId());
        Ability.setName(newAbility.getName());
        return abilityRepository.save(Ability);
    }
}
