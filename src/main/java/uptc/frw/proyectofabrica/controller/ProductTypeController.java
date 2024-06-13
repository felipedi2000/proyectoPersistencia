package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.ProductType;
import uptc.frw.proyectofabrica.service.ProductTypeService;

import java.util.List;

@RestController
@RequestMapping("productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/{id}")
    public ProductType getProductTypeById(@PathVariable long id) {
        return productTypeService.findProductTypeById(id);
    }

    @GetMapping
    public List<ProductType> getAllProductType() {
        return productTypeService.findAllProductType();
    }

    @PostMapping
    public ProductType createProductType(@RequestBody ProductType productType) {
        return productTypeService.saveProductType(productType);
    }

    @DeleteMapping("/{id}")
    public void deleteProductType(@PathVariable long id) {
        productTypeService.deleteProductType(id);
    }

    @PutMapping
    public ProductType updateProductType(@RequestBody ProductType productType) {
        return productTypeService.updateProductType(productType);
    }
}
