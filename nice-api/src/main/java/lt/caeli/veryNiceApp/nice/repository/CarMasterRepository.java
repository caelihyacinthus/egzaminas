package lt.caeli.veryNiceApp.nice.repository;

import lt.caeli.veryNiceApp.nice.model.CarMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarMasterRepository extends JpaRepository<CarMaster, Long> {

    List<CarMaster> findAllByNameContaining(String name);

    List<CarMaster> findAllByName(String name);

}