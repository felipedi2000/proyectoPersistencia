package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.Machine;
import uptc.frw.proyectofabrica.service.MachineService;

import java.util.List;

@RestController
@RequestMapping("machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping
    public List<Machine> getMachines() {
        return machineService.findAllMachines();
    }

    @GetMapping("/{id}")
    public Machine getMachineById(@PathVariable long id) {
        return machineService.findMachineById(id);
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return machineService.saveMachine(machine);
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable long id) {
        machineService.deleteMachine(id);
    }

    @PutMapping
    public Machine updateMachine(@RequestBody Machine machine) {
        return machineService.updateMachine(machine);
    }
}
