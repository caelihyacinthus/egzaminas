package lt.caeli.veryNiceApp.nice.dto;

import lt.caeli.veryNiceApp.nice.model.CarMaster;

import java.util.ArrayList;

public class CarMasterMapper {
    public static CarMaster toCarMaster(RequestCarMasterDTO request) {
        return new CarMaster(request.name(), new ArrayList<>(), new ArrayList<>());
    }

}
