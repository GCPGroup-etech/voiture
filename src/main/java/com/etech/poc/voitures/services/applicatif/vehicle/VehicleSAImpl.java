package com.etech.poc.voitures.services.applicatif.vehicle;

import com.etech.poc.voitures.commun.utils.mapper.VehicleMapper;
import com.etech.poc.voitures.data.dto.vehicle.VehicleDTO;
import com.etech.poc.voitures.data.dto.vehicle.VehicleListDTO;
import com.etech.poc.voitures.data.entity.Vehicle;
import com.etech.poc.voitures.services.repository.VehicleRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author benja
 */
@Service
public class VehicleSAImpl implements VehicleSA {

	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	VehicleMapper vehicleMapper;

	@PostConstruct
	public void init() {
		importDefaultVehicle();
	}

	public void importDefaultVehicle() {
		List<VehicleDTO> vehicles = new ArrayList<>();
		vehicles.add(new VehicleDTO("Model 1", "Mark 1", null));
		vehicles.add(new VehicleDTO("Model 2", "Mark 1", null));
		vehicles.add(new VehicleDTO("Model 3", "Mark 2", null));
		vehicles.add(new VehicleDTO("Model 4", "Mark 3", null));
		for (VehicleDTO vehicle : vehicles) {
			saveVehicle(vehicle);
		}
	}

	@Override
	public void saveVehicle(VehicleDTO dto) {
		Vehicle vehicle = vehicleRepository.findByModel(dto.getModel());
		if (vehicle == null) {
			vehicle = new Vehicle();
		} else {
			dto.setId(vehicle.getId());
		}
		vehicle = vehicleMapper.dtoToVehicle(dto);
		vehicleRepository.save(vehicle);
	}

	@Override
	public VehicleListDTO getListVehicle(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging;
		if (StringUtils.isEmpty(sortBy)) {
			sortBy = "id";
		}
		paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		Page<Vehicle> vehiclesPaged = vehicleRepository.findAll(paging);
		if (vehiclesPaged.hasContent()) {
			return new VehicleListDTO(vehicleMapper.vehiclesToDtos(vehiclesPaged.getContent()));
		} else {
			return new VehicleListDTO();
		}
	}
}
