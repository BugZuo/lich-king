package com.zuozuo.service.impl.user;

import com.zuozuo.base.SafeUtil;
import com.zuozuo.dao.user.UserDAO;
import com.zuozuo.model.user.BaseUser;
import com.zuozuo.service.user.IUserCoreService;
import com.zuozuo.service.user.LoginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bug on 15/11/30.
 */
@Service
public class UserCoreServiceImpl implements IUserCoreService {
    @Autowired
    private UserDAO userDAO;

    public BaseUser getById(long id) {
        return userDAO.getById(id);
    }

    public LoginInfo validateUsernameAndPassword(String username, String password) {
    	BaseUser user = userDAO.getByUsername(username);

    	if (user == null) {
    		return LoginInfo.failWithMessage(LoginInfo.UNKNOWN_USERNAME);
    	}

    	if (!user.getPassword().equals(SafeUtil.getSaltPassword(password))) {
    		return LoginInfo.failWithMessage(LoginInfo.ERROR_PASSWORD);
    	}

        LoginInfo loginInfo = LoginInfo.of(LoginInfo.LOGIN_SUCCESS);
        loginInfo.setUser(user);
        return loginInfo;
    }
}
