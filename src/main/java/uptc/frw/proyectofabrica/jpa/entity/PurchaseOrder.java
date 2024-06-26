package uptc.frw.proyectofabrica.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDEN_COMPRA")
public class PurchaseOrder {

    @Id
    @Column(name = "ID_ORDEN_COMPRA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_CLIENTE", insertable = false, updatable = false)
    private long idClient;

    @Column(name = "NUMERO_ORDEN")
    private long orderNumber;

    @Column(name = "FECHA_ENTREGA_ESPERADA")
    private Date orderExpectedDelivery;

    @Column(name = "FECHA_ENTREGA_REAL")
    private Date orderActualDelivery;

    @JsonIgnore
    @OneToMany(mappedBy = "purchaseOrder")
    private List<PurchaseDetail> PurchaseDetails;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;

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

    public List<PurchaseDetail> getPurchaseDetails() {
        return PurchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        PurchaseDetails = purchaseDetails;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
