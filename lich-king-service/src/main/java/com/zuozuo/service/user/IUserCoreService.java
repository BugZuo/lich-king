package com.zuozuo.service.user;

import com.zuozuo.model.user.BaseUser;
import com.zuozuo.model.user.LoginCheckResult;

/**
 * Created by bug on 15/11/30.
 */
public interface IUserCoreService {
    public BaseUser getById(long id);

    public LoginCheckResult validateUsernameAndPassword(String username, String password);
}
