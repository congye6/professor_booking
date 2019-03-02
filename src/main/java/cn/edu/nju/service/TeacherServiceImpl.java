package cn.edu.nju.service;

import cn.edu.nju.mapper.*;
import cn.edu.nju.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2019-01-03.
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private OrderMapper orderMapper;

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
    public TeacherDetailVO getTeacher(String wechatId) {
        TeacherVO teacherVO=teacherMapper.selectByWechatId(wechatId);
        if(teacherVO==null)
            return null;

        return getDetail(teacherVO);
    }

    @Override
    public ResponseVO getTeachers(int page, int pageSize) {
        List<TeacherVO> teacherList=teacherMapper.select(pageSize,page*pageSize);
        List<TeacherDetailVO> detailList=new ArrayList<>();
        for(TeacherVO teacher:teacherList){
            detailList.add(getDetail(teacher));
        }
        return ResponseVO.buildSuccess(detailList);
    }

    @Override
    public ResponseVO getCount() {
        return ResponseVO.buildSuccess(teacherMapper.selectCount());
    }

    /**
     * 查询教师的爬取的信息
     * @param teacherVO
     * @return
     */
    private TeacherDetailVO getDetail(TeacherVO teacherVO){
        TeacherDetailVO detailVO=new TeacherDetailVO();
        BeanUtils.copyProperties(teacherVO,detailVO);
        UserVO userVO=userMapper.selectUserById(teacherVO.getInfoId());
        if(userVO!=null){
            BeanUtils.copyProperties(userVO,detailVO);
        }else{
            detailVO.setId(-1);
        }
        return detailVO;
    }

    @Override
    public ResponseVO updateTeacher(TeacherVO teacherVO) {
        teacherMapper.updateByWechatId(teacherVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getOrders(String wechatId) {
        TeacherVO teacher=teacherMapper.selectByWechatId(wechatId);
        if(teacher==null||teacher.getInfoId()==-1)
            return ResponseVO.buildFailure("教师用户："+wechatId+" 不存在");
        List<ServiceVO> services=serviceMapper.getServiceListByExpertId(teacher.getInfoId());//教师发布的所有服务
        List<TeacherOrderVO> orders=new ArrayList<>();
        for(ServiceVO service:services){
            List<Integer> orderUsers=orderMapper.getOrderUsers(service.getId());//查询预约服务的所有用户
            for(Integer userId:orderUsers){
                StudentVO studentVO=studentMapper.selectByPrimaryKey(userId);
                if(studentVO!=null){
                    TeacherOrderVO order=new TeacherOrderVO(service,studentVO);
                    orders.add(order);
                }
            }
        }
        return ResponseVO.buildSuccess(orders);
    }

    @Override
    public ResponseVO searchUserByWechatName(String wechatName) {
        return ResponseVO.buildSuccess(teacherMapper.selectByName(wechatName));
    }

    @Override
    public ResponseVO deleteByWechatId(String wechatId) {
        return ResponseVO.buildSuccess(teacherMapper.deleteByWechatId(wechatId));
    }
}
