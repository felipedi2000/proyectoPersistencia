package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Ability;
import uptc.frw.proyectofabrica.jpa.entity.Machine;
import uptc.frw.proyectofabrica.jpa.repository.MachineRepository;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> findAllMachines(){
        return machineRepository.findAll();
    };

    public Machine findMachineById(long id){
        return machineRepository.findById(id).orElse(null);
    }

    public Machine saveMachine(Machine machine){
        return machineRepository.save(machine);
    }

    public void deleteMachine(long id){
        machineRepository.deleteById(id);
    }

    public Machine updateMachine(Machine newMachine){
        Machine machine = findMachineById(newMachine.getId());
        machine.setSerialNumber(newMachine.getSerialNumber());
        machine.setBrand(newMachine.getBrand());
        machine.setModel(newMachine.getModel());
        machine.setDatePurchase(newMachine.getDatePurchase());
        return machineRepository.save(machine);
    }
}
