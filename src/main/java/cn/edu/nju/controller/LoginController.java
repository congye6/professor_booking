package cn.edu.nju.controller;

import cn.edu.nju.service.LoginService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cong on 2018-11-07.
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public ResponseVO register(@RequestBody UserVO userVO){
        return loginService.register(userVO);
    }

}
