package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Ability {

    @Id
    @Column(name = "id_habilidad")
    private long id;

    @Column(name = "nombre")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "trabajador_habilidad",
            joinColumns = @JoinColumn(name = "id_habilidad"),
            inverseJoinColumns = @JoinColumn(name = "id_trabajado")
    )
    private List<Worker> workers;

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

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
