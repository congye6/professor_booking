package cn.edu.nju.service;

import cn.edu.nju.mapper.TeacherMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.TeacherDetailVO;
import cn.edu.nju.vo.TeacherVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-03.
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO login(String wechatId, String wechatIconUrl) {
        TeacherVO teacherVO=teacherMapper.selectByWechatId(wechatId);
        if(teacherVO!=null)
            return ResponseVO.buildSuccess("用户已添加");
        teacherVO=new TeacherVO();
        teacherVO.setWechatId(wechatId);
        teacherVO.setWechatIconUrl(wechatIconUrl);
        teacherMapper.insertSelective(teacherVO);
        return ResponseVO.buildSuccess("用户添加成功");
    }

    @Override
    public ResponseVO getTeacher(String wechatId) {
        TeacherVO teacherVO=teacherMapper.selectByWechatId(wechatId);
        if(teacherVO==null)
            return ResponseVO.buildFailure("用户不存在");
        TeacherDetailVO detailVO=new TeacherDetailVO();
        BeanUtils.copyProperties(teacherVO,detailVO);
        UserVO userVO=userMapper.selectUserById(teacherVO.getInfoId());
        if(userVO!=null){
            BeanUtils.copyProperties(userVO,detailVO);
        }else{
            detailVO.setId(-1);
        }
        return ResponseVO.buildSuccess(detailVO);
    }

    @Override
    public ResponseVO updateStudent(TeacherVO teacherVO) {
        teacherMapper.updateByWechatId(teacherVO);
        return ResponseVO.buildSuccess();
    }
}
