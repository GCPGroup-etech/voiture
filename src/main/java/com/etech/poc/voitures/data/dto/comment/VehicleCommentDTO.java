package com.etech.poc.voitures.data.dto.comment;

import com.etech.poc.voitures.data.dto.commun.BaseDTO;
import com.etech.poc.voitures.data.dto.vehicle.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 *
 * @author benja
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleCommentDTO extends BaseDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	VehicleDTO vehicle;
	List<CommentDTO> comments;

	public VehicleCommentDTO() {
	}

	public VehicleCommentDTO(VehicleDTO vehicle, List<CommentDTO> comments) {
		this.vehicle = vehicle;
		this.comments = comments;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

}
