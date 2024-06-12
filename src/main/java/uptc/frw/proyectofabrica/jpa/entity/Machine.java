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

    @ManyToMany(mappedBy = "machines")
    private List<Worker> workers;

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

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
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
