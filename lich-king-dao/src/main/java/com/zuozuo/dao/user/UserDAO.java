package com.zuozuo.dao.user;

import com.zuozuo.model.user.BaseUser;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by bug on 15/11/30.
 */
@Repository
public class UserDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private SqlSession readTpl;

    public BaseUser getById(long id) {
        return readTpl.selectOne("getById", id);
    }

    public BaseUser getByUsername(String username) {
    	return sqlSessionTemplate.selectOne("getByUsername", username);
    }
}
