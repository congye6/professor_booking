package cn.edu.nju.service;

import cn.edu.nju.mapper.*;
import cn.edu.nju.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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

    private ServiceExpertMapper serviceExpertMapper;

    public ServiceServiceImpl(UserMapper userMapper, ServiceMapper serviceMapper,
                              MajorTypeMapper majorTypeMapper, ServiceTypeMapper serviceTypeMapper,
                              ServiceExpertMapper serviceExpertMapper){
        this.userMapper = userMapper;
        this.serviceMapper = serviceMapper;
        this.majorTypeMapper = majorTypeMapper;
        this.serviceTypeMapper = serviceTypeMapper;
        this.serviceExpertMapper = serviceExpertMapper;
    }

    @Override
    public ResponseVO expertSearch(String expert, String nation, String position, String school) {
        if(StringUtils.isEmpty(expert) && StringUtils.isEmpty(nation) &&
                StringUtils.isEmpty(position) && StringUtils.isEmpty(school)){
            return ResponseVO.buildFailure("专家搜索输入信息为空");
        }

        List<UserVO> searchExpertList = userMapper.selectUserByInfo(expert, nation, position, school);
        return ResponseVO.buildSuccess(searchExpertList);
    }

    @Override
    public ResponseVO serviceSearch(String serviceName, String nation, String position,
                                    String school, Integer serviceType, Integer majorType) {
        if(StringUtils.isEmpty(serviceName) && StringUtils.isEmpty(nation) &&
                StringUtils.isEmpty(position) && StringUtils.isEmpty(school) &&
                serviceType == null && majorType == null){
            return ResponseVO.buildFailure("服务搜索输入信息为空");
        }

        serviceType = serviceType == null ? 0:serviceType;
        majorType = majorType == null ? 0:majorType;

        List<ServiceExpertVO> serviceExpertVOList = serviceExpertMapper.getSearchExpertInfo(serviceName, nation,
                position, school, serviceType, majorType);
        return ResponseVO.buildSuccess(serviceExpertVOList);
    }

    @Override
    public ResponseVO getServiceByExpertId(Integer expertId) {
        UserVO expert = userMapper.selectUserById(expertId);
        List<ServiceVO> serviceVOList = serviceMapper.getServiceListByExpertId(expertId);
        ExpertServiceVO expertServiceVO = new ExpertServiceVO();
        expertServiceVO.setExpert(expert);
        expertServiceVO.setServiceList(serviceVOList);

        return ResponseVO.buildSuccess(expertServiceVO);
    }

    @Override
    public ResponseVO serviceList(Integer startPos, Integer number) {
        if(startPos < 0){
            return ResponseVO.buildFailure("服务记录起始位置不能为负");
        }else if(number <=0){
            return ResponseVO.buildFailure("服务的数量应为正数");
        }

        List<ServiceVO> serviceVOList = serviceMapper.getServiceList(startPos, number);
        List<ServiceBriefVO> serviceBriefVOList = serviceVOList.stream().map(serviceVO -> {
            int professorId = serviceVO.getProfessorId();
            UserVO userVO = userMapper.selectUserById(professorId);
            ServiceBriefVO serviceBriefVO = new ServiceBriefVO();
            serviceBriefVO.setServiceVO(serviceVO);
            serviceBriefVO.setProfessorId(userVO.getId());
            serviceBriefVO.setProfessorName(userVO.getName());
            serviceBriefVO.setIconUrl(userVO.getIconUrl());
            serviceBriefVO.setPosition(userVO.getPosition());
            return serviceBriefVO;
        }).collect(Collectors.toList());

        return ResponseVO.buildSuccess(serviceBriefVOList);
    }

    @Override
    public ResponseVO serviceDetail(Integer serviceId) {
        ServiceVO serviceVO = serviceMapper.getServiceById(serviceId);
        if(null == serviceVO){
            return ResponseVO.buildFailure("该服务Id对应的服务不存在");
        }

        int professorId = serviceVO.getProfessorId();
        UserVO professor = userMapper.selectUserById(professorId);
        if(null == professor){
            return ResponseVO.buildFailure("该服务Id对应的专家不存在");
        }

        ServiceDetailVO serviceDetailVO = new ServiceDetailVO();
        serviceDetailVO.setUserVO(professor);
        serviceDetailVO.setServiceVO(serviceVO);

        return ResponseVO.buildSuccess(serviceDetailVO);
    }

    @Override
    public ResponseVO serviceCreate(ServiceVO vo) {
        Integer professorId = vo.getProfessorId();
        String title = vo.getTitle();
        String content = vo.getContent();
        String reserveAddress = vo.getReserveAddress();
        Timestamp reserveTime = vo.getReserveTime();
        Timestamp deadline = vo.getDeadline();
        Integer serviceTypeId = vo.getServiceTypeId();
        Integer majorTypeId = vo.getMajorTypeId();

        if(null == professorId){
            return ResponseVO.buildFailure("专家编号不能为空");
        }else if(StringUtils.isEmpty(title)){
            return ResponseVO.buildFailure("标题不能为空");
        }else if (StringUtils.isEmpty(content)){
            return ResponseVO.buildFailure("正文不能为空");
        }else if(StringUtils.isEmpty(reserveAddress)){
            return ResponseVO.buildFailure("预约地址不能为空");
        }else if(null == reserveTime){
            return ResponseVO.buildFailure("预约时间不能为空");
        }else if(null == deadline){
            return ResponseVO.buildFailure("截止时间不能为空");
        }else if(null == serviceTypeId){
            return ResponseVO.buildFailure("服务类型Id不能为空");
        }else if(null == majorTypeId){
            return ResponseVO.buildFailure("专业类型Id不能为空");
        }

        serviceMapper.insertService(professorId, title, content, reserveAddress, reserveTime, deadline, serviceTypeId, majorTypeId);
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
