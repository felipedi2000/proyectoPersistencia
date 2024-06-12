package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
public class Product {
    @Id
    @Column(name = "ID_PRODUCTO")
    private long id;

    @Column(name = "ID_TIPO_PRODUCTO")
    private long idTypeProduct;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DESCRIPCION")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<PurchaseDetail> PurchaseDetails;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(long idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return PurchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        PurchaseDetails = purchaseDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", idTypeProduct=" + idTypeProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
