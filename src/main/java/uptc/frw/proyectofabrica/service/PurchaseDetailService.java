package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Product;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseDetail;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseOrder;
import uptc.frw.proyectofabrica.jpa.repository.PurchaseDetailRepository;

import java.util.List;

@Service
public class PurchaseDetailService {

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private OperationCrudService operationCrudService;

    @Autowired
    private ProductService productService;

    public List<PurchaseDetail> findAllPurchaseDetail() {
        operationCrudService.createOperationCrud("Se consultaron todos los detalles de las compras");
        return purchaseDetailRepository.findAll();
    }

    public PurchaseDetail findPurchaseDetailById(long id) {
        operationCrudService.createOperationCrud("Se consulto un detalle de una compra con id: " + id);
        return purchaseDetailRepository.findById(id).orElse(null);
    }

    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail) {
        operationCrudService.createOperationCrud("Se guardo un detalle de una compra con id: " + purchaseDetail.getId());
        Product product = productService.findProductById(purchaseDetail.getIdProduct());
        PurchaseOrder purchaseOrder = purchaseOrderService.findPurchaseOrderById(purchaseDetail.getIdPurchaseOrder());
        purchaseDetail.setProduct(product);
        purchaseDetail.setPurchaseOrder(purchaseOrder);
        return purchaseDetailRepository.save(purchaseDetail);
    }

    public void deletePurchaseDetail(long id) {
        operationCrudService.createOperationCrud("Se borro un detalle de una compra con id: " + id);
        purchaseDetailRepository.deleteById(id);
    }

    public PurchaseDetail updatePurchaseDetail(PurchaseDetail purchaseDetailNew){
        operationCrudService.createOperationCrud("Se actualizo un detalle de una compra con id: " + purchaseDetailNew.getId());
        Product product = productService.findProductById(purchaseDetailNew.getIdProduct());
        PurchaseOrder purchaseOrder = purchaseOrderService.findPurchaseOrderById(purchaseDetailNew.getIdPurchaseOrder());
        PurchaseDetail purchaseDetail = findPurchaseDetailById(purchaseDetailNew.getId());
        purchaseDetail.setProduct(product);
        purchaseDetail.setPurchaseOrder(purchaseOrder);
        purchaseDetail.setQuantity(purchaseDetailNew.getQuantity());
        purchaseDetail.setPrice(purchaseDetailNew.getPrice());
        return purchaseDetailRepository.save(purchaseDetail);
    }
}
