package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_PRODUCTO")
public class ProductType {
    @Id
    @Column(name = "ID_TIPO_PRODUCTO")
    private long id;
    @Column(name = "ID_MATERIAL")
    private long idMaterial;
    @Column(name = "ID_MAQUINA")
    private long idMachine;
    @Column(name = "NOMBRE")
    private String name;

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
