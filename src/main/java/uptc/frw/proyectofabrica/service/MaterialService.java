package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Material;
import uptc.frw.proyectofabrica.jpa.repository.MaterialRepository;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material findMaterialById(long id) {
        return materialRepository.findById(id).orElse(null);
    }

    public List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }

    public Material saveMaterial(Material material){
        return materialRepository.save(material);
    }

    public void deleteMaterial(long id){
        materialRepository.deleteById(id);
    }

    public Material updateMaterial(Material newMaterial) {
        Material material = findMaterialById(newMaterial.getId());
        material.setName(newMaterial.getName());
        return materialRepository.save(material);
    }
}
