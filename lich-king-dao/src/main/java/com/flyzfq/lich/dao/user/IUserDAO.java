package com.flyzfq.lich.dao.user;

import com.flyzfq.lich.model.user.pojo.BaseUserDO;

/**
 * Created by bug on 16/3/16.
 */
public interface IUserDAO {

  public BaseUserDO getById(long id);

  public BaseUserDO getByUsername(String username);
}
