package cn.edu.nju.controller;

import cn.edu.nju.service.UserService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2018-11-08.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/id/{wechatId}",method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable String wechatId){
        return userService.getUser(wechatId);
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody UserVO userVO){
        return userService.updateUser(userVO);
    }

    @RequestMapping(value = "/user/name/{name}",method = RequestMethod.GET)
    public ResponseVO searchUserByName(@PathVariable String name){
        return userService.searchUserByName(name);
    }

    @RequestMapping(value = "/user/school/{school}",method = RequestMethod.GET)
    public ResponseVO searchUserBySchool(@PathVariable String school){
        return userService.searchUserBySchool(school);
    }

    @RequestMapping(value = "/user/interest/{interest}",method = RequestMethod.GET)
    public ResponseVO searchUserByInterest(@PathVariable String interest){
        return userService.searchUserByInterest(interest);
    }

    @RequestMapping(value = "/user/delete/{wechatId}",method = RequestMethod.POST)
    public ResponseVO deleteUser(@PathVariable String wechatId){
        return userService.deleteUser(wechatId);
    }


}
