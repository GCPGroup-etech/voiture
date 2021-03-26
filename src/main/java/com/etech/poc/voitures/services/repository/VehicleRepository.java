/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etech.poc.voitures.services.repository;

import com.etech.poc.voitures.data.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author benja
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Vehicle findByModel(String model);
	
}
