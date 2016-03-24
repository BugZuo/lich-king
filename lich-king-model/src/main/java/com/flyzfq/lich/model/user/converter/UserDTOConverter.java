package com.flyzfq.lich.model.user.converter;

import com.flyzfq.lich.model.base.BaseConverterAdapter;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.model.user.pojo.BaseUserDO;

/**
 * Created by bug on 16/3/24.
 */
public class UserDTOConverter extends BaseConverterAdapter<BaseUserDTO, BaseUserDO> {
  public BaseUserDTO conv(BaseUserDO baseUserDO) {
    if (baseUserDO == null) {
      return null;
    }
    return modelMapper.map(baseUserDO, BaseUserDTO.class);
  }
}
