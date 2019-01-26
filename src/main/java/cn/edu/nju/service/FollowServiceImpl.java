package cn.edu.nju.service;

import cn.edu.nju.mapper.FollowMapper;
import cn.edu.nju.mapper.TeacherMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.FollowVO;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2019-01-25.
 */
@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO follow(FollowVO followVO) {
        if(followMapper.select(followVO)!=null)
            return ResponseVO.buildFailure("已关注,请勿重复操作");
        followMapper.insert(followVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO unfollow(FollowVO followVO) {
        if(followMapper.select(followVO)==null)
            return ResponseVO.buildSuccess();
        followMapper.delete(followVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO followees(String studentWechatId) {
        List<Integer> teacherIdList=followMapper.selectByStudent(studentWechatId);
        List<UserVO> teachers=new ArrayList<>();
        for(int teacherId:teacherIdList){
            teachers.add(userMapper.selectUserById(teacherId));
        }
        return ResponseVO.buildSuccess(teachers);
    }

    @Override
    public ResponseVO followers(Integer teacherInfoId) {
        List<String> studentIdList=followMapper.selectByTeacher(teacherInfoId);
        List<StudentVO> students=new ArrayList<>();
        for(String studentId:studentIdList){
            students.add(studentService.getStudent(studentId));
        }
        return ResponseVO.buildSuccess(students);
    }
}
