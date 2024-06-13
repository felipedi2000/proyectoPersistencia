package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MATERIALES")
public class Material {

    @Id
    @Column(name = "ID_MATERIAL")
    private long id;

    @Column(name = "NOMBRE")
    private String name;

    @OneToMany(mappedBy = "material")
    private List<ProductType> productTypes;

    public Material() {
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

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
