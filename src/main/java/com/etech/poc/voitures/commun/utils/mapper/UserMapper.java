/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etech.poc.voitures.commun.utils.mapper;

import com.etech.poc.voitures.data.dto.user.UserDTO;
import com.etech.poc.voitures.data.entity.User;
import org.mapstruct.Mapper;

/**
 *
 * @author benja
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDTO userToDto(User user);
}
