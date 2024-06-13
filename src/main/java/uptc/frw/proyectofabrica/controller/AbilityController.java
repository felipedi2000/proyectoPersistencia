package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.Ability;
import uptc.frw.proyectofabrica.jpa.entity.Worker;
import uptc.frw.proyectofabrica.service.AbilityService;

import java.util.List;

@RestController
@RequestMapping("ability")
public class AbilityController {

    @Autowired
    private AbilityService abilityService;

    @GetMapping
    public List<Ability> getAllAbilities() {
        return abilityService.findAllAbilities();
    }

    @GetMapping("/{id}")
    public Ability getAbilityById(@PathVariable long id) {
        return abilityService.findAbilityById(id);
    }

    @PostMapping
    public Ability createAbility(@RequestBody Ability ability){
        return abilityService.saveAbility(ability);
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable long id) {
        abilityService.deleteAbility(id);
    }

    @PutMapping
    public Ability updateAbility(@RequestBody Ability ability) {
        return abilityService.updateAbility(ability);
    }

    @PostMapping("/{idAbility}/worker/{idWorker}")
    public Ability registerAbilityWorker(@PathVariable long idAbility, @PathVariable long idWorker){
        return abilityService.saveAbilityWorker(idAbility, idWorker);
    }
}
