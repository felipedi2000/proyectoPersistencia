package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Ability;
import uptc.frw.proyectofabrica.jpa.entity.Machine;
import uptc.frw.proyectofabrica.jpa.entity.Worker;
import uptc.frw.proyectofabrica.jpa.repository.AbilityRepository;

import java.util.List;

@Service
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;

    @Autowired
    private WorkerService workerService;

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

    public Ability saveAbilityWorker(long idAbility, long idWorker){
        Ability ability = findAbilityById(idAbility);
        Worker worker =  workerService.findWorkerById(idWorker);
        ability.getWorkers().add(worker);
        return abilityRepository.save(ability);
    }
}
