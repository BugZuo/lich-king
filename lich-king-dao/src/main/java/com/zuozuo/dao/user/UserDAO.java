package com.zuozuo.dao.user;

import com.zuozuo.model.user.BaseUser;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by bug on 15/11/30.
 */
public class UserDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public BaseUser getById(long id) {
        return sqlSessionTemplate.selectOne("getById", id);
    }

    public BaseUser getByUsername(String username) {
    	return sqlSessionTemplate.selectOne("getByUsername", username);
    }
}
