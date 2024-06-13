package uptc.frw.proyectofabrica.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.proyectofabrica.jpa.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
