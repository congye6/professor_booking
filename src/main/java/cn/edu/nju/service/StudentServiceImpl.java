package cn.edu.nju.service;

import cn.edu.nju.mapper.OrderMapper;
import cn.edu.nju.mapper.StudentMapper;
import cn.edu.nju.vo.OrderVO;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2019-01-02.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private OrderMapper orderMapper;

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

    @Override
    public ResponseVO getOrders(String wechatId) {
        StudentVO student=studentMapper.selectByWechatId(wechatId);
        if(student==null||student.getId()==null)
            return ResponseVO.buildFailure("微信用户："+wechatId+" 未注册");
        List<OrderVO> orders=orderMapper.getOrderList(student.getId());
        return ResponseVO.buildSuccess(orders);
    }

    @Override
    public ResponseVO getStudents(int page, int pageSize) {
        return ResponseVO.buildSuccess(studentMapper.select(pageSize,page*pageSize));
    }

    @Override
    public ResponseVO getCount() {
        return ResponseVO.buildSuccess(studentMapper.selectCount());
    }

    @Override
    public ResponseVO getToAuditStudents(int page, int pageSize) {
        return ResponseVO.buildSuccess(studentMapper.selectByAudit(false,pageSize,page*pageSize));
    }

    @Override
    public ResponseVO getAuditCount() {
        return ResponseVO.buildSuccess(studentMapper.selectAuditCount());
    }

    @Override
    public ResponseVO audit(String wechatId) {
        StudentVO student=new StudentVO();
        student.setWechatId(wechatId);
        student.setAudited(true);
        studentMapper.update(student);
        return ResponseVO.buildSuccess();
    }
}
