package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.annotation.Tainted;

@Entity
@Table(name = "trabajador_habilidad")
public class WorkerAbility {

    @Id
    @Column(name = "id_trabajador")
    private long idWorker;

    @Column(name = "id_habilidad")
    private long idAbility;

    public WorkerAbility() {
    }

    public long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(long idWorker) {
        this.idWorker = idWorker;
    }

    public long getIdAbility() {
        return idAbility;
    }

    public void setIdAbility(long idAbility) {
        this.idAbility = idAbility;
    }

    @Override
    public String toString() {
        return "WorkerAbility{" +
                "idWorker=" + idWorker +
                ", idAbility=" + idAbility +
                '}';
    }
}
