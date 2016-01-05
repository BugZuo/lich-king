package com.zuozuo.service.user;

import com.zuozuo.dao.user.UserDAO;
import com.zuozuo.model.user.BaseUser;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bug on 15/11/30.
 */
public interface IUserCoreService {
    public BaseUser getById(long id);

    public LoginInfo validateUsernameAndPassword(String username, String password);
}
