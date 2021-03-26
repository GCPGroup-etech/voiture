package com.etech.poc.voitures.commun.utils.mapper;

import com.etech.poc.voitures.data.dto.comment.CommentDTO;
import com.etech.poc.voitures.data.entity.Comment;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author benja
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, VehicleMapper.class})
public interface CommentMapper {

	CommentDTO commentToDto(Comment comment);

	Comment dtoToComment(CommentDTO comment);

	List<CommentDTO> commentsToDtos(List<Comment> comments);
	
}
