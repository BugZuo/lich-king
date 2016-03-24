package com.flyzfq.lich.biz.service.user;

import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.model.user.dto.RegisterInfoDTO;

/**
 * Created by bug on 15/11/30.
 */
public interface IUserCoreService {
  public BaseResult<BaseUserDTO> getById(long id);

  public BaseResult<BaseUserDTO> validateUsernameAndPassword(String username, String password);

  public BaseResult<Long> register(RegisterInfoDTO registerInfoDTO);
}
