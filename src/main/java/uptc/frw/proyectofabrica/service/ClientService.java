package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Client;
import uptc.frw.proyectofabrica.jpa.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OperationCrudService operationCrudService;

    public List<Client> findAllClients() {
        operationCrudService.createOperationCrud("Se consultaron todos los clientes");
        return clientRepository.findAll();
    }

    public Client findClientById(long id) {
        operationCrudService.createOperationCrud("Se consulto un cliente con id: " + id);
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        operationCrudService.createOperationCrud("Se guardo un cliente con id: " + client.getId());
        return clientRepository.save(client);
    }

    public void deleteClient(long id) {
        operationCrudService.createOperationCrud("Se borro un cliente con id: " + id);
        clientRepository.deleteById(id);
    }

    public Client updateClient(Client newClient){
        operationCrudService.createOperationCrud("Se actualizo un cliente con id: " + newClient.getId());
        Client client = findClientById(newClient.getId());
        client.setName(newClient.getName());
        client.setName(newClient.getAddress());
        client.setName(newClient.getContactName());
        return clientRepository.save(client);
    }
}
