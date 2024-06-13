package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseOrder;
import uptc.frw.proyectofabrica.service.PurchaseOrderService;

import java.util.List;

@RestController
@RequestMapping("purchaseOrder")
public class PurchaseOrderController {


    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrderService.findAllPurchaseOrder();
    }

    @GetMapping("/{id}")
    public PurchaseOrder getClientById(@PathVariable long id) {
        return purchaseOrderService.findPurchaseOrderById(id);
    }

    @PostMapping
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.savePurchaseOrder(purchaseOrder);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrder(@PathVariable long id) {
        purchaseOrderService.deletePurchaseOrder(id);
    }

    @PutMapping
    public PurchaseOrder updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(purchaseOrder);
    }

}