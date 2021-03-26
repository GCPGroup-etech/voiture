package com.etech.poc.voitures.services.applicatif.comment;

import com.etech.poc.voitures.commun.utils.mapper.CommentMapper;
import com.etech.poc.voitures.commun.utils.mapper.VehicleMapper;
import com.etech.poc.voitures.constraint.exception.ErrorsEnum;
import com.etech.poc.voitures.constraint.exception.FunctionalException;
import com.etech.poc.voitures.data.dto.comment.CommentDTO;
import com.etech.poc.voitures.data.dto.comment.VehicleCommentDTO;
import com.etech.poc.voitures.data.entity.Comment;
import com.etech.poc.voitures.data.entity.Vehicle;
import com.etech.poc.voitures.services.repository.CommentRepository;
import com.etech.poc.voitures.services.repository.VehicleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author benja
 */
@Service
public class CommentSAImpl implements CommentSA {

	@Autowired
	CommentMapper commentMapper;

	@Autowired
	VehicleMapper vehicleMapper;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public CommentDTO saveComment(CommentDTO dto) {
		Comment comment = commentRepository.save(commentMapper.dtoToComment(dto));
		dto.setId(comment.getId());
		return dto;
	}

	@Override
	public VehicleCommentDTO getVehicleComment(Long vehicleID, Integer pageNo, Integer pageSize, String sortBy) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleID);
		if (!vehicle.isPresent()) {
			throw new FunctionalException(ErrorsEnum.ERR_COMMENT_VEHICLE_NOT_FOUND) {
			};
		}

		Pageable paging;
		if (StringUtils.isEmpty(sortBy)) {
			sortBy = "id";
		}
		paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		Page<Comment> commentsPaged = commentRepository.findCommentByVehicle(vehicle.get(), paging);
		if (commentsPaged.hasContent()) {
			return new VehicleCommentDTO(vehicleMapper.vehicleToDto(vehicle.get()), commentMapper.commentsToDtos(commentsPaged.getContent()));
		} else {
			return new VehicleCommentDTO();
		}
	}
}
