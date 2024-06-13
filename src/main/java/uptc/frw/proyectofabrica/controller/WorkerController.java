package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.Worker;
import uptc.frw.proyectofabrica.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.findAllWorkers();
    }

    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable long id) {
        return workerService.findWorkerById(id);
    }

    @PostMapping
    public Worker createWorker(@RequestBody Worker worker) {
        return workerService.saveWorker(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable long id) {
        workerService.deleteWorker(id);
    }

    @PutMapping
    public Worker updateWorker(@RequestBody Worker worker) {
        return workerService.updateWorker(worker);
    }
}
