/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etech.poc.voitures.services.applicatif.comment;

import com.etech.poc.voitures.data.dto.comment.CommentDTO;
import com.etech.poc.voitures.data.dto.comment.VehicleCommentDTO;

/**
 *
 * @author benja
 */
public interface CommentSA {
	public CommentDTO saveComment(CommentDTO dto);
	public VehicleCommentDTO getVehicleComment(Long vehicleID, Integer pageNo, Integer pageSize, String sortBy);
}
