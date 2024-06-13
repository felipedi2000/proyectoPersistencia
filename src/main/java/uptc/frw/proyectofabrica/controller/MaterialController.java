package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.Material;
import uptc.frw.proyectofabrica.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @GetMapping("/{id}")
    public Material getMaterialById(@PathVariable long id) {
        return materialService.findMaterialById(id);
    }

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.findAllMaterials();
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialService.saveMaterial(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable long id) {
        materialService.deleteMaterial(id);
    }

    @PutMapping
    public Material updateMaterial(@RequestBody Material material) {
        return materialService.updateMaterial(material);
    }
}
