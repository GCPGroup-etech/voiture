/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etech.poc.voitures.services.applicatif.vehicle;

import com.etech.poc.voitures.data.dto.vehicle.VehicleDTO;
import com.etech.poc.voitures.data.dto.vehicle.VehicleListDTO;

/**
 *
 * @author benja
 */
public interface VehicleSA {

	public void saveVehicle(VehicleDTO dto);

	public VehicleListDTO getListVehicle(Integer pageNo, Integer pageSize, String sortBy);
}
