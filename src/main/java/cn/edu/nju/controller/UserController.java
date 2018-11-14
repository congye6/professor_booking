package cn.edu.nju.controller;

import cn.edu.nju.service.UserService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 爬取的数据管理
 * Created by cong on 2018-11-08.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *根据id获取专家信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/id/{id}",method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable Integer id){
        if(id==null)
            return ResponseVO.buildFailure("id不能为空");
        return userService.getUser(id);
    }

    /**
     * 更新专家信息
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody UserVO userVO){
        return userService.updateUser(userVO);
    }

    /**
     * 根据名称模糊搜索
     * @param name
     * @return
     */
    @RequestMapping(value = "/user/name/{name}",method = RequestMethod.GET)
    public ResponseVO searchUserByName(@PathVariable String name){
        return userService.searchUserByName(name);
    }

    /**
     * 根据学校搜索
     * @param school
     * @return
     */
    @RequestMapping(value = "/user/school/{school}",method = RequestMethod.GET)
    public ResponseVO searchUserBySchool(@PathVariable String school){
        return userService.searchUserBySchool(school);
    }

    /**
     * 根据研究方向搜索
     * @param interest
     * @return
     */
    @RequestMapping(value = "/user/interest/{interest}",method = RequestMethod.GET)
    public ResponseVO searchUserByInterest(@PathVariable String interest){
        return userService.searchUserByInterest(interest);
    }

    /**
     * 删除专家信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.POST)
    public ResponseVO deleteUser(@PathVariable Integer id){
        if(id==null)
            return ResponseVO.buildFailure("id不能为空");
        return userService.deleteUser(id);
    }


}
