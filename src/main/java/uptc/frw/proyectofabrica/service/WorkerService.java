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

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker findWorkerById(long id) {
        return workerRepository.findById(id).orElse(null);
    }

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public void deleteWorker(long id) {
        workerRepository.deleteById(id);
    }

    public Worker updateWorker(Worker newWorker) {
        Worker worker = findWorkerById(newWorker.getId());
        worker.setName(newWorker.getName());
        worker.setLastName(newWorker.getLastName());
        worker.setBornDate(newWorker.getBornDate());
        worker.setAdress(newWorker.getAdress());
        return workerRepository.save(worker);
    }

    public Worker saveMachineWorker(long idWorker, long idMachine){
        Worker worker = findWorkerById(idWorker);
        Machine machine =  machineService.findMachineById(idMachine);
        worker.getMachines().add(machine);
        return workerRepository.save(worker);
    }
}
