package uptc.frw.proyectofabrica.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.proyectofabrica.jpa.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
