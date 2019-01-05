package cn.edu.nju.service;

import cn.edu.nju.mapper.StudentMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-02.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResponseVO login(String wechatId, String wechatIconUrl) {
        StudentVO studentVO=studentMapper.selectByWechatId(wechatId);
        if(studentVO!=null)
            return ResponseVO.buildSuccess("用户信息已添加");
        studentVO=new StudentVO();
        studentVO.setWechatId(wechatId);
        studentVO.setWechatIconUrl(wechatIconUrl);
        studentMapper.insertSelective(studentVO);
        return ResponseVO.buildSuccess("用户信息已添加");
    }

    @Override
    public ResponseVO getStudent(String wechatId) {
        return ResponseVO.buildSuccess(studentMapper.selectByWechatId(wechatId));
    }

    @Override
    public ResponseVO updateStudent(StudentVO studentVO) {
        studentMapper.update(studentVO);
        return ResponseVO.buildSuccess();
    }
}
