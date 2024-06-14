package uptc.frw.proyectofabrica.service;

import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Material;
import uptc.frw.proyectofabrica.jpa.repository.MaterialRepository;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private OperationCrudService operationCrudService;

    public Material findMaterialById(long id) {
        operationCrudService.createOperationCrud("Se consulto un material con id:" + id);
        return materialRepository.findById(id).orElse(null);
    }

    public List<Material> findAllMaterials() {
        operationCrudService.createOperationCrud("Se consultaron todos los materiales");
        return materialRepository.findAll();
    }

    public Material saveMaterial(Material material){
        operationCrudService.createOperationCrud("Se guardo material con id:" + material.getId());
        return materialRepository.save(material);
    }

    public void deleteMaterial(long id){
        operationCrudService.createOperationCrud("Se borro un material con id:" + id);
        materialRepository.deleteById(id);
    }

    public Material updateMaterial(Material newMaterial) {
        operationCrudService.createOperationCrud("Se actualizo un material con id:" + newMaterial.getId());
        Material material = findMaterialById(newMaterial.getId());
        material.setName(newMaterial.getName());
        return materialRepository.save(material);
    }
}
