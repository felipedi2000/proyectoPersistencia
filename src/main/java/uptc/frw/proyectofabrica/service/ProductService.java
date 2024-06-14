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
    private OperationCrudService operationCrudService;

    @Autowired
    private ProductTypeService productTypeService;

    public List<Product> findAllProducts() {
        operationCrudService.createOperationCrud("Se consultaron todos los productos");
        return productRepository.findAll();
    }

    public Product findProductById(long id) {
        operationCrudService.createOperationCrud("Se consulto un producto con id: " + id);
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        operationCrudService.createOperationCrud("Se guardo un producto con id: " + product.getId());
        ProductType productType = productTypeService.findProductTypeById(product.getIdTypeProduct());
        product.setProductType(productType);
        return productRepository.save(product);
    }

    public void deleteProduct(long id){
        operationCrudService.createOperationCrud("Se borro un producto con id: " + id);
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product newProduct) {
        operationCrudService.createOperationCrud("Se actualizo un producto con id: " + newProduct.getId());
        ProductType productType = productTypeService.findProductTypeById(newProduct.getIdTypeProduct());
        Product product = findProductById(newProduct.getId());
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setProductType(productType);
        return productRepository.save(product);
    }
}
