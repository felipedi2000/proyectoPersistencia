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

    @Autowired
    private OperationCrudService operationCrudService;

    public List<Machine> findAllMachines(){
        operationCrudService.createOperationCrud("Se consultaron todos las maquinas");
        return machineRepository.findAll();
    };

    public Machine findMachineById(long id){
        operationCrudService.createOperationCrud("Se consulto una maquina con id: " + id);
        return machineRepository.findById(id).orElse(null);
    }

    public Machine saveMachine(Machine machine){
        operationCrudService.createOperationCrud("Se guardo una maquina con id: " + machine.getId());
        return machineRepository.save(machine);
    }

    public void deleteMachine(long id){
        operationCrudService.createOperationCrud("Se borro una maquina con id: " + id);
        machineRepository.deleteById(id);
    }

    public Machine updateMachine(Machine newMachine){
        operationCrudService.createOperationCrud("Se actualizo una maquina con id: " + newMachine.getId());
        Machine machine = findMachineById(newMachine.getId());
        machine.setSerialNumber(newMachine.getSerialNumber());
        machine.setBrand(newMachine.getBrand());
        machine.setModel(newMachine.getModel());
        machine.setDatePurchase(newMachine.getDatePurchase());
        return machineRepository.save(machine);
    }
}
