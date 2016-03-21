package com.flyzfq.lich.dao.impl.user;

import com.flyzfq.lich.dao.user.IUserDAO;
import com.flyzfq.lich.model.user.pojo.BaseUserDO;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by bug on 15/11/30.
 */
@Repository
public class UserDAOImpl implements IUserDAO {
  @Autowired
  private SqlSessionTemplate writeTpl;

  @Autowired
  private SqlSession readTpl;

  public BaseUserDO getById(long id) {
    return readTpl.selectOne("getById", id);
  }

  public BaseUserDO getByUsername(String username) {
    return writeTpl.selectOne("getByUsername", username);
  }
}
