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
    private ProductService productService;

    public List<PurchaseDetail> findAllPurchaseDetail() {
        return purchaseDetailRepository.findAll();
    }

    public PurchaseDetail findPurchaseDetailById(long id) {

        return purchaseDetailRepository.findById(id).orElse(null);
    }

    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail) {
        Product product = productService.findProductById(purchaseDetail.getIdProduct());
        PurchaseOrder purchaseOrder = purchaseOrderService.findPurchaseOrderById(purchaseDetail.getIdPurchaseOrder());
        purchaseDetail.setProduct(product);
       purchaseDetail.setPurchaseOrder(purchaseOrder);
        return purchaseDetailRepository.save(purchaseDetail);
    }


    public PurchaseDetail updatePurchaseDetail(PurchaseDetail purchaseDetailNew){
        PurchaseDetail purchaseDetail = findPurchaseDetailById(purchaseDetailNew.getId());
        purchaseDetail.setQuantity(purchaseDetailNew.getQuantity());
        purchaseDetail.setPrice(purchaseDetailNew.getPrice());
        return purchaseDetailRepository.save(purchaseDetail);
    }

    public void deletePurchaseDetail(long id) {

        purchaseDetailRepository.deleteById(id);

    }

}
