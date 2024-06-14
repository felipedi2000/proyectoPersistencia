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

    @Autowired
    private OperationCrudService operationCrudService;

    public List<PurchaseOrder> findAllPurchaseOrder() {
        operationCrudService.createOperationCrud("Se consultaron todos las orden de compra");
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder findPurchaseOrderById(long id) {
        operationCrudService.createOperationCrud("Se consulto una orden de compra con id: " + id);
        return purchaseOrderRepository.findById(id).orElse(null);
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        operationCrudService.createOperationCrud("Se guardo un orden de compra con id: " + purchaseOrder.getId());
        Client client = clientService.findClientById(purchaseOrder.getIdClient());
        purchaseOrder.setClient(client);
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public void deletePurchaseOrder(long id) {
        operationCrudService.createOperationCrud("Se borro un orden de compra con id: " + id);
        purchaseOrderRepository.deleteById(id);
    }

    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrderNew){
        operationCrudService.createOperationCrud("Se actualizar un orden de compra con id: " + purchaseOrderNew.getId());
        Client client = clientService.findClientById(purchaseOrderNew.getIdClient());
        PurchaseOrder purchaseOrder = findPurchaseOrderById(purchaseOrderNew.getId());
        purchaseOrder.setClient(client);
        purchaseOrder.setOrderNumber(purchaseOrderNew.getOrderNumber());
        purchaseOrder.setOrderExpectedDelivery(purchaseOrderNew.getOrderExpectedDelivery());
        purchaseOrder.setOrderActualDelivery(purchaseOrderNew.getOrderActualDelivery());
        return purchaseOrderRepository.save(purchaseOrder);
    }
}
