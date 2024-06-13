package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Product;
import uptc.frw.proyectofabrica.jpa.entity.ProductType;
import uptc.frw.proyectofabrica.jpa.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeService productTypeService;

    public Product findProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        ProductType productType = productTypeService.findProductTypeById(product.getIdTypeProduct());
        product.setProductType(productType);
        return productRepository.save(product);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product newProduct) {
        ProductType productType = productTypeService.findProductTypeById(newProduct.getIdTypeProduct());
        Product product = findProductById(newProduct.getId());
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setProductType(productType);
        return productRepository.save(product);
    }
}
