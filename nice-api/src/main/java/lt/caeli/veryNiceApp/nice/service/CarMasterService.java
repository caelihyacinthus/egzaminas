package lt.caeli.veryNiceApp.nice.service;

import lt.caeli.veryNiceApp.nice.model.CarMaster;
import lt.caeli.veryNiceApp.nice.repository.CarMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarMasterService {

    private final CarMasterRepository carMasterRepository;

    @Autowired
    public CarMasterService(CarMasterRepository carMasterRepository) {
        this.carMasterRepository = carMasterRepository;
    }

    public List<CarMaster> findAllCarMasters() {
        return carMasterRepository.findAll();
    }

    public boolean existsCarMasterById(long id) {
        return carMasterRepository.existsById(id);
    }

    public Optional<CarMaster> findCarMasterById(long id) {
        return carMasterRepository.findById(id);
    }

    public CarMaster saveCarMaster(CarMaster carMaster) {
        return carMasterRepository.save(carMaster);
    }

    public void deleteCarMasterById(long id) {
        carMasterRepository.deleteById(id);
    }

    public List<CarMaster> findAllCarMasterByNameContaining(String name) {
        return carMasterRepository.findAllByNameContaining(name);
    }

    public Page<CarMaster> findAllCarMasterPage(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return carMasterRepository.findAll(pageable);
    }
}
