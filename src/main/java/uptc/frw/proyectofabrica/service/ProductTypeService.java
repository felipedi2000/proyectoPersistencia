package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Machine;
import uptc.frw.proyectofabrica.jpa.entity.Material;
import uptc.frw.proyectofabrica.jpa.entity.ProductType;
import uptc.frw.proyectofabrica.jpa.repository.ProductTypeRepository;

import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private MachineService machineService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private OperationCrudService operationCrudService;

    public List<ProductType> findAllProductType() {
        operationCrudService.createOperationCrud("Se consultaron todos los tipo de producto");
        return productTypeRepository.findAll();
    }

    public ProductType findProductTypeById(long id) {
        operationCrudService.createOperationCrud("Se consulto un tipo de producto con id: " + id);
        return productTypeRepository.findById(id).orElse(null);
    }

    public ProductType saveProductType(ProductType productType){
        operationCrudService.createOperationCrud("Se guardo un tipo de producto con id: " + productType.getId());
        Machine machine = machineService.findMachineById(productType.getIdMachine());
        Material material = materialService.findMaterialById(productType.getIdMaterial());
        productType.setMachine(machine);
        productType.setMaterial(material);
        return productTypeRepository.save(productType);
    }

    public void deleteProductType(long id){
        operationCrudService.createOperationCrud("Se borro un tipo de producto con id: " + id);
        productTypeRepository.deleteById(id);
    }

    public ProductType updateProductType(ProductType newProductType) {
        operationCrudService.createOperationCrud("Se actualizar un tipo de producto con id: " + newProductType.getId());
        Machine machine = machineService.findMachineById(newProductType.getIdMachine());
        Material material = materialService.findMaterialById(newProductType.getIdMaterial());
        ProductType productType = findProductTypeById(newProductType.getId());
        productType.setMachine(machine);
        productType.setMaterial(material);
        productType.setName(newProductType.getName());
        return productTypeRepository.save(productType);
    }
}
