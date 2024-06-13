package uptc.frw.proyectofabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseDetail;
import uptc.frw.proyectofabrica.service.PurchaseDetailService;


import java.util.List;

@RestController
@RequestMapping("purchaseDetail")
public class PurchaseDetailController {


        @Autowired
        private PurchaseDetailService purchaseDetailService;


        @GetMapping
        public List<PurchaseDetail> getPurchaseDetails() {
                return purchaseDetailService.findAllPurchaseDetail();
        }

        @GetMapping("/{id}")
        public PurchaseDetail getPurchaseDetailById(@PathVariable long id) {
                return purchaseDetailService.findPurchaseDetailById(id);
        }

        @PostMapping
        public PurchaseDetail createPurchaseDetail(@RequestBody PurchaseDetail purchaseDetail) {
                return purchaseDetailService.savePurchaseDetail(purchaseDetail);
        }

        @DeleteMapping("/{id}")
        public void deletePurchaseOrder(@PathVariable long id) {
                purchaseDetailService.deletePurchaseDetail(id);
        }

        @PutMapping
        public PurchaseDetail updatePurchaseDetail(@RequestBody PurchaseDetail purchaseDetail) {
                return purchaseDetailService.updatePurchaseDetail(purchaseDetail);
        }
}

