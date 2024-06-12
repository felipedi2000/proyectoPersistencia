package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Ability {

    @Id
    @Column(name = "id_habilidad")
    private long id;

    @Column(name = "nombre")
    private String name;

    public Ability() {
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

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
