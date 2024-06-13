package uptc.frw.proyectofabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.proyectofabrica.jpa.entity.Client;
import uptc.frw.proyectofabrica.jpa.entity.Product;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseDetail;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseOrder;
import uptc.frw.proyectofabrica.jpa.repository.ClientRepository;
import uptc.frw.proyectofabrica.jpa.repository.PurchaseOrderRepository;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private ClientService clientService;

    public List<PurchaseOrder> findAllPurchaseOrder() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder findPurchaseOrderById(long id) {

        return purchaseOrderRepository.findById(id).orElse(null);
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        Client client = clientService.findClientById(purchaseOrder.getIdClient());
        purchaseOrder.setClient(client);
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrderNew){
        PurchaseOrder purchaseOrder = findPurchaseOrderById(purchaseOrderNew.getId());
        purchaseOrder.setOrderNumber(purchaseOrderNew.getOrderNumber());
        purchaseOrder.setOrderExpectedDelivery(purchaseOrderNew.getOrderExpectedDelivery());
        purchaseOrder.setOrderActualDelivery(purchaseOrderNew.getOrderActualDelivery());
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public void deletePurchaseOrder(long id) {

        purchaseOrderRepository.deleteById(id);

    }
}
