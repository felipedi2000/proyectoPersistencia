package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TIPO_PRODUCTO")
public class ProductType {
    @Id
    @Column(name = "ID_TIPO_PRODUCTO")
    private long id;

    @Column(name = "ID_MATERIAL", insertable = false, updatable = false)
    private long idMaterial;

    @Column(name = "ID_MAQUINA", insertable = false, updatable = false)
    private long idMachine;

    @Column(name = "NOMBRE")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_MAQUINA")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "ID_MATERIAL")
    private Material material;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;

    public ProductType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public long getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(long idMachine) {
        this.idMachine = idMachine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", idMaterial=" + idMaterial +
                ", idMachine=" + idMachine +
                ", name='" + name + '\'' +
                '}';
    }
}
