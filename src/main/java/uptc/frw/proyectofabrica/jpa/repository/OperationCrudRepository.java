package uptc.frw.proyectofabrica.jpa.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import uptc.frw.proyectofabrica.jpa.entity.OperationCrud;
@Repository
public interface OperationCrudRepository extends ElasticsearchRepository<OperationCrud, String> {
}