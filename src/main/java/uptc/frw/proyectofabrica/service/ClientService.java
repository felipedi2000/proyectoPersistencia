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

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(long id) {

        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }


    public Client updateClient(Client clientNew){
        Client client = findClientById(clientNew.getId());
        client.setName(clientNew.getName());
        client.setName(clientNew.getAddress());
        client.setName(clientNew.getContactName());
        return clientRepository.save(client);
    }

    public void deleteClient(long id) {

        clientRepository.deleteById(id);

    }

    }
