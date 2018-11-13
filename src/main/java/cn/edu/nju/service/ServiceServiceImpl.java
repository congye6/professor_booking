package cn.edu.nju.service;

import cn.edu.nju.mapper.MajorTypeMapper;
import cn.edu.nju.mapper.ServiceMapper;
import cn.edu.nju.mapper.ServiceTypeMapper;
import cn.edu.nju.vo.*;
import cn.edu.nju.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public ServiceServiceImpl(UserMapper userMapper, ServiceMapper serviceMapper,
                              MajorTypeMapper majorTypeMapper, ServiceTypeMapper serviceTypeMapper){
        this.userMapper = userMapper;
        this.serviceMapper = serviceMapper;
        this.majorTypeMapper = majorTypeMapper;
        this.serviceTypeMapper = serviceTypeMapper;
    }

    @Override
    public ResponseVO serviceSearch(String content) {
        if(StringUtils.isEmpty(content)) {
            return ResponseVO.buildFailure("搜索内容不能为空");
        }
        List<UserVO> professorList =  userMapper.selectUserByName(content);

        List<ServiceVO> titleServiceVOList = serviceMapper.getServiceListByTitle(content);
        List<ServiceVO> contentServiceVOList = serviceMapper.getServiceListByContent(content);
        List<ServiceVO> allServiceList = new ArrayList<>();

        List<ServiceVO> serviceVOList = new ArrayList<>();
        Set<Integer> containedProfessorIdSet = new HashSet<>();
        titleServiceVOList.addAll(contentServiceVOList);
        titleServiceVOList.forEach(serviceVO -> {
            int id = serviceVO.getProfessorId();
            if(!containedProfessorIdSet.contains(id)){
                serviceVOList.add(serviceVO);
                containedProfessorIdSet.add(id);
                allServiceList.add(serviceVO);
            }
        });

        ServiceSearchVO serviceSearchVO = new ServiceSearchVO();
        serviceSearchVO.setProfessorList(professorList);
        serviceSearchVO.setServiceList(allServiceList);

        return ResponseVO.buildSuccess(serviceSearchVO);
    }

    @Override
    public ResponseVO serviceList(int startPos, int number) {
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
    public ResponseVO serviceDetail(int serviceId) {
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
