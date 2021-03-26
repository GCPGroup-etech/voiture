package com.etech.poc.voitures.data.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author benja
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleDTO {
	private Long id;
	private String model;
	private String mark;
	private String url;

	public VehicleDTO() {
	}

	public VehicleDTO(String model, String mark, String url) {
		this.model = model;
		this.mark = mark;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
