package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uptc.frw.proyectofabrica.service.WorkerService;

@RestController
@RequestMapping("worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
}
