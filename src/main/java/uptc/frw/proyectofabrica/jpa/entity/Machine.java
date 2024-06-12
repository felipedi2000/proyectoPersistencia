package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MAQUINA")
public class Machine {
    @Id
    @Column(name = "ID_MAQUINA")
    private long id;
    @Column(name = "NUMERO_SERIE")
    private String serialNumber;
    @Column(name = "MARCA")
    private String brand;
    @Column(name = "MODELO")
    private String model;
    @Column(name = "FECHA_COMPRA")
    private Date datePurchase;

    @OneToMany(mappedBy = "machine")
    private List<ProductType> productTypes;

    public Machine() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", datePurchase=" + datePurchase +
                '}';
    }
}
