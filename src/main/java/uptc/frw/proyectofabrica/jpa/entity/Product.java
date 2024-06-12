package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
