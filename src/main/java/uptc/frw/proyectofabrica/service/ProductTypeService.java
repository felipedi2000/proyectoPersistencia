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

    public ProductType findProductTypeById(long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    public List<ProductType> findAllProductType() {
        return productTypeRepository.findAll();
    }

    public ProductType saveProductType(ProductType productType){
        Machine machine = machineService.findMachineById(productType.getIdMachine());
        Material material = materialService.findMaterialById(productType.getIdMaterial());
        productType.setMachine(machine);
        productType.setMaterial(material);
        return productTypeRepository.save(productType);
    }

    public void deleteProductType(long id){
        productTypeRepository.deleteById(id);
    }

    public ProductType updateProductType(ProductType newProductType) {
        Machine machine = machineService.findMachineById(newProductType.getIdMachine());
        Material material = materialService.findMaterialById(newProductType.getIdMaterial());
        ProductType productType = findProductTypeById(newProductType.getId());
        productType.setMachine(machine);
        productType.setMaterial(material);
        productType.setName(newProductType.getName());
        return productTypeRepository.save(productType);
    }
}
