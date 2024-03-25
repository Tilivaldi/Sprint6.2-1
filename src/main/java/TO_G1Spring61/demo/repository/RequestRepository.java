package TO_G1Spring61.demo.repository;

import TO_G1Spring61.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Long> {

}
