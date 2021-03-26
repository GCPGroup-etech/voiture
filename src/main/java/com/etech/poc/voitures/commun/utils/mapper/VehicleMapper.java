package com.etech.poc.voitures.commun.utils.mapper;

import com.etech.poc.voitures.data.dto.vehicle.VehicleDTO;
import com.etech.poc.voitures.data.entity.Vehicle;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author benja
 */
@Mapper(componentModel = "spring")
public interface VehicleMapper {

	VehicleDTO vehicleToDto(Vehicle vehicle);

	Vehicle dtoToVehicle(VehicleDTO dto);

	List<VehicleDTO> vehiclesToDtos(List<Vehicle> vehicles);

}
