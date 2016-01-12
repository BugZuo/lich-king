package com.zuozuo.views.home.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zuozuo.common.web.APIStatus;
import com.zuozuo.common.web.StandardResponseAPI;
import com.zuozuo.converter.user.UserDTOConverter;
import com.zuozuo.forms.LoginForm;
import com.zuozuo.model.user.LoginCheckResult;
import com.zuozuo.service.user.IUserCoreService;

/**
 * Created by bug on 15/12/9.
 */
@RestController
@RequestMapping("api/")
public class LoginApi {

    @Autowired
    private IUserCoreService userCoreService;

    @RequestMapping(value = "login/", method = RequestMethod.POST)
//    @ResponseBody  @RestController 继承自Controller,包含了@ResponseBody标签
    public StandardResponseAPI login(LoginForm loginForm) {  //
        // 匿名表单绑定，可用@ModelAttribute
        // ("loginForm") LoginForm loginForm指定
        if (null == loginForm) {
            return new StandardResponseAPI(APIStatus.INVALID_PARAM, "invalid_param");
        }

        if (null == loginForm.getUsername() || "".equals(loginForm.getUsername().trim())) {
            return new StandardResponseAPI(APIStatus.INVALID_PARAM, "empty username");
        }

        if (null == loginForm.getPassword() || "".equals(loginForm.getPassword().trim())) {
            return new StandardResponseAPI(APIStatus.INVALID_PARAM, "empty password");
        }
        LoginCheckResult loginCheckResult = userCoreService.validateUsernameAndPassword(loginForm.getUsername(),
            loginForm.getPassword());
        if (loginCheckResult.isSuccess()) {
            return new StandardResponseAPI(APIStatus.SUCCESS, loginCheckResult.getMessage(),
                UserDTOConverter.conv(loginCheckResult.getUser()));
        }
        return new StandardResponseAPI(APIStatus.INVALID_PARAM, loginCheckResult.getMessage());
    }
}
