package com.flyzfq.lich.web.assember.user;

import com.flyzfq.lich.model.user.BaseUser;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.web.assember.BaseAssemberAdapter;
import com.flyzfq.lich.web.dto.user.ApiBasicUserDTO;

/**
 * Created by bug on 15/12/9.
 */
public class ApiUserAssemberAdapter extends BaseAssemberAdapter<ApiBasicUserDTO, BaseUser> {

  public static ApiBasicUserDTO conv(BaseUserDTO baseUserDTO) {
    if (null == baseUserDTO) {
      return null;
    }

    return modelMapper.map(baseUserDTO, ApiBasicUserDTO.class);
  }
}
