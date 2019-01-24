package cn.edu.nju.controller;

import cn.edu.nju.service.TeacherService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2019-01-03.
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 登录
     * 首次登录需要添加用户
     * @return
     */
    @RequestMapping(value = "/teacher/login",method = RequestMethod.POST)
    public ResponseVO login(@RequestBody TeacherVO teacherVO){
        return teacherService.login(teacherVO.getWechatId(),teacherVO.getWechatIconUrl());
    }

    /**
     * 根据微信号获取教师信息
     * @param wechatId
     * @return
     */
    @RequestMapping(value = "/teacher/{wechatId}",method = RequestMethod.GET)
    public ResponseVO getTeacher(@PathVariable String wechatId){
        return teacherService.getTeacher(wechatId);
    }

    /**
     * 更新教师信息
     * @param
     * @return
     */
    @RequestMapping(value = "/teacher/update",method = RequestMethod.POST)
    public ResponseVO updateTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.updateTeacher(teacherVO);
    }

    @RequestMapping(value = "/teacher/student/orders",method = RequestMethod.GET)
    public ResponseVO getOrders(@RequestParam("wid") String wechatId){
        return teacherService.getOrders(wechatId);
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public ResponseVO searchTeacherByWechatName(@RequestParam("wechatName") String wechatName){
        return teacherService.searchUserByWechatName(wechatName);
    }

    /**
     * 分页获取教师信息
     * @param page      第几页，从0开始
     * @param pageSize  一页有多少条
     * @return
     */
    @RequestMapping(value = "/teachers",method = RequestMethod.GET)
    public ResponseVO getTeachers(@RequestParam Integer page,@RequestParam Integer pageSize){
        return teacherService.getTeachers(page,pageSize);
    }

    /**
     * 一共有多少教师用户
     * @return
     */
    @RequestMapping(value = "/teacher/count",method = RequestMethod.GET)
    public ResponseVO getCount(){
        return teacherService.getCount();
    }



}
