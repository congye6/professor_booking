package cn.edu.nju.service;

import cn.edu.nju.mapper.FollowMapper;
import cn.edu.nju.mapper.TeacherMapper;
import cn.edu.nju.vo.FollowVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-25.
 */
@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public ResponseVO follow(FollowVO followVO) {
        if(followMapper.select(followVO)!=null)
            return ResponseVO.buildFailure("已关注,请勿重复操作");

        return null;
    }

    @Override
    public ResponseVO unfollow(FollowVO followVO) {
        return null;
    }

    @Override
    public ResponseVO followees(String studentWechatId) {
        return null;
    }

    @Override
    public ResponseVO followers(String teacherWechatId) {
        return null;
    }
}
