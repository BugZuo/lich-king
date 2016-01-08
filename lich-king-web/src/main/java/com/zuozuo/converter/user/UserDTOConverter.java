package com.zuozuo.converter.user;

import com.zuozuo.dto.user.ApiBasicUserDTO;
import com.zuozuo.model.user.BaseUser;

import org.modelmapper.ModelMapper;

/**
 * Created by bug on 15/12/9.
 */
public class UserDTOConverter {

    private final static ModelMapper modelMapper = new ModelMapper();

    public static ApiBasicUserDTO conv(BaseUser baseUser) {
        if (null == baseUser) {
            return null;
        }

        return modelMapper.map(baseUser, ApiBasicUserDTO.class);
    }
}
