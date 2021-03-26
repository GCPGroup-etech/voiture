package com.etech.poc.voitures.controller;

import com.etech.poc.voitures.data.dto.vehicle.VehicleListDTO;
import com.etech.poc.voitures.services.applicatif.vehicle.VehicleSA;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benja
 */
@RestController
@RequestMapping(value = "/vehicle")
public class VehicleControler {

	@Autowired
	VehicleSA vehicleSA;

	@PreAuthorize("permitAll()")
	@ApiOperation(value = "List vehicle", notes = "Paged list of all vehicle, no filter")
	@PostMapping("/list")
	public ResponseEntity<VehicleListDTO> getListVehicle(
			@ApiParam(name = "pageNo") @RequestParam(defaultValue = "0") Integer pageNo,
			@ApiParam(name = "pageSize") @RequestParam(defaultValue = "10") Integer pageSize)
			throws Exception {
		try {
			return new ResponseEntity<>(vehicleSA.getListVehicle(pageNo, pageSize, null), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new VehicleListDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
