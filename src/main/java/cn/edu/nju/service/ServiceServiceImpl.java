package cn.edu.nju.service;

import cn.edu.nju.mapper.ServiceMapper;
import cn.edu.nju.vo.ServiceVO;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/09
 */
@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public ResponseVO serviceSearchByProfessorName(String professorName) {
        if(StringUtils.isEmpty(professorName)) {
            return ResponseVO.buildFailure("专家姓名不能为空");
        }
        List<UserVO> professorList =  userMapper.selectUserByName(professorName);
        return ResponseVO.buildSuccess(professorList);
    }

    @Override
    public ResponseVO serviceSearchByServiceName(String serviceName) {
        return null;
    }

    @Override
    public ResponseVO serviceClassify() {
        return null;
    }

    @Override
    public ResponseVO serviceList(int startPos, int number) {
        if(startPos < 0){
            return ResponseVO.buildFailure("服务记录起始位置不能为负");
        }else if(number <=0){
            return ResponseVO.buildFailure("服务的数量应为正数");
        }

        List<ServiceVO> serviceVOList = serviceMapper.getService(startPos, number);
        return ResponseVO.buildSuccess(serviceVOList);
    }

    @Override
    public ResponseVO serviceDetail() {
        return null;
    }

    @Override
    public ResponseVO serviceCreate(ServiceVO vo) {
        Integer professorId = vo.getProfessorId();
        String title = vo.getTitle();
        String reserveAddress = vo.getReserveAddress();
        Timestamp reserveTime = vo.getReserveTime();
        Timestamp deadline = vo.getDeadline();

        if(null == professorId){
            return ResponseVO.buildFailure("专家编号不能为空");
        }else if(StringUtils.isEmpty(title)){
            return ResponseVO.buildFailure("标题不能为空");
        }else if(StringUtils.isEmpty(reserveAddress)){
            return ResponseVO.buildFailure("预约地址不能为空");
        }else if(null == reserveTime){
            return ResponseVO.buildFailure("预约时间不能为空");
        }else if(null == deadline){
            return ResponseVO.buildFailure("截止时间不能为空");
        }

        serviceMapper.insertService(professorId, title, reserveAddress, reserveTime, deadline);
        return ResponseVO.buildSuccess(true);
    }

}
