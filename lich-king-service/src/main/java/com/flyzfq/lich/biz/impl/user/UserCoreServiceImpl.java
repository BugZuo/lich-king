package com.flyzfq.lich.biz.impl.user;

import com.flyzfq.arthas.base.SafeUtil;
import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.common.result.BaseResultCode;
import com.flyzfq.lich.dao.impl.user.UserDAOImpl;
import com.flyzfq.lich.model.user.constants.LoginCheckConstants;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.model.user.pojo.BaseUserDO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bug on 15/11/30.
 */
@Service
public class UserCoreServiceImpl implements IUserCoreService {
  @Autowired
  private UserDAOImpl userDAOImpl;

  @Autowired
  private ModelMapper modelMapper;

  public BaseResult<BaseUserDTO> getById(long id) {
    BaseUserDO baseUserDO = userDAOImpl.getById(id);
    if (baseUserDO == null) {
      return BaseResult.of(BaseResultCode.NOT_FOUND);
    }
    return new BaseResult<>(modelMapper.map(baseUserDO, BaseUserDTO.class));
  }

  public BaseResult<BaseUserDTO> validateUsernameAndPassword(String username, String
      password) {
    BaseUserDO user = userDAOImpl.getByUsername(username);

    if (user == null) {
      return BaseResult.of(LoginCheckConstants.UNKNOWN_USERNAME, BaseResultCode.ERROR.getCode());
    }

    if (!user.getPassword().equals(SafeUtil.getSaltPassword(password))) {
      return BaseResult.of(LoginCheckConstants.ERROR_PASSWORD, BaseResultCode.ERROR.getCode());
    }
    return new BaseResult<>(modelMapper.map(user, BaseUserDTO.class));
  }
}
