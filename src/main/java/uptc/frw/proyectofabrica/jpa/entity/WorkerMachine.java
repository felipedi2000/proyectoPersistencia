package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajador_maquina")
public class WorkerMachine {

    @Id
    @Column(name = "id_trabajador")
    private long idWorker;

    @Column(name = "id_maquina")
    private long idMachine;

    public WorkerMachine() {
    }

    public long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(long idWorker) {
        this.idWorker = idWorker;
    }

    public long getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(long idMachine) {
        this.idMachine = idMachine;
    }

    @Override
    public String toString() {
        return "WorkerMachine{" +
                "idWorker=" + idWorker +
                ", idMachine=" + idMachine +
                '}';
    }
}
