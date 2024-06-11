package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "ORDEN_COMPRA")
public class PurchaseOrder {

    @Id
    @Column(name = "ID_ORDEN_COMPRA")
    private long id;
    @Column(name = "ID_CLIENTE")
    private long idClient;
    @Column(name = "NUMERO_ORDEN")
    private long orderNumber;
    @Column(name = "FECHA_ENTREGA_ESPERADA")
    private Date orderExpectedDelivery;
    @Column(name = "FECHA_ENTREGA_REAL")
    private Date orderActualDelivery;

    public PurchaseOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderExpectedDelivery() {
        return orderExpectedDelivery;
    }

    public void setOrderExpectedDelivery(Date orderExpectedDelivery) {
        this.orderExpectedDelivery = orderExpectedDelivery;
    }

    public Date getOrderActualDelivery() {
        return orderActualDelivery;
    }

    public void setOrderActualDelivery(Date orderActualDelivery) {
        this.orderActualDelivery = orderActualDelivery;
    }

    @Override
    public String toString() {
        return "purchaseOrder{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", orderNumber=" + orderNumber +
                ", orderExpectedDelivery=" + orderExpectedDelivery +
                ", orderActualDelivery=" + orderActualDelivery +
                '}';
    }
}
