package uptc.frw.proyectofabrica.jpa.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "DETALLE_COMPRA")
public class PurchaseDetail {

    @Id
    @Column(name = "ID_DETALLE_COMPRA")
    private long id;

    @Column(name = "ID_PRODUCTO", insertable = false, updatable = false)
    private long idProduct;

    @Column(name = "ID_ORDEN_COMPRA", insertable = false, updatable = false)
    private long idPurchaseOrder;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEN_COMPRA")
    private PurchaseOrder purchaseOrder;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public PurchaseDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdPurchaseOrder() {
        return idPurchaseOrder;
    }

    public void setIdPurchaseOrder(long idPurchaseOrder) {
        this.idPurchaseOrder = idPurchaseOrder;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", idPurchaseOrder=" + idPurchaseOrder +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}