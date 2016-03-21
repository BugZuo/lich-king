package com.flyzfq.lich.biz.service.user;

import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;

/**
 * Created by bug on 15/11/30.
 */
public interface IUserCoreService {
  public BaseResult<BaseUserDTO> getById(long id);

  public BaseResult<BaseUserDTO> validateUsernameAndPassword(String username, String password);
}
