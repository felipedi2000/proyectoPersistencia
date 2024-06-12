package uptc.frw.proyectofabrica.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.proyectofabrica.jpa.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
