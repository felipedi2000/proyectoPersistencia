package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;
}
