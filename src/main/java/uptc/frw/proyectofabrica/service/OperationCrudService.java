package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.OperationCrud;
import uptc.frw.proyectofabrica.jpa.repository.OperationCrudRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class OperationCrudService {

    @Autowired
    private OperationCrudRepository operationCrudRepository;

    public void createOperationCrud(String message) {
        OperationCrud operationCrud = new OperationCrud();
        operationCrud.setMessage(message);
        operationCrud.setTimestamp(new Date());
        operationCrudRepository.save(operationCrud);
    }
}
