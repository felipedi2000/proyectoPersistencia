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

    @Autowired
    private OperationCrudService operationCrudService;

    public List<Ability> findAllAbilities() {
        operationCrudService.createOperationCrud("Se consultaron todos las habilidades");
        return abilityRepository.findAll();
    }

    public Ability findAbilityById(long id){
        operationCrudService.createOperationCrud("Se consulto una habilidad con id: " + id);
        return abilityRepository.findById(id).orElse(null);
    }

    public Ability saveAbility (Ability ability) {
        operationCrudService.createOperationCrud("Se guardo una habilidad con id: " + ability.getId());
        return abilityRepository.save(ability);
    }

    public void deleteAbility (long id) {
        operationCrudService.createOperationCrud("Se borro una habilidad con id: " + id);
        abilityRepository.deleteById(id);
    }

    public Ability updateAbility (Ability newAbility) {
        operationCrudService.createOperationCrud("Se actualizo una habilidad con id: " + newAbility.getId());
        Ability Ability = findAbilityById(newAbility.getId());
        Ability.setName(newAbility.getName());
        return abilityRepository.save(Ability);
    }

    public Ability saveAbilityWorker(long idAbility, long idWorker){
        Ability ability = findAbilityById(idAbility);
        Worker worker =  workerService.findWorkerById(idWorker);
        ability.getWorkers().add(worker);
        operationCrudService.createOperationCrud("Se guardo un habilidad  con id: " + idAbility +
                " para el trabajador con id: " + idWorker);
        return abilityRepository.save(ability);
    }
}
