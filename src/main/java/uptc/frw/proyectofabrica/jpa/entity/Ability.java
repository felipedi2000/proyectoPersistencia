package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "HABILIDADES")
public class Ability {

    @Id
    @Column(name = "ID_HABILIDAD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOMBRE")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "TRABAJADOR_HABILIDAD",
            joinColumns = @JoinColumn(name = "ID_HABILIDAD"),
            inverseJoinColumns = @JoinColumn(name = "ID_TRABAJADOR")
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
