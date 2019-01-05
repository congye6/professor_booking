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
     * 分页获取用户数据
     * @param pageIndex 获取第几页的数据，从0开始
     * @param pageSize  一页有多少条数据
     * @return
     */
    @RequestMapping(value = "/user/page/{pageIndex}/size/{pageSize}",method = RequestMethod.GET)
    public ResponseVO getUserByPage(@PathVariable Integer pageIndex,@PathVariable Integer pageSize){
        return userService.getUserByPage(pageIndex,pageSize);
    }

    /**
     * 获取用户总数
     * @return
     */
    @RequestMapping(value = "/user/count",method = RequestMethod.GET)
    public ResponseVO getUserCount(){
        return userService.getUserCount();
    }

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

    @RequestMapping(value = "/user/country",method = RequestMethod.GET)
    public ResponseVO getAllCountry(){
        return userService.getAllCountry();
    }

    @RequestMapping(value = "/user/position",method = RequestMethod.GET)
    public ResponseVO getAllPosition(){
        return userService.getAllPosition();
    }




}
