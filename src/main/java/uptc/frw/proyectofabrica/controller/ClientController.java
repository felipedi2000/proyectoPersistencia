package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uptc.frw.proyectofabrica.service.ClientService;


@RestController
@RequestMapping("client")
public class ClientController {


    @Autowired
    private ClientService clientService;
}

