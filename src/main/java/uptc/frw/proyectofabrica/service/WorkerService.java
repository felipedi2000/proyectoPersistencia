package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Ability;
import uptc.frw.proyectofabrica.jpa.entity.Machine;
import uptc.frw.proyectofabrica.jpa.entity.Worker;
import uptc.frw.proyectofabrica.jpa.repository.AbilityRepository;
import uptc.frw.proyectofabrica.jpa.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private MachineService machineService;

    @Autowired
    private OperationCrudService operationCrudService;

    public List<Worker> findAllWorkers() {
        operationCrudService.createOperationCrud("Se consultaron todos los trabajadores");
        return workerRepository.findAll();
    }

    public Worker findWorkerById(long id) {
        operationCrudService.createOperationCrud("Se consulto un trabajador con id: " + id);
        return workerRepository.findById(id).orElse(null);
    }

    public Worker saveWorker(Worker worker) {
        operationCrudService.createOperationCrud("Se guardar un trabajador con id: " + worker.getId());
        return workerRepository.save(worker);
    }

    public void deleteWorker(long id) {
        operationCrudService.createOperationCrud("Se borro un trabajador con id: " + id);
        workerRepository.deleteById(id);
    }

    public Worker updateWorker(Worker newWorker) {
        operationCrudService.createOperationCrud("Se actualizar un trabajador con id: " + newWorker.getId());
        Worker worker = findWorkerById(newWorker.getId());
        worker.setName(newWorker.getName());
        worker.setLastName(newWorker.getLastName());
        worker.setBornDate(newWorker.getBornDate());
        worker.setAdress(newWorker.getAdress());
        return workerRepository.save(worker);
    }

    public Worker saveMachineWorker(long idWorker, long idMachine){
        operationCrudService.createOperationCrud("Se guardo un trabajador con id: " +
                idWorker + "para la maquina on id: " + idMachine);
        Worker worker = findWorkerById(idWorker);
        Machine machine =  machineService.findMachineById(idMachine);
        worker.getMachines().add(machine);
        return workerRepository.save(worker);
    }
}
