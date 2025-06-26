package lt.caeli.veryNiceApp.nice.dto.book;

import lt.caeli.veryNiceApp.nice.model.CarMaster;

import java.util.List;

public class CarMasterMapper {

    public static GetPartialCarMasterResponseDTO toGetPartialCarMasterResponseDTO(CarMaster carMaster) {
        return new GetPartialCarMasterResponseDTO(
            carMaster.getId(),
            carMaster.getName(),
            carMaster.getCategories()
        );
    }

    public static CreateCarMasterResponseDTO toCreateCarMasterResponseDTO(CarMaster carMaster) {
        return new CreateCarMasterResponseDTO(
            carMaster.getId(),
            carMaster.getName(),
            carMaster.getCategories()
        );
    }

    public static GetCarMasterResponseDTO toGetCarMasterResponseDTO(CarMaster carMaster) {
        return new GetCarMasterResponseDTO(
            carMaster.getId(),
            carMaster.getName(),
            carMaster.getCategories(),
            carMaster.getReviews()
        );
    }

    public static UpdateCarMasterResponseDTO toUpdateCarMasterResponseDTO(CarMaster carMaster) {
        return new UpdateCarMasterResponseDTO(
            carMaster.getId(),
            carMaster.getName(),
            carMaster.getReviews(),
            carMaster.getCategories()
        );
    }

    public static CarMaster toCarMaster(CreateCarMasterRequestDTO createBookRequestDTO) {
        return new CarMaster(
            createBookRequestDTO.name(),
            List.of(),
            createBookRequestDTO.categories()
        );
    }

    public static CarMaster toCarMaster(UpdateCarMasterRequestDTO updateBookRequestDTO) {
        return new CarMaster(
            updateBookRequestDTO.id(),
            updateBookRequestDTO.name(),
            updateBookRequestDTO.reviews(),
            updateBookRequestDTO.categories()
        );
    }
}
