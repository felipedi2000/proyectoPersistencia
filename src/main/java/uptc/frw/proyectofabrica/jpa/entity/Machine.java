package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

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
