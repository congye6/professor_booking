package cn.edu.nju.controller;

import cn.edu.nju.service.FollowService;
import cn.edu.nju.vo.FollowVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关注
 * Created by cong on 2019-01-26.
 */
@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 关注教师
     * @return
     */
    @RequestMapping(value = "/follow",method = RequestMethod.POST)
    public ResponseVO follow(@RequestParam String studentWechatId,@RequestParam Integer teacherInfoId){
        return followService.follow(new FollowVO(studentWechatId,teacherInfoId));
    }

    /**
     * 取消关注
     * @return
     */
    @RequestMapping(value = "/unfollow",method = RequestMethod.POST)
    public ResponseVO unfollow(@RequestParam String studentWechatId,@RequestParam Integer teacherInfoId){
        return followService.unfollow(new FollowVO(studentWechatId,teacherInfoId));
    }

    /**
     * 我的关注
     * @param studentWechatId
     * @return
     */
    @RequestMapping(value = "/followees",method = RequestMethod.GET)
    public ResponseVO followees(@RequestParam String studentWechatId){
        return followService.followees(studentWechatId);
    }

    /**
     * 关注我的
     * @param teacherInfoId
     * @return
     */
    @RequestMapping(value = "/followers",method = RequestMethod.GET)
    public ResponseVO followers(@RequestParam Integer teacherInfoId){
        return followService.followers(teacherInfoId);
    }
}
