package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Client {

    @Id
    @Column(name = "ID_CLIENTE")
    private long id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private long phoneNumber;

    @Column(name = "NOMBRE_CONTACTO")
    private String contactName;

    @OneToMany(mappedBy = "client")
    private List<PurchaseOrder> PurchaseOrders;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return PurchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        PurchaseOrders = purchaseOrders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", contactName='" + contactName + '\'' +
                '}';
    }
}
