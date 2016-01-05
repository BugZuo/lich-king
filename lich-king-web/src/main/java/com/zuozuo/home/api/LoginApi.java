package com.zuozuo.home.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zuozuo.base.APIStatus;
import com.zuozuo.base.StandardResponseAPI;
import com.zuozuo.convertor.user.UserDTOConverter;
import com.zuozuo.forms.LoginForm;
import com.zuozuo.service.user.IUserCoreService;
import com.zuozuo.service.user.LoginInfo;

/**
 * Created by bug on 15/12/9.
 */
@RestController
@RequestMapping("api/")
public class LoginApi {

    @Autowired
    private IUserCoreService userCoreService;

    @RequestMapping(value = "login/", method = RequestMethod.POST)
    @ResponseBody
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
        LoginInfo loginInfo = userCoreService.validateUsernameAndPassword(loginForm.getUsername(),
            loginForm.getPassword());
        if (loginInfo.isSuccess()) {
            return new StandardResponseAPI(true, APIStatus.SUCCESS, loginInfo.getMessage(),
                UserDTOConverter.conv(loginInfo.getUser()));
        }
        return new StandardResponseAPI(APIStatus.INVALID_PARAM, loginInfo.getMessage());
    }
}
