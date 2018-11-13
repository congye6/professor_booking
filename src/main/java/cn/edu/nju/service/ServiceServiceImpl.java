package cn.edu.nju.service;

import cn.edu.nju.mapper.MajorTypeMapper;
import cn.edu.nju.mapper.ServiceMapper;
import cn.edu.nju.mapper.ServiceTypeMapper;
import cn.edu.nju.vo.*;
import cn.edu.nju.mapper.UserMapper;
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

    private UserMapper userMapper;

    private ServiceMapper serviceMapper;

    private MajorTypeMapper majorTypeMapper;

    private ServiceTypeMapper serviceTypeMapper;

    public ServiceServiceImpl(UserMapper userMapper, ServiceMapper serviceMapper,
                              MajorTypeMapper majorTypeMapper, ServiceTypeMapper serviceTypeMapper){
        this.userMapper = userMapper;
        this.serviceMapper = serviceMapper;
        this.majorTypeMapper = majorTypeMapper;
        this.serviceTypeMapper = serviceTypeMapper;
    }

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

        // TODO 服务列表信息要包含专家信息，UserMapper那边需要有根据id查User的方法
        List<ServiceVO> serviceVOList = serviceMapper.getServiceList(startPos, number);
        return ResponseVO.buildSuccess(serviceVOList);
    }

    @Override
    public ResponseVO serviceDetail(int serviceId) {
        // TODO 服务列表信息要包含专家信息，UserMapper那边需要有根据id查User的方法
        ServiceVO serviceVO = serviceMapper.getServiceById(serviceId);
        if(null == serviceVO){
            return ResponseVO.buildFailure("该服务Id对应的服务不存在");
        }
        return ResponseVO.buildSuccess(serviceVO);
    }

    @Override
    public ResponseVO serviceCreate(ServiceVO vo) {
        // TODO 在创建服务时是否需要指定服务分类和专业分类
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

    @Override
    public ResponseVO getAllMajorType() {
        List<MajorTypeVO> majorTypeVOList = majorTypeMapper.getAllMajorType();
        return ResponseVO.buildSuccess(majorTypeVOList);
    }

    @Override
    public ResponseVO getAllServiceType() {
        List<ServiceTypeVO> serviceTypeVOList = serviceTypeMapper.getAllServiceType();
        return ResponseVO.buildSuccess(serviceTypeVOList);
    }
}
