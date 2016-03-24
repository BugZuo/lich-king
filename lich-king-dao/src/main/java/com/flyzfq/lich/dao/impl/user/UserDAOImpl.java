package com.flyzfq.lich.dao.impl.user;

import com.flyzfq.lich.dao.user.IUserDAO;
import com.flyzfq.lich.model.user.pojo.BaseUserDO;
import com.flyzfq.lich.model.user.pojo.RegisterInfoDO;

import com.google.common.collect.Maps;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by bug on 15/11/30.
 */
@Repository
public class UserDAOImpl implements IUserDAO {
  @Autowired
  private SqlSessionTemplate writeTpl;

  @Autowired
  private SqlSession readTpl;

  private static final String MAPPING_PREFIX = "UserMapper.";

  public BaseUserDO getById(long id) {
    Map<String, Object> params = Maps.newHashMap();
    params.put("columnName", "id");
    params.put("columnValue", id);
    return readTpl.selectOne(MAPPING_PREFIX + "getByOneColumn", params);
  }

  public BaseUserDO getByUsername(String username) {
    Map<String, Object> params = Maps.newHashMap();
    params.put("columnName", "username");
    params.put("columnValue", username);
    return readTpl.selectOne(MAPPING_PREFIX + "getByOneColumn", params);
  }

  public BaseUserDO getByEmail(String email) {
    Map<String, Object> params = Maps.newHashMap();
    params.put("columnName", "email");
    params.put("columnValue", email);
    return readTpl.selectOne(MAPPING_PREFIX + "getByOneColumn", params);
  }

  public BaseUserDO getByTelephone(String telephone) {
    Map<String, Object> params = Maps.newHashMap();
    params.put("columnName", "telephone");
    params.put("columnValue", telephone);
    return readTpl.selectOne(MAPPING_PREFIX + "getByOneColumn", params);
  }

  @Override
  public Long insert(RegisterInfoDO registerInfoDO) {
    writeTpl.insert(MAPPING_PREFIX + "insert", registerInfoDO);
    return registerInfoDO.getId();
  }
}
